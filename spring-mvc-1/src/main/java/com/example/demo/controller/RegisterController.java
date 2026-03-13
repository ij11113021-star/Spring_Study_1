package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.UserForm;
import com.example.demo.domain.service.UsersRegisterService;

import ch.qos.logback.core.model.Model;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class RegisterController {

	@Autowired
	private UsersRegisterService usersRegisterService;

	@GetMapping("/form")
	private String readForm(@ModelAttribute UserForm userForm) {
		return "form";
	}

	@PostMapping("/form")
	private String confirm(@Validated(UserForm.Groups.class) @ModelAttribute UserForm userForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// エラーがある場合、form.htmlに戻る
			return "form";

		}
		boolean hasError = usersRegisterService.isValid(userForm, result);
		if (hasError) {
			return "form";
		}

		// 登録処理
		usersRegisterService.register(userForm);

		return "confirm";
	}
}
