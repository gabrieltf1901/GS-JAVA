// src/main/java/com/gestaoabrigos/event/LoginSuccessEvent.java
package com.gestaoabrigos.event;

import com.gestaoabrigos.model.User;

public record LoginSuccessEvent(Object source, User user) { }
