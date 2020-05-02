package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText at;
    Button bt;
    TextView ct;
    DecimalFormat f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        at=findViewById(R.id.at);
        bt=findViewById(R.id.bt);
        ct=findViewById(R.id.ct);

        ct.setVisibility(View.GONE);

        f=new DecimalFormat("#0.00");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (at.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "please fill all fields!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int a=Integer.parseInt(at.getText().toString().trim());
                    double temp=((a/5.0)*9)+32;
                    String res="FAHRENHEIT TEMPERATURE for "+a+"°C  is "+f.format(temp)+"°F.";
                    ct.setText(res);
                    ct.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
