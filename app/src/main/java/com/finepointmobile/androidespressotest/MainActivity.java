package com.finepointmobile.androidespressotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mFirstName;
    Button mButton;
    TextView mGoodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirstName = (EditText) findViewById(R.id.first_name);
        mButton = (Button) findViewById(R.id.button);
        mGoodName = (TextView) findViewById(R.id.good_name);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = mFirstName.getText().toString();
                if (firstName.contains("Daniel")) {
                    mGoodName.setText("Good name!");
                } else {
                    mGoodName.setText("Your name is bad.");
                }
            }
        });
    }
}
