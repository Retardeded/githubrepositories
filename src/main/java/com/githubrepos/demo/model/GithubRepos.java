package com.githubrepos.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GithubRepos {

    private String repoName;
    private List<Branch> branches;

    @Override
    public String toString() {
        return "GithubRepo{" +
                ", repoName='" + repoName + '\'' +
                ", branches=" + branches +
                '}';
    }

    public GithubRepos(String repoName, List<Branch> branches) {
        this.repoName = repoName;
        this.branches = branches;
    }
}
