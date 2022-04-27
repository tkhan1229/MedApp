package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Telephony;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonalDetail extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

private TextView name;
private TextView NHS;
private TextView DOB;
private TextView Address;
private TextView Contact;
private TextView Email;
private TextView Age;

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
        setContentView(R.layout.activity_personal_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        name = (TextView) findViewById(R.id.txtAname);
        NHS = (TextView) findViewById(R.id.txtAnumber);
        DOB = (TextView) findViewById(R.id.txtAdob);
        Address = (TextView) findViewById(R.id.txtAaddress);
        Contact = (TextView) findViewById(R.id.txtACnumber);
        Email = (TextView) findViewById(R.id.txtAemail);
        Age = (TextView) findViewById(R.id.txtAage);
setUserInfo();

    }

    private void setUserInfo() {
        try {
            Intent intent = getIntent();
            lol=intent.getStringExtra("Username");
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

            name.setText(namest);
                NHS.setText(lol);
                DOB.setText(DOBst);
                Address.setText(addressst);


                Contact.setText(numberst);

                Age.setText(emailst);

                Email.setText(agest);




        } catch (Exception ex) {
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
        getMenuInflater().inflate(R.menu.personal_detail, menu);
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
            Intent intent = new Intent(PersonalDetail.this, PersonalDetail.class);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("All", All);

            startActivity(intent);
        } else if (id == R.id.navAppointment) {
            Intent intent = new Intent(PersonalDetail.this, Appointment.class);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("All", All);

            startActivity(intent);
        } else if (id == R.id.navReport) {
            Intent intent = new Intent(PersonalDetail.this, MedicalReport.class);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("All", All);

            startActivity(intent);
        } else if (id == R.id.navMedication) {

            Intent intent = new Intent(PersonalDetail.this, MedicalInformation.class);
intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("Username",lol);
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
            Intent intent = new Intent(PersonalDetail.this, Settings.class);
            intent.putExtra("paracetamol", paracetamol);
            intent.putExtra("aspirin", aspirin);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            intent.putExtra("All", All);

            startActivity(intent);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
