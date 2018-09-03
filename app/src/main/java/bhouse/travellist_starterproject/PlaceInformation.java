package bhouse.travellist_starterproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlaceInformation {

    public String templeName;
    public String[] templeImages;



    public PlaceInformation(String templeName, String[] templeImages) {
        this.templeName = templeName;
        this.templeImages = templeImages;
    }



   /* public static ArrayList<PlaceInformation> placeList() {
        ArrayList<PlaceInformation> list = new ArrayList<>();
        for (int i = 0; i < historyArray.length; i++) {
            PlaceInformation pi = new PlaceInformation();
            pi.templeDescription = historyArray[i];
            pi.templeHistory = descriptionArray[i];
            pi.templeTimings = historyArray[i];
            list.add(pi);
        }
        return (list);
    }*/
}
