package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText EditA, EditB;
    private TextView Result;
    private Button btnTong,btnTru,btnNhan,btnChia,btnUoc,btnExit;

    private void calculate(char operator) {
        int a = Integer.parseInt(EditA.getText().toString());
        int b = Integer.parseInt(EditB.getText().toString());
        int result = 0;

        switch (operator){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result= a*b;
                break;
            case '/':
                if (b!=0){
                    result = a/b;
                }
                else {
                    Toast.makeText(this,"Không chia cho 0",Toast.LENGTH_LONG).show();
                    return;
                }
                break;
        }
        Result.setText(String.valueOf(result));
    }
    private void calculateUoc(){
        int a = Integer.parseInt(EditA.getText().toString());
        int b = Integer.parseInt(EditB.getText().toString());

        while(b!=0){
            int temp = 0;
            b = a%b;
            a = temp;
        }
        Result.setText(String.valueOf(a));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditA = findViewById(R.id.edt_a);
        EditB = findViewById(R.id.edt_b);
        Result = findViewById(R.id.result);

        btnTong = findViewById(R.id.tong);
        btnTru = findViewById(R.id.hieu);
        btnNhan = findViewById(R.id.tich);
        btnChia = findViewById(R.id.thuong);
        btnUoc = findViewById(R.id.uoc);
        btnExit = findViewById(R.id.exit);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('+');
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('-');
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('*');
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('/');
            }
        });

        btnUoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateUoc();

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}