package bhouse.travellist_starterproject;

import java.util.ArrayList;

public class PlaceData {

  public static String[] placeNameArray = {"Kapalishwar","Sri Ramakrishna",
          "India",  "Ashtalakshmi", "Tirupathi"};

  public static ArrayList<Place> placeList() {
    ArrayList<Place> list = new ArrayList<>();
    for (int i = 0; i < placeNameArray.length; i++) {
      Place place = new Place();
      place.name = placeNameArray[i];
      place.imageName = placeNameArray[i].replaceAll("\\s+", "").toLowerCase();
      if (i == 2 || i == 5) {
        place.isFav = true;
      }
      list.add(place);
    }
    return (list);
  }
}
