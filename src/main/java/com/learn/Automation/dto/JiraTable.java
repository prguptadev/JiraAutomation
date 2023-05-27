package com.learn.Automation.dto;

public class JiraTable {

    private int id;
    private String cves;
    private  String severity;
    private String type;
    private String Summary;
    private String Description;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCves() {
        return cves;
    }

    public void setCves(String cves) {
        this.cves = cves;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "JiraTable{" +
                "id=" + id +
                ", cves='" + cves + '\'' +
                ", severity='" + severity + '\'' +
                ", type='" + type + '\'' +
                ", Summary='" + Summary + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
