package com.example.myapplication;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.io.IOException;
import java.util.ArrayList;

public class MedicalReport extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView report1;
    private TextView report2;
    private TextView report3;
    private TextView report4;
    private TextView report5;
    private TextView report6;
String lol;
    String NHSid;
    String passwordst;
    String emailst;
    String addressst;
    String numberst;
    String agest;
    String namest;
    String DOBst;
    String paracetamol;
    String aspirin;
    ArrayList<String> All = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        report1 = (TextView) findViewById(R.id.txt1);
        report2 = (TextView) findViewById(R.id.txt2);
        report3 = (TextView) findViewById(R.id.txt3);
        report4 = (TextView) findViewById(R.id.txt4);
        report5 = (TextView) findViewById(R.id.txt5);
        report6 = (TextView) findViewById(R.id.txt6);

        validate();

    }


    private void validate() {
        try {
            Intent intent = getIntent();
            lol = intent.getStringExtra("Username");
            NHSid = intent.getStringExtra("Username");
            passwordst = intent.getStringExtra("Password");
            emailst = intent.getStringExtra("Email");
            addressst = intent.getStringExtra("Address");
            numberst= intent.getStringExtra("Number");
            namest = intent.getStringExtra("Name");
            DOBst = intent.getStringExtra("DOB");
            agest = intent.getStringExtra("Age");
            paracetamol= intent.getStringExtra("paracetamol");
            aspirin= intent.getStringExtra("aspirin");
            All= intent.getStringArrayListExtra("All");

            if (lol.equals("Admin")) {
                report1.setText("www.google.com");
            }
        }catch (Exception ex) {
            Log.e("Error", ex.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.medical_report, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navDetails) {
            Intent intent = new Intent(MedicalReport.this, PersonalDetail.class);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("All", All);

            startActivity(intent);
        } else if (id == R.id.navAppointment) {
            Intent intent = new Intent(MedicalReport.this, Appointment.class);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("All", All);

            startActivity(intent);
        } else if (id == R.id.navReport) {
            Intent intent = new Intent(MedicalReport.this, MedicalReport.class);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("All", All);

            startActivity(intent);
        } else if (id == R.id.navMedication) {
            Intent intent = new Intent(MedicalReport.this, MedicalInformation.class);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("All", All);

            startActivity(intent);
        } else if (id == R.id.navSettings) {
            Intent intent = new Intent(MedicalReport.this, Settings.class);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("All", All);

            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
