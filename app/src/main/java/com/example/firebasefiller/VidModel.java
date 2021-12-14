package com.example.firebasefiller;

public class VidModel {

        public String videoURL;
        public String tv;
        public String countdown;

        public VidModel(){

        }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getCountdown() {
        return countdown;
    }

    public void setCountdown(String countdown) {
        this.countdown = countdown;
    }

    public VidModel(String videoURL, String tv, String countdown) {
        this.videoURL = videoURL;
        this.tv = tv;
        this.countdown = countdown;
    }
}
