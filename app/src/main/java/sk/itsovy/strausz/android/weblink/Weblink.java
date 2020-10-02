package sk.itsovy.strausz.android.weblink;

import java.io.Serializable;

public class Weblink  implements Serializable {

    private String title;
    private float rating;
    private String url;

    public Weblink(String title){
        this(title, 3);
        this.title = title;

    }

    public void setTitle(String title) {
        this.title = title;
        this.url =   Utils.getWikipediaUtl(title);

    }

    public Weblink(String title, float rating) {
        this.title = title;
        this.rating = rating;
        this.url =   Utils.getWikipediaUtl(title);
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }

    public String getUrl() {
        return url;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
