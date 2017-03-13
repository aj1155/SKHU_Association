package me.skhu.controller.admin;

import me.skhu.domain.BoardImage;
import me.skhu.domain.Photo;
import me.skhu.domain.dto.BoardImageDto;
import me.skhu.service.BoardImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * Created by iljun on 2017-03-06.
 */
@Controller
@RequestMapping("image")
public class ImageController {

    @Autowired
    private BoardImageService boardImageService;

    @RequestMapping("/file_uploader")
    public String file_uploader(HttpServletRequest request, HttpServletResponse response, Photo photo) {
        String s = boardImageService.imageUpload(request,response,photo);
        return "redirect:" + s;
    }

    @RequestMapping("/file_uploader_html5")
    public void file_uploader_html5(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boardImageService.multiImageUpload(request,response);
    }
}
