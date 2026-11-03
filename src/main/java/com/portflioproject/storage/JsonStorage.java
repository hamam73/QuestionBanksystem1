package com.portflioproject.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class JsonStorage {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private JsonStorage() {}

    public static <T> void save(Path file, List<T> items, Class<T> clazz) throws IOException {
        Type listType = TypeToken.getParameterized(List.class, clazz).getType();
        Path parent = file.toAbsolutePath().getParent();
        if (parent != null) Files.createDirectories(parent);
        Files.writeString(file, GSON.toJson(items, listType));
    }

    public static <T> List<T> load(Path file, Class<T> clazz) throws IOException {
        if (!Files.exists(file)) return new ArrayList<>();
        Type listType = TypeToken.getParameterized(List.class, clazz).getType();
        String json = Files.readString(file);
        List<T> list = GSON.fromJson(json, listType);
        return list != null ? list : new ArrayList<>();
    }
}