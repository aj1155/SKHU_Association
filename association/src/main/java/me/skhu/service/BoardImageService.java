package me.skhu.service;

import me.skhu.domain.BoardImage;
import me.skhu.domain.BoardPost;
import me.skhu.domain.Photo;
import me.skhu.domain.dto.BoardImageDto;
import me.skhu.repository.BoardImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by iljun on 2017-03-03.
 */
@Service
public class BoardImageService {

    @Autowired
    private BoardImageRepository boardImageRepository;

    private BoardPostService boardPostService;

    @Transactional(readOnly = false)
    public void preSave(String path){
        boardImageRepository.save(BoardImage.of(path));
    }

    @Transactional(readOnly = false)
    public void delete(int boardId){
        boardImageRepository.delete(boardId);
    }

    @Transactional(readOnly = false)
    public void deleteOrphan(int boardPostId){
        //deleteOrphan
    }

    public void updateImage(int boardId){
        boardImageRepository.delete(boardId);

    }
    public BoardImageDto findById(int id){
        return BoardImageDto.of(boardImageRepository.findById(id));
    }

    public String imageUpload(HttpServletRequest request, HttpServletResponse response, Photo photo){
        String return1 = request.getParameter("callback");
        String return2 = "?callback_func=" + request.getParameter("callback_func");
        String return3 = "";
        String name = "";
        try {
            if (photo.getFileData() != null && photo.getFileData().getOriginalFilename() != null && !photo.getFileData().getOriginalFilename().equals("")) {
                // 기존 상단 코드를 막고 하단코드를 이용
                name = photo.getFileData().getOriginalFilename().substring(photo.getFileData().getOriginalFilename().lastIndexOf(File.separator) + 1);
                String filename_ext = name.substring(name.lastIndexOf(".") + 1);
                filename_ext = filename_ext.toLowerCase();
                String[] allow_file = {"jpg", "png", "bmp", "gif"};
                int cnt = 0;
                for (int i = 0; i < allow_file.length; i++) {
                    if (filename_ext.equals(allow_file[i])) {
                        cnt++;
                    }
                }
                if (cnt == 0) {
                    return3 = "&errstr=" + name;
                } else {
                    //파일 기본경로
                    String dftFilePath = request.getSession().getServletContext().getRealPath("/");
                    //파일 기본경로 _ 상세경로
                    String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator + "multiupload" + File.separator;
                    boardImageRepository.save(BoardImage.of(filePath));
                    File file = new File(filePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String realFileNm = "";
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                    String today = formatter.format(new java.util.Date());
                    realFileNm = today + UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
                    String rlFileNm = filePath + realFileNm;
                    ///////////////// 서버에 파일쓰기 /////////////////
                    photo.getFileData().transferTo(new File(rlFileNm));
                    ///////////////// 서버에 파일쓰기 /////////////////
                    return3 += "&bNewLine=true";
                    return3 += "&sFileName=" + name;
                    return3 += "&sFileURL=/resources/editor/multiupload/" + realFileNm;
                }
            } else {
                return3 += "&errstr=error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return return1 + return2 + return3;
    }

    public void multiImageUpload(HttpServletRequest request, HttpServletResponse response){
        String path = request.getSession().getServletContext().getRealPath("/");
        try {
            //파일정보
            String sFileInfo = "";
            //파일명을 받는다 - 일반 원본파일명
            String filename = request.getHeader("file-name");
            //파일 확장자
            String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
            //확장자를소문자로 변경
            filename_ext = filename_ext.toLowerCase();
            //이미지 검증 배열변수
            String[] allow_file = {"jpg","png","bmp","gif"};
            //돌리면서 확장자가 이미지인지
            int cnt = 0;
            for(int i=0; i<allow_file.length; i++) {
                if(filename_ext.equals(allow_file[i])){
                    cnt++;
                }
            }
            //이미지가 아님
            if(cnt == 0) {
                PrintWriter print = response.getWriter();
                print.print("NOTALLOW_"+filename);
                print.flush();
                print.close();
            } else {
                //이미지이므로 신규 파일로 디렉토리 설정 및 업로드
                // 파일 기본경로
                String dftFilePath = request.getSession().getServletContext().getRealPath("/");
                //파일 기본경로 _ 상세경로
                String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator +"multiupload" + File.separator;
                File file = new File(filePath);
                if(!file.exists()) {
                    file.mkdirs();
                }
                String realFileNm = "";
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String today= formatter.format(new java.util.Date());
                realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
                String rlFileNm = filePath + realFileNm;
                ///////////////// 서버에 파일쓰기 /////////////////
                InputStream is = request.getInputStream();
                OutputStream os=new FileOutputStream(rlFileNm);
                int numRead;
                byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
                while((numRead = is.read(b,0,b.length)) != -1){
                    os.write(b,0,numRead);
                }
                if(is != null) {
                    is.close();
                }
                os.flush();
                os.close();
                ///////////////// 서버에 파일쓰기 /////////////////
                // 정보 출력
                sFileInfo += "&bNewLine=true";
                // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
                sFileInfo += "&sFileName="+ filename;;
                sFileInfo += "&sFileURL="+"/resources/editor/multiupload/"+realFileNm;
                PrintWriter print = response.getWriter();
                boardImageRepository.save(BoardImage.of(filePath+realFileNm));
                print.print(sFileInfo);
                print.flush();
                print.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(BoardPost boardPost, HttpServletRequest request){
        int boardId = boardPost.getId();
        String s = "<img[^>]*src=[\"']/resources/editor/multiupload/?([^>\"']+)[\"']?[^>]*>";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(boardPost.getContent());
        String dftFilePath = request.getSession().getServletContext().getRealPath("/");
        String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator +"multiupload" + File.separator;
        while(matcher.find()){
            String s2 = matcher.group(1);
            s2=filePath+s2;
            BoardImage boardImage = boardImageRepository.findByPath(s2);
            boardImage.setBoardId(boardId);
            boardImageRepository.save(boardImage);
            File file = new File(s2);
            file.delete();
        }
        boardImageRepository.deleteAuto();
    }
}
