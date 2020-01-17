package com.isa.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ApiDataParser {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> List<T> parse(String FILENAME, Class<T> tClass) throws IOException {
        logger.info("Parsing List from filename");
        logger.info("file: " + FILENAME);

        return objectMapper.readValue(new File(FILENAME), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass));
    }

}
