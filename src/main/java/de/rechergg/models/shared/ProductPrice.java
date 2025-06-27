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
public class ProductPrice {
    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("modified_at")
    String modifiedAt;

    String id;

    @JsonProperty("amount_type")
    String amountType;

    @JsonProperty("is_archived")
    Boolean isArchived;

    @JsonProperty("product_id")
    String productId;

    String type;

    @JsonProperty("recurring_interval")
    String recurringInterval;

    @JsonProperty("price_currency")
    String priceCurrency;

    @JsonProperty("price_amount")
    Integer priceAmount;

    Boolean legacy;
}