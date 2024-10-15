package com.appling.paging.application.paging_concept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.appling.paging.application.paging_concept.entity.User;
import com.appling.paging.application.paging_concept.service.UserService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getAllUsers(@RequestParam(defaultValue = "0") int page, ModelMap model) {
		Page<User> userPage = userService.findUsers(page, 20);
		model.put("userList", userPage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", userPage.getTotalPages());
		return "user-list";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage() {
		return "welcome";
	}

	@RequestMapping(value = "/delete-user")
	public String deleteDataById(@RequestParam int id) {
		System.out.println("printID:------" + id);
		userService.deleteUserData(id);
		return "redirect:users";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showAddUserPage(ModelMap model) {
		User userToBeAdded = new User(null, "", "", "");
		model.put("user", userToBeAdded);
		return "add-user";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(@Valid User user) {
		userService.addUser(user);
		return "redirect:users";
	}

}
