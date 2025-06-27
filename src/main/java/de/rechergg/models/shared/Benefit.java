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
public class Benefit {
    String id;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("modified_at")
    String modifiedAt;

    String type;
    String description;
    Boolean selectable;
    Boolean deletable;

    @JsonProperty("organization_id")
    String organizationId;
}