package com.githubrepos.demo.webclient;

import com.githubrepos.demo.model.Branch;
import com.githubrepos.demo.model.GithubRepos;
import com.githubrepos.demo.webclient.dto.GithubBranchDto;
import com.githubrepos.demo.webclient.dto.GithubRepoDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class GithubClient {

    private static final String GITHUB_URL = "https://api.github.com/";
    private RestTemplate restTemplate = new RestTemplate();

    public List<GithubRepos> getGithubRepo(String githubUser) {
        List<GithubRepoDto> reposDto = getGithubReposDto("users/" + githubUser + "/repos");
        List<GithubRepoDto> reposFiltered = reposDto.stream().filter(c -> !c.fork).toList();
        List<List<Branch>> branches = reposFiltered.stream().map(r -> getGithubBranch(r.branches_url.split("\\{")[0])).toList();
        List<GithubRepos> repos = new ArrayList<>();
        for(int i = 0; i < reposFiltered.size(); i++) {
            String repoName = reposFiltered.get(i).name;
            repos.add(new GithubRepos(repoName, branches.get(i)));
        }
        return repos;
    }

    public List<Branch> getGithubBranch(String githubBranch) {
        List<GithubBranchDto> branchesDto = getGithubBranchDto(githubBranch);
        List<Branch> branches = branchesDto.stream().map(GithubBranchDto::toBranch).collect(Collectors.toList());
        return branches;
    }

    private List<GithubRepoDto> getGithubReposDto(String url) {

        try {
            ResponseEntity<List<GithubRepoDto>> rateResponse =
                    restTemplate.exchange(GITHUB_URL + url,
                            HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                            });
            List<GithubRepoDto> repos = rateResponse.getBody();

            return repos;
        } catch (HttpStatusCodeException e) {
            throw new ResponseStatusException(NOT_FOUND, "Such user does not exist");
        }

    }

    private List<GithubBranchDto> getGithubBranchDto(String url) {

        ResponseEntity<List<GithubBranchDto>> rateResponse =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                        });
        List<GithubBranchDto> repos = rateResponse.getBody();
        return repos;
    }
}