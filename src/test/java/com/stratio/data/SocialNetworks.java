package com.stratio.data;

public enum SocialNetworks {
    TWITTER("https://twitter.com/StratioBD"),
    INSTAGRAM("https://www.instagram.com/we_are_stratio/"),
    LINKEDIN("https://www.linkedin.com/company/stratiobd");

    private String displayName;

    SocialNetworks(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
