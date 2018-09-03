package bhouse.travellist_starterproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.senab.photoview.PhotoViewAttacher;

import static bhouse.travellist_starterproject.R.id.bottomSheet;

public class MultipleImages extends AppCompatActivity {
    public static final String EXTRA_PARAM_ID = "place_id";
    public static final String TEMPLE_NAME = "temple_id";
    private Place mPlace;
    public ImageButton mShareImageButtom, mDownloadImageButton;
    Button btnNext;
    private ImageSwitcher simpleImage;
    PhotoViewAttacher photoAttacher;
    View bottomSheet;
    BottomSheetBehavior bottomSheetBehavior;

    // to keep current Index of ImageID array
    int currentIndex = 0;
    static Map<Integer, int[]> map = new HashMap<>();
    static int ashtalasksmiIds[] = {R.drawable.ashtalakshmi, R.drawable.kapalishwar};
    static int ramakrishnaIds[] = {R.drawable.sriramakrishna, R.drawable.parthasarathy};
    static int kapalishwar[] = {R.drawable.kapalishwar, R.drawable.kaligambaltemple};
    static int Parthasarathy[] = {R.drawable.kapalishwar, R.drawable.kaligambaltemple};
    static int Vadapalani[] = {R.drawable.kapalishwar, R.drawable.kaligambaltemple};
    static int Kaligambaltemple[] = {R.drawable.kapalishwar, R.drawable.kaligambaltemple};
    static int Iskcon[] = {R.drawable.kapalishwar, R.drawable.kaligambaltemple};

    static {
        map.put(0, ramakrishnaIds);
        map.put(1, ashtalasksmiIds);
        map.put(2, kapalishwar);
        map.put(3, Parthasarathy);
        map.put(4, Vadapalani);
        map.put(5, Kaligambaltemple);
        map.put(6, Iskcon);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.DetailActivity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_images);
        final int img = (int) getIntent().getSerializableExtra(TEMPLE_NAME);
        simpleImage = findViewById(R.id.simpleImageButton);
        Log.d("MultipleImage", String.valueOf(img));
        btnNext = (Button) findViewById(R.id.buttonNext);
        mShareImageButtom = (ImageButton) findViewById(R.id.shareImage);
        mDownloadImageButton = (ImageButton) findViewById(R.id.downloadImage);
        bottomSheet = (View) findViewById(R.id.bottomSheet);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        mShareImageButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

       /* mDownloadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
                //ImageView img=(ImageView)findViewById(R.id.imgPicker);
              //  img.setImageBitmap(b);
                Bitmap bitmap = BitmapFactory.decodeFile())
                new ImageSave(getApplicationContext()).
                        setFileName("myImage.png").
                        setDirectoryName("images").
                        save();
            }
        });*/
        simpleImage.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // set the Height And Width of ImageView To FIll PARENT
                int getFirstImage[] = map.get(img);
                imageView.setImageResource(getFirstImage[0]);
                photoAttacher = new PhotoViewAttacher(imageView);
                photoAttacher.update();
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ImageSwitcher
        simpleImage.setInAnimation(in);
        simpleImage.setOutAnimation(out);

        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                Log.d("Insdie onClick", String.valueOf(currentIndex));
                //  Check If index reaches maximum then reset it

                if (map.containsKey(img)) {
                    Log.d("Inside map Onclick:::", String.valueOf(map));
                    int arr[] = map.get(img);
                    Log.d("Inside for map Onclic:", String.valueOf(arr.length));
                    if (currentIndex == arr.length)
                        currentIndex = 0;
                    simpleImage.setImageResource(arr[currentIndex]); // set the image in ImageSwitcher

                }
            }
        });
        // simpleImage.setImageResource(ashtalasksmiIds[0]);
        // mPlace = PlaceData.placeList().g00et(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));
      /*  mPlace = PlaceData.placeList().get(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));
      //  simpleImageSwitcher = (ImageSwitcher) findViewById(R.id.simpleImageSwitcher);


        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
     //   simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                // set the Height And Width of ImageView To FIll PARENT
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ImageSwitcher
        simpleImageSwitcher.setInAnimation(in);
        simpleImageSwitcher.setOutAnimation(out);


        // ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image  will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count)
                    currentIndex = 0;
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
            }
        });

    }
*/
    }
}