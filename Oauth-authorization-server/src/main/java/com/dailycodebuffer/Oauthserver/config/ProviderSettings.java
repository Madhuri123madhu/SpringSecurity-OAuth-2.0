package com.dailycodebuffer.Oauthserver.config;

public class ProviderSettings
{

    private String issuer;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public static ProviderSettingsBuilder builder() {
        return new ProviderSettingsBuilder();
    }

    public static class ProviderSettingsBuilder {
        private String issuer;

        public ProviderSettingsBuilder issuer(String issuer) {
            this.issuer = issuer;
            return this;
        }

        public ProviderSettings build() {
            ProviderSettings providerSettings = new ProviderSettings();
            providerSettings.setIssuer(this.issuer);
            return providerSettings;
        }
    }
}
