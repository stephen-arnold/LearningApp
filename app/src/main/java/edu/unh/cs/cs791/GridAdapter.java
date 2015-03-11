package edu.unh.cs.cs791;

/**
 * Created by Tay on 3/11/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class GridAdapter extends BaseAdapter {
    private Context context;

    ArrayList<String> entities = new ArrayList<String>();
    String[] x;


    public GridAdapter(Context context, ArrayList<String> entities) {
        this.context = context;
        this.entities = entities;

    }

    public GridAdapter(Context context, String[] x) {
        this.context = context;
        this.x = x;

    }



    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);
            gridView = inflater.inflate(R.layout.grid, null);

            // set value into textview
             //   TextView textView = (TextView) gridView.findViewById(R.id.gridText);
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(entities.get(position));


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
            return entities.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}