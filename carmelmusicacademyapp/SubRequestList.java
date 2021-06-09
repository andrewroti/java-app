package com.example.carmelmusicacademyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class SubRequestList extends AppCompatActivity {

    SubRequestAdapter subRequestAdapter;

    ListView lvSubList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_request_list);


        lvSubList = findViewById(R.id.lvSubList);

        DataQueryBuilder dataQueryBuilder = DataQueryBuilder.create();
        dataQueryBuilder.setGroupBy("created");

        Backendless.Persistence.of(SubRequests.class).find(new AsyncCallback<List<SubRequests>>() {
            @Override
            public void handleResponse(List<SubRequests> response) {

                TestApplication.subRequests = response;
                subRequestAdapter = new SubRequestAdapter(SubRequestList.this, TestApplication.subRequests);
                lvSubList.setAdapter(subRequestAdapter);



            }

            @Override
            public void handleFault(BackendlessFault fault) {



            }
        });
    }
}
