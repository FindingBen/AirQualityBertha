package com.example.airqualityapi;

import android.content.Intent;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;


public class weather<getWristData> extends AppCompatActivity {
    private static String loggedUser;
    public boolean AutoSend = false;
    Button click;
    private TextView fetchDataView;
    private static final String BASE_URI = "https://berthawristbandrestprovider.azurewebsites.net/api/wristbanddata";
    public Data measurment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Intent navigate = getIntent();
        loggedUser = navigate.getStringExtra(MainActivity.USERNAME);
        measurment = new Data();


    }


    /*public void fetchData(View view) {

        ReadDataTask task = new ReadDataTask();
        task.execute("https://berthawristbandrestprovider.azurewebsites.net/api/wristbanddata/");
    }*/

    public void addData(View view) {


        ReadDataTask task = new ReadDataTask();

        task.execute("https://berthabackendrestprovider.azurewebsites.net/api/data");


    }

    private class ReadDataTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {

            try {
              String jsonString=  HttpHelper.GetHttpResponse(BASE_URI).toString();
                Log.d("ReadWrist", jsonString);

                JSONObject jsonObject = null;

                jsonObject = new JSONObject(jsonString);
                jsonObject.put("utc", new Date().getTime());
                jsonObject.put("latitude", 11.7);
                jsonObject.put("longitude",12.2);
                jsonObject.put("userId", "Ben");
                jsonObject.put("noise",0.0);
                String JsonDocument = jsonObject.toString();
                Log.d("JSON",JsonDocument);
                DoPost("https://berthabackendrestprovider.azurewebsites.net/api/data", JsonDocument);

            } catch (JSONException | IOException e) {
                Log.d("SOMETHING", e.getMessage());
            }

            return "something";
        }

    }

    private class PostDataTask extends AsyncTask<String, Void, CharSequence> {


        @Override
        protected CharSequence doInBackground(String... params) {
            String urlString = params[0];
            String jsonDocument = params[1];
            try {
                return DoPost(urlString, jsonDocument);
            } catch (MalformedURLException ex) {
                cancel(true);
                String message = ex.getMessage() + " " + urlString;
                Log.e("BOOK", message);
                return message;
            } catch (IOException ex) {
                cancel(true);
                Log.e("BOOK", ex.getMessage());
                return ex.getMessage();
            }
        }

        @Override
        protected void onPostExecute(CharSequence charSequence) {
            super.onPostExecute(charSequence);
            TextView messageView = findViewById(R.id.text_1);
            messageView.setText(charSequence);
            AutoSend = true;
            Log.d("MINE", charSequence.toString());
            finish();
        }

        @Override
        protected void onCancelled(CharSequence charSequence) {
            super.onCancelled(charSequence);
            TextView messageView = findViewById(R.id.text_1);
            messageView.setText(charSequence);
            Log.d("MINE", charSequence.toString());
            finish();
        }
    }

    private CharSequence DoPost(String urlString, String jsonDocument) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.write(jsonDocument);
        osw.flush();
        osw.close();
        int responseCode = connection.getResponseCode();
        if (responseCode / 100 != 2) {
            String responseMessage = connection.getResponseMessage();
            throw new IOException("HTTP response code: " + responseCode + " " + responseMessage);
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String line = reader.readLine();
        return line;
    }


    protected void back2(View view) {
        finish();

    }
}
