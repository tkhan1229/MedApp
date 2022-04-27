package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Login extends AppCompatActivity {
 private EditText username;
 private EditText password;
 private Button login;
 private TextView incorrect;
 String NHSid;

    ArrayList<String> users = new ArrayList<String>();
    ArrayList<String> ids = new ArrayList<>();


    private static final String FILE_NAME = "Inventory.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText)findViewById(R.id.txtUsername);
        password = (EditText)findViewById(R.id.txtPassword);
        login = (Button)findViewById(R.id.btnLogin);
        incorrect = (TextView)findViewById(R.id.lblIncorrect);

        login.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                getUserInfo();
                validate(username.getText().toString(), password.getText().toString());
            }
        });
    }



    public void getUserInfo() {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            int count =1;
            int ucount = 1;
            int pcount = 2;
            int idcount = 8;
            while ((text = br.readLine()) != null) {
                //if ((count == 1) || (count==2)|| (count == 11) || (count==12)|| (count == 21) || (count==22)) {
                if (count == ucount) {
                    sb.append(text).append("\n");
                    users.add(text);
                    ucount = ucount + 10;
                }
                else if (count == pcount) {
                    sb.append(text).append("\n");
                    users.add(text);
                    pcount = pcount + 10;
                }
                /*else if (count == idcount) {
                    idcount = idcount + 10;
                    ids.add(text);
                }*/
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
    private void validate(String username, String password) {
        if (((username.equals(("d"))) && (password.equals("p")))) {
            Intent intent2 = new Intent(Login.this, DoctorDetails.class);
            intent2.putExtra("Username", username);
            startActivity(intent2);
        }

        if (((username.equals(users.get(0))) && (password.equals(users.get(1))))) {
            Intent intent = new Intent(Login.this, Inventory.class);
            intent.putExtra("Username",username);
            startActivity(intent);

        }
        else if (((username.equals(users.get(2))) && (password.equals(users.get(3))))) {
            Intent intent = new Intent(Login.this, Inventory.class);
            intent.putExtra("Username",username);
            startActivity(intent);

        }
        else if (((username.equals(users.get(4))) && (password.equals(users.get(5))))) {
            Intent intent = new Intent(Login.this, Inventory.class);
            intent.putExtra("Username",username);
            startActivity(intent);

        }
        else if (((username.equals(("d"))) && (password.equals("p")))) {
            Intent intent = new Intent(Login.this, DoctorDetails.class);
            intent.putExtra("Username", username);
            startActivity(intent);
        }
    else {
        incorrect.setText("Incorrect Username or Password");
        }

    }









    /* public void save(View v) {
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            mEditText.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
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
    }

    123
    password
    Mr Mustafa Boskurt
12/12/2000
        45 Mile Road, London, E20 9QW
07853452234
    m.boskurt@hotmail.com
18


        1234
    pass
    Mr Michael Turner
11/11/2000
        45 Bank Road, London, E5 9LW
07843351134
    m.turner@hotmail.com
18


        12345
    pa
    Dr He Zhongyue
10/10/1965
        45 Block Road, London, E10 2RW
07823452234
    he@hotmail.com
53

    Paracetamol

    Paracetamol is a commonly used medicine that can help treat pain and reduce a high temperature (fever).
    It's typically used to relieve mild or moderate pain, such as headaches, toothache or sprains, and reduce fevers caused by illnesses such as colds and flu.

    It may not be safe to take paracetamol at the same time as:
    other products containing paracetamol – including combination products where paracetamol is one of the ingredients
    carbamazepine – used to treat epilepsy and some types of pain
    colestyramine – used to reduce itchiness caused by primary biliary cirrhosis (a type of liver disease)

    Aspirin

    Aspirin is an everyday painkiller for aches and pains such as headache, toothache and period pain. It can also be used to treat colds and 'flu-like' symptoms, and to bring down a fever (38C and above). It is also known as acetylsalicylic acid.

            It's safe to take aspirin with paracetamol or codeine.
    But do not take aspirin with ibuprofen or naproxen without talking to a doctor. Aspirin, ibuprofen and naproxen belong to the same group of medicines called non-steroidal anti-inflammatory drugs (NSAIDs). If you take them together, aspirin plus ibuprofen or naproxen may increase the chance of you getting side effects like stomach ache.

*/
}
