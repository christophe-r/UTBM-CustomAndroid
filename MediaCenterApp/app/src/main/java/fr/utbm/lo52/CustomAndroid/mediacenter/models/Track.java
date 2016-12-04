package fr.utbm.lo52.CustomAndroid.mediacenter.models;

import android.util.Log;

/**
 * Created by vmars on 04/12/2016.
 */

public class Track {

    private String trackNumber;
    private String title;
    private String mediaPath;

    public Track(String trackNumber, String title, String mediaPath) {
        this.trackNumber = trackNumber;
        this.title = title;
        this.mediaPath = mediaPath;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
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

}
