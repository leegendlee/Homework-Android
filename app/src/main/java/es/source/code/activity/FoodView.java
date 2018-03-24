package es.source.code.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import es.source.code.R;
import es.source.code.adapter.FoodViewPagerAdapter;
import es.source.code.fragment.FoodItemFragment;

public class FoodView extends AppCompatActivity implements FoodItemFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_view);
        Resources resources = getResources();
        String[] food_types = {resources.getString(R.string.cold_food), resources.getString(R.string.hot_food), resources.getString(R.string.seafood), resources.getString(R.string.drinks)};

        TabLayout foodViewTab = (TabLayout) findViewById(R.id.foodView_tabLayout);
        ViewPager foodViewViewPager = (ViewPager) findViewById(R.id.foodView_viewPager);
        FoodViewPagerAdapter foodViewPagerAdapter = new FoodViewPagerAdapter(getSupportFragmentManager());
        foodViewPagerAdapter.setPage_titles(food_types);
        foodViewPagerAdapter.setFragmentList(food_types);

        foodViewViewPager.setAdapter(foodViewPagerAdapter);
        foodViewTab.setupWithViewPager(foodViewViewPager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.foodView_toolBar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.i("id", String.valueOf(item.getItemId()));
                switch (item.getItemId()) {
                    case R.id.toolBar_btnService:
                        Log.i("id", String.valueOf(item.getItemId()));
                        Intent mainScreen = new Intent(FoodView.this, MainScreen.class);
                        startActivity(mainScreen);
                }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
