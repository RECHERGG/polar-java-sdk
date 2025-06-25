package de.rechergg.api.checkout;


import de.rechergg.Polar;
import de.rechergg.PolarClient;
import de.rechergg.models.request.checkout.CheckoutCreateRequest;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
public class CheckoutServiceIntegrationTest {

    private final static String POLAR_ACCESS_TOKEN = System.getenv("POLAR_ACCESS_TOKEN");
    private final PolarClient client = Polar.sdk()
            .accessToken(POLAR_ACCESS_TOKEN)
            .useSandbox(true)
            .build();

    @Test
    void testCreateCheckoutSession_success() throws Exception {
        var request = CheckoutCreateRequest.builder()
                .productId("dc00d47e-386b-4a55-945d-e6f1b25c9d2d")
                .build();

        var response = this.client.coreApi()
                .checkoutService()
                .createCheckoutSession(request)
                .get(10, TimeUnit.SECONDS);

        assertNotNull(response, "Response must not be null");
        assertNotNull(response.id(), "Checkout ID must not be null");
        assertTrue(response.status().equalsIgnoreCase("open") || response.status().equalsIgnoreCase("pending"),
                "Status should be 'open' or 'pending'");

        log.info("Checkout session created: ID={}, Status={}", response.id(), response.status());
    }

    @Test
    void testCreateCheckoutSession_invalidProduct_shouldFail() {
        var request = CheckoutCreateRequest.builder()
                .productId("invalid-product-id")
                .build();

        var futureResponse = this.client.coreApi()
                .checkoutService()
                .createCheckoutSession(request);

        var exception = assertThrows(Exception.class, () -> futureResponse.get(10, TimeUnit.SECONDS));

        assertInstanceOf(IOException.class, exception.getCause());
        log.warn("Expected failure for invalid product ID: {}", exception.getMessage());
    }
}