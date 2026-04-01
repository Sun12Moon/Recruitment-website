package com.example.techrecruit;

public class Job {
    private int id;
    private String title;
    private String company;
    private String location;
    private String salaryRange;
    private String tags;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getSalaryRange() { return salaryRange; }
    public void setSalaryRange(String salaryRange) { this.salaryRange = salaryRange; }

    public String getTags() { return tags; }
    public void setTags(String tags) { this.tags = tags; }
}