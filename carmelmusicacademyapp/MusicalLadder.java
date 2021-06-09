package com.example.carmelmusicacademyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class MusicalLadder extends AppCompatActivity {

    ListView lvStudents;

    LadderAdapter adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musical_ladder);


        lvStudents = findViewById(R.id.lvStudents);

        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MusicalLadder.this, DeleteMusicalLadderStudent.class);
                intent.putExtra("index", position);
                startActivityForResult(intent, 1);


            }
        });



        String whereClause = "userEmail = '" + TestApplication.user.getEmail() + "'";

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause(whereClause);
        queryBuilder.setSortBy("created");


        Backendless.Persistence.of(LadderList.class).find(queryBuilder, new AsyncCallback<List<LadderList>>() {
            @Override
            public void handleResponse(List<LadderList> response) {



                TestApplication.students = response;
                adapter = new LadderAdapter(MusicalLadder.this, TestApplication.students);
                lvStudents.setAdapter(adapter);
            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(MusicalLadder.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });








    }
}
