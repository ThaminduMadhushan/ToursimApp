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
        setContentView(R.layout.home_screen);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Colombo","Colombo is the vibrant and bustling capital city of Sri Lanka, an island nation in South Asia. As the country's largest city and commercial hub, Colombo offers a diverse array of attractions and experiences for travelers. Here's a brief description of Colombo travel:" ,4.5, "pic1"));
        items.add(new PopularDomain("Galle","Galle is a charming coastal city located in the southern part of Sri Lanka. It is renowned for its rich history, picturesque beaches, and well-preserved colonial architecture. Here's a brief description of Galle travel:",4.9, "pic2"));
        items.add(new PopularDomain("Jaffna", "Jaffna, located in the northernmost region of Sri Lanka, is a city steeped in history and cultural heritage. Despite the challenges it faced during the country's civil conflict, Jaffna has emerged as a vibrant destination, inviting travelers to explore its unique attractions. Here's a brief description of Jaffna travel:",4.7, "pic3"));

        recyclerViewPopular = findViewById(R.id.view_top);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterPopular = new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}
