package com.example.carmelmusicacademyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class NavigationMenu extends AppCompatActivity {


    Button btnMusicalLadder, btnContacts, btnBandProspects, btnRequestSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);


        btnMusicalLadder = findViewById(R.id.btnMusicalLadder);
        btnMusicalLadder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationMenu.this, "Loading your students!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NavigationMenu.this, MusicalLadder.class));
            }
        });

        btnContacts = findViewById(R.id.btnContacts);
        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(NavigationMenu.this, "Loading all teacher contacts.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NavigationMenu.this, TeacherContacts.class));
            }
        });

        btnBandProspects = findViewById(R.id.btnBandProspects);
        btnBandProspects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(NavigationMenu.this, BandProspects.class));
            }
        });

        btnRequestSub = findViewById(R.id.btnRequestSub);
        btnRequestSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(NavigationMenu.this, SubRequestForm.class));

            }
        });
    }
}
