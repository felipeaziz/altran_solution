package com.altran.solution.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class OrganizationDTO {
    private String code;
    private String description;
    private String name;
    private String url;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() { return this.url;}

    public void setUrl(String url) { this.url = url;}

    @Override
    public String toString() {
        return "Organization [Code=" + this.code + ", description=" + this.description  + ", name=" + this.name + "]"
                + ", url=" + this.url;
    }
}
