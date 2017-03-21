package me.skhu.controller.admin;

import javax.servlet.http.HttpServletResponse;

import me.skhu.domain.Introduce;
import me.skhu.domain.dto.AdminDto;
import me.skhu.domain.dto.UserExcelDto;
import me.skhu.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.domain.dto.UserDto;
import me.skhu.service.AdminService;
import me.skhu.util.Excel.ExcelRead;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private IntroduceService introduceService;

	@RequestMapping("excelDownload")
	public void excelDownload(Model model, HttpServletResponse response) throws Exception{
		ExcelRead excel = new ExcelRead();
		excel.xlsxWriter(adminService.findExcelList(),response);
	}

	@RequestMapping(value = "excelUpload" , method=RequestMethod.GET)
	public String excelUpload(){
		return "admin/excelUpload";
	}

	@RequestMapping(value = "excelUpload" , method=RequestMethod.POST)
	public String excelUpload(Model model, @RequestParam("excelFile") MultipartFile files, MultipartHttpServletRequest request) throws IOException {
		List<UserExcelDto> list = adminService.excelRead(files, request);
		model.addAttribute("excelList",list);
		return "admin/excelUpload";
	}

	@RequestMapping(value = "userExcelInsert" , method=RequestMethod.POST)
	public String userExcelInsert(UserDto userDto){
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

	@RequestMapping(value = "introduceEdit", method = RequestMethod.GET)
	public String introduceEdit(Model model){
		model.addAttribute("introduce",introduceService.find());
		return "admin/introduceEdit";
	}

	@RequestMapping(value="introduceEdit", method = RequestMethod.POST)
	public String introduceEdit(Model model, Introduce introduce){
		introduceService.save(introduce);
		return "admin/introduce";
	}

	@RequestMapping(value="introduce",method = RequestMethod.GET)
	public String introduce(Model model){
		model.addAttribute("introduce",introduceService.find());
		return "admin/introduce";
	}

}