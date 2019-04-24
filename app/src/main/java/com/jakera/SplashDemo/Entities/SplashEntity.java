package com.jakera.SplashDemo.Entities;


import java.io.Serializable;

/**
 * Created by jakera on 2019/4/23.
 */

public class SplashEntity implements Serializable {
    private int picture;
    private String firstContent;
    private String firstCircleContent;
    private String secondCircleContent;
    private String firstPoem;
    private String secondPoem;

    public SplashEntity(int picture, String firstContent, String firstCircleContent, String secondCircleContent, String firstPoem, String secondPoem) {
        this.picture = picture;
        this.firstContent = firstContent;
        this.firstCircleContent = firstCircleContent;
        this.secondCircleContent = secondCircleContent;
        this.firstPoem = firstPoem;
        this.secondPoem = secondPoem;
    }

    public int getPicture() {
        return picture;
    }

    public String getFirstContent() {
        return firstContent;
    }

    public String getFirstCircleContent() {
        return firstCircleContent;
    }

    public String getSecondCircleContent() {
        return secondCircleContent;
    }

    public String getFirstPoem() {
        return firstPoem;
    }

    public String getSecondPoem() {
        return secondPoem;
    }
}
