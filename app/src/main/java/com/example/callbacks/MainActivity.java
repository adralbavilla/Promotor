package com.example.callbacks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public LeafletListAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adaptador = new LeafletListAdapter(this, menuItems());
        recyclerView = findViewById(R.id.recycler_view_leaflet);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);


        PopupMenuGetAll.getListItems(this, R.array.listArray);

    }

    public static ArrayList<Leaflet> menuItems(){
        ArrayList<Leaflet> menuList = new ArrayList<>();
        menuList.add(new Leaflet("GRUPO MARTINEZ LOPEZ", "10 DE NOV 9:30 AM"));
        menuList.add(new Leaflet("GRUPO PEREZ", "10 DE NOV 9:30 AM"));
        menuList.add(new Leaflet("GRUPO LOPEZ SANCHEZ", "10 DE NOV 9:30 AM"));
        menuList.add(new Leaflet("GRUPO MARTINEZ LOPEZ", "10 DE NOV 9:30 AM"));
        menuList.add(new Leaflet("ABRAHAM LOPEZ", "10 DE NOV 9:30 AM"));
        menuList.add(new Leaflet("GRUPO MARTINEZ LOPEZ", "10 DE NOV 9:30 AM"));
        return menuList;
    }

}
