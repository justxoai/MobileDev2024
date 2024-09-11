package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


public class WeatherActivity extends AppCompatActivity {

    private ViewPager2 mviewPager;

    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("Weather", "onCreate Call");

        mviewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);

        mviewPager.setAdapter(adapter);

        mviewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.i("Weather", "Page selected: " + position);
            }
        });

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