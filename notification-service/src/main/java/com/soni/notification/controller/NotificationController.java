package com.soni.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class NotificationController {

    @GetMapping
    public List getNotification(){
        return new ArrayList<>();
    }
}
