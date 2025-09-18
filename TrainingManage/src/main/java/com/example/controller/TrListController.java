package com.example.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.TrListEntity;
import com.example.model.TrListForm;
import com.example.service.TrListService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/*
 * 研修生一覧画面用Controller
 */
@Controller
public class TrListController {

	@Autowired
	public SmartValidator validator;

	@Autowired
	HttpSession session;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private TrListService trListService;

	// 検索ボタン押下
	@RequestMapping(value = "/trList/search", method = RequestMethod.POST)
	@ResponseBody
	public String search(@Valid TrListForm trListForm, BindingResult result, Model model) {
		String message = "";
		if (result.hasErrors()) {
			// エラーメッセージを改行付与して結合
			for (ObjectError error : result.getFieldErrors()) {
				// メッセージを取得する
				message += messageSource.getMessage(error, Locale.JAPAN) + "\n";
			}
			return message;
		}
		trListForm.setTrainingStart(trListForm.getTrainingStart().replaceAll("-", "/"));
		List<TrListEntity> list = trListService.selectTrList(trListForm);
		if (list == null) {
			message = messageSource.getMessage("listNull", new String[] {}, Locale.JAPAN);
		}
		session.setAttribute("list", list);
		//メッセージを返却
		return message;
	}

	@RequestMapping(value = "/iframe")
	public String iframe() {
		return "trListSearch";
	}

	@RequestMapping(value = "/trList", params = "csv", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
			+ "; charset=UTF-8; Content-Disposition: attachment")
	@ResponseBody
	public String csvDownload(HttpServletResponse response) {
		List<TrListEntity> list = (List<TrListEntity>) session.getAttribute("list");
		if(list == null) {
			list = new ArrayList<TrListEntity>();
		}
		try {
			String str = "名前,性別,新卒：中途,研修開始日,pc番号,st2合格日数,担当講師\n";
			for (TrListEntity entity : list) {
				str += entity.getName() + "," + entity.getGender() + "," + entity.getNewhalfway() + ","
						+ entity.getTrainingStart() + "," + entity.getPcNumber() + "," + entity.getStep2Pass() + ","
						+ entity.getLecturerName() + "\n";
			}
			byte[] file = str.getBytes();
			OutputStream os = response.getOutputStream();
			os.write(file);
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=traineeList.csv");
			response.setContentLength(file.length);
			os.write(file);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
