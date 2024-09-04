package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.*;
import android.view.View;


public class WeatherActivity extends AppCompatActivity {

//    private static final String TAG = "MainActivity";

    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_main);

        Log.i("Weather", "onCreate Call");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i("Weather", "onStart Call");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("Weather", "onResume Call");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i("Weather", "onPause Call");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i("Weather", "onStop Call");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("Weather", "onDestroy Call");
    }


}