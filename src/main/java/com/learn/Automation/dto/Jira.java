package com.learn.Automation.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties
public class Jira {

    @Value("${ZipPath}")
    private String ZipPath;
    @Value("${pdfDesirPath}")
    private String pdfDesirPath;
    @Value("${jira.user.name}")
    private String username;
    @Value("${jira.pass.word}")
    private String password;
    @Value("${jira.company.url}")
    private String url;
    @Value("${jira.project.key}")
    private String projectKey;
    @Value("${jira.issue.type}")
    private Long issueType;
    @Value("${jira.assignee.name}")
    private String assigneeName;
    @Value("${jira.assignee.self}")
    private String assigneeSelf;
    @Value("${jira.assignee.displayName}")
    private String assigneeDisplayName;
    @Value("${jira.priority.self}")
    private String priorityself;
    @Value("${jira.priority.id}")
    private Long priortiyId;
    @Value("${jira.priority.name}")
    private String priortiyName;
    @Value("${jira.components.name}")
    private String componentsName;
}
