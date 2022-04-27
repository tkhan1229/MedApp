package com.example.myapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import static com.example.myapplication.Notifications.CHANNEL_1_ID;

public class Appointment extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DatePickerListener {
    String lol;
    String NHSid;
    String passwordst;
    String emailst;
    String addressst;
    String numberst;
    String agest;
    String namest;
    String DOBst;
    String store;
    String days;
    String storedDay;
    ArrayList<String> All = new ArrayList<String>();

    private Button nine;
    private Button ten;
    private Button eleven;
    private Button twelve;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private static final String patient1 = "Appointment1.txt";
    private static final String patient2 = "Appointment2.txt";
    private static final String storingDay = "day.txt";

    String paracetamol;
    String aspirin;
    private NotificationManagerCompat notificationManager;
    private Button btn9, btn10, btn11, btn12, btn1, btn2, btn3, btn4, btn5;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        notificationManager = NotificationManagerCompat.from(this);

        final HorizontalPicker picker = (HorizontalPicker) findViewById(R.id.datePicker);
        picker.setListener(this)
                .setDays(120)
                .setOffset(7)
                .setDateSelectedColor(Color.DKGRAY)
                .setDateSelectedTextColor(Color.WHITE)
                .setMonthAndYearTextColor(Color.DKGRAY)
                .setTodayButtonTextColor(getResources().getColor(R.color.colorPrimary))
                .setTodayDateTextColor(getResources().getColor(R.color.colorPrimary))
                .setTodayDateBackgroundColor(Color.GRAY)
                .setUnselectedDayTextColor(Color.DKGRAY)
                .setDayOfWeekTextColor(Color.DKGRAY)
                .setUnselectedDayTextColor(getResources().getColor(R.color.primaryTextColor))
                .showTodayButton(false)
                .init();
        picker.setBackgroundColor(Color.LTGRAY);
        picker.setDate(new DateTime());


