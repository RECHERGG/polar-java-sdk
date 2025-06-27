package de.rechergg.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachedCustomField {
    @JsonProperty("custom_field_id")
    String customFieldId;

    @JsonProperty("custom_field")
    CustomField customField;

    Integer order;
    Boolean required;
}