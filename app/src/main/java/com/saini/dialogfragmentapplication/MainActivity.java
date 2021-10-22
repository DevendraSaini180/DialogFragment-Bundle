package com.saini.dialogfragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnOpenDialog, mSendBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnOpenDialog = findViewById(R.id.buttonDialogFragment);
        mSendBundle = findViewById(R.id.buttonBundle);
        mBtnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDialogFragment dialogFragment = new LoginDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "Login Dialog");
            }
        });

        mSendBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "passing bundle from main to another activity", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
//                bundle.putString("string", "Passing String Bundle from Main Activity to Another Activity");
//                bundle.putBoolean("boolean", true);
//                bundle.putInt("price", 15000);
                bundle.putFloat("pi", 3.14f);
                Intent intent = new Intent(MainActivity.this, ReceivingActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}