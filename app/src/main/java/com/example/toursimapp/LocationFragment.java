package com.example.toursimapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LocationFragment extends Fragment {

    private static final String ARG_LOCATION_NAME = "locationName";
    private static final String ARG_LOCATION_DESCRIPTION = "locationDescription";

    private String locationName;
    private String locationDescription;

    public static LocationFragment newInstance(String locationName, String locationDescription) {
        LocationFragment fragment = new LocationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LOCATION_NAME, locationName);
        args.putString(ARG_LOCATION_DESCRIPTION, locationDescription);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            locationName = getArguments().getString(ARG_LOCATION_NAME);
            locationDescription = getArguments().getString(ARG_LOCATION_DESCRIPTION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        TextView locationNameTextView = view.findViewById(R.id.locationNameTextView);
        TextView locationDescriptionTextView = view.findViewById(R.id.locationDescriptionTextView);

        locationNameTextView.setText(locationName);
        locationDescriptionTextView.setText(locationDescription);

        return view;
    }
}
