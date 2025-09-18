package com.example.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.LoginEntity;
import com.example.model.LoginForm;
import com.example.service.LoginService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private LoginService loginService;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@RequestMapping(value = "/login", params = "login", method = RequestMethod.POST)
	public String login(Model model, @Valid @ModelAttribute LoginForm loginForm, BindingResult result) {
		// バリデーションエラー
		if (result.hasErrors()) {
			return "login";
		}

		LoginEntity entity = loginService.selectUser(loginForm);

		// ユーザー情報が存在しない
		if (entity == null) {
			model.addAttribute("message", messageSource.getMessage("loginError", new String[] {}, Locale.JAPAN));
			return "login";
		}

		session.setAttribute("name", entity.getUserName());
		return "top";
	}
}
