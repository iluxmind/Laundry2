package com.example.laundry;

import android.content.Intent;
import android.os.Bundle;

import com.example.laundry.model.Global;
import com.example.laundry.model.User;
import com.example.laundry.remote.RetrofitClientInstance;
import com.example.laundry.remote.userService;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //สมัครสมาชิก
        LinearLayout register = (LinearLayout) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
    public void login(View v){
        /*Service*/

        final Global g = (Global) getApplicationContext();

        userService service = RetrofitClientInstance.getRetrofitInstance().create(userService.class);
        EditText tel = findViewById(R.id.editTextPhone);
        Call<User> call = service.getUserInfo(""+tel.getText());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                EditText pass = findViewById(R.id.editTextTextPassword);
                if(response.body().getPassword().equals(pass.getText().toString())){
                    g.setUsername(response.body().getUsername());
                    g.setAddress(response.body().getAddress());
                    g.setName(response.body().getName());
                    g.setTel(response.body().getTel());
                    g.setPassword(response.body().getPassword());
                            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                            startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "เบอร์โทรศัพท์หรือรหัสผ่านผิด โปรดลองอีกครั้ง", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}