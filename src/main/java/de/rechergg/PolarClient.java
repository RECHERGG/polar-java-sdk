package de.rechergg;

import de.rechergg.api.CoreApi;
import de.rechergg.api.CoreApiImpl;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

@Getter
@Accessors(fluent = true)
public class PolarClient {

    private final String accessToken;
    private final OkHttpClient httpClient;
    private final String baseUrl;

    public static final String PROD_BASE_URL = "https://api.polar.sh";
    public static final String SANDBOX_BASE_URL = "https://sandbox-api.polar.sh";

    private final CoreApi coreApi;

    @Builder
    private PolarClient(String accessToken, boolean useSandbox) {
        this.accessToken = accessToken;
        this.baseUrl = useSandbox ? SANDBOX_BASE_URL : PROD_BASE_URL;
        this.httpClient = new OkHttpClient();
        this.coreApi = new CoreApiImpl(this);
    }
}