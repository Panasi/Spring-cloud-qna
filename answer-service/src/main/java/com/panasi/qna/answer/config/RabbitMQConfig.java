package com.panasi.qna.answer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class RabbitMQConfig {
	
	@Bean
	MessageConverter messageConverter(Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
	    return new Jackson2JsonMessageConverter(jackson2ObjectMapperBuilder.build());
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
	    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	    rabbitTemplate.setMessageConverter(messageConverter);
	    return rabbitTemplate;
	}
	
	@Bean
	Queue isQuestionExistsQueue() {
	    return new Queue("isQuestionExistsQueue");
	}
	
	@Bean
	Queue getAnswerRatingQueue() {
	    return new Queue("getAnswerRatingQueue");
	}

}
