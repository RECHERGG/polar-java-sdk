package de.rechergg.models.checkout.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.rechergg.utils.JsonSerializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Request model for listing checkout sessions.
 * This class encapsulates the parameters needed to filter and paginate checkout sessions.
 * https://docs.polar.sh/api-reference/checkouts/list-sessions
 */
@Getter
@Accessors(fluent = true)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutListRequest implements JsonSerializable {

    @JsonProperty("organization_id")
    private String organizationId;

    @JsonProperty("organization_ids")
    @Singular("organizationIdEntry")
    private List<String> organizationIds;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("product_ids")
    @Singular("productIdEntry")
    private List<String> productIds;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_ids")
    @Singular("customerIdEntry")
    private List<String> customerIds;

    @JsonProperty("query")
    private String query;

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("status")
    @Singular("status")
    private List<String> status;

    @JsonProperty("sort")
    @Singular("sort")
    private List<String> sorting;
}