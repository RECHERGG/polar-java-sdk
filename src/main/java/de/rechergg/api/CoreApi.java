package de.rechergg.api;

import de.rechergg.api.checkout.CheckoutService;
import de.rechergg.api.checkout.links.CheckoutLinksService;

public interface CoreApi {

    CheckoutService checkoutService();

    CheckoutLinksService checkoutLinksService();
}
