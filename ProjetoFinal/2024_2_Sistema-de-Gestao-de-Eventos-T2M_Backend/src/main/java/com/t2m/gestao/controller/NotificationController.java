package com.t2m.gestao.controller;

import com.t2m.gestao.model.Notification;
import com.t2m.gestao.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    @ResponseBody
    public  List<Notification> listarNotificacoesPorEmail(@RequestParam String email) {
        return notificationService.listarNotificacoesPorEmail(email);
    }

    @PutMapping("/{id}/read")
    public String markNotificationAsRead(@PathVariable Long id) {
        boolean updated = notificationService.markNotificationAsRead(id);
        if (updated) {
            return "Notification marked as read.";
        } else {
            return "Notification not found.";
        }
    }
    @GetMapping(value = "/queue", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> connect(@RequestParam String email){
        return notificationService.registerUser(email);
    }
}
