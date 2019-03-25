package com.example.airqualityapi;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

public class ReadHttp extends AsyncTask<String, Void, CharSequence> {
    @Override
    protected CharSequence doInBackground(String... urls) {
        String urlString = urls[0];
        try {
            CharSequence result = HttpHelper.GetHttpResponse(urlString);
            return result;
        } catch (IOException ex) {
            cancel(true);
            String errorMessage = ex.getMessage() + "\n" + urlString;
            Log.e("BOOK", errorMessage);
            return errorMessage;
        }
    }
}
