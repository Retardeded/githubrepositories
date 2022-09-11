package com.githubrepos.demo.service;

import com.githubrepos.demo.model.GithubUser;
import com.githubrepos.demo.webclient.GithubClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GithubService {

    private final GithubClient githubClient;

    public GithubService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public GithubUser getUserRepo(String user) {
        var repos = githubClient.getGithubRepo(user);
        return new GithubUser(user, repos);
    }

}
