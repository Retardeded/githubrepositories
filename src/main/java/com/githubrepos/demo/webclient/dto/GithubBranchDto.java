package com.githubrepos.demo.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.githubrepos.demo.model.Branch;

public class GithubBranchDto {

    public String name;
    public Commit commit;
    @JsonProperty("protected")
    public boolean myprotected;

    public Branch toBranch() {
        return new Branch(name, commit.sha);
    }
}

