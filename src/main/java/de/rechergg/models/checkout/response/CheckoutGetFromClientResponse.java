package de.rechergg.models.checkout.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.rechergg.models.shared.*;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;
import okhttp3.Address;

import java.util.List;
import java.util.Map;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutGetFromClientResponse {

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("modified_at")
    String modifiedAt;

    String id;

    @JsonProperty("custom_field_data")
    Map<String, Object> customFieldData;

    @JsonProperty("payment_processor")
    PaymentProcessor paymentProcessor;

    String status;

    @JsonProperty("client_secret")
    String clientSecret;

    String url;

    @JsonProperty("expires_at")
    String expiresAt;

    @JsonProperty("success_url")
    String successUrl;

    @JsonProperty("embed_origin")
    String embedOrigin;

    Integer amount;

    @JsonProperty("discount_amount")
    Integer discountAmount;

    @JsonProperty("net_amount")
    Integer netAmount;

    @JsonProperty("tax_amount")
    Integer taxAmount;

    @JsonProperty("total_amount")
    Integer totalAmount;

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
    Address customerBillingAddress;

    @JsonProperty("customer_tax_id")
    String customerTaxId;

    @JsonProperty("payment_processor_metadata")
    Map<String, Object> paymentProcessorMetadata;

    @JsonProperty("subtotal_amount")
    Integer subtotalAmount;

    @JsonProperty("customer_billing_address_fields")
    CustomerBillingAddress customerBillingAddressFields;

    @JsonProperty("billing_address_fields")
    Map<String, String> billingAddressFields;

    List<Product> products;

    Product product;

    @JsonProperty("product_price")
    ProductPrice productPrice;

    Discount discount;

    Organization organization;

    @JsonProperty("attached_custom_fields")
    List<AttachedCustomField> attachedCustomFields;
}
