package com.cleanarchitecture.todos.api.presenter.rest.group;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleanarchitecture.todos.api.presenter.rest.requests.GroupCreateRequest;

@RestController
@RequestMapping("/groups")
public class TodoGroupController {
	
	@GetMapping("/")
	public String create(GroupCreateRequest groupCreateRequest) {
		return "working";
	}
}
