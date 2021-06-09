package com.example.carmelmusicacademyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.Date;

public class SubRequestForm extends AppCompatActivity {


    EditText etReason, etDateRequesting;


    Button btnSubmit, btnViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_request_form);

        etDateRequesting = findViewById(R.id.etDateRequesting);
        etReason = findViewById(R.id.etReason);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String dateRequested = etDateRequesting.getText().toString();
                final String reason = etReason.getText().toString();

                final SubRequests subRequests = new SubRequests();

                subRequests.setDateRequested(dateRequested);
                subRequests.setReason(reason);
                subRequests.setUserEmail(TestApplication.user.getEmail());

                Backendless.Persistence.save(subRequests, new AsyncCallback<SubRequests>() {
                    @Override
                    public void handleResponse(SubRequests response) {
                        Toast.makeText(SubRequestForm.this, "Request has been received.", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(SubRequestForm.this, NavigationMenu.class));
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });
            }
        });

        btnViewList = findViewById(R.id.btnViewList);
        btnViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SubRequestForm.this, "Loading all pending Sub requests.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SubRequestForm.this, SubRequestList.class));
            }
        });


    }
}
