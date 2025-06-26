package de.rechergg.models.request.checkout;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Request wrapper for retrieving a checkout session by ID.
 * Used only for parameter abstraction — the request has no body.
 */
@Value
@Builder
@Accessors(fluent = true)
public class CheckoutGetRequest {

    /**
     * The ID of the checkout session to retrieve.
     */
    String checkoutId;
}