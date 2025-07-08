package kr.co.soldesk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.soldesk.beans.UserBean;

public class UserValidator implements Validator {

	@Override // 데이터 베이스 잡기.
	public boolean supports(Class<?> clazz) {

		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userbean = (UserBean) target;

		String beanName = errors.getObjectName();
		if (beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if (userbean.getUser_pw().equals(userbean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}

			// 회원가입시에만 사용
			if (beanName.equals("joinUserBean")) {
				if (userbean.isUserIdExist() == false) {
					errors.rejectValue("user_id", "DontCheckUserIdExist");
				}
			}
		} // if

	} // validate

}
