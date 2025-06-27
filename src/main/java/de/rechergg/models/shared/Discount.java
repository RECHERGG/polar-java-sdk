package de.rechergg.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Discount {
    String duration;
    String type;
    Integer amount;
    String currency;
    String id;
    String name;
    String code;
}
