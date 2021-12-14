package com.example.firebasefiller;

public class ExerciseModel {
   String turl, title, description;

   public ExerciseModel(){

   }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExerciseModel(String turl, String title, String description) {
        this.turl = turl;
        this.title = title;
        this.description = description;
    }
}

