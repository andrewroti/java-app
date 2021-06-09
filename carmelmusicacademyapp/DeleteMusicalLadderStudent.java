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

import java.util.List;

public class DeleteMusicalLadderStudent extends AppCompatActivity {

    Button btnYes, btnNo;

    private List<LadderList> ladderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_musical_ladder_student);

        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

        final int index = getIntent().getIntExtra("index", 0);


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(DeleteMusicalLadderStudent.this, "Removing student from your list.", Toast.LENGTH_SHORT).show();

                Backendless.Persistence.of(LadderList.class).remove(TestApplication.students.get(index), new AsyncCallback<Long>() {
                    @Override
                    public void handleResponse(Long response) {

                        TestApplication.students.remove(index);
                        Toast.makeText(DeleteMusicalLadderStudent.this, "Student was successfully removed from your list.", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK);
                        startActivity(new Intent(DeleteMusicalLadderStudent.this, NavigationMenu.class));
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                        Toast.makeText(DeleteMusicalLadderStudent.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });





        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DeleteMusicalLadderStudent.this, "No changes have been made at this time.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DeleteMusicalLadderStudent.this, NavigationMenu.class));
            }
        });
    }
}
