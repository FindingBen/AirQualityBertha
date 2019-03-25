package com.example.airqualityapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class DataAdapterItem extends ArrayAdapter<Data> {
    private final int resource;

    public DataAdapterItem(Context context, int resource, List<Data> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    public DataAdapterItem(Context context, int resource, Data[] objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Data data = getItem(position);
        String user = data.getUserId();
        double deviceID=data.getDeviceId();
        LinearLayout bookView;
        if (convertView == null) {
            bookView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, bookView, true);
        } else {
            bookView = (LinearLayout) convertView;
        }
        TextView titleView = bookView.findViewById(R.id.user_name);
        titleView.setText("Name: "+user);




        return bookView;
    }
}
