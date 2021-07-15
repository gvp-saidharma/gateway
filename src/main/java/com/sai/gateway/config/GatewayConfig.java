package com.sai.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        String user = "user"; //'localhost'
        String course = "course"; //'localhost'
        return builder.routes()
                .route(r -> r.path("/token/*").or().path("/test")
                        .filters(f -> f.filter(filter))
                        .uri("http://"+user+":3004"))
                .route( r -> r.path("/api/auth/*")
                        .filters(f -> f.filter(filter))
                        .uri("http://"+user+":3004"))
                .route( r -> r.path("/testing")
                        .filters(f -> f.filter(filter))
                        .uri("http://"+course+":3005"))
                .route( r -> r.path("/course*")
                        .filters(f -> f.filter(filter))
                        .uri("http://"+course+":3005"))
                .route( r -> r.path("/course/*")
                        .filters(f -> f.filter(filter))
                        .uri("http://"+course+":3005"))
                .route( r -> r.path("/mycourse*")
                        .filters(f -> f.filter(filter))
                        .uri("http://"+course+":3005"))
                .route( r -> r.path("/mycourse/*")
                        .filters(f -> f.filter(filter))
                        .uri("http://"+course+":3005"))
                .build();
    }
}
