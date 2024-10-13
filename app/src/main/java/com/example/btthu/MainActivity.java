package com.example.btthu;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import Fragment.ViewPagesAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         ViewPager2 viewPager;
        BottomNavigationView bottomNavigationView;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPagesAdapter adapter = new ViewPagesAdapter(this);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.id_home);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.id_news);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.id_setting);
                        break;
                }
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.id_home) {
                    viewPager.setCurrentItem(0);
                } else if (itemId == R.id.id_news) {
                    viewPager.setCurrentItem(1);
                } else if (itemId == R.id.id_setting) {
                    viewPager.setCurrentItem(2);
                }
                return true;
            }
        });
    }
}