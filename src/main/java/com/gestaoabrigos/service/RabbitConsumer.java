// RabbitConsumer.java
package com.gestaoabrigos.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Serviço consumidor de mensagens do RabbitMQ.
 */
@Service
public class RabbitConsumer {

    @RabbitListener(queues = "fila.abrigos")
    public void receiveAbrigo(Object message) {
        // Lógica de processamento de mensagem de abrigo
        System.out.println("Mensagem de abrigo recebida: " + message);
    }

    @RabbitListener(queues = "fila.recursos")
    public void receiveRecurso(Object message) {
        // Lógica de processamento de mensagem de recurso
        System.out.println("Mensagem de recurso recebida: " + message);
    }
}
