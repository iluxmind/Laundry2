package com.example.laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laundry.model.User;
import com.example.laundry.remote.RetrofitClientInstance;
import com.example.laundry.remote.userService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    User u = new User();
    private userService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }
    public void register(View v){
        EditText t1 = findViewById(R.id.name);
        EditText t2 = findViewById(R.id.address);
        EditText t3 = findViewById(R.id.phone);
        EditText t4 = findViewById(R.id.pass);
        EditText t5 = findViewById(R.id.cpass);
if(t4.getText().toString().equals(t5.getText().toString())){
    u = new User(t3.getText().toString(),t4.getText().toString(),t1.getText().toString(),t3.getText().toString(),t2.getText().toString());
    userService service = RetrofitClientInstance.getRetrofitInstance().create(userService.class);
    Call<User> call = service.register(u);
    Toast.makeText(this, ""+t3.getText().toString()+t4.getText().toString()+t1.getText().toString()+t3.getText().toString()+t2.getText().toString(), Toast.LENGTH_SHORT).show();
    call.enqueue(new Callback<User>() {
        @Override
        public void onResponse(Call<User> call, Response<User> response) {

                Toast.makeText(RegisterActivity.this, "สมัครสมาชิกสำเร็จ"+response, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onFailure(Call<User> call, Throwable t) {
            Toast.makeText(RegisterActivity.this, "ลองใหม่อีกครั้ง"+t, Toast.LENGTH_SHORT).show();
        }
    });
}else{
    Toast.makeText(this, "รหัสผ่านไม่ตรงกัน กรุาลองใหม่อีกครั้ง", Toast.LENGTH_SHORT).show();
}
    }
}