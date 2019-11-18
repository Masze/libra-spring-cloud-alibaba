package com.wj.user;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@Component
@RefreshScope
public class Global {

	@Value("${role.server.name:service-role}")
	private String roleServerName;

}
