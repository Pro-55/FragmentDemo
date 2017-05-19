package com.pro.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    BottomNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_layout);

        bottom_nav = (BottomNavigationView)findViewById(R.id.bottom_nav_bar);
        BottomNavigationHelper.disableShiftMode(bottom_nav);
        Menu menue = bottom_nav.getMenu();
        MenuItem item = menue.getItem(4);
        item.setChecked(true);

        bottom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent profile = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(profile);
                        break;
                    case R.id.search:
                        Intent explore = new Intent(ProfileActivity.this, ExploreActivity.class);
                        startActivity(explore);
                        break;
                    case R.id.add:
                        Intent add = new Intent(ProfileActivity.this, AddActivity.class);
                        startActivity(add);
                        break;
                    case R.id.favorite:
                        Intent fav = new Intent(ProfileActivity.this, FavoriteActivity.class);
                        startActivity(fav);
                        break;
                    case R.id.profile:
                        Toast.makeText(getApplicationContext(), "Already In Profile Activity!", Toast.LENGTH_LONG).show();
                        break;
                }
                return false;
            }
        });
    }
}
