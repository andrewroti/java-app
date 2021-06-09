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

public class BandProspects extends AppCompatActivity {

    Button btnViewList, btnSubmitStudent;
    EditText etStudentName, etAge, etInstrument, etTeacher, etLessonDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_band_prospects);

        btnViewList = findViewById(R.id.btnViewList);
        btnViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(BandProspects.this, "Loading the Band Prospects list.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BandProspects.this, BandProspectsList.class));

            }
        });


        etStudentName = findViewById(R.id.etStudentName);
        etAge = findViewById(R.id.etAge);
        etInstrument = findViewById(R.id.etInstrument);
        etTeacher = findViewById(R.id.etTeacher);
        etLessonDays = findViewById(R.id.etLessonDays);

        btnSubmitStudent = findViewById(R.id.btnSubmitStudent);
        btnSubmitStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etAge.getText().toString().isEmpty()|| etInstrument.getText().toString().isEmpty()||
                    etLessonDays.getText().toString().isEmpty()||etStudentName.getText().toString().isEmpty()||
                    etTeacher.getText().toString().isEmpty()){

                    Toast.makeText(BandProspects.this, "Please enter all fields.", Toast.LENGTH_SHORT).show();
                }
                else{

                    String name = etStudentName.getText().toString().trim();
                    String age = etAge.getText().toString().trim();
                    String instrument = etInstrument.getText().toString().trim();
                    String teacher = etTeacher.getText().toString().trim();
                    String lessonDays = etLessonDays.getText().toString().trim();

                    BandProspectsBackendless bandProspectsBackendless = new BandProspectsBackendless();

                    bandProspectsBackendless.setAge(age);
                    bandProspectsBackendless.setName(name);
                    bandProspectsBackendless.setInstrument(instrument);
                    bandProspectsBackendless.setTeacher(teacher);
                    bandProspectsBackendless.setLessonDays(lessonDays);

                    Backendless.Persistence.save(bandProspectsBackendless, new AsyncCallback<BandProspectsBackendless>() {
                        @Override
                        public void handleResponse(BandProspectsBackendless response) {

                            Toast.makeText(BandProspects.this, "Your student has been added to the database.", Toast.LENGTH_SHORT).show();
                            etAge.setText("");
                            etInstrument.setText("");
                            etLessonDays.setText("");
                            etStudentName.setText("");
                            etTeacher.setText("");
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {

                            Toast.makeText(BandProspects.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


                }

            }
        });
    }
}
