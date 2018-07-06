package com.example.android.gymapp2;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Instructor extends AppCompatActivity {

private RecyclerView instructor_recyclerview;
private GridLayoutManager gridLayoutManager;
//private CustomAdapter adapter;
private List<InstructorData> data_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        instructor_recyclerview = findViewById(R.id.instructor_recyclerview);
        data_list = new ArrayList<>();
        //load_data_from_server(0);
}

    /*private void load_data_from_server(int id) {
        AsyncTask<Integer, Void, Void> task = new AsyncTask<Integer, Void, Void>() {


            @Override
            protected Void doInBackground(Integer... integers) {
                return null;
            }
        }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }
    @Override
    public	boolean	onOptionsItemSelected(MenuItem item){
        switch	(item.getItemId())
        {case	R.id.home:
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
            return	true;
            case	R.id.profile:
                Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
                return	true;
            case	R.id.logout:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                return	true;
            case	R.id.help:
                Toast.makeText(this, "help", Toast.LENGTH_SHORT).show();
                return	true;
            default:
                //	Do	nothing
        }
        return	super.onOptionsItemSelected(item);		}
}