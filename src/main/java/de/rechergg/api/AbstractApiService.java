package de.rechergg.api;

import lombok.extern.log4j.Log4j2;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Log4j2
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

    @Override
    protected CompletableFuture<Response> get(String endpoint) {
        return this.executor.getAsync(baseUrl + endpoint);
    }

    protected CompletableFuture<String> handleResponse(Response response) {
        if (response == null) {
            return CompletableFuture.failedFuture(new IOException("Response is null"));
        }

        if (!response.isSuccessful()) {
            String errorBody = read(response);
            String message = "HTTP %d %s — Body: %s".formatted(
                    response.code(),
                    response.message(),
                    errorBody != null ? errorBody : "(empty)"
            );
            log.warn("Unsuccessful response: {}", message);
            response.close();
            return CompletableFuture.failedFuture(new IOException(message));
        }

        if (response.body() == null) {
            response.close();
            return CompletableFuture.failedFuture(new IOException("Response body is null"));
        }

        try (response) {
            var body = response.body().string();

            log.debug(body);
            return CompletableFuture.completedFuture(body);
        } catch (IOException e) {
            return CompletableFuture.failedFuture(new IOException("Failed to read response body", e));
        }
    }

    private String read(Response response) {
        try (response) {
            if (response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            log.error("Failed to read response body", e);
        }
        return null;
    }
}
