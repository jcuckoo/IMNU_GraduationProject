package film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import film.bean.User;
import film.service.RegisterService;


/*
 * ÓÃ»§×¢²á
 */
@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = "/RegisterController", method = RequestMethod.POST)
	public String Register(User userInfo) {

		if (registerService.Register(userInfo) == 1)
			return "index";
		else
			return "index";
	}
}
