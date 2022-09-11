package com.githubrepos.demo.webclient.dto;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
public class License {
    public String key;
    public String name;
    public String spdx_id;
    public String url;
    public String node_id;
}
