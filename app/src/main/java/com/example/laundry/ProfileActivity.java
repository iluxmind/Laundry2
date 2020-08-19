package com.example.laundry;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laundry.model.Global;
import com.example.laundry.model.User;

public class ProfileActivity extends AppCompatActivity {
    User u = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final Global g = (Global) getApplicationContext();
        TextView t1 = findViewById(R.id.pname);
        TextView t2 = findViewById(R.id.pusername);
        TextView t3 = findViewById(R.id.ptel);
        TextView t4 = findViewById(R.id.paddress);
        TextView t5 = findViewById(R.id.ppassword);

        t1.setText(g.getName());
        t2.setText(g.getUsername());
        t3.setText(g.getTel());
        t4.setText(g.getAddress());
        t5.setText(g.getPassword());

    }


}