package sk.itsovy.strausz.android.weblink;

public class Utils {

    public static String getWikipediaUtl(String title){
        title = title.replaceAll(" ","_");
        return "https://en.wikipedia.org/wiki/"+title;
    }
}
