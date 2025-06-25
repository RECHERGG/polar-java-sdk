package de.rechergg.api;

import okhttp3.Response;

import java.util.concurrent.CompletableFuture;

public interface RequestExecutor {

    CompletableFuture<Response> postAsync(String url, String jsonBody);
}
