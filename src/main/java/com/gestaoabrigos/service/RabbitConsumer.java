package com.gestaoabrigos.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitConsumer {

    @RabbitListener(queues = "fila.abrigos")
    public void receiveAbrigo(Object message) {
        System.out.println("Mensagem de abrigo recebida: " + message);
    }

    @RabbitListener(queues = "fila.recursos")
    public void receiveRecurso(Object message) {
        System.out.println("Mensagem de recurso recebida: " + message);
    }
}
