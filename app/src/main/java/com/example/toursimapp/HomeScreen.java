package com.example.toursimapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    private RecyclerView.Adapter<PopularAdapter.ViewHolder> adapterPopular;
    private RecyclerView recyclerViewPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Colombo", "Description 1", "pic1"));
        items.add(new PopularDomain("Colombo", "Description 2", "pic2"));
        items.add(new PopularDomain("Colombo", "Description 3", "pic3"));

        recyclerViewPopular = findViewById(R.id.view_top);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterPopular = new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}
