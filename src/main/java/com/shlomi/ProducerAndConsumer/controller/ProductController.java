package com.shlomi.ProducerAndConsumer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.shlomi.ProducerAndConsumer.config.RabbitMQProducerConfiguration;
import com.shlomi.ProducerAndConsumer.entity.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    final ObjectMapper xmlMapper = new XmlMapper();

    @PostMapping
    public Product sendProduct(@RequestBody Product product) throws Exception {

        //Converts JSON to XML
        final String xml = xmlMapper.writeValueAsString(new Product(product.getProductId(), product.getName(), product.getQuantity()));

        System.out.println("Sending message...");
        Product responseProduct = (Product) rabbitTemplate.convertSendAndReceive(RabbitMQProducerConfiguration.topicExchangeName, "message_routing_key", xml);
        return responseProduct;
    }

}