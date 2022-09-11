package com.githubrepos.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Branch {
    String name;
    String sha;
    public Branch(String name, String sha) {
        this.name = name;
        this.sha = sha;
    }
}
