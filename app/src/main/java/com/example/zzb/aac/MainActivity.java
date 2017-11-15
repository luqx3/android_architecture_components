package com.example.zzb.aac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zzb.aac.repository.IPRepository;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    IPRepository ipRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv);
        ipRepository=new IPRepository();
        ipRepository.init(this);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ipRepository.getIp("000000");
            }
        });

    }
}
