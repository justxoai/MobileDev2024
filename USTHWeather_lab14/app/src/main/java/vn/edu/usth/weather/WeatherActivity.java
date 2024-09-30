package vn.edu.usth.weather;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;

import android.util.Log;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WeatherActivity extends AppCompatActivity {

    private ViewPager2 mviewPager;

    private TabLayout tabLayout;

    private MaterialToolbar toolbar;

    private Handler handler;

    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("Weather", "onCreate Call");

        mviewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);

//        handler = new Handler(Looper.getMainLooper());

        ViewPagerAdapter v = new ViewPagerAdapter(this);
        mviewPager.setAdapter(v);

        new TabLayoutMediator(tabLayout, mviewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Paris");
                        break;
                    case 1:
                        tab.setText("HaNoi");
                        break;
                    case 2:
                        tab.setText("HCM");
                        break;
                    default:
                        tab.setText("NewYork");
                        break;
                }
            }
        }).attach();

        mviewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.i("Weather", "Page selected: " + position);
            }
        });

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {

                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {

                Toast.makeText(WeatherActivity.this, "Refresh completed!", Toast.LENGTH_SHORT).show();
            }
        };

        task.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbartop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.refresh) {

            Toast.makeText(this, "Refreshing", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.more) {

            Intent intent = new Intent(WeatherActivity.this, PrefActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private void simulateNetworkRequest() {
//        Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//
//                    Thread.sleep(3000);
//
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            Toast.makeText(WeatherActivity.this, "Refresh completed!", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }



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