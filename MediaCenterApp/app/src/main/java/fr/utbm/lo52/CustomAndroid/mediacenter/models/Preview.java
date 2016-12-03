package fr.utbm.lo52.CustomAndroid.mediacenter.models;

/**
 * Created by vmars on 03/12/2016.
 */

public class Preview {

    private String title;
    private String illustrationPath;

    public Preview(String title, String illustrationPath) {
        this.title = title;
        this.illustrationPath = illustrationPath;
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

}
