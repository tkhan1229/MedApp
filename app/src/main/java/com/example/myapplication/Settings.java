package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.File;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Settings extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
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

    int modifyNumber = 0;
    int modifyPassword = 0;
    int modifyEmail = 0;
    int modifyAddress = 0;

    ArrayList<String> All = new ArrayList<String>();

private EditText password;
private EditText email;
private EditText address;
private EditText number;
private Button btnSave;
    private static final String FILE_NAME = "Inventory.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        password = (EditText) findViewById(R.id.txtPassword);
        email = (EditText) findViewById(R.id.txtEmail);
        address = (EditText) findViewById(R.id.txtAddress);
        number = (EditText) findViewById(R.id.txtNumber);
        btnSave=(Button) findViewById(R.id.btnSave);
        updateAccountDetail();



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                password = (EditText) findViewById(R.id.txtPassword);
                email = (EditText) findViewById(R.id.txtEmail);
                address = (EditText) findViewById(R.id.txtAddress);
                number = (EditText) findViewById(R.id.txtNumber);

                passwordst=password.getText().toString();
                emailst=email.getText().toString();
                addressst=address.getText().toString();
                numberst=number.getText().toString();

                modifyFile();
  
            }
        });



    }
    public void modifyFile()
    {


        try {
File file = new File(getFilesDir()+"/"+FILE_NAME);
            RandomAccessFile ran = new RandomAccessFile(file, "rw");
            if (NHSid.equals(All.get(0))) {
                modifyNumber = 73;
                modifyPassword = 4;
                modifyEmail = 85;
                modifyAddress = 43;
            }
            else if (NHSid.equals(All.get(2))) {
                modifyNumber = 180;
                modifyPassword = 117;
                modifyEmail = 192;
                modifyAddress = 151;
            }
    else if (NHSid.equals(All.get(4))) {
        modifyNumber = 284;
        modifyPassword = 224;
        modifyEmail = 296;
        modifyAddress = 253;
    }
    ran.seek(modifyNumber);
    ran.write(numberst.getBytes());

            ran.seek(modifyPassword);
            ran.write(passwordst.getBytes());

            ran.seek(modifyEmail);
            ran.write(emailst.getBytes());

            ran.seek(modifyAddress);
            ran.write(addressst.getBytes());
    Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
            Toast.LENGTH_LONG).show();


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }


 
    private void updateAccountDetail() {
        try {
            Intent intent = getIntent();

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

                password.setText(passwordst);
                email.setText(emailst);
                address.setText(addressst);
                number.setText(numberst);



        }catch (Exception ex) {
            Log.e("Error", ex.getMessage());
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
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
            Intent intent = new Intent(Settings.this, PersonalDetail.class);
            intent.putExtra("Username",NHSid);
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
            Intent intent = new Intent(Settings.this, Appointment.class);
            intent.putExtra("Username",NHSid);
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
            Intent intent = new Intent(Settings.this, MedicalReport.class);
            intent.putExtra("Username",NHSid);
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
            Intent intent = new Intent(Settings.this, MedicalInformation.class);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("Username",NHSid);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("All", All);

            startActivity(intent);
        } else if (id == R.id.navSettings) {
            Intent intent = new Intent(Settings.this, Settings.class);
            intent.putExtra("Username",NHSid);
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

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
