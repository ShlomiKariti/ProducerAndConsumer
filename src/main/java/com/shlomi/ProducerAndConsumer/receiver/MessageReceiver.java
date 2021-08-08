package com.shlomi.ProducerAndConsumer.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shlomi.ProducerAndConsumer.entity.Product;
import com.shlomi.ProducerAndConsumer.utils.JSONFormatter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MessageReceiver {

    @RabbitListener(queues = "message_queue")
    public Product receiveMessage(String message) throws Exception {


        //Converts XML String into a formatted JSON String
        String jsonValue = JSONFormatter.ConvertXMLToJson(message);
//        System.out.println("Mapped to JSON:\n" + jsonValue);

        //Converts JSON String into an Object of type Product
        Product product = new ObjectMapper().readValue(jsonValue, Product.class);
//        System.out.println("Mapped to Object:\n" + product);


        System.out.println("Response sent successfully");

        return product;

    }
}