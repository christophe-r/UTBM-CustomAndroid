package fr.utbm.lo52.CustomAndroid.mediacenter.models;

import java.io.Serializable;

/**
 * Created by vmars on 03/12/2016.
 */


public class Episode implements Serializable {

    private String EpNumber;
    private String title;
    private String mediaPath;
    private String summary;

    public Episode(String summary, String mediaPath, String epNumber, String title) {
        this.summary = summary;
        this.mediaPath = mediaPath;
        this.EpNumber = epNumber;
        this.title = title;
    }

    public String getEpNumber() {
        return EpNumber;
    }

    public void setEpNumber(String epNumber) {
        EpNumber = epNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}