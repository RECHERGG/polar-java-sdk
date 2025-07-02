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
public class SubscriptionSettings {

    @JsonProperty("allow_multiple_subscriptions")
    Boolean allowMultipleSubscriptions;

    @JsonProperty("allow_customer_updates")
    Boolean allowCustomerUpdates;

    @JsonProperty("proration_behavior")
    String prorationBehavior;
}
