package sk.itsovy.strausz.android.weblink;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Weblink  implements Serializable {

    private UUID uuid;
    private String title;
    private float rating;
    private String url;

    public Weblink(String title){
        this(title, 0);
        this.title = title;

    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weblink weblink = (Weblink) o;
        return Objects.equals(uuid, weblink.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    public void setTitle(String title) {
        this.title = title;
        this.url =   Utils.getWikipediaUtl(title);

    }

    public Weblink(String title, float rating) {
        this.uuid = UUID.randomUUID();
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

    public static Weblink createEmptyWeblink(){
        return new Weblink("");
    }
}
