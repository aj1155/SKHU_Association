package me.skhu.service;

import lombok.extern.slf4j.Slf4j;
import me.skhu.domain.Files;
import me.skhu.domain.User;
import me.skhu.domain.dto.FilesDto;
import me.skhu.repository.FilesRepository;
import net.sf.jazzlib.ZipEntry;
import net.sf.jazzlib.ZipInputStream;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Component
public class FileService {

	@Autowired
	private FilesRepository fileRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@Transactional(readOnly = false)
	public void upload(int boardPostId, MultipartFile[] files, MultipartHttpServletRequest request){
    	long size;
    	String path;
		String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/files/");
		String fileName;
		Files f;
    	if (files != null && files.length >0) {
    		for(int i =0 ;i< files.length; i++){
	            try {
	                fileName = files[i].getOriginalFilename();
	                size=files[i].getSize();
	                byte[] bytes = files[i].getBytes();
	                path=rootPath+fileName;
	                BufferedOutputStream buffStream =
	                        new BufferedOutputStream(new FileOutputStream(new File(path)));
	                buffStream.write(bytes);
	                buffStream.close();
	                f= new Files(boardPostId,fileName,size,path);
		            fileRepository.save(f);
	            } catch (Exception e) {
	            	System.out.println("file upload Error : " + e.getMessage());
	            }

    		}
    	}
	}
	public FilesDto findByBoardId(int boardId){
		return FilesDto.of(boardId, fileRepository.findByBoardId(boardId));
	}

	@Transactional(readOnly = false)
	public void deleteByBoardId(int boardId){
		if(fileRepository.findByBoardId(boardId)!=null){
			fileDelete(boardId);
			fileRepository.deleteByBoardId(boardId);
		}
	}

	public void fileDelete(int id){
		File file;
		List<Files> list = fileRepository.findByBoardId(id);
		for(Files f : list){
			file = new File(f.getPath());
			file.delete();
		}
	}

	public void download(int id, HttpServletResponse response) throws IOException{
		File file = new File(fileRepository.findOne(id).getPath());

		byte fileByte[] = FileUtils.readFileToByteArray(new File(file.getPath()));

	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(file.getName(),"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);

	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}

	public String excelUpload(MultipartFile file, MultipartHttpServletRequest request){
		String fileName = null;
		String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/excel/");
		String path=null;
		try{
			fileName=file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			path = rootPath+fileName;
			BufferedOutputStream buffStream =
					new BufferedOutputStream(new FileOutputStream(new File(path)));
			buffStream.write(bytes);
            buffStream.close();
		}catch (Exception e){
			System.out.println("Image upload Error : " + e.getMessage());
		}
		return path;
	}

	public void zipUpload(MultipartFile zipFile , MultipartHttpServletRequest request) throws Exception{
		String fileName = null;
		String rootPath = request.getSession().getServletContext().getRealPath("/resources/zip/");
		String path = null;
		try{
			fileName = zipFile.getOriginalFilename();
			byte[] bytes = zipFile.getBytes();
			path = rootPath+fileName;
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(path)));
			bufferedOutputStream.write(bytes);
			bufferedOutputStream.close();
			File newFile = new File(path+zipFile.getOriginalFilename());
			zipFile.transferTo(newFile);
			unzip(newFile,request);
			deleteAllFiles(rootPath);
			File directory = new File(rootPath);
			directory.mkdir();
		}catch(Exception e){
			log.error("zipUpload error " + e.getMessage(), e);
		}

	}

	private void unzip(File file, HttpServletRequest request) throws Exception{
		FileInputStream fileInputStream = null;
		ZipInputStream zipInputStream = null;
		ZipEntry zipEntry = null;
		try{
			fileInputStream = new FileInputStream(file);
			zipInputStream = new ZipInputStream(fileInputStream);

			while((zipEntry=zipInputStream.getNextEntry())!=null){
				String fileName = zipEntry.getName();
				String[] temp=fileName.split("/");

				if(zipEntry.isDirectory()){
					File directory = new File(fileName);
					directory.mkdirs();
				}else{
					unzipEntry(zipInputStream,request,temp[temp.length-1]);
				}
			}
		}finally{
			if(zipInputStream!=null)
				zipInputStream.close();
			if(fileInputStream!=null)
				fileInputStream.close();
		}
	}

	private void unzipEntry(ZipInputStream zipInputStream , HttpServletRequest request,String imageName) throws Exception{
		FileOutputStream fileOutputStream = null;
		String path = request.getSession().getServletContext().getRealPath("/resources/upload/profileImg/");
		File file = null;
		try{
			file = new File(path+imageName);
			fileOutputStream = new FileOutputStream(file);
			byte[] bytes = new byte[256];
			int len = 0;
			while((len = zipInputStream.read(bytes))!=-1){
				fileOutputStream.write(bytes,0,len);
			}
			userService.imageUpload(imageName);
		}finally{
			if(fileOutputStream!=null)
				fileOutputStream.close();
		}
	}

	public String imageUpload(MultipartFile file, MultipartHttpServletRequest request){
		String fileName=null;
		String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/advertiseImage/");
		String path=null;
		if(file!=null){
			try{
				fileName=file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				path = rootPath+fileName;
				BufferedOutputStream buffStream =
						new BufferedOutputStream(new FileOutputStream(new File(path)));
				buffStream.write(bytes);
				buffStream.close();
			}catch (Exception e){
				System.out.println("Image upload Error : " + e.getMessage());
			}
		}
		return "../resources/upload/advertiseImage/"+fileName;
	}

	private void deleteAllFiles(String path){
		File file = new File(path);
		File[] tempFile = file.listFiles();

		if(tempFile.length > 0 ){
			for(int i=0; i<tempFile.length ; i++){
				if(tempFile[i].isFile()){
					tempFile[i].delete();
				}else{
					deleteAllFiles(tempFile[i].getPath());
				}
				tempFile[i].delete();
			}
			file.delete();
		}
	}

	public void imageDownload(HttpServletResponse response){
		//File file = findImage(adminService.getCurrentAdmin().getCategory().getId());

		//byte fileByte[] = FileUtils.readFileToByteArray(new File(file.getPath()));
		//response.setContentType("application/zip");
		//response.setContentLength(fileByte.length);
		//response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(file.getName(),"UTF-8")+"\";");
		//response.setHeader("Content-Transfer-Encoding", "binary");
		//response.getOutputStream().write(fileByte);

		//response.getOutputStream().flush();
		//response.getOutputStream().close();
	}

	private File findImage(int categoryId) throws Exception{
		List<User> imageList = userService.findByCategoryIdAndImage(categoryId);

		return null;
	}
}
