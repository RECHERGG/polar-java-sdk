package de.rechergg.models.response.checkout;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;
import lombok.Builder;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutCreateResponse {

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("modified_at")
    String modifiedAt;

    String id;

    @JsonProperty("custom_field_data")
    Map<String, Object> customFieldData;

    @JsonProperty("payment_processor")
    String paymentProcessor;

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
    CustomerBillingAddress customerBillingAddress;

    @JsonProperty("customer_tax_id")
    String customerTaxId;

    @JsonProperty("payment_processor_metadata")
    Map<String, Object> paymentProcessorMetadata;

    @JsonProperty("subtotal_amount")
    Integer subTotalAmount;

    @JsonProperty("customer_billing_address_fields")
    Map<String, Boolean> customerBillingAddressFields;

    Map<String, Object> metadata;

    @JsonProperty("external_customer_id")
    String externalCustomerId;

    @JsonProperty("customer_external_id")
    String customerExternalId;

    List<Product> products;

    Product product;

    @JsonProperty("product_price")
    ProductPrice productPrice;

    Discount discount;

    @JsonProperty("subscription_id")
    String subscriptionId;

    @JsonProperty("attached_custom_fields")
    List<AttachedCustomField> attachedCustomFields;

    @JsonProperty("customer_metadata")
    Map<String, Object> customerMetadata;


    @Value
    @Builder
    @Jacksonized
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CustomerBillingAddress {
        String line1;
        String line2;
        @JsonProperty("postal_code")
        String postalCode;
        String city;
        String state;
        String country;
    }


    @Value
    @Builder
    @Jacksonized
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Product {
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


    @Value
    @Builder
    @Jacksonized
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ProductPrice {
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


    @Value
    @Builder
    @Jacksonized
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Benefit {
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


    @Value
    @Builder
    @Jacksonized
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Media {
        String id;

        @JsonProperty("organization_id")
        String organizationId;

        String name;
        String path;

        @JsonProperty("mime_type")
        String mimeType;

        Integer size;

        @JsonProperty("storage_version")
        String storageVersion;

        @JsonProperty("checksum_etag")
        String checksumEtag;

        @JsonProperty("checksum_sha256_base64")
        String checksumSha256Base64;

        @JsonProperty("checksum_sha256_hex")
        String checksumSha256Hex;

        @JsonProperty("last_modified_at")
        String lastModifiedAt;

        String version;
        String service;

        @JsonProperty("is_uploaded")
        Boolean isUploaded;

        @JsonProperty("created_at")
        String createdAt;

        @JsonProperty("size_readable")
        String sizeReadable;

        @JsonProperty("public_url")
        String publicUrl;
    }


    @Value
    @Builder
    @Jacksonized
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Discount {
        String duration;
        String type;
        Integer amount;
        String currency;
        String id;
        String name;
        String code;
    }


    @Value
    @Builder
    @Jacksonized
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AttachedCustomField {
        @JsonProperty("custom_field_id")
        String customFieldId;

        @JsonProperty("custom_field")
        CustomField customField;

        Integer order;
        Boolean required;
    }


    @Value
    @Builder
    @Jacksonized
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CustomField {
        @JsonProperty("created_at")
        String createdAt;

        @JsonProperty("modified_at")
        String modifiedAt;

        String id;
        Map<String, Object> metadata;
        String type;
        String slug;
        String name;

        @JsonProperty("organization_id")
        String organizationId;

        Map<String, Object> properties;
    }
}