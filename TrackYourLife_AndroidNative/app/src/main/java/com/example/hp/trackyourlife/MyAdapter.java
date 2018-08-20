package com.example.hp.trackyourlife;

/**
 * Created by hp on 16-04-2017.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MyAdapter extends ArrayAdapter<Item>{
    public static final String EXTRA_MESSAGE = "com.example.hp.TrackYourLife.MESSAGE";
    ArrayList<Item> animalList = new ArrayList<>();

    public MyAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        animalList = objects;
    }
    public int getCount() {
        return super.getCount();
    }
    public View getView(int position, View convertView, ViewGroup Parent){
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_listview, null);
        TextView textView = (TextView) v.findViewById(R.id.label);
        ImageButton imageBtn = (ImageButton) v.findViewById(R.id.icon);
        textView.setText(animalList.get(position).getAnimalName());
        imageBtn.setImageResource(animalList.get(position).getAnimalImage());
        final String msg = animalList.get(position).getAnimalName();
        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayCategory.class);
                intent.putExtra(EXTRA_MESSAGE, msg);
                v.getContext().startActivity(intent);
            }
        });
        return v;
    }

}
