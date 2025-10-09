package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.TrRegiForm;
import com.example.service.TrRegiService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/*
 * 研修生登録画面用Controller
 */
@Controller
public class TrRegiController {

	@Autowired
	HttpSession session;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TrRegiService trRegiService;

	// 登録ボタン押下
	@RequestMapping(value = "/trRegi", params = "registration", method = RequestMethod.POST)
	public String registration(Model model, @Valid @ModelAttribute TrRegiForm trRegiForm, BindingResult result) {
		if (result.hasErrors()) {
			return "trRegi";
		}

		// 登録処理
		trRegiService.registration(trRegiForm);

		return "trRegi";
	}
}
