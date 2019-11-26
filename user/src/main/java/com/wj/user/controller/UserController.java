package com.wj.user.controller;

import com.wj.api.entity.Role;
import com.wj.api.entity.User;
import com.wj.api.service.RoleServiceFeignClient;
import com.wj.user.Global;
import com.wj.user.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Slf4j
@RequestMapping("user")
@RestController
public class UserController {

	private final UserServiceImpl userServiceImpl;

	private final RestTemplate restTemplate;

	private final Global global;

	private final RoleServiceFeignClient roleService;


	public UserController(UserServiceImpl userServiceImpl, RestTemplate restTemplate, Global global, RoleServiceFeignClient roleService) {
		this.userServiceImpl = userServiceImpl;
		this.restTemplate = restTemplate;
		this.global = global;
		this.roleService = roleService;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUSerById(@PathVariable String id) {
		User user = userServiceImpl.getUserById(id);

		Role[] str = restTemplate.getForObject("http://"+global.getRoleServerName()+"/role/list/" + id, Role[].class);
		assert str != null;
		user.setRoleList(Arrays.asList(str));

		return user;
	}

	@RequestMapping(value = "/feign/{id}", method = RequestMethod.GET)
	public User getUSerByIdWithFeign(@PathVariable String id) {
		User user = userServiceImpl.getUserById(id);

		user.setRoleList(roleService.findRoleByUserId(id));
		return user;
	}

}
