package fr.utbm.lo52.CustomAndroid.mediacenter.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmars on 03/12/2016.
 */

public class Serie implements Serializable {

    private String title;
    private String illustrationPath;
    private int lastSeasonNumber;
    private List<Season> seasons;

    public Serie(String title, String illustrationPath) {
        this.title = title;
        this.illustrationPath = illustrationPath;
        this.seasons = new ArrayList<>();
        this.lastSeasonNumber = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIllustrationPath() {
        return illustrationPath;
    }

    public void setIllustrationPath(String illustrationPath) {
        this.illustrationPath = illustrationPath;
    }

    public void addSeason(Season season) {
        this.seasons.add(season);
        if(Integer.parseInt(season.getSeasonNumber()) > lastSeasonNumber){
            lastSeasonNumber = Integer.parseInt(season.getSeasonNumber());
            illustrationPath = season.getIllustrationPath();
        }
    }

    public List<Season> getSeasons() {
        return this.seasons;
    }
}
