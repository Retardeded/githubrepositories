package com.githubrepos.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GithubUser {
    String login;
    List<GithubRepos> repos;

    public GithubUser(String login, List<GithubRepos> repos) {
        this.login = login;
        this.repos = repos;
    }
}
