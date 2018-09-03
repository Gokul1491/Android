package bhouse.travellist_starterproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.DetailViewHolder> {
    Context dContext;
    public static final String TAG = "DetailListAdapter";
    ArrayList<PlaceInformation> dList;

    public DetailListAdapter(Context dContext, ArrayList<PlaceInformation> arrayList) {
        Log.d(TAG, "Start of an DetailListAdapter Construc ");
        this.dContext = dContext;
        dList = arrayList;

    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
        Log.d(TAG, "Start of an onCreateViewHolder");
        return new DetailViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final DetailViewHolder holder, int position) {

      //  final PlaceInformation place = new PlaceInformation().placeList().get(position);
        /*holder.historyTV.setText(place.templeHistory);
        holder.descriptionTV.setText(place.templeDescription);
        holder.timingsTV.setText(place.templeTimings);*/

    }

    @Override
    public int getItemCount() {
     //   return new PlaceInformation().placeList().size();
        return  0;
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {

        public CardView historyCV, descriptionCV, timingsCV;
        public TextView historyTV, descriptionTV, timingsTV;

        public DetailViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "Start of an detail View holder having recycler view");
             historyCV = itemView.findViewById(R.id.historyCard);
            historyTV = itemView.findViewById(R.id.historyTV);
              descriptionCV = itemView.findViewById(R.id.descriptionCard);
            descriptionTV = itemView.findViewById(R.id.descriptionTV);
              timingsCV = itemView.findViewById(R.id.timingsCard);
            timingsTV = itemView.findViewById(R.id.timingsTV);
            Log.d(TAG, "End of an detail View holder recycler");

        }
    }
}
