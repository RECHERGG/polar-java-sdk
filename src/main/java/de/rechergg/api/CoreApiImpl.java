package de.rechergg.api;

import de.rechergg.PolarClient;
import de.rechergg.api.checkout.CheckoutService;

public class CoreApiImpl implements CoreApi {

    private final CheckoutService checkoutService;

    public CoreApiImpl(PolarClient polarClient) {
        var baseUrl = polarClient.baseUrl();
        var executor = new OkHttpRequestExecutor(polarClient.httpClient(), polarClient.accessToken());

        this.checkoutService = new CheckoutService(executor, baseUrl);
    }

    @Override
    public CheckoutService checkoutService() {
        return this.checkoutService;
    }
}
