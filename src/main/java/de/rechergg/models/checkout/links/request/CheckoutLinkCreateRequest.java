package de.rechergg.models.checkout.links.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.rechergg.models.shared.PaymentProcessor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

/**
 * Request Model for creating a Checkout Link via Polar API.
 * https://docs.polar.sh/api-reference/checkout-links/create
 */
@Value
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutLinkCreateRequest {

    @JsonProperty("payment_processor")
    PaymentProcessor paymentProcessor;

    @JsonProperty("product_price_id")
    String productPriceId;

    @JsonProperty("product_id")
    String productId;

    @JsonProperty("products")
    List<String> products;

    @JsonProperty("metadata")
    Map<String, String> metadata;

    String label;

    @JsonProperty("allow_discount_codes")
    Boolean allowDiscountCodes;

    @JsonProperty("require_billing_address")
    Boolean requireBillingAddress;

    @JsonProperty("discount_id")
    String discountId;

    @JsonProperty("success_url")
    String successUrl;
}
