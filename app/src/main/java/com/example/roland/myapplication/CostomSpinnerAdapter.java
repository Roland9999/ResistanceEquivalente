package com.example.roland.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import java.util.List;

public class CostomSpinnerAdapter extends ArrayAdapter<String> implements SpinnerAdapter {
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costom_spinner_adapter);
    }
*/
    Context context;

    private final List<String> myColors; // Notre liste de couleurs

    public CostomSpinnerAdapter(Context context, List<String> objects) {
        super(context, R.layout.activity_costom_spinner_adapter, objects);
        this.context = context;
        this.myColors = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        //super.getDropDownView(position, convertView, parent);

        View rowView = convertView;

        if (rowView == null) {
            // Get a new instance of the row layout view
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            rowView = inflater.inflate(R.layout.activity_costom_spinner_adapter, null);

            rowView.setBackgroundColor(Color.parseColor(myColors.get(position)));

        } else {
            rowView.setBackgroundColor(Color.parseColor(myColors.get(position)));
        }
        return rowView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            // Get a new instance of the row layout view
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            rowView = inflater.inflate(R.layout.activity_costom_spinner_adapter, null);

            rowView.setBackgroundColor(Color.parseColor(myColors.get(position)));

        } else {
            rowView.setBackgroundColor(Color.parseColor(myColors.get(position)));
        }
        return rowView;
    }

}
