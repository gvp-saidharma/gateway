package com.sai.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GatewayController {

    @RequestMapping("/coursefallback")
    public Mono<String> courses() {
        return Mono.just("Course API is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/paymentfallback")
    public Mono<String> payments() {
        return Mono.just("Payment API is taking too long to respond or is down. Please try again later");
    }
}
