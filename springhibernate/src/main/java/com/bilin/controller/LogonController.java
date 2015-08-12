package com.bilin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bilin.service.LoginServiceInterface;
import com.bilin.util.Md5Util;

@Controller
public class LogonController {

	private LoginServiceInterface loginHelper;

	private LoginServiceInterface getLoginHelper() {
		return loginHelper;
	}

	@Autowired
	private void setLogonHelper(LoginServiceInterface logionHelper) {
		this.loginHelper = logionHelper;
	}

	@RequestMapping(value = "/logon", method = RequestMethod.POST)
	public String login(RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("username") String username, @RequestParam("password") String password) {

		if (username == "" || password == "") {
			redirectAttributes.addFlashAttribute("message", "用户信息为空");
			return "redirect:/";
		}
		//password = Md5Util.getMd5Hex(password);
		//int userid = this.getLoginHelper().validate(username, password);
		int userid = 0;
		if (userid != -1) {
			// System.out.println("logon enter!!!!!!");
			request.getSession().setAttribute("userid", userid);
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("scope", 0);
			return "redirect:/index";

		}
		else {
			// System.out.println("logon failed!!!!!!");
			redirectAttributes.addFlashAttribute("message", "user not exist");
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/quit")
	public String quit(RedirectAttributes redirectAttributes, HttpServletRequest request) {
		request.getSession().setAttribute("username", null);
		request.getSession().setAttribute("userid", null);
		request.getSession().setAttribute("scope", null);
		return "redirect:/";
	}

	@RequestMapping(value = "/main")
	public ModelAndView post(HttpServletRequest request) {
		ModelAndView main;
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		if (userid == null) {
			main = new ModelAndView("logon");
		}
		else {
			main = new ModelAndView("main");
			main.addObject("username", request.getSession().getAttribute("username"));
		}
		return main;
	}


	@RequestMapping(value = "/index")
	public ModelAndView usertoolspost(HttpServletRequest request) {
		ModelAndView main;
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		if (userid == null) {
			main = new ModelAndView("logon");
		}
		else {
			main = new ModelAndView("index");
		}
		return main;
	}

	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public ModelAndView regist(HttpServletRequest request) {
		ModelAndView regist = new ModelAndView("regist");
		return regist;
	}

}