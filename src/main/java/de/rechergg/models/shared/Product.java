package de.rechergg.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("modified_at")
    String modifiedAt;

    String id;
    String name;
    String description;

    @JsonProperty("recurring_interval")
    String recurringInterval;

    @JsonProperty("is_recurring")
    Boolean isRecurring;

    @JsonProperty("is_archived")
    Boolean isArchived;

    @JsonProperty("organization_id")
    String organizationId;

    List<ProductPrice> prices;

    List<Benefit> benefits;

    List<Media> medias;
}