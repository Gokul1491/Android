package bhouse.travellist_starterproject;

import java.util.ArrayList;

public class PlaceData {

    public static String[] placeNameArray = {"Sri Ramakrishna",
            "Ashtalakshmi", "Tirupathi", "Kapalishwar"};

    public static String[] descriptionArray = {"Ramakrishna Math is a monastic organisation for men brought into existence by Ramakrishna a 19th-century saint of Bengal.",
            "The Ashtalakshmi Kovil is a Hindu temple, which lies on the shorelines near the Elliot's beach, in Chennai, India. The temple is dedicated to the goddess Lakshmi, and her eight primary forms – the Ashtalakshmi – the giver of all eight forms of wealth, namely, offspring, success, prosperity, wealth, courage, bravery, food, and knowledge.",
            "Tirupathi",
            "Kapalishwar"};

    public static ArrayList<Place> placeList() {
        ArrayList<Place> list = new ArrayList<>();
        for (int i = 0; i < placeNameArray.length; i++) {
            Place place = new Place();
            place.name = placeNameArray[i];
            place.templeDescription = descriptionArray[i];
            place.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
            if (i == 2 || i == 5) {
                place.isFav = true;
            }
            list.add(place);
        }
        return (list);
    }
}
