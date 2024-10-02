package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_weather, container, false);
//        v.setBackgroundColor(0xdbfbdb);

        return inflater.inflate(R.layout.fragment_weather, container, false);
    }
}