package com.gianluca.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch swNotifications;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swNotifications = findViewById(R.id.swNotifications);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isNotificationEnabled = sharedPreferences.getBoolean("notifications",false);
        swNotifications.setChecked(isNotificationEnabled);
        swNotifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sharedPreferences.edit().putBoolean("notifications",b).apply();
            }
        });
    }
}