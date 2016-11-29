package fr.utbm.lo52.CustomAndroid.mediacenter.Model;

/**
 * Created by Christophe on 2016-11-29.
 */

public class Video {
    private String title;
    private String author;
    private String imageUrl;

    public Video(String title, String author, String imageUrl) {
        this.title = title;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }


}