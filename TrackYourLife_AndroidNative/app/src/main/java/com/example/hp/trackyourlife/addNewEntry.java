package com.example.hp.trackyourlife;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Calendar;

public class addNewEntry extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    DatePickerDialog datePickerDialog;
    EditText editText, time2;
    int time1;
    int buttonClick;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_entry);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.priorityArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    public void showFromDateDialog (View v) {
        buttonClick = v.getId();
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "DatePicker");
    }
    public void populateSetDate(int year, int month, int day) {
        if(buttonClick == R.id.button5)
            editText = (EditText) findViewById(R.id.editText4);
        else if(buttonClick == R.id.button4)
            editText = (EditText) findViewById(R.id.editText7);
        editText.setText(month + "/" + day + "/" + year);
    }
    public void populateSetTime(int hour, int minute){
        switch(time1){
            case R.id.editText8:
                time2 = (EditText) findViewById(R.id.editText8);
                break;
            case R.id.editText9:
                time2 = (EditText) findViewById(R.id.editText9);
                break;
            case R.id.editText10:
                time2 = (EditText) findViewById(R.id.editText10);
                break;
        }
        time2.setText(hour + ":" + minute);

    }
    public void showToDateDialog (View v) {
        buttonClick = v.getId();
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "DatePicker");
    }
    public void showTimeDialog (View v) {
        time1 = v.getId();
        DialogFragment newFragment1 = new TimePickerFragment();
        newFragment1.show(getSupportFragmentManager(), "TimePicker");
    }
}
