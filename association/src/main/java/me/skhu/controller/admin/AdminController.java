package me.skhu.controller.admin;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import me.skhu.service.AdminService;
import me.skhu.util.Excel;

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
}