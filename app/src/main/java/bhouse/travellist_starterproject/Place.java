package bhouse.travellist_starterproject;

import android.content.Context;

public class Place {

  public String name;
  public String imageName;
  public String templeDescription;
  public String templeHistory;
  public String templeTimings;

    public Place(String name, String imageName, String templeDescription, String templeHistory, String templeTimings ) {
        this.name = name;
        this.imageName = imageName;
        this.templeDescription = templeDescription;
        this.templeHistory = templeHistory;
        this.templeTimings = templeTimings;

    }

  public int getImageResourceId(Context context) {
    return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
  }
}
