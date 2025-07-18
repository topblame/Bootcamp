package kr.co.soldesk.controller;

import java.nio.file.attribute.UserPrincipalLookupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.soldesk.service.UserService;

@RestController
@RequestMapping("/user")
public class RestApiController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		//1. select sql -> dao -> service ->controller
		boolean chk = userService.checkuserIdExist(user_id);
		
		return chk+"";
	}
	

	
	
}
