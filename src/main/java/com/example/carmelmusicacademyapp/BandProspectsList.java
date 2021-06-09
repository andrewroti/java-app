package com.example.carmelmusicacademyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class BandProspectsList extends AppCompatActivity {

    ListView lvBandProspects;
    BandProspectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band_prospects_list);

        lvBandProspects = findViewById(R.id.lvBandProspects);

        DataQueryBuilder dataQueryBuilder = DataQueryBuilder.create();
        dataQueryBuilder.setSortBy("created");

        Backendless.Persistence.of(BandProspectsBackendless.class).find(dataQueryBuilder, new AsyncCallback<List<BandProspectsBackendless>>() {
            @Override
            public void handleResponse(List<BandProspectsBackendless> response) {

                TestApplication.bandProspectsBackendlessList = response;
                adapter = new BandProspectAdapter(BandProspectsList.this, TestApplication.bandProspectsBackendlessList);
                lvBandProspects.setAdapter(adapter);
            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(BandProspectsList.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
