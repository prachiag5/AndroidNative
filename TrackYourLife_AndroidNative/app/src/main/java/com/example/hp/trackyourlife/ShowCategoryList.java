package com.example.hp.trackyourlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ShowCategoryList extends AppCompatActivity {
    ListView simpleList;
    int id;
    ArrayList<Item> animalList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        setContentView(R.layout.activity_show_category_list);
        simpleList = (ListView) findViewById(R.id.mobile_list);
        animalList.add(new Item("Medicine", R.drawable.list));
        animalList.add(new Item("Grocery", R.drawable.list));
        animalList.add(new Item("Office Meeting", R.drawable.list));
        animalList.add(new Item("Movie", R.drawable.list));

        MyAdapter adapter = new MyAdapter (this, R.layout.activity_listview, animalList);
        simpleList.setAdapter(adapter);

       /* ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);*/
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, addNewEntry.class);
        startActivity(intent);
    }
}
