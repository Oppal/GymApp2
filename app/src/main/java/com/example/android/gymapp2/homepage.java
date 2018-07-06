package com.example.android.gymapp2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.gymapp2.R;
import com.example.android.gymapp2.item;
import com.example.android.gymapp2.itemAdapter;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class homepage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private itemAdapter adapter;
    private List<item> albumList;

    protected  void attachBaseContext(Context newBase){
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

       Paper.init(this);

       String language = Paper.book().read("language");
       if(language==null){
           Paper.book().write("language", "en");

       }

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        adapter = new itemAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.gg).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    @Override
    public	boolean	onOptionsItemSelected(MenuItem item){
        switch	(item.getItemId())
        {case	R.id.home:
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
            return	true;
            case	R.id.profile:
                Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
                return	true;
                case	R.id.logout:
                    Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                    return	true;
                    case	R.id.english:
                        Toast.makeText(this, "english", Toast.LENGTH_SHORT).show();
                        Paper.book().write("language", "en");
                        updateView((String)Paper.book().read("language"));
                        return	true;
            case	R.id.kiswahili:
                Toast.makeText(this, "kiswahili", Toast.LENGTH_SHORT).show();
                Paper.book().write("language", "sw");
                updateView((String)Paper.book().read("language"));
                return	true;
            case	R.id.German:
                Toast.makeText(this, "German", Toast.LENGTH_SHORT).show();
                Paper.book().write("language", "de");
                updateView((String)Paper.book().read("language"));
                return	true;
            case	R.id.help:
                Toast.makeText(this, "help", Toast.LENGTH_SHORT).show();
                return	true;
                        default:
                            //	Do	nothing
                            }
                             return	super.onOptionsItemSelected(item);		}

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this, lang);
        Resources resources = context.getResources();
        finish();
        startActivity(new Intent(homepage.this, homepage.class));
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.map1,
                R.drawable.workout,
                R.drawable.i1,

        };

        item a = new item("Locate", "Find a gym near you!", covers[0]);
        albumList.add(a);

        a = new item("Workouts", "design your workout programmes!", covers[1]);
        albumList.add(a);

        a = new item("Instructor", "View the profiles of our instructors", covers[2]);
        albumList.add(a);


        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
