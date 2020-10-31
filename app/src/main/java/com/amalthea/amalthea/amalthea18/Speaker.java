package com.amalthea.amalthea.amalthea18;

public class Speaker {
    private String name;
    private String job;
    private String univ;
    private String topic;
    private String details;
    private String url;

    public Speaker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Speaker(String name, String job, String univ, String topic, String details, String url) {
        this.name = name;
        this.job = job;
        this.univ = univ;
        this.topic = topic;
        this.details = details;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
