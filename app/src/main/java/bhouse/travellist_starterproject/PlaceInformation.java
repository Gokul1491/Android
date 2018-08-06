package bhouse.travellist_starterproject;

import java.util.ArrayList;

public class PlaceInformation {

    public String templeDescription;
    public String templeHistory;
    public String templeTimings;

    public PlaceInformation() {
    }

    public PlaceInformation(String templeDescription, String templeHistory, String templeTimings) {
        this.templeDescription = templeDescription;
        this.templeHistory = templeHistory;
        this.templeTimings = templeTimings;
    }
  public static String[] historyArray = {"\nRamakrishna Math is a monastic organisation for men brought into existence by Ramakrishna a 19th-century saint of Bengal.",
            "\nThe Ashtalakshmi Kovil is a Hindu temple, which lies on the shorelines near the Elliot's beach, in Chennai, India. The temple is dedicated to the goddess Lakshmi, and her eight primary forms – the Ashtalakshmi – the giver of all eight forms of wealth, namely, offspring, success, prosperity, wealth, courage, bravery, food, and knowledge.",
            "\nTirupathi",
            "\nKapalishwar", "\nParthasarathy",
            "\nVadapalani",
            "\nKaligambaltemple",
            "\nIskcon"};

    public static String[] descriptionArray = {"\nRamakrishna Math is a monastic organisation for men brought into existence by Ramakrishna a 19th-century saint of Bengal.",
            "\nThe Ashtalakshmi Kovil is a Hindu temple, which lies on the shorelines near the Elliot's beach, in Chennai, India. The temple is dedicated to the goddess Lakshmi, and her eight primary forms – the Ashtalakshmi – the giver of all eight forms of wealth, namely, offspring, success, prosperity, wealth, courage, bravery, food, and knowledge.",
            "\nTirupathi",
            "\nKapalishwar", "\nParthasarathy",
            "\nVadapalani",
            "\nKaligambaltemple",
            "\nIskcon"};
    public static String[] timingArray = {"\nRamakrishna Math is a monastic organisation for men brought into existence by Ramakrishna a 19th-century saint of Bengal.",
            "\nThe Ashtalakshmi Kovil is a Hindu temple, which lies on the shorelines near the Elliot's beach, in Chennai, India. The temple is dedicated to the goddess Lakshmi, and her eight primary forms – the Ashtalakshmi – the giver of all eight forms of wealth, namely, offspring, success, prosperity, wealth, courage, bravery, food, and knowledge.",
            "\nTirupathi",
            "\nKapalishwar", "\nParthasarathy",
            "\nVadapalani",
            "\nKaligambaltemple",
            "\nIskcon"};


    public static ArrayList<PlaceInformation> placeList() {
        ArrayList<PlaceInformation> list = new ArrayList<>();
        for (int i = 0; i < historyArray.length; i++) {
            PlaceInformation pi = new PlaceInformation();
            pi.templeDescription = historyArray[i];
            pi.templeHistory = descriptionArray[i];
            pi.templeTimings = historyArray[i];
            list.add(pi);
        }
        return (list);
    }
}
