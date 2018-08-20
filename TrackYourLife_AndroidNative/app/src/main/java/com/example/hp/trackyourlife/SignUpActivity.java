package com.example.hp.trackyourlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText edit1 = (EditText) findViewById(R.id.editText);
        EditText edit2 = (EditText) findViewById(R.id.editText2);
        EditText edit3 = (EditText) findViewById(R.id.editText3);
        String uname = edit1.getText().toString();
        String email = edit2.getText().toString();
        String pword = edit3.getText().toString();
        if(TextUtils.isEmpty(uname)) {
            edit1.setError("Please enter required detail");
            return;
        }
        else if(TextUtils.isEmpty(email)) {
            edit2.setError("Please enter required detail");
            return;
        }
        else if(TextUtils.isEmpty(pword)) {
            edit3.setError("Please enter required detail");
            return;
        }
    }
    public void sendMessage (View view) {
        Intent intent = new Intent(this, ShowCategoryList.class);
        startActivity(intent);
    }
}
