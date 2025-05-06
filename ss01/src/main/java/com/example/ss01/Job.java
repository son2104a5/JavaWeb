package com.example.ss01;

public class Job {
    private int id;
    private String name;
    private String status;

    public Job(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}
