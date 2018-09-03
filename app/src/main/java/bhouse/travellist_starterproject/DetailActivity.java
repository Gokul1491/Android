package bhouse.travellist_starterproject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_PARAM_ID = "place_id";
    public static final String TEMPLE_NAME = "temple_id";
    private ImageView mImageView, mShareView;
    private TextView mHistory, mDescirption, mTiminigs;
    private LinearLayout mTitleHolder, mRevealView;
    private ImageButton mAddButton, mAddButton1;
    private Place mPlace;
    private ArrayList<String> mTodoList;
    private ArrayAdapter mToDoAdapter;
    private RecyclerView dRecyclerView;
    public TravelListAdapter mAdapter;
   // private DetailListAdapter dAdapter;
    public static final String DETAIL_TAG = "DETAIL_ACTIVITY";
    private ArrayList<PlaceInformation> dList = new ArrayList<>();
    private CollapsingToolbarLayout collapsingToolbarLayout = null;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d(DETAIL_TAG, "Start of an onCreateViewHolder");
        setTheme(R.style.DetailActivity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
                // using bundle to retrieve the data from main activitty
                mPlace = PlaceData.placeList().get(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));
        final int val = (int) getIntent().getSerializableExtra(EXTRA_PARAM_ID);
        Log.d(DETAIL_TAG+"postion", String.valueOf(val));
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.colapse_layout);
        mImageView = (ImageView) findViewById(R.id.placeImage1);
       // mShareView = (ImageView) findViewById(R.id.shareImage);
        mHistory = (TextView) findViewById(R.id.historyTV);
        mDescirption = (TextView) findViewById(R.id.descriptionTV);
        mTiminigs = (TextView) findViewById(R.id.timingsTV);
        //     dRecyclerView = (RecyclerView) findViewById(R.id.dList);
        //    dRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //   dAdapter = new DetailListAdapter(this,dList);
        //   mRevealView = (LinearLayout) findViewById(R.id.llEditTextHolder);
        // mEditTextTodo = (EditText) findViewById(R.id.etTodo);
        // this is for adding the music
                /*MediaPlayer mp = MediaPlayer.create(this,R.raw.rajali);
                mp.start();*/
       // mAddButton =(ImageButton) findViewById(R.id.btn_add1);
       //   mAddButton.setOnClickListener((View.OnClickListener) this);
        //dAdapter = new DetailListAdapter(this,dList);
        // dRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //  dRecyclerView.setAdapter(dAdapter);
        //  dRecyclerView.setAdapter(dAdapter);
     //   defaultColor = getResources().getColor(R.color.primary_dark);

        //   mInputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //    mRevealView.setVisibility(View.INVISIBLE);
        //isEditTextVisible = false;
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.placeImage1:
                      /*  int imageIds[] = {R.drawable.ashtalakshmi, R.drawable.parthasarathy, R.drawable.sriramakrishna, R.drawable.kapalishwar, R.drawable.kaligambaltemple};
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(R.drawable.sriramakrishna);
                        al.add(R.drawable.ashtalakshmi);
                        al.add(R.drawable.parthasarathy);
                        al.add(R.drawable.vadapalani);
                        al.add(R.drawable.kaligambaltemple);*/

                        //  PlaceInformation pi = new PlaceInformation("Ashtalakshmi", {})
                        Intent intent = new Intent(DetailActivity.this, MultipleImages.class);
                        intent.putExtra(DetailActivity.TEMPLE_NAME, val);

                       // ActivityCompat.startActivity(DetailActivity.this, intent );
                        startActivity(intent);
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.fab:
                        Intent intentMap = new Intent(DetailActivity.this, MapsActivity.class);
                        intentMap.putExtra(DetailActivity.TEMPLE_NAME, val);
                        startActivity(intentMap);
                }
            }
        });
        // setUpAdapter();
        loadPlace();
        //  windowTransition();
        //getPhoto();
    }


  /*private void setUpAdapter() {
    mTodoList = new ArrayList<>();
    mToDoAdapter = new ArrayAdapter(this, R.layout.row_todo, mTodoList);
    mList.setAdapter(mToDoAdapter);
  }*/

    private void loadPlace() {

        collapsingToolbarLayout.setTitle(mPlace.name);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
        mImageView.setImageResource(mPlace.getImageResourceId(this));

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), mPlace.getImageResourceId(this));
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(R.attr.colorPrimaryDark));
            }
        });
        mHistory.setText(mPlace.templeHistory);
        mDescirption.setText(mPlace.templeDescription);
        mTiminigs.setText(mPlace.templeTimings);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void windowTransition() {
        getWindow().getEnterTransition().addListener(new TransitionAdapter() {
            @Override
            public void onTransitionEnd(Transition transition) {
                mAddButton.animate().alpha(1.0f);
                getWindow().getEnterTransition().removeListener(this);
            }
        });
    }

    private void addToDo(String todo) {
        mTodoList.add(todo);
    }

    /*private void getPhoto() {
        Bitmap photo = BitmapFactory.decodeResource(getResources(), mPlace.getImageResourceId(this));
        colorize(photo);
    }

    private void colorize(Bitmap photo) {
        Palette mPalette = Palette.generate(photo);
        applyPalette(mPalette);
    }

    private void applyPalette(Palette mPalette) {
        getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColor(defaultColor)));
        // mTitleHolder.setBackgroundColor(mPalette.getMutedColor(defaultColor));
        // mRevealView.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
    }
*/
    /* @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
     @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add1:


                Intent intent = new Intent(DetailActivity.this, MapsActivity.class);
                startActivity(intent);
        //*if (!isEditTextVisible) {
        //  revealEditText(mRevealView);
        //  mEditTextTodo.requestFocus();
        //  mInputManager.showSoftInput(mEditTextTodo, InputMethodManager.SHOW_IMPLICIT);
        //  mAddButton.setImageResource(R.drawable.icn_morph);
        //  mAnimatable = (Animatable) (mAddButton).getDrawable();
        //  mAnimatable.start();


        }
    }
*/


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void revealEditText(LinearLayout view) {

        int cx = view.getRight() - 30;
        int cy = view.getBottom() - 60;
        int finalRadius = Math.max(view.getWidth(), view.getHeight());
        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
        view.setVisibility(View.VISIBLE);
        //isEditTextVisible = true;
        anim.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void hideEditText(final LinearLayout view) {
        int cx = view.getRight() - 30;
        int cy = view.getBottom() - 60;
        int initialRadius = view.getWidth();
        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });
        //  isEditTextVisible = false;
        anim.start();
    }

    @Override
    public void onBackPressed() {
      finish();
      /*    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(50);
        mAddButton.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onAnimationEnd(Animation animation) {
                mAddButton.setVisibility(View.GONE);
                finishAfterTransition();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }*/
    }
}