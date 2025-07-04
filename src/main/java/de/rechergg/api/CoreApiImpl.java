package de.rechergg.api;

import de.rechergg.PolarClient;
import de.rechergg.api.checkout.CheckoutService;
import de.rechergg.api.checkout.links.CheckoutLinksService;

public class CoreApiImpl implements CoreApi {

    private final CheckoutService checkoutService;
    private final CheckoutLinksService checkoutLinksService;

    public CoreApiImpl(PolarClient polarClient) {
        var baseUrl = polarClient.baseUrl();
        var executor = new OkHttpRequestExecutor(polarClient.httpClient(), polarClient.accessToken());

        this.checkoutService = new CheckoutService(executor, baseUrl);
        this.checkoutLinksService = new CheckoutLinksService(executor, baseUrl);
    }

    @Override
    public CheckoutService checkoutService() {
        return this.checkoutService;
    }

    @Override
    public CheckoutLinksService checkoutLinksService() {
        return this.checkoutLinksService;
    }
}
