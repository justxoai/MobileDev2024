package vn.edu.usth.weather;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.Environment;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {

    private ViewPager2 mviewPager;

    private TabLayout tabLayout;

    private MaterialToolbar toolbar;

    private Handler handler;

    private MediaPlayer mediaPlayer;
    private static final String TAG = "MediaPlayerDemo";
    private static final String MP3_FILE_NAME = "raw/fireside_dreams.mp3";
    private static final int REQUEST_PERMISSION_WRITE = 1001;

    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("Weather", "onCreate Call");

        mviewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);

        handler = new Handler(Looper.getMainLooper());

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

        playMP3FromSDCard();
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

    private void copyMP3ToExternalStorage() {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try{

            inputStream = getResources().openRawResource(R.raw.fireside_dreams);

            File sdCard = Environment.getExternalStorageDirectory();
            File directory = new File(sdCard.getAbsolutePath() + "/Music/");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(directory, MP3_FILE_NAME);
            outputStream = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            Log.d(TAG, "MP3 file copied to SD card: " + file.getAbsolutePath());

        } catch (IOException e) {
            Log.e(TAG, "Failed to copy MP3 file to SD card", e);
        } finally {

            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void playMP3FromSDCard() {
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File file = new File(sdCard.getAbsolutePath() + "/Music/" + MP3_FILE_NAME);

            if (file.exists()) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(file.getAbsolutePath());
                mediaPlayer.prepare();
                mediaPlayer.start();
                Log.d(TAG, "Playing MP3 from SD card: " + file.getAbsolutePath());
            } else {
                Log.e(TAG, "MP3 file not found on SD card.");
            }
        } catch (IOException e) {
            Log.e(TAG, "Failed to play MP3 file", e);
        }
    }

    private void simulateNetworkRequest() {
        Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(3000);


                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(WeatherActivity.this, "Refresh completed!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
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