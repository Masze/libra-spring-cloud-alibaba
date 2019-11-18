package com.wj.role.controller;

import com.wj.role.entity.Role;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("role")
@RestController
public class RoleController {

	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	public List<Role> findRoleByUserId(@PathVariable String userId) {
		List<Role> list = new ArrayList<>();
		if ("999".equals(userId)) {
			Role e = new Role();
			e.setId("1");
			e.setName("1");
			list.add(e);
			Role r = new Role();
			r.setId("2");
			r.setName("2");
			list.add(r);
		}

		return list;
	}
}
