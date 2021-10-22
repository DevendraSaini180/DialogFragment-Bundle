package com.saini.dialogfragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReceivingActivity extends AppCompatActivity {

    TextView mUserName, mPassword, mBundleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_receiving);

        mUserName = findViewById(R.id.textViewUserName);
        mPassword = findViewById(R.id.textViewPassword);
        mBundleText = findViewById(R.id.textViewBundle);

//        Intent intent = getIntent();
//        ArrayList<String> list;
//        list = (ArrayList<String>) intent.getSerializableExtra("LoginData");
//        mUserName.setText(list.get(0));
//        mPassword.setText(list.get(1));

        Bundle bundle = getIntent().getExtras();
//        String textBundle = bundle.getString("string", "No Data from Main Activity");
//        boolean textBundle = bundle.getBoolean("boolean");
//        int textBundle = bundle.getInt("price");
        float textBundle = bundle.getFloat("pi");
        mBundleText.setText(String.valueOf(textBundle));
        Toast.makeText(this, "float value received", Toast.LENGTH_SHORT).show();
    }
}