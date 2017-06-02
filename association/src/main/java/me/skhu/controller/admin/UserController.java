package me.skhu.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.skhu.repository.UserRepository;
import me.skhu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import me.skhu.domain.dto.OriginUserDto;
import me.skhu.domain.dto.UserDto;
import me.skhu.domain.dto.UserForm;
import me.skhu.util.Pagination;
import me.skhu.util.PaginationUser;
import me.skhu.util.Excel.ExcelRead;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private OriginUserService originUserService;

	@Autowired
	private OriginUserPhoneService originUserPhoneSerice;

	@Autowired
	private PositionService positionService;

	//Spring Security session information check

	@Autowired
	private AdminService adminService;

	@Autowired
	private FileService fileService;

	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute("pagination") PaginationUser pagination){
		pagination.setPageSize(10);
		model.addAttribute("position", positionService.getUserType());
		model.addAttribute("list",userService.list(pagination));
		return "user/list";
	}

	@RequestMapping(value="/list", method=RequestMethod.POST, params="cmd=delete")
	public String deleteUser(Model model, @ModelAttribute("pagination") PaginationUser pagination, String[] del)throws Exception{
		userService.delete(del);
		return "redirect:/user/list?"+pagination.getQueryString();
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model){
		model.addAttribute("userDto",userService.newUserDto());
		model.addAttribute("position", positionService.getUserType());
		return "user/edit";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST, params="cmd=save")
	public String create(Model model, UserDto userDto){
		userService.create(userDto);
		return "redirect:/user/list";
	}

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") int id, @ModelAttribute("pagination") PaginationUser pagination, HttpServletRequest request){
		String imgPath="/resources/upload/profileImg/"+id+"_img.png";
		File file = new File(request.getSession().getServletContext().getRealPath("/")+imgPath);
		if(!file.exists())
			imgPath = "/resources/upload/profileImg/user.png";
		model.addAttribute("imgPath", imgPath);
		model.addAttribute("userDto", userService.findById(id));
		model.addAttribute("position", positionService.getUserType());
		return "user/edit";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST, params="cmd=save")
	public String edit(Model model, @RequestParam("id") int id, UserDto userDto, @ModelAttribute("pagination") PaginationUser pagination)throws Exception{
		userService.update(userDto,id);
		return "redirect:/user/list?"+pagination.getQueryString();
	}

	@RequestMapping(value="userEditList", method=RequestMethod.GET)
	public String userEditList (Model model, Pagination pagination){
		model.addAttribute("userEditList",userService.getEditUser(pagination));
		return "user/userEditList";
	}

	@RequestMapping(value = "/userEditAgree" , method=RequestMethod.GET)
	@ResponseBody
	public void userEditAgree(@RequestParam(value="checkList[]") List<String> checked){
		System.out.println("checkList[] : " + checked);
		System.out.println("checked[0]: " + checked.get(0));
		System.out.println("checked[1]: " + checked.get(1).toString());
	}

	@RequestMapping(value="userEditDetail", method = RequestMethod.GET)
	public String userEditDetails(Model model, @RequestParam("id") int id){
		OriginUserDto originUser = originUserService.findById(id);
		model.addAttribute("originUser",originUser);
		model.addAttribute("user",userService.findById(originUser.getUserId()));
		return "user/userEditDetail";
	}

	@RequestMapping(value = "phoneNumberEditList", method = RequestMethod.GET)
	public String phoneNumberEditList(Model model, Pagination pagination){
		model.addAttribute("list",originUserPhoneSerice.pagination(pagination));
		return "user/phoneNumberEditList";
	}

	@RequestMapping(value = "agree", method = RequestMethod.GET)
	public @ResponseBody String agree(@RequestParam("id") int id) {
		try {
			originUserPhoneSerice.agree(id);
			return "success";
		} catch (Exception e) {
			return "false";
		}
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST, params="cmd=delete")
	public String deleteOne(Model model, @RequestParam("id") int id, UserDto userDto, @ModelAttribute("pagination") PaginationUser pagination)throws Exception{
		userService.deleteOne(id);
		return "redirect:/user/list?"+pagination.getQueryString();
	}

	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String imageTest(Model model,@RequestParam("id") int id, @RequestParam("cma_file") MultipartFile uploadFile, HttpServletRequest request) throws Exception{
		userService.saveImg(request.getServletContext().getRealPath("/"),id,uploadFile);
		return "redirect:/user/edit?id="+id;
	}

	@RequestMapping("/typeList")
	public String list(Model model){
		model.addAttribute("list", positionService.getUserType());
		return "user/typeList";
	}

	@RequestMapping(value="/createType", method=RequestMethod.GET)
	public String createType(Model model){
		return "user/createType";
	}

	@RequestMapping(value="/createType", method=RequestMethod.POST)
	public String createType(String type, String name){
		positionService.createType(type,name);
		return "redirect:/user/typeList";
	}

	@RequestMapping(value="agrees", method = RequestMethod.GET)
	public @ResponseBody String agrees(@RequestParam(value = "id" , required = true) List<Integer> id){
		try{
			originUserPhoneSerice.agrees(id);
			return "success";
		}catch (Exception e){
			return "fail";
		}
	}

	@RequestMapping("/createByExcel")
	public String createByExcel(Model model){
		return "user/createByExcel";
	}

	@RequestMapping("excelDownload")
	public void excelDownload(Model model, HttpServletRequest request,HttpServletResponse response) throws Exception{
		ExcelRead excel = new ExcelRead();
		excel.xlsxWriter(adminService.findExcelList(),response, request);
	}

	@RequestMapping(value = "excelUpload" , method=RequestMethod.GET)
	public String excelUpload(){
		return "user/createByExcel";
	}

	@RequestMapping(value = "excelUpload" , method=RequestMethod.POST)
	public String excelUpload(Model model, @RequestParam("excelFile") MultipartFile files, MultipartHttpServletRequest request) throws IOException {
		UserForm userForm = new UserForm();
		userForm.setList(adminService.excelRead(files, request));
		model.addAttribute("excelList",userForm);
		return "user/createByExcel";
	}

	@RequestMapping(value = "userExcelInsert" , method=RequestMethod.POST)
	public String userExcelInsert(@ModelAttribute UserForm userForm, @ModelAttribute("pagination") PaginationUser pagination, @RequestParam(value="values") List<String> values){
		adminService.saveuUserList(userForm.getList(),values);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "imageUpload", method = RequestMethod.POST)
	public String userImageUpload(MultipartFile imageFile, MultipartHttpServletRequest request) throws Exception{
		fileService.zipUpload(imageFile,request);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "imageDownload" ,method = RequestMethod.GET)
	public void imageDownload(HttpServletResponse response){
		fileService.imageDownload(response);
	}
}
