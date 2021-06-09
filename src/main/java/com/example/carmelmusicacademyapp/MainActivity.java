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


public class MainActivity extends AppCompatActivity {



    Button btnRegister, btnLogin;
    EditText etEmail, etPassword, etConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

       btnRegister = findViewById(R.id.btnRegister);
       btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(etEmail.getText().toString().trim().equals("andrewroti@gmail.com") &&
                       etPassword.getText().toString().trim().equals(etConfirmPassword.getText().toString().trim()) ||
                        (etEmail.getText().toString().trim().equals("ohhistella@gmail.com") &&
                                etPassword.getText().toString().trim().equals(etConfirmPassword.getText().toString().trim())||
                                (etEmail.getText().toString().trim().equals("mb08ash@gmail.com") &&
                                        etPassword.getText().toString().trim().equals(etConfirmPassword.getText().toString().trim()))))
               {
                    String email = etEmail.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();

                    BackendlessUser user = new BackendlessUser();

                    user.setEmail(email);
                    user.setPassword(password);



                    Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {

                            Toast.makeText(MainActivity.this, "Registration was successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, ActivateAccount.class));
                            MainActivity.this.finish();

                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {

                            Toast.makeText(MainActivity.this, "Error:" + fault.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });




               }else{

                   Toast.makeText(MainActivity.this, "Invalid user credentials!", Toast.LENGTH_SHORT).show();
               }
            }

       });

       btnLogin = findViewById(R.id.btnLogin);
       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(MainActivity.this, ActivateAccount.class));
           }
       });

    }


}
