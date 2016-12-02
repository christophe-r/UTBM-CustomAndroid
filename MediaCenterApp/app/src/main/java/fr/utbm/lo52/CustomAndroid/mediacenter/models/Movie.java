package fr.utbm.lo52.CustomAndroid.mediacenter.models;

/**
 * Created by Christophe on 2016-11-29.
 */

public class Movie {
    private String title;
    private String year;
    private String illustrationPath;
    private String mediaPath;
    private String actors;
    private String director;
    private String summary;

    public Movie(String title, String year, String illustrationPath, String mediaPath, String actors, String director, String summary) {
        this.title = title;
        this.year = year;
        this.illustrationPath = illustrationPath;
        this.mediaPath = mediaPath;
        this.actors = actors;
        this.director = director;
        this.summary = summary;
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

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
