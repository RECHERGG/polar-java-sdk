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
public class Organization {

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("modified_at")
    String modifiedAt;

    String id;

    String name;

    String slug;

    @JsonProperty("avatar_url")
    String avatarUrl;

    String email;

    String website;

    List<Social> socials;

    @JsonProperty("details_submitted_at")
    String detailsSubmittedAt;

    @JsonProperty("feature_settings")
    FeatureSettings featureSettings;

    @JsonProperty("subscription_settings")
    SubscriptionSettings subscriptionSettings;

    String bio;

    String company;

    String blog;

    String location;

    @JsonProperty("twitter_username")
    String twitterUsername;

    @JsonProperty("pledge_minimum_amount")
    Integer pledgeMinimumAmount;

    @JsonProperty("pledge_badge_show_amount")
    Boolean pledgeBadgeShowAmount;

    @JsonProperty("default_upfront_split_to_contributors")
    Object defaultUpfrontSplitToContributors;

    @JsonProperty("profile_settings")
    ProfileSettings profileSettings;

}
