package com.crpr.androidadapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crpr.androidadapters.monster.MonsterActivity;
import com.crpr.androidadapters.multi_item.MultiItemActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(0,0);

        setContentView(R.layout.activity_main);

        setupClickListeners();
    }

    private void setupClickListeners() {
        findViewById(R.id.main_monster_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(MonsterActivity.class);
            }
        });

        findViewById(R.id.main_multi_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(MultiItemActivity.class);
            }
        });

        findViewById(R.id.main_shared_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void launchActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
