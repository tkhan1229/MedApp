package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.widget.EditText;
import java.util.ArrayList;

public class Inventory extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView name;
    private Button Personal;
    private Button Appointment;
    private Button Medicine;
    private Button Report;
    private Button Settings;

    private static Inventory obj=null;
    public Inventory getInstance(){
        if(obj==null){
            obj= new Inventory();
        }
        return obj;
    }


    private static final String FILE_NAME = "Inventory.txt";


    ArrayList<String> test = new ArrayList<String>();
    ArrayList<String> user = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
Button Home;
    String NHSid;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        name = (TextView) findViewById(R.id.lblUser3);
        Personal= (Button) findViewById(R.id.btnPersonal);
        Appointment= (Button) findViewById(R.id.btnAppointment);
        Medicine= (Button) findViewById(R.id.btnInfo);
        Report= (Button) findViewById(R.id.btnReport);
        Settings= (Button) findViewById(R.id.btnSettings);
        Home=(Button) findViewById(R.id.btnHome);



        Personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsers();
                getUserInfo();
                getMedInfo();

                Intent intent = new Intent(Inventory.this, PersonalDetail.class);
                if (NHSid.equals(test.get(0))) {
                    intent.putExtra("paracetamol", sb.toString());
                    intent.putExtra("aspirin", sb2.toString());
                    intent.putExtra("Username", NHSid);
                    intent.putExtra("Password",test.get(1));
                    intent.putExtra("Name", test.get(2));
                    intent.putExtra("DOB", test.get(3));
                    intent.putExtra("Address", test.get(4));
                    intent.putExtra("Number", test.get(5));
                    intent.putExtra("Email", test.get(6));
                    intent.putExtra("Age", test.get(7));
                    intent.putExtra("All", user);

                    startActivity(intent);
                } 

            }
        });

        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsers();
                getUserInfo();
                getMedInfo();

                if (NHSid.equals(test.get(0))) {
                    Intent intent = new Intent(Inventory.this, Settings.class);
                    intent.putExtra("paracetamol", sb.toString());
                    intent.putExtra("aspirin", sb2.toString());
                    intent.putExtra("Username", NHSid);
                    intent.putExtra("Password",test.get(1));
                    intent.putExtra("Name", test.get(2));
                    intent.putExtra("DOB", test.get(3));
                    intent.putExtra("Address", test.get(4));
                    intent.putExtra("Number", test.get(5));
                    intent.putExtra("Email", test.get(6));
                    intent.putExtra("Age", test.get(7));
                    intent.putExtra("All", user);

                    startActivity(intent);
                } 
            }
        });

        Appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsers();
                getUserInfo();
                getMedInfo();

                if (NHSid.equals(test.get(0))) {
                    Intent intent = new Intent(Inventory.this, Appointment.class);
                    intent.putExtra("paracetamol", sb.toString());
                    intent.putExtra("aspirin", sb2.toString());
                    intent.putExtra("Username", NHSid);
                    intent.putExtra("Password",test.get(1));
                    intent.putExtra("Name", test.get(2));
                    intent.putExtra("DOB", test.get(3));
                    intent.putExtra("Address", test.get(4));
                    intent.putExtra("Number", test.get(5));
                    intent.putExtra("Email", test.get(6));
                    intent.putExtra("Age", test.get(7));
                    intent.putExtra("All", user);

                    startActivity(intent);
                } 
            }
        });

        Medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsers();
                getUserInfo();

                getMedInfo();

                if (NHSid.equals(test.get(0))) {
                    Intent intent = new Intent(Inventory.this, MedicalInformation.class);
                    intent.putExtra("paracetamol", sb.toString());
                    intent.putExtra("aspirin", sb2.toString());
                    intent.putExtra("Username", NHSid);
                    intent.putExtra("Password",test.get(1));
                    intent.putExtra("Name", test.get(2));
                    intent.putExtra("DOB", test.get(3));
                    intent.putExtra("Address", test.get(4));
                    intent.putExtra("Number", test.get(5));
                    intent.putExtra("Email", test.get(6));
                    intent.putExtra("Age", test.get(7));
                    intent.putExtra("All", user);

                    startActivity(intent);
                } 
            }
        });

        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsers();
                getUserInfo();

                getMedInfo();
                if (NHSid.equals(test.get(0))) {
                    Intent intent = new Intent(Inventory.this, MedicalReport.class);
                    intent.putExtra("paracetamol", sb.toString());
                    intent.putExtra("aspirin", sb2.toString());
                    intent.putExtra("Username", NHSid);
                    intent.putExtra("Password",test.get(1));
                    intent.putExtra("Name", test.get(2));
                    intent.putExtra("DOB", test.get(3));
                    intent.putExtra("Address", test.get(4));
                    intent.putExtra("Number", test.get(5));
                    intent.putExtra("Email", test.get(6));
                    intent.putExtra("Age", test.get(7));
                    intent.putExtra("All", user);

                    startActivity(intent);
                } 
            }
        });






        validate();
    }
    public void getUserInfo() {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            int count=1;

            while ((text = br.readLine()) != null) {

                if(user.get(0).equals(NHSid)) {
                    if (count <= 8) {

                        sb.append(text).append("\n");
                        test.add(text);


                    }
                }
                else if(user.get(2).equals(NHSid)) {
                    if ((count >= 11)&&(count<=18)) {

                        sb.append(text).append("\n");
                        test.add(text);


                    }
                }
                else if(user.get(4).equals(NHSid)) {
                    if ((count >= 21)&&(count<=28)) {

                        sb.append(text).append("\n");
                        test.add(text);


                    }
                }
                count++;

            }

           // mEditText.setText(test.get(7));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getUsers() {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            int count =1;
            while ((text = br.readLine()) != null) {
                if ((count == 1) || (count==2)|| (count == 11) || (count==12)|| (count == 21) || (count==22)) {
                    sb.append(text).append("\n");

                    user.add(text);
                }


                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void getMedInfo() {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);


            String text;
            int count=1;

            while ((text = br.readLine()) != null) {

                if((count>=30) &&(count<=38)) {
                    sb.append(text).append("\n");

                }
                else if((count>=40) &&(count<=45)) {
                    sb2.append(text).append("\n");

                }
                count++;

            }

            // mEditText.setText(test.get(7));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void validate() {

        try {
            Intent intent = getIntent();
            NHSid = intent.getStringExtra("Username");

            if (NHSid.equals(test.get(0))) {

                name.setText(test.get(2));



            }


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
        getMenuInflater().inflate(R.menu.personal_details, menu);
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

            getUsers();
            getUserInfo();
            getMedInfo();
            Intent intent = new Intent(Inventory.this, PersonalDetail.class);
            if (NHSid.equals(test.get(0))) {
                intent.putExtra("paracetamol", sb.toString());
                intent.putExtra("aspirin", sb2.toString());
                intent.putExtra("Username", NHSid);
                intent.putExtra("Password",test.get(1));
                intent.putExtra("Name", test.get(2));
                intent.putExtra("DOB", test.get(3));
                intent.putExtra("Address", test.get(4));
                intent.putExtra("Number", test.get(5));
                intent.putExtra("Email", test.get(6));
                intent.putExtra("Age", test.get(7));
                intent.putExtra("All", user);

                startActivity(intent);
            } 

        } else if (id == R.id.navAppointment) {
            getUsers();
            getUserInfo();
            getMedInfo();
            Intent intent = new Intent(Inventory.this, Appointment.class);
            intent.putExtra("Username",NHSid);
            if (NHSid.equals(test.get(0))) {
                intent.putExtra("paracetamol", sb.toString());
                intent.putExtra("aspirin", sb2.toString());
                intent.putExtra("Username", NHSid);
                intent.putExtra("Password",test.get(1));
                intent.putExtra("Name", test.get(2));
                intent.putExtra("DOB", test.get(3));
                intent.putExtra("Address", test.get(4));
                intent.putExtra("Number", test.get(5));
                intent.putExtra("Email", test.get(6));
                intent.putExtra("Age", test.get(7));
                intent.putExtra("All", user);

                startActivity(intent);
            } 
        } else if (id == R.id.navReport) {
            getUsers();
            getUserInfo();
            getMedInfo();
            Intent intent = new Intent(Inventory.this, MedicalReport.class);
            intent.putExtra("Username",NHSid);
            if (NHSid.equals(test.get(0))) {
                intent.putExtra("paracetamol", sb.toString());
                intent.putExtra("aspirin", sb2.toString());
                intent.putExtra("Username", NHSid);
                intent.putExtra("Password",test.get(1));
                intent.putExtra("Name", test.get(2));
                intent.putExtra("DOB", test.get(3));
                intent.putExtra("Address", test.get(4));
                intent.putExtra("Number", test.get(5));
                intent.putExtra("Email", test.get(6));
                intent.putExtra("Age", test.get(7));
                intent.putExtra("All", user);

                startActivity(intent);
            } 
        } else if (id == R.id.navMedication) {
            getUsers();
            getUserInfo();

            getMedInfo();
            Intent intent = new Intent(Inventory.this, MedicalInformation.class);
            intent.putExtra("Username",NHSid);
            if (NHSid.equals(test.get(0))) {
                intent.putExtra("paracetamol", sb.toString());
                intent.putExtra("aspirin", sb2.toString());
                intent.putExtra("Username", NHSid);
                intent.putExtra("Password",test.get(1));
                intent.putExtra("Name", test.get(2));
                intent.putExtra("DOB", test.get(3));
                intent.putExtra("Address", test.get(4));
                intent.putExtra("Number", test.get(5));
                intent.putExtra("Email", test.get(6));
                intent.putExtra("Age", test.get(7));
                intent.putExtra("All", user);

                startActivity(intent);
            } 
        } else if (id == R.id.navSettings) {
            getUsers();
            getUserInfo();
            getMedInfo();
            if(NHSid.equals(test.get(0))) {
                Intent intent = new Intent(Inventory.this, Settings.class);
                intent.putExtra("Username", NHSid);
                intent.putExtra("Name", test.get(2));
                intent.putExtra("DOB", test.get(3));
                intent.putExtra("Address", test.get(4));
                intent.putExtra("Number", test.get(5));
                intent.putExtra("Email", test.get(6));
                intent.putExtra("Age", test.get(7));
                intent.putExtra("Password",test.get(1));
                intent.putExtra("paracetamol", sb.toString());
                intent.putExtra("aspirin", sb2.toString());
                intent.putExtra("All", user);


                startActivity(intent);
            }
            
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
