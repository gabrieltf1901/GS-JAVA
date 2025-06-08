// src/main/java/com/gestaoabrigos/event/AuthEventPublisher.java
package com.gestaoabrigos.event;

import com.gestaoabrigos.model.User;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AuthEventPublisher {
    private final ApplicationEventPublisher publisher;

    public AuthEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishLoginSuccess(User user) {
        publisher.publishEvent(new LoginSuccessEvent(this, user));
    }
}
