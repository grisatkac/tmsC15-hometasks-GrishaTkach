package com.example.lesson23_24.models;

import java.util.Objects;

public class CourseModel {

    private String name;
    private String language;
    private String additionalInfo;
    private String secret;

    public CourseModel(String name, String language, String additionalInfo, String secret) {
        this.name = name;
        this.language = language;
        this.additionalInfo = additionalInfo;
        this.secret = secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseModel that = (CourseModel) o;
        return Objects.equals(name, that.name) && Objects.equals(language, that.language) && Objects.equals(additionalInfo, that.additionalInfo) && Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, language, additionalInfo, secret);
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
