package de.rechergg.models.checkout.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.rechergg.models.shared.CustomerBillingAddress;
import de.rechergg.utils.JsonSerializable;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

/**
 * Model for updating a Checkout via Polar API.
 * This class encapsulates the parameters needed to update an existing checkout session.
 * https://docs.polar.sh/api-reference/checkouts/update-session
 */
@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutUpdateRequest implements JsonSerializable {

    @JsonProperty("custom_field_data")
    Map<String, Object> customFieldData;

    @JsonProperty("product_id")
    String productId;

    @Deprecated
    @JsonProperty("product_price_id")
    String productPriceId;

    Integer amount;

    @JsonProperty("is_business_customer")
    Boolean isBusinessCustomer;

    @JsonProperty("customer_name")
    String customerName;

    @JsonProperty("customer_email")
    String customerEmail;

    @JsonProperty("customer_billing_name")
    String customerBillingName;

    @JsonProperty("customer_billing_address")
    CustomerBillingAddress customerBillingAddress;

    @JsonProperty("customer_tax_id")
    String customerTaxId;

    @JsonProperty("metadata")
    Map<String, Object> metadata;

    @JsonProperty("discount_id")
    String discountId;

    @JsonProperty("allow_discount_codes")
    Boolean allowDiscountCodes;

    @JsonProperty("require_billing_address")
    Boolean requireBillingAddress;

    @JsonProperty("customer_ip_address")
    String customerIpAddress;

    @JsonProperty("customer_metadata")
    Map<String, Object> customerMetadata;

    @JsonProperty("success_url")
    String successUrl;

    @JsonProperty("embed_origin")
    String embedOrigin;

}
