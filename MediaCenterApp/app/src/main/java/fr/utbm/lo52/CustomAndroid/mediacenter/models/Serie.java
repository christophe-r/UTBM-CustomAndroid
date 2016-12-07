package fr.utbm.lo52.CustomAndroid.mediacenter.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmars on 03/12/2016.
 */

public class Serie implements Serializable {

    private String title;
    private String year;
    private String illustrationPath;
    private String actors;
    private String season;
    private List<Episode> episodes;

    public Serie(String title, String year, String illustrationPath, String actors, String season) {
        this.title = title;
        this.year = year;
        this.illustrationPath = illustrationPath;
        this.actors = actors;
        this.season = season;
        this.episodes = new ArrayList<>();
    }
    public void addEpisode(Episode episode){
        this.episodes.add(episode);
    }

    public List<Episode> getEpisodes(){
        return this.episodes;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
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

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }



}
