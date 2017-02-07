package me.skhu.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.domain.Files;
import me.skhu.domain.dto.FilesDto;
import me.skhu.repository.FilesRepository;

@Component
public class FileService {

	@Autowired
	private FilesRepository fileRepository;

	@Transactional(readOnly = false)
	public void upload(int boardPostId, MultipartFile[] files, MultipartHttpServletRequest request){
    	long size;
    	String path;
    	String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/files/");
		String fileName;
		Files f;
		System.out.println(request.getSession());
		System.out.println(request.getSession().getServletContext());
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		System.out.println("request URL : " +request.getRequestURI());
		System.out.println("request URL : " +request.getRequestURL());
		System.out.println("request context path " + request.getContextPath());
		System.out.println("request servlet Path " + request.getServletPath());
		System.out.println("gerServletContext Path : " +request.getServletContext());
    	if (files != null && files.length >0) {
    		for(int i =0 ;i< files.length; i++){
	            try {
	                fileName = files[i].getOriginalFilename();
	                size=files[i].getSize();
	                byte[] bytes = files[i].getBytes();
	                path=rootPath+fileName;
	                System.out.println("path: " + path);
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
		System.out.println("path " + path);
		return "../resources/upload/advertiseImage/"+fileName;
	}
}
