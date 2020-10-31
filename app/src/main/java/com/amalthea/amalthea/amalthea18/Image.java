package com.amalthea.amalthea.amalthea18;

public class Image {
    private String url;

    private String details;

    public Image() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Image(String url, String details) {
        this.url = url;
        this.details = details;
    }
}
