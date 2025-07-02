package de.rechergg.api.checkout;

import de.rechergg.api.AbstractApiService;
import de.rechergg.api.OkHttpRequestExecutor;
import de.rechergg.models.checkout.CheckoutSession;
import de.rechergg.models.checkout.request.CheckoutCreateRequest;
import de.rechergg.models.checkout.request.CheckoutGetRequest;
import de.rechergg.models.checkout.request.CheckoutListRequest;
import de.rechergg.models.checkout.request.CheckoutUpdateRequest;
import de.rechergg.models.checkout.response.CheckoutGetFromClientResponse;
import de.rechergg.models.checkout.response.CheckoutGetResponse;
import de.rechergg.models.checkout.response.CheckoutListResponse;
import de.rechergg.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Log4j2
public class CheckoutService extends AbstractApiService {


    public CheckoutService(OkHttpRequestExecutor executor, String baseUrl) {
        super(executor, baseUrl);
    }

    /**
     * Creates a new checkout session with the given request parameters.
     * Auth Token scopes: "checkout:write"
     * @param request The request containing checkout details.
     */
    public CompletableFuture<CheckoutSession> createCheckoutSession(CheckoutCreateRequest request) {
        return post("/v1/checkouts/", request.toJson())
                .thenCompose(this::handleResponse)
                .thenApply(body -> JsonUtils.fromJson(body, CheckoutSession.class));
    }

    /**
     * Retrieves an existing checkout session by its ID.
     * Auth Token scopes: "checkout:read" and "checkouts:write"
     * @param request The request containing the checkout ID.
     */
    public CompletableFuture<CheckoutGetResponse> getCheckoutSession(CheckoutGetRequest request) {
        return get("/v1/checkouts/" + request.checkoutId())
                .thenCompose(this::handleResponse)
                .thenApply(body -> JsonUtils.fromJson(body, CheckoutGetResponse.class));
    }

    /**
     * Lists all checkout sessions.
     * Auth Token scopes: "checkout:read" and "checkouts:write"
     * @param request The request containing pagination parameters.
     */
    public CompletableFuture<CheckoutListResponse> listCheckoutSessions(CheckoutListRequest request) {
        var url = new StringBuilder("/v1/checkouts");
        var queryParams = new ArrayList<String>();

        if (request.page() != null) {
            queryParams.add("page=" + encode(request.page().toString()));
        }

        if (request.limit() != null) {
            queryParams.add("limit=" + encode(request.limit().toString()));
        }

        if (request.query() != null) {
            queryParams.add("query=" + encode(request.query()));
        }

        if (request.organizationId() != null) {
            queryParams.add("organization_id=" + encode(request.organizationId()));
        }

        if (request.customerId() != null) {
            queryParams.add("customer_id=" + encode(request.customerId()));
        }

        if (request.status() != null) {
            request.status().forEach(status ->
                    queryParams.add("status=" + encode(status))
            );
        }

        if (request.sorting() != null) {
            request.sorting().forEach(sort ->
                    queryParams.add("sort=" + encode(sort))
            );
        }

        if (request.productIds() != null) {
            request.productIds().forEach(id ->
                    queryParams.add("product_ids=" + encode(id))
            );
        }

        if (!queryParams.isEmpty()) {
            url.append("?").append(String.join("&", queryParams));
        }

        return get(url.toString())
                .thenCompose(this::handleResponse)
                .thenApply(body -> JsonUtils.fromJson(body, CheckoutListResponse.class));
    }

    public CompletableFuture<CheckoutSession> updateCheckoutSession(String id, CheckoutUpdateRequest request) {
        return patch("/v1/checkouts/" + id, request.toJson())
                .thenCompose(this::handleResponse)
                .thenApply(body -> JsonUtils.fromJson(body, CheckoutSession.class));
    }

    /**
     * Get a checkout session by client secret.
     * @param secret The client secret of the checkout session.
     */
    public CompletableFuture<CheckoutGetFromClientResponse> getCheckoutSessionByClientSecret(String secret) {
        return get("/v1/checkouts/client/" + secret)
                .thenCompose(this::handleResponse)
                .thenApply(body -> JsonUtils.fromJson(body, CheckoutGetFromClientResponse.class));
    }

}
