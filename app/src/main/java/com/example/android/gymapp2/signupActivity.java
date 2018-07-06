package com.example.android.gymapp2;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.paperdb.Paper;

public class signupActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String REGISTER_URL = "https://lucasgymapp.000webhostapp.com/backend/registered.php";

    public static final String KEY_FISRTNAME = "firstname";
    public static final String KEY_LASTNAME = "lastname";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_AGE = "age";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    private EditText etfirstname;
    private EditText etlastname;
    private EditText etgender;
    private EditText etage;
    private EditText etemail;
    private EditText etpassword;

    private Button ButtonSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        etfirstname = (EditText) findViewById(R.id.EditTextFirstname);
        etlastname = (EditText) findViewById(R.id.EditTextLastname);
        etgender = (EditText) findViewById(R.id.EditTextGender);
        etage = (EditText) findViewById(R.id.EditTextAge);
        etemail = (EditText) findViewById(R.id.EditTextEmail);
        etpassword = (EditText) findViewById(R.id.EditTextPassword);

        ButtonSignup = (Button) findViewById(R.id.ButtonSignup);
        ButtonSignup.setOnClickListener(this);
    }
    private void registerUser(){
        final String firstname = etfirstname.getText().toString().trim();
        final String lastname = etlastname.getText().toString().trim();
        final String gender = etgender.getText().toString().trim();
        final String age = etage.getText().toString().trim();
        final String email = etemail.getText().toString().trim();
        final String password= etpassword.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(signupActivity.this,response,Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(signupActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params  = new HashMap< String, String>();
                params.put(KEY_FISRTNAME,firstname);
                params.put(KEY_LASTNAME,lastname);
                params.put(KEY_GENDER,gender);
                params.put(KEY_AGE,age);
                params.put(KEY_EMAIL,email);
                params.put(KEY_PASSWORD,password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    public  void onClick(View v)
    {
        if(v == ButtonSignup){
            registerUser();
        }

    }
//
}
