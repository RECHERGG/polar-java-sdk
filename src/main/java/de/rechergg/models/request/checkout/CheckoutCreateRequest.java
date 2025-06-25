package de.rechergg.models.request.checkout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.rechergg.utils.JsonSerializable;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * Model for creating a Checkout via Polar API.
 * Only "products" is required; all other fields are optional.
 * https://docs.polar.sh/api-reference/checkouts/create-session
 */
@Value
@Builder
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutCreateRequest implements JsonSerializable {

    // Required: at least one product ID
    @Singular("productId")
    @JsonProperty("products")
    List<String> products;

    // Optional settings
    @JsonProperty("successUrl")
    String successUrl;

    @JsonProperty("cancelUrl")
    String cancelUrl;

    @JsonProperty("customerEmail")
    String customerEmail;

    @JsonProperty("customerName")
    String customerName;

    @JsonProperty("externalCustomerId")
    String externalCustomerId;

    @JsonProperty("isBusinessCustomer")
    Boolean isBusinessCustomer;

    @JsonProperty("allowDiscountCodes")
    Boolean allowDiscountCodes;

    @JsonProperty("requireBillingAddress")
    Boolean requireBillingAddress;

    @JsonProperty("embed")
    Boolean embed;

    @JsonProperty("testMode")
    Boolean testMode;

    @JsonProperty("discountId")
    String discountId;

    @JsonProperty("amount")
    Integer amount;

    @JsonProperty("organizationId")
    String organizationId;

    @JsonProperty("referralCode")
    String referralCode;

    @Singular("metadataEntry")
    @JsonProperty("metadata")
    Map<String, Object> metadata;

    @Singular("customFieldEntry")
    @JsonProperty("customFieldData")
    Map<String, Object> customFieldData;

    @Singular("customerMetadataEntry")
    @JsonProperty("customerMetadata")
    Map<String, Object> customerMetadata;
}
