package com.example.android.gymapp2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener{
    private static final String LOGIN_URL = "https://lucasgymapp.000webhostapp.com/backend/login.php";


    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";




    private EditText EditedTextEmail;
    private EditText EditedTextPassword;


    private Button ButtonLogin;
    private TextView TextviewSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditedTextEmail = (EditText) findViewById(R.id.EditedTextEmail);
        EditedTextPassword = (EditText) findViewById(R.id.EditedTextPassword);


        TextviewSignup= findViewById(R.id.TextViewSignup);

        ButtonLogin = (Button) findViewById(R.id.ButtonLogin);
        ButtonLogin.setOnClickListener(this);
    }
    private void logUser(){
        final String email = EditedTextEmail.getText().toString().trim();
        final String password= EditedTextPassword.getText().toString().trim();




        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.toString().trim().equals("success")){
                            homeopen();

                        }else{
                            homeopen();
                            Toast.makeText(MainActivity.this,response,Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams()throws AuthFailureError{
                Map<String, String> map  = new HashMap<String, String> ();
                map.put(KEY_EMAIL,email);
                map.put(KEY_PASSWORD,password);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void homeopen(){
        Intent intent = new Intent(this,homepage.class);
        startActivity(intent);
    }

    @Override
    public  void onClick(View v)
    {
        logUser();

    }
}