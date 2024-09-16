package com.example.lap2_1;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class m001_act_splash extends AppCompatActivity {
    private View itemLoadingLayout;
    private LinearLayout splashLayout, inforCorgi;
    private Button btnGoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_m001_act_splash);

        itemLoadingLayout = findViewById(R.id.item_loading);  // ID của ProgressBar
        splashLayout = findViewById(R.id.m001_act_splash);
        inforCorgi = findViewById(R.id.info_corgi);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.m001_act_splash), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        new Handler().postDelayed(() -> {
            // Ẩn layout của item_loading
            itemLoadingLayout.setVisibility(View.GONE);

            // Thay đổi màu nền của splash layout
            int[] colors = {
                    R.color.purple_200,
                    R.color.purple_500,
                    R.color.purple_700,
                    R.color.teal_200,
                    R.color.teal_500
            };

            // Chọn màu ngẫu nhiên từ mảng màu
            int randomColor = colors[new Random().nextInt(colors.length)];
            splashLayout.setBackgroundColor(ContextCompat.getColor(this, randomColor));

            // Hiển thị splash layout
            splashLayout.setVisibility(View.VISIBLE);
        }, 1000);// 1 giây


        btnGoto = findViewById(R.id.Goto_info);
        btnGoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splashLayout.setVisibility(View.GONE);
                itemLoadingLayout.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        itemLoadingLayout.setVisibility(View.GONE);
                        inforCorgi.setVisibility(View.VISIBLE);
                    }
                },1000);
            }
        });

    }
}