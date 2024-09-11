package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherandForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherandForecastFragment extends Fragment {

    private String city;

    public static WeatherandForecastFragment newInstance(String city) {
        WeatherandForecastFragment fragment = new WeatherandForecastFragment();

        Bundle args = new Bundle();

        args.putString("city", city);

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            city = getArguments().getString("city");
        }

        // Inflate your layout and do the necessary setup
        return inflater.inflate(R.layout.fragment_weatherand_forecast, container, false);
    }
}