        nine = (Button) findViewById(R.id.btn9);
        ten = (Button) findViewById(R.id.btn10);
        eleven = (Button) findViewById(R.id.btn11);
        twelve = (Button) findViewById(R.id.btn12);
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);

       days=Integer.toString(picker.getDays());


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        validate();


        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;


                try {

                    if (NHSid.equals(All.get(0))) {
                        days=Integer.toString(picker.getDays());
                        store = store + " 9am";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        fos = openFileOutput(storingDay, MODE_PRIVATE);
                        fos.write(days.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        nine.setBackgroundColor(Color.GRAY);
                        nine.setClickable(false);

                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 9am";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        nine.setBackgroundColor(Color.GRAY);
                        nine.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                try {

                    if (NHSid.equals(All.get(0))) {
                        store = store + " 10am";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        ten.setBackgroundColor(Color.GRAY);
                        ten.setClickable(false);


                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 10am";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        ten.setBackgroundColor(Color.GRAY);
                        ten.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                try {

                    if (NHSid.equals(All.get(0))) {
                        store = store + "11am";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        eleven.setBackgroundColor(Color.GRAY);
                        eleven.setClickable(false);


                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 11am";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        eleven.setBackgroundColor(Color.GRAY);
                        eleven.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                try {

                    if (NHSid.equals(All.get(0))) {
                        store = store + " 12pm";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        twelve.setBackgroundColor(Color.GRAY);
                        twelve.setClickable(false);


                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 12pm";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        twelve.setBackgroundColor(Color.GRAY);
                        twelve.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                try {

                    if (NHSid.equals(All.get(0))) {
                        store = store + " 1pm";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        one.setBackgroundColor(Color.GRAY);
                        one.setClickable(false);


                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 1pm";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        one.setBackgroundColor(Color.GRAY);
                        one.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                try {

                    if (NHSid.equals(All.get(0))) {
                        store = store + " 2pm";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        two.setBackgroundColor(Color.GRAY);
                        two.setClickable(false);


                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 2pm";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        two.setBackgroundColor(Color.GRAY);
                        two.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                try {

                    if (NHSid.equals(All.get(0))) {
                        store = store + " 3pm";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        three.setBackgroundColor(Color.GRAY);
                        three.setClickable(false);


                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 3pm";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        three.setBackgroundColor(Color.GRAY);
                        three.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                try {

                    if (NHSid.equals(All.get(0))) {
                        store = store + " 4pm";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        four.setBackgroundColor(Color.GRAY);
                        four.setClickable(false);


                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 4pm";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        four.setBackgroundColor(Color.GRAY);
                        four.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                try {

                    if (NHSid.equals(All.get(0))) {
                        store = store + " 5pm";
                        fos = openFileOutput(patient1, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        five.setBackgroundColor(Color.GRAY);
                        five.setClickable(false);


                    } else if (NHSid.equals(All.get(2))) {
                        store = store + " 5pm";
                        fos = openFileOutput(patient2, MODE_PRIVATE);
                        fos.write(store.getBytes());
                        AlertDialog alertDialog = new AlertDialog.Builder(Appointment.this).create();
                        alertDialog.setTitle("Appointment");
                        alertDialog.setMessage("Appointment Created: "+ store);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        five.setBackgroundColor(Color.GRAY);
                        five.setClickable(false);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sendAppointment(v);
            }

        });


        getDay();
    }
    public void getDay() {
        FileInputStream fis = null;

        try {
            fis = openFileInput(days);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");

                storedDay = text;

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
    public void onDateSelected(DateTime dateSelected) {


            Toast.makeText(this, dateSelected.toString(), Toast.LENGTH_SHORT).show();
            store = dateSelected.toString();

            nine.setClickable(true);
            nine.setBackgroundColor(Color.LTGRAY);
            ten.setClickable(true);
            ten.setBackgroundColor(Color.LTGRAY);
            eleven.setClickable(true);
            eleven.setBackgroundColor(Color.LTGRAY);
            twelve.setClickable(true);
            twelve.setBackgroundColor(Color.LTGRAY);
            one.setClickable(true);
            one.setBackgroundColor(Color.LTGRAY);
            two.setClickable(true);
            two.setBackgroundColor(Color.LTGRAY);
            three.setClickable(true);
            three.setBackgroundColor(Color.LTGRAY);
            four.setClickable(true);
            four.setBackgroundColor(Color.LTGRAY);
            five.setClickable(true);
            five.setBackgroundColor(Color.LTGRAY);





    }



    private void validate() {
        try {
            Intent intent = getIntent();
            NHSid = intent.getStringExtra("Username");
            passwordst = intent.getStringExtra("Password");
            emailst = intent.getStringExtra("Email");
            addressst = intent.getStringExtra("Address");
            numberst = intent.getStringExtra("Number");
            namest = intent.getStringExtra("Name");
            DOBst = intent.getStringExtra("DOB");
            agest = intent.getStringExtra("Age");
            lol = intent.getStringExtra("Username");
            All = intent.getStringArrayListExtra("All");
            paracetamol = intent.getStringExtra("paracetamol");
            aspirin = intent.getStringExtra("aspirin");


        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());
        }
    }

    public void sendAppointment(View view) {
        String title = "You have a reminder for appointment";
        String time = "Your appointment is booked";
        Notification notification =  new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setContentTitle(title)
                .setContentText(time)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setSmallIcon(R.drawable.lockicon)
                .build();

        notificationManager.notify(1,notification);
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
        getMenuInflater().inflate(R.menu.appointment, menu);
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
                Intent intent = new Intent(Appointment.this, PersonalDetail.class);
                intent.putExtra("Username", lol);
                intent.putExtra("Name", namest);
                intent.putExtra("DOB", DOBst);
                intent.putExtra("Address", addressst);
                intent.putExtra("Number", numberst);
                intent.putExtra("Email", emailst);
                intent.putExtra("Age", agest);
                intent.putExtra("Password", passwordst);
                intent.putExtra("paracetamol", paracetamol);
                intent.putExtra("aspirin", aspirin);
                intent.putExtra("All", All);

                startActivity(intent);
            } else if (id == R.id.navAppointment) {
                Intent intent = new Intent(Appointment.this, Appointment.class);
                intent.putExtra("Username", lol);
                intent.putExtra("Name", namest);
                intent.putExtra("DOB", DOBst);
                intent.putExtra("Address", addressst);
                intent.putExtra("Number", numberst);
                intent.putExtra("Email", emailst);
                intent.putExtra("Age", agest);
                intent.putExtra("Password", passwordst);
                intent.putExtra("paracetamol", paracetamol);
                intent.putExtra("aspirin", aspirin);
                intent.putExtra("All", All);

                startActivity(intent);
            } else if (id == R.id.navReport) {
                Intent intent = new Intent(Appointment.this, MedicalReport.class);
                intent.putExtra("Username", lol);
                intent.putExtra("Name", namest);
                intent.putExtra("DOB", DOBst);
                intent.putExtra("Address", addressst);
                intent.putExtra("Number", numberst);
                intent.putExtra("Email", emailst);
                intent.putExtra("Age", agest);
                intent.putExtra("Password", passwordst);
                intent.putExtra("paracetamol", paracetamol);
                intent.putExtra("aspirin", aspirin);
                intent.putExtra("All", All);

                startActivity(intent);
            } else if (id == R.id.navMedication) {
                Intent intent = new Intent(Appointment.this, MedicalInformation.class);
                intent.putExtra("Username", lol);
                intent.putExtra("Name", namest);
                intent.putExtra("DOB", DOBst);
                intent.putExtra("Address", addressst);
                intent.putExtra("Number", numberst);
                intent.putExtra("Email", emailst);
                intent.putExtra("Age", agest);
                intent.putExtra("Password", passwordst);
                intent.putExtra("paracetamol", paracetamol);
                intent.putExtra("aspirin", aspirin);
                intent.putExtra("All", All);

                startActivity(intent);
            } else if (id == R.id.navSettings) {
                Intent intent = new Intent(Appointment.this, Settings.class);
                intent.putExtra("Username", lol);
                intent.putExtra("Name", namest);
                intent.putExtra("DOB", DOBst);
                intent.putExtra("Address", addressst);
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