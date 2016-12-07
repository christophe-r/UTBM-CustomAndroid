package fr.utbm.lo52.CustomAndroid.mediacenter.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by vmars on 03/12/2016.
 */

public class Preview implements Serializable {

    private String title;
    private String illustrationPath;
    private Object data;
    private Class DetailActivityclass;

    public Preview(String title, String illustrationPath, Object data, Class detailActivityclass) {
        DetailActivityclass = detailActivityclass;
        this.title = title;
        this.illustrationPath = illustrationPath;
        this.data = data;
    }

    public Class getDetailActivityclass() {
        return DetailActivityclass;
    }

    public void setDetailActivityclass(Class detailActivityclass) {
        DetailActivityclass = detailActivityclass;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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
