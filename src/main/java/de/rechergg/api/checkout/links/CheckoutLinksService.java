package de.rechergg.api.checkout.links;

import de.rechergg.api.AbstractApiService;
import de.rechergg.api.OkHttpRequestExecutor;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CheckoutLinksService extends AbstractApiService {


    public CheckoutLinksService(OkHttpRequestExecutor executor, String baseUrl) {
        super(executor, baseUrl);
    }


}
