package com.example.hp.trackyourlife;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tx = (TextView)findViewById(R.id.textView);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/painter.ttf");
        tx.setTypeface(custom_font);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
