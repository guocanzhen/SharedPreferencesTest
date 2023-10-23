package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveData = findViewById(R.id.save_data);
        saveData.setOnClickListener(v -> {
            SharedPreferences.Editor edit = getSharedPreferences("data", MODE_PRIVATE).edit();
            edit.putString("name", "Tom");
            edit.putInt("age", 18);
            edit.putBoolean("marry", false);
            edit.apply();
        });

        Button restoreData = findViewById(R.id.restore_data);
        restoreData.setOnClickListener(v -> {
            SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
            String name = pref.getString("name", "");
            int age = pref.getInt("age", 0);
            boolean marry = pref.getBoolean("marry", false);
            Log.d("MainActivity", "name is " + name);
            Log.d("MainActivity", "age is " + age);
            Log.d("MainActivity", "marry is " + marry);
        });
    }
}