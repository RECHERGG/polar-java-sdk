package de.rechergg.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Media {
    String id;

    @JsonProperty("organization_id")
    String organizationId;

    String name;
    String path;

    @JsonProperty("mime_type")
    String mimeType;

    Integer size;

    @JsonProperty("storage_version")
    String storageVersion;

    @JsonProperty("checksum_etag")
    String checksumEtag;

    @JsonProperty("checksum_sha256_base64")
    String checksumSha256Base64;

    @JsonProperty("checksum_sha256_hex")
    String checksumSha256Hex;

    @JsonProperty("last_modified_at")
    String lastModifiedAt;

    String version;
    String service;

    @JsonProperty("is_uploaded")
    Boolean isUploaded;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("size_readable")
    String sizeReadable;

    @JsonProperty("public_url")
    String publicUrl;
}

