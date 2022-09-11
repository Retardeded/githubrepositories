package com.githubrepos.demo.controller;

import com.githubrepos.demo.model.GithubUser;
import com.githubrepos.demo.service.GithubService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }


    @GetMapping("/repo/{user}")
    public GithubUser getRepo(@PathVariable String user) {
        var userRepo = githubService.getUserRepo(user);
        return userRepo;
    }
}
