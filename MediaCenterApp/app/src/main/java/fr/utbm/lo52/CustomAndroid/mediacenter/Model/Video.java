package fr.utbm.lo52.CustomAndroid.mediacenter.Model;

/**
 * Created by Christophe on 2016-11-29.
 */

public class Video {
    private String title;
    private String year;
    private String illustrationPath;

    public Video(String title, String year, String illustrationPath) {
        this.title = title;
        this.year = year;
        this.illustrationPath = illustrationPath;
    }

    public String getIllustrationPath(){
        return illustrationPath;
    }

    public String getTitle(){
        return title;
    }

    public String getYear(){
        return year;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setYear(String year){
        this.year = year;
    }

    public void setIllustrationPath(String illustrationPath){
        this.illustrationPath = illustrationPath;
    }


}