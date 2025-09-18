package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.LoginForm;
import com.example.model.TrListForm;

import jakarta.servlet.http.HttpSession;

@Controller
public class MenuController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public String request(Model model,@RequestParam("tran")String tran) {

		switch(tran){
		case "trList":
			model.addAttribute("trListForm",new TrListForm());
			session.removeAttribute("list");
			break;
		case "trRegi":
			break;
		case "trUpde":
			break;
		case "trDele":
			break;
		case "trCount":
			break;
		}
		return tran;
	}
	// ログアウト
	@RequestMapping(value = "/menu", params = "logout", method = RequestMethod.POST)
	public String logout(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		session.invalidate();
		return "login";
	}
}