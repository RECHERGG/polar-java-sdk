package de.rechergg.models.checkout.request;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * Request wrapper for retrieving a checkout session by ID.
 * Used only for parameter abstraction — the request has no body.
 * https://docs.polar.sh/api-reference/checkouts/get-session
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