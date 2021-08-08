package com.shlomi.ProducerAndConsumer.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class JSONFormatter {

    public static String ConvertXMLToJson(String message) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        //Reading the XML
        JsonNode jsonNode = xmlMapper.readTree(message.getBytes());
        //Create a new ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(jsonNode);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectMapper.readTree(jsonValue));
    }
}
