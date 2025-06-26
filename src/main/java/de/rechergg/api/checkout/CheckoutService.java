package de.rechergg.api.checkout;

import de.rechergg.api.AbstractApiService;
import de.rechergg.api.OkHttpRequestExecutor;
import de.rechergg.models.request.checkout.CheckoutCreateRequest;
import de.rechergg.models.request.checkout.CheckoutGetRequest;
import de.rechergg.models.response.checkout.CheckoutCreateResponse;
import de.rechergg.models.response.checkout.CheckoutGetResponse;
import de.rechergg.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;

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
    public CompletableFuture<CheckoutCreateResponse> createCheckoutSession(CheckoutCreateRequest request) {
        return post("/v1/checkouts", request.toJson())
                .thenCompose(this::handleResponse)
                .thenApply(body -> JsonUtils.fromJson(body, CheckoutCreateResponse.class));
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


}
