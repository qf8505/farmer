package com.qf.farmer.resource.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qf.farmer.resource.domain.Message;

@RestController
public class ResourceController {

	@PreAuthorize("hasAuthority('ROLE_USER')")
	@RequestMapping("/")
	public Message message() {
		return new Message("Hello World");
	}
}
