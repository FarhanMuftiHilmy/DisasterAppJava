package com.arfdn.disasterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.arfdn.disasterapp.databinding.ActivityMainJavaBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivityJava extends AppCompatActivity {

    private ActivityMainJavaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainJavaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Disaster> disasterList = generateDummy();
        DisasterAdapterJava adapterDisaster = new DisasterAdapterJava(disasterList, new DisasterAdapterJava.OnClickDisaster() {
            @Override
            public void onClick(Disaster disaster) {
                Toast.makeText(MainActivityJava.this, "You clicked on " + disaster.getNameDisaster(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.rvDisaster.setAdapter(adapterDisaster);

        // linearLayoutManager
//        binding.rvDisaster.setLayoutManager(new LinearLayoutManager(this));
        // gridLayoutManager
        binding.rvDisaster.setLayoutManager(new GridLayoutManager(MainActivityJava.this, 2));

    }

    private List<Disaster> generateDummy() {
        List<Disaster> dummyList = new ArrayList<>();
        dummyList.add(new Disaster("Tsunami", "Natural"));
        dummyList.add(new Disaster("Volcanic Eruption", "Natural"));
        dummyList.add(new Disaster("Earthquake", "Natural"));
        dummyList.add(new Disaster("Flood", "Natural"));
        dummyList.add(new Disaster("Fire", "Natural"));
        dummyList.add(new Disaster("Nuclear Accident", "Man-made"));
        dummyList.add(new Disaster("Terrorist Attack", "Man-made"));
        dummyList.add(new Disaster("War", "Man-made"));
        return dummyList;
    }
}