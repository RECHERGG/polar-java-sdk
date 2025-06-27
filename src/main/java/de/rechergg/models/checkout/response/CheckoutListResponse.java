package de.rechergg.models.checkout.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.rechergg.models.checkout.CheckoutSession;
import de.rechergg.models.shared.Pagination;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutListResponse {

    CheckoutSession[] items;

    Pagination pagination;
}
