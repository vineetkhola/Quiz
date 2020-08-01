package com.vinu.radiorachi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg ,rg2;
    RadioButton rb;
    Button b;
    LinearLayout ll1, ll2;
    TextView question2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         question2 = findViewById(R.id.textView1);
         rg2 = findViewById(R.id.rg1);
        rg=(RadioGroup)findViewById(R.id.rg);
        b=(Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                int id=rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(id);

                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("You selected "+rb.getText()+" Do you want to continue?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ll1 =(LinearLayout)findViewById(R.id.linear1);
                        ll2 =(LinearLayout)findViewById(R.id.linear2);
                        ll1.setVisibility(View.GONE);
                        ll2.setVisibility(View.VISIBLE);
                        question2.setVisibility(View.VISIBLE);
                        rg2.setVisibility(View.VISIBLE);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       // builder.setCancelable(true);
                        dialogInterface.dismiss();

                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.setTitle("Rachita Alert");
                alertDialog.show();
            }
        });

    }
}