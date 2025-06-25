package de.rechergg.api;

import okhttp3.Response;

import java.util.concurrent.CompletableFuture;

public abstract class AbstractApiService extends ApiService {

    protected final RequestExecutor executor;
    protected final String baseUrl;

    protected AbstractApiService(RequestExecutor executor, String baseUrl) {
        this.executor = executor;
        this.baseUrl = baseUrl;
    }

    @Override
    protected CompletableFuture<Response> post(String endpoint, String jsonBody) {
        return this.executor.postAsync(baseUrl + endpoint, jsonBody);
    }
}
