package com.curso.android.app.practica.viewpagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewpager;
    MyViewPagerAdapter myAdapter;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabLayout = findViewById(R.id.tabLayout);

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        //Add the fragments in the viewpager fragment adpater class
        myAdapter.addFragment(new Fragment1());
        myAdapter.addFragment(new Fragment2());
        myAdapter.addFragment(new Fragment3());

        // Set the orientation in viewpager2:
        viewpager = findViewById(R.id.viewPager2);
        viewpager.setOrientation(viewpager.ORIENTATION_HORIZONTAL);
        viewpager.setAdapter(myAdapter);

        // connect tabLayout with viewPager
        new TabLayoutMediator(
                tabLayout,
                viewpager,
                new TabLayoutMediator.TabConfigurationStrategy(){
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("Fragment "+(position+1));
                    }
                }
        ).attach();

    }
}