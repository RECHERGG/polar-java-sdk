package de.rechergg.models.checkout.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.rechergg.models.shared.*;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutGetResponse {

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("modified_at")
    String modifiedAt;

    @JsonProperty("id")
    String id;

    @JsonProperty("custom_field_data")
    Map<String, Object> customFieldData;

    @JsonProperty("payment_processor")
    String paymentProcessor;

    @JsonProperty("status")
    String status;

    @JsonProperty("client_secret")
    String clientSecret;

    @JsonProperty("url")
    String url;

    @JsonProperty("expires_at")
    String expiresAt;

    @JsonProperty("success_url")
    String successUrl;

    @JsonProperty("embed_origin")
    String embedOrigin;

    @JsonProperty("amount")
    Integer amount;

    @JsonProperty("discount_amount")
    Integer discountAmount;

    @JsonProperty("net_amount")
    Integer netAmount;

    @JsonProperty("tax_amount")
    Integer taxAmount;

    @JsonProperty("total_amount")
    Integer totalAmount;

    @JsonProperty("currency")
    String currency;

    @JsonProperty("product_id")
    String productId;

    @JsonProperty("product_price_id")
    String productPriceId;

    @JsonProperty("discount_id")
    String discountId;

    @JsonProperty("allow_discount_codes")
    Boolean allowDiscountCodes;

    @JsonProperty("require_billing_address")
    Boolean requireBillingAddress;

    @JsonProperty("is_discount_applicable")
    Boolean isDiscountApplicable;

    @JsonProperty("is_free_product_price")
    Boolean isFreeProductPrice;

    @JsonProperty("is_payment_required")
    Boolean isPaymentRequired;

    @JsonProperty("is_payment_setup_required")
    Boolean isPaymentSetupRequired;

    @JsonProperty("is_payment_form_required")
    Boolean isPaymentFormRequired;

    @JsonProperty("customer_id")
    String customerId;

    @JsonProperty("is_business_customer")
    Boolean isBusinessCustomer;

    @JsonProperty("customer_name")
    String customerName;

    @JsonProperty("customer_email")
    String customerEmail;

    @JsonProperty("customer_ip_address")
    String customerIpAddress;

    @JsonProperty("customer_billing_name")
    String customerBillingName;

    @JsonProperty("customer_billing_address")
    CustomerBillingAddress customerBillingAddress;

    @JsonProperty("customer_tax_id")
    String customerTaxId;

    @JsonProperty("payment_processor_metadata")
    Map<String, Object> paymentProcessorMetadata;

    @JsonProperty("subtotal_amount")
    Integer subTotalAmount;

    @JsonProperty("customer_billing_address_fields")
    Map<String, Boolean> customerBillingAddressFields;

    @JsonProperty("metadata")
    Map<String, Object> metadata;

    @JsonProperty("external_customer_id")
    String externalCustomerId;

    @JsonProperty("customer_external_id")
    String customerExternalId;

    @JsonProperty("products")
    List<Product> products;

    @JsonProperty("product")
    Product product;

    @JsonProperty("product_price")
    ProductPrice productPrice;

    @JsonProperty("discount")
    Discount discount;

    @JsonProperty("subscription_id")
    String subscriptionId;

    @JsonProperty("attached_custom_fields")
    List<AttachedCustomField> attachedCustomFields;

    @JsonProperty("customer_metadata")
    Map<String, Object> customerMetadata;
}