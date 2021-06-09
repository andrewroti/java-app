package com.example.carmelmusicacademyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserIdStorageFactory;

public class ActivateAccount extends AppCompatActivity {


    EditText etEmail, etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate_account);


        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){

                    Toast.makeText(ActivateAccount.this, "Please fill out all required fields.", Toast.LENGTH_SHORT).show();
                }else{

                    String email = etEmail.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();

                   Backendless.UserService.login(email, password, new AsyncCallback<BackendlessUser>() {
                       @Override
                       public void handleResponse(BackendlessUser response) {

                           TestApplication.user = response;
                           Toast.makeText(ActivateAccount.this, "Login was Successful!", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(ActivateAccount.this, NavigationMenu.class));
                           ActivateAccount.this.finish();

                       }

                       @Override
                       public void handleFault(BackendlessFault fault) {

                           Toast.makeText(ActivateAccount.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();

                       }
                   }, true);

                }

            }
        });

        Backendless.UserService.isValidLogin(new AsyncCallback<Boolean>() {
            @Override
            public void handleResponse(Boolean response)
            {
                if(response) {

                    String userObjectId = UserIdStorageFactory.instance().getStorage().get();
                    Backendless.Data.of(BackendlessUser.class).findById(userObjectId, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {

                            TestApplication.user = response;
                            Toast.makeText(ActivateAccount.this, "Already logged in as '" + TestApplication.user.getEmail() + "'.  Loading your home page.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ActivateAccount.this, NavigationMenu.class));
                            ActivateAccount.this.finish();

                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {

                            Toast.makeText(ActivateAccount.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


                }
            }
            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(ActivateAccount.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
