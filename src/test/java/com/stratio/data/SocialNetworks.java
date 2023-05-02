package com.stratio.data;

public enum SocialNetworks {
    twitter("https://twitter.com/StratioBD"),
    instagram("https://www.instagram.com/we_are_stratio/"),
    linkedin("https://www.linkedin.com/company/stratiobd");

    private String displayName;

    SocialNetworks(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
