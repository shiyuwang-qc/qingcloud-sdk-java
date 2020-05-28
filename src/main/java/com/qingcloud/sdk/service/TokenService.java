package com.qingcloud.sdk.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qingcloud.sdk.exception.QCException;
import com.qingcloud.sdk.model.OutputModel;
import com.qingcloud.sdk.request.QCOkHttpRequestClient;
import okhttp3.Request;

public class TokenService {

    private static final String CREDENTIAL_PROXY_HOST = "169.254.169.254";
    private static final String CREDENTIAL_PROXY_PORT = "80";
    private static final String CREDENTIAL_PROXY_PROTOCOL = "http";
    private static final String CREDENTIAL_PROXY_URI = "/latest/meta-data/security-credentials";

    public TokenService() {}

    /**
     * @return GetTokenOutput Response body and headers in the class
     * @throws QCException IOException or network error
     *
     * <a href=https://docs.qingcloud.com/product/sdk/>Documentation URL</a>
     */
    public TokenService.GetTokenOutput getToken() {
        Request request = QCOkHttpRequestClient.getInstance().buildGetRequest(getCredentialProxyUrl(), "");

        OutputModel model = null;
        try {
            model = QCOkHttpRequestClient.getInstance().requestAction(request, true, GetTokenOutput.class);
        } catch (QCException e) {
            System.out.print("Failed to get credentials");
            e.printStackTrace();
        }

        if(model != null){
            return (TokenService.GetTokenOutput) model;
        }
        return null;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GetTokenOutput extends OutputModel {
        private String action;

        @JsonProperty(value = "action")
        public void setAction(String action) {
            this.action = action;
        }

        @JsonProperty(value = "action")
        public String getAction() {
            return this.action;
        }

        private Integer retCode;

        @JsonProperty(value = "ret_code")
        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        @JsonProperty(value = "ret_code")
        public Integer getRetCode() {
            return this.retCode;
        }

        private String jti;

        @JsonProperty(value = "jti")
        public String getJti() {
            return jti;
        }

        @JsonProperty(value = "jti")
        public void setJti(String jti) {
            this.jti = jti;
        }

        private String token;

        @JsonProperty(value = "id_token")
        public String getToken() {
            return token;
        }

        @JsonProperty(value = "id_token")
        public void setToken(String token) {
            this.token = token;
        }

        private String accessKey;

        @JsonProperty(value = "access_key")
        public String getAccessKey() {
            return accessKey;
        }

        @JsonProperty(value = "access_key")
        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        private String accessSecret;

        @JsonProperty(value = "secret_key")
        public String getAccessSecret() {
            return accessSecret;
        }

        @JsonProperty(value = "secret_key")
        public void setAccessSecret(String accessSecret) {
            this.accessSecret = accessSecret;
        }

        private String expiration;

        @JsonProperty(value = "expiration")
        public String getExpiration() {
            return expiration;
        }

        @JsonProperty(value = "expiration")
        public void setExpiration(String expiration) {
            this.expiration = expiration;
        }
    }

    private String getCredentialProxyUrl() {
        return String.format("%s://%s:%s%s", CREDENTIAL_PROXY_PROTOCOL, CREDENTIAL_PROXY_HOST, CREDENTIAL_PROXY_PORT,
                CREDENTIAL_PROXY_URI);
    }
}
