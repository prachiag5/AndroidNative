package com.example.hp.trackyourlife;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayCategory extends AppCompatActivity {
    Toolbar a1;
    ListView listView1, listView2;
    ArrayList<Item> medicine = new ArrayList<>();
    ArrayList<Item> medicine1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_category);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyAdapter.EXTRA_MESSAGE);
        a1 = (Toolbar) findViewById(R.id.my_toolbar2);
        a1.setTitle(message);
        listView1 = (ListView) findViewById(R.id.listView1);
        listView2 = (ListView) findViewById(R.id.listView2);
        medicine.add(new Item("Ziffie", R.drawable.ic_delete));
        medicine.add(new Item("Crocin", R.drawable.ic_delete));
        medicine1.add(new Item("Ziffie", R.drawable.ic_delete));
        medicine1.add(new Item("Crocin", R.drawable.ic_delete));
        MyAdapter adapter = new MyAdapter (this, R.layout.activity_listview, medicine);
        listView1.setAdapter(adapter);
        MyAdapter adapter1 = new MyAdapter (this, R.layout.activity_listview, medicine1);
        listView2.setAdapter(adapter);
        setDynamicHeight(listView1);
        setDynamicHeight(listView2);
    }
    public static void setDynamicHeight(ListView list){
        ListAdapter adapter = list.getAdapter();
        if(adapter == null){
            return;
        }
        int height = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(list.getWidth(), View.MeasureSpec.UNSPECIFIED);
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, list);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            height += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = list.getLayoutParams();
        layoutParams.height = height + (list.getDividerHeight() * (adapter.getCount() - 1));
        list.setLayoutParams(layoutParams);
        list.requestLayout();
    }
    public void sendMessage(View v){
        Intent intent = new Intent(this, addNewEntry.class);
        startActivity(intent);
    }
}
