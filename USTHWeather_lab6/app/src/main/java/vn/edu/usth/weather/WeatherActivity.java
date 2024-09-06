package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class WeatherActivity extends AppCompatActivity {

    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Create a new Fragment to be placed in the activity l
//        ForecastFragment forecastFragment = new ForecastFragment();
        // Add the fragment to the 'container' FrameLayout
//        getSupportFragmentManager().beginTransaction().add(R.id.main, forecastFragment).commit();// container => main

//        WeatherFragment weatherFragment = new WeatherFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.main, weatherFragment).commit();

        setContentView(R.layout.activity_weather);

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