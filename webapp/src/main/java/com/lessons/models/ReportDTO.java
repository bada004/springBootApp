package com.lessons.models;

public class ReportDTO {
    private String description;
    private String displayName;
    private boolean reviewed;
    private Integer reportId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public Integer getReportId() { return reportId; }

    public void setReportId(Integer reportId) { this.reportId = reportId; }
}
