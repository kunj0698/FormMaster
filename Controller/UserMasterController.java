package com.Project.FormMaster.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Project.FormMaster.Dto.UserMasterDto;
import com.Project.FormMaster.Entity.UserMaster;
import com.Project.FormMaster.Service.UserMasterService;

@Controller
public class UserMasterController 
{

	@Autowired
	UserMasterService ums;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@RequestMapping("/login")
	public String login() 
	{
		return "index";
	}
	
	
	
	@RequestMapping("/masterUser")
	public String FillForm() {
		return "master_users";
	}
	
	
	
	
	@PostMapping("/AddUser") 
	/*public String AddProduct(@ModelAttribute ProductDto proDto, @RequestParam("image") MultipartFile multipartFile)*/
	public @ResponseBody String  AddUserData(@RequestPart("UserMstDto")UserMasterDto UserMstDto, @RequestPart(value="imageUpload") MultipartFile multipartFile) throws IOException{
		
		
	    System.out.println(UserMstDto.getContactNo());
	    System.out.println(UserMstDto.getEmail());
	    System.out.println(UserMstDto.getFirstName());
	    System.out.println(UserMstDto.getLastName());
		String id=ums.AddUserData(UserMstDto,multipartFile);
	    
     	return id;
		
	}
	
	//ROLE
	@GetMapping("/role")
	public @ResponseBody List<Object[]> role() {
		List<Object[]> a = ums.role();
		return a;
	}
	//GENDER
	
	@GetMapping("/gender")
	public @ResponseBody List<Object[]> gender() {
		List<Object[]> b = ums.gender();
		return b;
	}
	
	//GRID
	@GetMapping("/load")
	public @ResponseBody List<Object[]> Grid() {
		List<Object[]> ss = ums.Grid();
		System.out.println(ss);
		return ss;
	}
	
	//EDIT
	@GetMapping("/edituser/{userMasterId}")
	@ResponseBody
	public Optional<UserMaster> edit(@PathVariable("userMasterId") int userMasterId) {
		System.out.println(userMasterId);
		return ums.edit(userMasterId);
	}
	
	//DELETE
	@ResponseBody
	@DeleteMapping("/DelUser/{userMasterId}")

	public String UserDel(@PathVariable("userMasterId") int userMasterId) {
		ums.UserDel(userMasterId);
		return "deleted";
	}

}
