package com.example.carmelmusicacademyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class TeacherContacts extends AppCompatActivity {

    ListView lvContacts;
    ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_contacts);

        lvContacts = findViewById(R.id.lvContacts);

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        queryBuilder.setSortBy("name");

        Backendless.Persistence.of(Contacts.class).find(queryBuilder, new AsyncCallback<List<Contacts>>() {
            @Override
            public void handleResponse(List<Contacts> response) {

                TestApplication.contacts = response;
                adapter =  new ContactsAdapter(TeacherContacts.this, TestApplication.contacts);
                lvContacts.setAdapter(adapter);
            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(TeacherContacts.this, "" + fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
