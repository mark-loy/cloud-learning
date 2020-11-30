package com.mark.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 木可
 * @version 1.0
 * @date 2020/11/29 14:35
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator getRouter(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("gateway_route_1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("gateway_route_2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }
}
