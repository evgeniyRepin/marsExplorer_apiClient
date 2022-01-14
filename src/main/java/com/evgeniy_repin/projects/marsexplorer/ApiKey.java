package com.evgeniy_repin.projects.marsexplorer;

public enum ApiKey {
    API_KEY("6sKc7FZPRd6f8yiwrhPXN0AyV67QajtYnSyZpyAx");

    private String key;

    ApiKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
