package vn.edu.usth.weather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;

import android.util.Log;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherActivity extends AppCompatActivity {

    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Call
        setContentView(R.layout.activity_weather);
        Log.i("Weather", "onCreate Call");

        ViewPager2 mviewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);

        ViewPagerAdapter v = new ViewPagerAdapter(this);
        mviewPager.setAdapter(v);


        // Tablayout
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

        Extract_music();

        Play_music();

        new Logo_task().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbartop, menu);
        return true;
    }
    // Refresh Button
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

    // Play Music
    private void Extract_music() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.fireside_dreams);
            File outFile = new File(getExternalFilesDir(null), "raw/fireside_dreams.mp3");

            FileOutputStream outputStream = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.close();
            inputStream.close();
            Log.i("USTHWeather", "MP3 extracted to: " + outFile.getAbsolutePath());
        } catch (IOException e) {
            Log.e("USTHWeather", "Error extracting MP3", e);
        }
    }

    private void Play_music() {
        try {
            File mp3File = new File(getExternalFilesDir(null), "raw/fireside_dreams.mp3");

            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(mp3File.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            Log.i("USTHWeather", "Playing MP3");
        } catch (IOException e) {
            Log.e("USTHWeather", "Error playing MP3", e);
        }
    }

    // Define the AsyncTask for network simulation
    private class SimulateNetworkTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(WeatherActivity.this, "Starting refresh...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                // Simulate network delay
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data refreshed successfully!";
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(WeatherActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    private class Logo_task extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... voids) {
            Bitmap bitmap = null;
            try {
                // Initialize URL
                URL url = new URL("https://usth.edu.vn/wp-content/uploads/2021/11/logo.png");
                // Make a request to the server
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();

                // Check the response code
                int response = connection.getResponseCode();
                Log.i("USTHWeather", "The response is: " + response);

                InputStream is = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();

            } catch (IOException e) {
                Log.e("USTHWeather", "Error downloading image", e);
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                // Find the ForecastFragment and update the ImageView
                ForecastFragment fragment = (ForecastFragment) getSupportFragmentManager().findFragmentById(R.id.forecastFragment);
                if (fragment != null) {
                    fragment.updateLogo(result);
                }
                Toast.makeText(WeatherActivity.this, "Data refreshed successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(WeatherActivity.this, "Failed to download logo", Toast.LENGTH_SHORT).show();
            }
        }
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