package fr.utbm.lo52.CustomAndroid.mediacenter.Model;

/**
 * Created by Christophe on 2016-11-29.
 */

public class Movie extends Video {
    private String mediaPath;
    private String actors;
    private String realisator;
    private String summary;

    public Movie(String title, String year, String illustrationPath, String mediaPath, String actors, String realisator, String summary) {
        super(title, year, illustrationPath);
        this.mediaPath = mediaPath;
        this.actors = actors;
        this.realisator = realisator;
        this.summary = summary;
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

    public String getRealisator() {
        return realisator;
    }

    public void setRealisator(String realisator) {
        this.realisator = realisator;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
