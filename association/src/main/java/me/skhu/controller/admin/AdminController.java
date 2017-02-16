package me.skhu.controller.admin;

import javax.servlet.http.HttpServletResponse;

import me.skhu.config.security.SecurityAdminDetails;
import me.skhu.domain.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.domain.dto.UserDto;
import me.skhu.service.AdminService;
import me.skhu.util.Excel;

import java.io.IOException;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("excelDownload")
	public void excelDownload(Model model, HttpServletResponse response) throws Exception{
		Excel excel = new Excel();
		excel.xlsxWriter(adminService.findExcelList(0),response);
	}

	@RequestMapping(value = "excelUpload" , method=RequestMethod.GET)
	public String excelUpload(){
		return "admin/excelUpload";
	}

	@RequestMapping(value = "excelUpload" , method=RequestMethod.POST)
	public String excelUpload(Model model, @RequestParam("excelFile") MultipartFile files, MultipartHttpServletRequest request) throws IOException {
		model.addAttribute("excelList",adminService.excelRead(files, request));
		return "admin/excelUpload";
	}

	@RequestMapping(value = "userExcelInsert" , method=RequestMethod.POST)
	public String userExcelInsert(UserDto userDto){
		System.out.println(userDto.getImage());
		System.out.println(userDto.getBirth());
		System.out.println(userDto.getCategoryName());
		adminService.saveuUserList(userDto);
		return "boardpost/list";
	}

	@RequestMapping(value="adminSave", method = RequestMethod.GET)
	public String adminSave(Model model){
		AdminDto adminDto = new AdminDto();
		adminDto.setCategoryId(1);
		adminDto.setCategoryName("함께맞는빕");
		model.addAttribute("adminDto",adminDto);
		return "admin/save";
	}

	@RequestMapping(value = "adminSave" , method = RequestMethod.POST)
	public String adminSave(AdminDto adminDto){
		adminService.saveAdmin(adminDto);
		return "admin/save";
	}

}