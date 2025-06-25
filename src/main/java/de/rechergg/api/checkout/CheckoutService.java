package de.rechergg.api.checkout;

import de.rechergg.api.AbstractApiService;
import de.rechergg.api.OkHttpRequestExecutor;
import de.rechergg.models.request.checkout.CheckoutCreateRequest;
import de.rechergg.models.response.checkout.CheckoutCreateResponse;
import de.rechergg.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
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
                .thenCompose(response -> {
                    try {
                        if (!response.isSuccessful()) {
                            if (response.body() == null) {
                                return CompletableFuture.failedFuture(new IOException("HTTP Fehler: " + response.code() + " - " + response.message()));
                            }

                            return CompletableFuture.failedFuture(new IOException("HTTP Fehler: " + response.code() + " - " + response.body().string()));
                        }

                        var body = response.body().string();
                        log.debug(body);

                        var parsed = JsonUtils.fromJson(body, CheckoutCreateResponse.class);
                        return CompletableFuture.completedFuture(parsed);
                    } catch (IOException e) {
                        return CompletableFuture.failedFuture(e);
                    }
                });
    }


}
