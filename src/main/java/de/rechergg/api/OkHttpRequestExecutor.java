package de.rechergg.api;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class OkHttpRequestExecutor implements RequestExecutor {

    private final OkHttpClient httpClient;
    private final String accessToken;

    public OkHttpRequestExecutor(OkHttpClient client, String token) {
        this.httpClient = client;
        this.accessToken = token;
    }

    @Override
    public CompletableFuture<Response> postAsync(String url, String jsonBody) {
        var body = RequestBody.create(jsonBody, MediaType.get("application/json; charset=utf-8"));
        var request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        var future = new CompletableFuture<Response>();

        this.httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                future.complete(response);
            }
        });

        return future;
    }

}
