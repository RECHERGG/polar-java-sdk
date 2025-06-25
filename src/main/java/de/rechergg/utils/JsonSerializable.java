package de.rechergg.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonSerializable {

    ObjectMapper MAPPER = new ObjectMapper();

    default String toJson() {
        try {
            return MAPPER.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize object to JSON", e);
        }
    }
}
