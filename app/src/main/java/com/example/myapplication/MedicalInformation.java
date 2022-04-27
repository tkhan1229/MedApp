package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MedicalInformation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String NHSid;
    String passwordst;
    String emailst;
    String addressst;
    String numberst;
    String agest;
    String namest;
    String DOBst;
    ArrayList<String> All = new ArrayList<String>();

    String lol;
    String paracetamol;
    String aspirin;



    ListView lv;
    SearchView sv;
    String[] medicine = {"Paracetamol","Aspirin"};
    ArrayAdapter<String> adapter;


    TextView mEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        lv=(ListView) findViewById(R.id.listView1);
        sv=(SearchView)findViewById(R.id.searchView1);
        mEditText =findViewById(R.id.textView);


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, medicine);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    mEditText.setText(paracetamol);
                }
                else if(position==1) {
                    mEditText.setText(aspirin);
                }
                else {

                }

            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return false;
            }

        });
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
            All= intent.getStringArrayListExtra("All");

            paracetamol= intent.getStringExtra("paracetamol");
            aspirin= intent.getStringExtra("aspirin");

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
        getMenuInflater().inflate(R.menu.medical_information, menu);
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
            Intent intent = new Intent(MedicalInformation.this, PersonalDetail.class);
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
            Intent intent = new Intent(MedicalInformation.this, Appointment.class);
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
            Intent intent = new Intent(MedicalInformation.this, MedicalReport.class);
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
            Intent intent = new Intent(MedicalInformation.this, MedicalInformation.class);
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
            Intent intent = new Intent(MedicalInformation.this, Settings.class);
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
