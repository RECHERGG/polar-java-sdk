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
public class Subscribe {

    Boolean promote;

    @JsonProperty("show_count")
    Boolean showCount;

    @JsonProperty("count_free")
    Boolean countFree;
}
