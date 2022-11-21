package com.timely.timely.enumeration;

public enum Status {
    PROJECT_FINISHED("PROJECT_FINISHED"),
    PROJECT_UNFINISHED("PROJECT_UNFINISHED");
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
