package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NewReport extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DatePickerDialog.OnDateSetListener{
    String lol;
    String NHSid;
    String passwordst;
    String emailst;
    String addressst;
    String numberst;
    String agest;
    String namest;
    String DOBst;
    private EditText patientidtextview;
    private Date datevar;
    private Spinner spinnermed;
    private Spinner spinnerpre;
    private EditText conditionview;
    ArrayList<Prescription> pres = new ArrayList<>();
    ArrayList<Medication> meds = new ArrayList<>();
    private static final String PRE_FILE = "/data/data/com.example.myapplication/files/prescriptions.txt";
    private static final String MED_FILE = "/data/data/com.example.myapplication/files/medications.txt";
    private static final String REP_FILE = "/data/data/com.example.myapplication/files/reports.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView dateview = findViewById(R.id.date);
        patientidtextview = findViewById(R.id.patientidtext);
        conditionview = findViewById(R.id.conditiontext);
        readPres();
        readMeds();
        //TEST __________________________________________________
        //meds.add(new Medication(103, "Paracetmaol", 0, "Mild Pain Relief"));
        //meds.add(new Medication(231, "Aspirin", 0, "Treats pain, fever and inflammation"));

        //pres.add(new Prescription(436, "twice a day", "3 weeks", false, new Date(2019,6,21)));
        //pres.add(new Prescription(520, "once a day", "5 weeks", true, new Date(2020, 2, 12)));

        ArrayList<String> medsname = new ArrayList<>();
        medsname.add(meds.get(0).getName());
        medsname.add(meds.get(1).getName());
        ArrayList<Integer> presname = new ArrayList<>();
        for (int i = 0; i < pres.size(); i++) {
            presname.add(pres.get(i).getId());
        }
        //TEST ____________________________________________________

        spinnermed = (Spinner)findViewById(R.id.medspinner);
        ArrayAdapter spinnermedadapt = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, medsname);
        spinnermed.setAdapter(spinnermedadapt);
        spinnerpre = (Spinner)findViewById(R.id.prespinner);
        ArrayAdapter spinnerpreadapt = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, presname);
        spinnerpre.setAdapter(spinnerpreadapt);
        Button dateselect = findViewById(R.id.date_button);
        dateselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), NewReport.this, 2019, 3, 13);
                datePickerDialog.show();
            }
        });
        Button submitbutton = findViewById(R.id.submit);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                boolean check = false;
                Medication med = null;
                Prescription pre = null;
                while(i < pres.size() && !(check)) {
                    if (Integer.toString(pres.get(i).getId()).equals(spinnerpre.getSelectedItem().toString())) {
                        pre = pres.get(i);
                        check = true;
                    }
                    i++;
                }
                int k = 0;
                boolean check1 = false;
                while( i < meds.size() && !(check1)) {
                    if (meds.get(k).getName().equals(spinnermed.getSelectedItem())) {
                        med = meds.get(k);
                        check1 = true;
                    }
                    k++;
                }
                Report thereport = new Report(patientidtextview.getText().toString(), datevar, conditionview.getText().toString(), med, pre);
                try {
                    FileOutputStream f = new FileOutputStream(REP_FILE);
                    ObjectOutputStream o = new ObjectOutputStream(f);
                    o.writeObject(thereport);
                    o.close();
                    f.close();
                    Intent intent = new Intent(NewReport.this, DoctorDetails.class);
                    patientidtextview.setText("WORKS");
                    startActivity(intent);
                } catch(IOException e) {
                    e.printStackTrace();
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void readMeds() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(MED_FILE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String string = null;
            int count = 0;
            String[] temp = new String[4];
            while ((string = br.readLine()) != null) {
                temp[count] = string;
                count++;
                if (count == 4) {
                    int tryint;
                    int tryint2;
                    if (tryParse(temp[0])) {
                        tryint = Integer.parseInt(temp[0]);
                    }
                    else {
                        tryint = 0;
                    }
                    if (tryParse(temp[2])) {
                        tryint2 = Integer.parseInt(temp[2]);
                    }
                    else {
                        tryint2 = 0;
                    }
                    meds.add(new Medication(tryint, temp[1], tryint2, temp[3]));
                    count = 0;
                    string = br.readLine();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void readPres() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(PRE_FILE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String string = null;
            int count = 0;
            String[] temp = new String[7];
            while ((string = br.readLine()) != null) {
                temp[count] = string;
                count++;
                if (count == 7) {
                    int tryint;
                    if (tryParse(temp[0])) {
                        tryint = Integer.parseInt(temp[0]);
                    }
                    else {
                        tryint = 0;
                    }
                    Date trydate;
                    if (tryParse(temp[4]) && tryParse(temp[5]) && tryParse(temp[6])) {
                        trydate = new Date(Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6]));
                    }
                    else {
                        trydate = new Date();
                    }
                    pres.add(new Prescription(tryint, temp[1], temp[2], Boolean.parseBoolean(temp[3]), trydate));
                    count = 0;
                    string = br.readLine();
                }

            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public boolean tryParse(String str) {
        try {
            int tryint = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
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
        getMenuInflater().inflate(R.menu.new_report, menu);
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
            Intent intent = new Intent(NewReport.this, DoctorDetails.class);
            intent.putExtra("Username",lol);
            intent.putExtra("Name", namest);
            intent.putExtra("DOB", DOBst);
            intent.putExtra("Address",addressst);
            intent.putExtra("Number", numberst);
            intent.putExtra("Email", emailst);
            intent.putExtra("Age", agest);
            intent.putExtra("Password", passwordst);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onDateSet(DatePicker d, int year, int month, int day)
    {
        datevar = new Date(year, month, day);
    }
}
