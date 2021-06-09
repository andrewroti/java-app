package com.example.carmelmusicacademyapp;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.List;


public class TestApplication extends Application
{

    public static final String APPLICATION_ID = "49D14290-A591-4880-FF23-EA5563B25F00";
    public static final String API_KEY = "5441A838-C2F3-42E3-9303-3D3AD6E34DC3";
    public static final String SERVER_URL = "https://api.backendless.com";

    public static BackendlessUser user;
    public static List<LadderList> students;
    public static List<Contacts> contacts;
    public static List<BandProspectsBackendless> bandProspectsBackendlessList;
    public static List<SubRequests> subRequests;

    @Override
    public void onCreate() {
        super.onCreate();

        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );



    }
}
