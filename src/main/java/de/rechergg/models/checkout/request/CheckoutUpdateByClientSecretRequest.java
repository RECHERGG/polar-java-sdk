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

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutUpdateByClientSecretRequest implements JsonSerializable {

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

    @JsonProperty("discount_code")
    String discountCode;

}
