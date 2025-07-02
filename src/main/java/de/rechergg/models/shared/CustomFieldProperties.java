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
public class CustomFieldProperties {

    @JsonProperty("form_label")
    String formLable;

    @JsonProperty("form_help_text")
    String formHelpText;

    @JsonProperty("form_placeholder")
    String formPlaceholder;

    @JsonProperty("textarea")
    Boolean textArea;

    @JsonProperty("min_length")
    Integer minLength;

    @JsonProperty("max_length")
    Integer maxLength;

}
