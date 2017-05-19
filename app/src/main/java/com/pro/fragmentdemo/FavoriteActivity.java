package com.pro.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class FavoriteActivity extends AppCompatActivity {

    BottomNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_layout);

        bottom_nav = (BottomNavigationView)findViewById(R.id.bottom_nav_bar);
        BottomNavigationHelper.disableShiftMode(bottom_nav);
        Menu menue = bottom_nav.getMenu();
        MenuItem item = menue.getItem(3);
        item.setChecked(true);

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent fav = new Intent(FavoriteActivity.this, MainActivity.class);
                        startActivity(fav);
                        break;
                    case R.id.search:
                        Intent explore = new Intent(FavoriteActivity.this, ExploreActivity.class);
                        startActivity(explore);
                        break;
                    case R.id.add:
                        Intent add = new Intent(FavoriteActivity.this, AddActivity.class);
                        startActivity(add);
                        break;
                    case R.id.favorite:
                        Toast.makeText(getApplicationContext(), "Already In Favorite Activity!", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.profile:
                        Intent profile = new Intent(FavoriteActivity.this, ProfileActivity.class);
                        startActivity(profile);
                        break;
                }
                return false;
            }
        });
    }
}
