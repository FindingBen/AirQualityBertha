package com.example.airqualityapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class usersPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appBar1);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.users_page);
        TextView listHeader = new TextView(this);
        listHeader.setText("Sensor Data");
        ListView listView = findViewById(R.id.dataListView);
        listView.addHeaderView(listHeader);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void showData(View view){
        ReadTask task = new ReadTask();
        task.execute("https://berthabackendrestprovider.azurewebsites.net/api/data/Ben");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_create_order:
                //When I create weather page I will put it on intent :)
                Intent intent = new Intent(this, weather.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private class ReadTask extends ReadHttp {
        @Override
        protected void onPostExecute(CharSequence jsonString) {
            Log.d("log",jsonString.toString());
            Gson gson = new GsonBuilder().create();
            final Data[] data = gson.fromJson(jsonString.toString(), Data[].class);
            Log.d("log", Arrays.toString(data));

            ListView listView = findViewById(R.id.dataListView);
            //ArrayAdapter<Book> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, books);
            DataAdapterItem adapter = new DataAdapterItem(getBaseContext(), R.layout.dataitem, data);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Intent intent = new Intent(getBaseContext(), DataActivity.class);
                    // Book book = books.get((int) id);
                    // Book book = books[(int) id];
                    Data data = (Data) parent.getItemAtPosition(position);
                    intent.putExtra(DataActivity.DATA, data);
                    startActivity(intent);
                }
            });

        }

        @Override
        protected void onCancelled(CharSequence message) {
            TextView messageTextView = findViewById(R.id.mainTextView);
            messageTextView.setText(message);
            Log.e("BOOKS", message.toString());
        }
    }


}



