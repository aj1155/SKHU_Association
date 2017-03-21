package me.skhu.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MailService {

	@Autowired private JavaMailSender javaMailSender;

	public void sendMailAddFile(String to, String subject, String msg, MultipartFile[] files){
		MimeMessage message = javaMailSender.createMimeMessage();
		String[] email;
		email=to.split(", ");
		try{
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject(subject);
			messageHelper.setText(msg,true);
			messageHelper.setFrom("norlights23@gmail.com");
			messageHelper.setTo(email);

			for(MultipartFile file : files){
				if(file.getSize() > 0){
					messageHelper.addAttachment(file.getOriginalFilename(), file);
				}
			}
			javaMailSender.send(message);
		} catch(MailException e){
			e.printStackTrace();
			System.out.println(e);
		} catch(Throwable e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
