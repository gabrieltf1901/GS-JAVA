// RabbitConfig.java
package com.gestaoabrigos.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração de RabbitMQ: filas, exchange e bindings.
 */
@Configuration
public class RabbitConfig {

    public static final String ABRIGOS_QUEUE = "fila.abrigos";
    public static final String RECURSOS_QUEUE = "fila.recursos";
    public static final String EXCHANGE_NAME  = "exchange.abrigos";
    public static final String ROUTING_KEY_ABRIGOS  = "routing.key.abrigos";
    public static final String ROUTING_KEY_RECURSOS = "routing.key.recursos";

    @Bean
    public Queue abrigosQueue() {
        return new Queue(ABRIGOS_QUEUE, true);
    }

    @Bean
    public Queue recursosQueue() {
        return new Queue(RECURSOS_QUEUE, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingAbrigos(Queue abrigosQueue, DirectExchange exchange) {
        return BindingBuilder.bind(abrigosQueue)
                .to(exchange)
                .with(ROUTING_KEY_ABRIGOS);
    }

    @Bean
    public Binding bindingRecursos(Queue recursosQueue, DirectExchange exchange) {
        return BindingBuilder.bind(recursosQueue)
                .to(exchange)
                .with(ROUTING_KEY_RECURSOS);
    }
}
