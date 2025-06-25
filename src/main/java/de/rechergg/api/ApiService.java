package de.rechergg.api;

import okhttp3.Response;

import java.util.concurrent.CompletableFuture;

public abstract class ApiService {

    protected abstract CompletableFuture<Response> post(String endpoint, String jsonBody);
}
