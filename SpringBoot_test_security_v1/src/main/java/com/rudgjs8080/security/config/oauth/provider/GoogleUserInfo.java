package com.rudgjs8080.security.config.oauth.provider;

import java.util.Map;

public class GoogleUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attributes; // OAuth2User 가 들고 있는 getAttributes

    public GoogleUserInfo(Map<String,Object> attributes){
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {

        return (String) attributes.get("sub");
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("email");
    }
}
