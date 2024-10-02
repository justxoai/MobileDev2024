package vn.edu.usth.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class ForecastFragment extends Fragment {
    private ImageView logo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        LinearLayout layout = new LinearLayout(getContext());
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//        TextView textView = new TextView(getContext());
//        textView.setText("USTH Weather");
//
//        // Create a new ImageView
//        ImageView imageView = new ImageView(getContext());
//        imageView.setImageResource(R.drawable.weather);
//        imageView.setBackgroundColor(0xFF000000);
//        imageView.setPadding(16, 16, 16, 16);
//
//        // Add the TextView and ImageView to the layout
//        layout.addView(textView);
//        layout.addView(imageView);
//
//        // Return the layout as the root view of the fragment
//        return layout;

        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
        v.setBackgroundColor(0xffffff);

        logo = v.findViewById(R.id.logo);
        return v;
    }
    public void updateLogo(Bitmap bitmap) {
        // Update the ImageView with the downloaded bitmap
        if (logo != null) {
            logo.setImageBitmap(bitmap);
        }
    }
}