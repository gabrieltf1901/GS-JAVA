// src/main/java/com/gestaoabrigos/event/LoginSuccessHandler.java
package com.gestaoabrigos.event;

import com.gestaoabrigos.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler {

    private static final Logger logger = LogManager.getLogger(LoginSuccessHandler.class);

    @EventListener
    public void onLoginSuccess(LoginSuccessEvent event) {
        User user = event.user();
        logger.info("Login bem-sucedido para: " + user.getUsername());
        // ... outras ações ...
    }
}
