package com.portflioproject.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class JsonStorage {
    // ObjectMapper is the main class in Jackson for JSON conversion
    // enable(INDENT_OUTPUT) formats the JSON to be human-readable
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    private JsonStorage() {}

    // Save a list to a JSON file using File I/O
    public static <T> void save(String filePath, List<T> items) throws IOException {
        File file = new File(filePath);
        // Create the directory if it doesn't exist (File I/O)
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        // Jackson converts the list to JSON and writes it to the file
        MAPPER.writeValue(file, items);
    }

    // Load a list from a JSON file (Data Retrieval)
    public static <T> List<T> load(String filePath, Class<T> clazz) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        // Jackson reads the file and converts it back to a List of objects
        return MAPPER.readValue(file, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
    }
}