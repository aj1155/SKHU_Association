package me.skhu.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import me.skhu.domain.Files;
import me.skhu.repository.FileRepository;

@Component
public class FileService {

	@Autowired
	private FileRepository fileRepository;

	@Transactional(readOnly = false)
	public void upload(int boardPostId, MultipartFile[] files){
		String fileName = null;
    	long size;
    	Files f = null;
    	String path;
    	if (files != null && files.length >0) {
    		for(int i =0 ;i< files.length; i++){
	            try {
	                fileName = files[i].getOriginalFilename();
	                size=files[i].getSize();
	                byte[] bytes = files[i].getBytes();
	                path="C:\\Users\\iljun\\sts\\file\\" + fileName;
	                BufferedOutputStream buffStream =
	                        new BufferedOutputStream(new FileOutputStream(new File(path)));
	                buffStream.write(bytes);
	                buffStream.close();
	                f= new Files(boardPostId,fileName,size,path);
		            fileRepository.save(f);
	            } catch (Exception e) {
	            }

    		}
    	}
	}
}
