package de.rechergg.api.checkout;


import de.rechergg.Polar;
import de.rechergg.PolarClient;
import de.rechergg.models.checkout.request.CheckoutCreateRequest;
import de.rechergg.models.checkout.request.CheckoutGetRequest;
import de.rechergg.models.checkout.request.CheckoutListRequest;
import de.rechergg.models.checkout.request.CheckoutUpdateRequest;
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

    @Test
    void testGetCheckoutSession_success() throws Exception {
        // Erstelle eine neue Checkout-Session
        var createRequest = CheckoutCreateRequest.builder()
                .productId("dc00d47e-386b-4a55-945d-e6f1b25c9d2d")
                .build();

        var created = this.client.coreApi()
                .checkoutService()
                .createCheckoutSession(createRequest)
                .get(10, TimeUnit.SECONDS);

        assertNotNull(created.id(), "Created checkout ID must not be null");

        var request = CheckoutGetRequest.builder()
                .checkoutId(created.id())
                .build();

        var retrieved = this.client.coreApi()
                .checkoutService()
                .getCheckoutSession(request)
                .get(10, TimeUnit.SECONDS);

        assertNotNull(retrieved, "Retrieved checkout must not be null");
        assertEquals(created.id(), retrieved.id(), "IDs must match");
        assertEquals(created.status(), retrieved.status(), "Status must match");

        log.info("Retrieved checkout: ID={}, Status={}", retrieved.id(), retrieved.status());
    }

    @Test
    void testListCheckoutSessions_success() throws Exception {
        var request = CheckoutListRequest.builder()
                .limit(5)
                .sort("-created_at")
                .build();

        var result = this.client.coreApi()
                .checkoutService()
                .listCheckoutSessions(request)
                .get(10, TimeUnit.SECONDS);

        assertNotNull(result.pagination().totalCount(), "Response must not be null");

        log.info("List request returned successfully");
    }

    @Test
    void testUpdateCheckoutSession_success() throws Exception {
        var createRequest = CheckoutCreateRequest.builder()
                .productId("dc00d47e-386b-4a55-945d-e6f1b25c9d2d")
                .build();

        var created = this.client.coreApi()
                .checkoutService()
                .createCheckoutSession(createRequest)
                .get(10, TimeUnit.SECONDS);

        assertNotNull(created.id(), "Created checkout ID must not be null");

        var updateRequest = CheckoutUpdateRequest.builder()
                .productId("dc00d47e-386b-4a55-945d-e6f1b25c9d2d")
                .amount(1200)
                .build();

        var updated = this.client.coreApi()
                .checkoutService()
                .updateCheckoutSession(created.id(), updateRequest)
                .get(10, TimeUnit.SECONDS);

        assertNotNull(updated.id(), "Updated checkout ID must not be null");
        log.info("Updated checkout session: ID={}, Status={}", updated.id(), updated.status());
    }

    @Test
    void testGetCheckoutSessionFromClient_success() throws Exception {
        var createRequest = CheckoutCreateRequest.builder()
                .productId("dc00d47e-386b-4a55-945d-e6f1b25c9d2d")
                .build();

        var created = this.client.coreApi()
                .checkoutService()
                .createCheckoutSession(createRequest)
                .get(10, TimeUnit.SECONDS);

        var session = this.client.coreApi()
                .checkoutService()
                .getCheckoutSessionByClientSecret(created.clientSecret())
                .get(10, TimeUnit.SECONDS);
        assertNotNull(session.id(), "Session ID must not be null");
        log.info(session);
    }
}