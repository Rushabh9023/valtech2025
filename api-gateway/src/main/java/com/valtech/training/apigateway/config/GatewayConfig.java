package com.valtech.training.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	
@Bean
public RouteLocator routeLocator(RouteLocatorBuilder builder) {
	return builder.routes()
			.route(p -> p.path("/get").uri("http://httpbin.org:80"))
			.build();
}
	
}
