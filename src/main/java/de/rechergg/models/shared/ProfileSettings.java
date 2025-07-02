package de.rechergg.models.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileSettings {

    Boolean enabled;

    String description;

    @JsonProperty("featured_projects")
    List<String> featuredProjects;

    @JsonProperty("featured_organizations")
    List<String> featuredOrganizations;

    List<String> links;

    Subscribe subscribe;

    @JsonProperty("accent_color")
    String accentColor;
}
