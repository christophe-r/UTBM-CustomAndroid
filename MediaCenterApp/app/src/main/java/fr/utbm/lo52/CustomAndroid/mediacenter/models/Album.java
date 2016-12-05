package fr.utbm.lo52.CustomAndroid.mediacenter.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmars on 04/12/2016.
 */

public class Album {
    private String title;
    private String year;
    private String author;
    private String illustrationPath;
    private List<Track> tracks = new ArrayList<>();

    public Album(String title, String author, String illustrationPath, String year) {
        this.illustrationPath = illustrationPath;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void addTrack(Track track){
        this.tracks.add(track);
    }

    public List<Track> getTracks(){
        return this.tracks;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIllustrationPath() {
        return illustrationPath;
    }

    public void setIllustrationPath(String illustrationPath) {
        this.illustrationPath = illustrationPath;
    }
}
