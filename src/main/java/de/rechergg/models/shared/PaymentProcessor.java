package de.rechergg.models.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public enum PaymentProcessor {

    @JsonValue
    STRIPE("stripe");

    private final String value;

    @JsonCreator
    public static PaymentProcessor fromValue(String value) {
        for (var processor : PaymentProcessor.values()) {
            if (processor.value.equalsIgnoreCase(value)) {
                return processor;
            }
        }
        throw new IllegalArgumentException("Unknown payment processor: " + value);
    }
}
