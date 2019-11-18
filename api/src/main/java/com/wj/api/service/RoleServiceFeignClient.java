package com.wj.api.service;

import com.wj.api.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@RequestMapping(value = "/role")
@FeignClient(name = "service-role")
public interface RoleServiceFeignClient {

	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	List<Role> findRoleByUserId(@PathVariable String userId);

}
