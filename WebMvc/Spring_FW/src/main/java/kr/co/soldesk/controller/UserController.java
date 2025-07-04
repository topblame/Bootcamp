package kr.co.soldesk.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.soldesk.beans.UserBean;
import kr.co.soldesk.service.UserService;
import kr.co.soldesk.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// UserBean의 loginUserBean객체로서 session 영역을 의미함.
	@Resource(name = "loginUserBean")
	@Lazy // 안전장치. 
	private UserBean loginUserBean;

	// topmenu -> user/login @ModelAttribute("tempLoginUserBean") -> login.jsp
	// (model) -> user/login_pro
	// 객체 유효성 적용.
	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
			 @RequestParam(value = "fail", defaultValue = "false") boolean fail, Model model) {
		//fail에 false면 실패하지 않았음 이므로 성공. 정상출력
		model.addAttribute("fail", fail);
		
		return "user/login";
	}

	// 유효성 적용 + 결과 유무.
	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("tempLoginUserBean") UserBean tempLoginUserBean,
			BindingResult result) {

		if (result.hasErrors()) {
			return "user/login"; // 처음부터 다시 시작.
		}
		userService.getLoginUserInfo(tempLoginUserBean);
		
		if(loginUserBean.isUserLogin()==true) {
			return "user/login_success"; // 유효성통과하고, 로그인 성공
		}
		return "user/login_fail";  // 유효성통과했으나 로그인 실패.
	}

	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}

	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {

		if (result.hasErrors()) {
			return "user/join"; // 유효성 검사에 충족하지 못하여 실패.
		}

		userService.addUserInfo(joinUserBean);
		return "user/join_success"; // 유효성 검사에 성공
	}//

	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}

	@GetMapping("/logout")
	public String logout() {
		loginUserBean.setUserLogin(false);
		return "user/logout";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}

}
