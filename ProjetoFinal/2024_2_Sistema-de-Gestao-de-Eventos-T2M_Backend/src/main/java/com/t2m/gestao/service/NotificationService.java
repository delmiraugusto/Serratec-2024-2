package com.t2m.gestao.service;

import com.t2m.gestao.model.Notification;
import com.t2m.gestao.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;


    public List<Notification> listarNotificacoesPorEmail(String corporativeEmail) {
        return notificationRepository.findByEmail(corporativeEmail);
    }

    public boolean markNotificationAsRead(Long id) {
        Optional<Notification> notificationOptional = notificationRepository.findById(id);
        if (notificationOptional.isPresent()) {
            Notification notification = notificationOptional.get();
            notification.setRead(true);
            notificationRepository.save(notification);
            return true;
        }
        return false;
    }


    private final Map<String, Sinks.Many<String>> userNotificationSinks = new ConcurrentHashMap<>();

    public Flux<String> registerUser(String email) {
        Sinks.Many<String> sink = userNotificationSinks.computeIfAbsent(email, id -> Sinks.many().multicast().onBackpressureBuffer());
        return sink.asFlux().doOnCancel(() -> {
            removeUser(email);
        });
    }

    public void removeUser(String email) {
        userNotificationSinks.remove(email);
    }

    public String sendNotification(String email, String title, String message) {
        Notification notification = new Notification();
        notification.setEmail(email);
        notification.setTitulo(title);
        notification.setMensagem(message);

        notificationRepository.save(notification);

        Sinks.Many<String> sink = userNotificationSinks.get(email);
        if (sink != null) {
            sink.tryEmitNext(title);
            System.out.println("Aqui era pra ter enviado");
        } else {
            System.out.println("Usuário não está conectado: " + email);
        }
        return "ok";
    }


}
