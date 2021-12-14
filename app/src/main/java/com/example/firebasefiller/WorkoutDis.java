package com.example.firebasefiller;

public class WorkoutDis {
   String expandedDescription, totalTime, difLevel, types;
    public WorkoutDis(){

    }

    public String getExpandedDescription() {
        return expandedDescription;
    }

    public void setExpandedDescription(String expandedDescription) {
        this.expandedDescription = expandedDescription;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getDifLevel() {
        return difLevel;
    }

    public void setDifLevel(String difLevel) {
        this.difLevel = difLevel;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public WorkoutDis(String expandedDescription, String totalTime, String difLevel, String types) {
        this.expandedDescription = expandedDescription;
        this.totalTime = totalTime;
        this.difLevel = difLevel;
        this.types = types;
    }
}
