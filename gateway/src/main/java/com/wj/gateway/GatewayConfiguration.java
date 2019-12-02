package com.wj.gateway;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author Eric Zhao
 */
@Configuration
public class GatewayConfiguration {

	/**
	 * 默认实现为 DefaultBlockRequestHandler，
	 * 当被限流时会返回类似于下面的错误信息：Blocked by Sentinel: FlowException
	 */
	@Bean
	public BlockRequestHandler blockRequestHandler() {
		return (exchange, t) ->
				ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS.value())
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(fromObject("SCS Sentinel block"));
	}

}
