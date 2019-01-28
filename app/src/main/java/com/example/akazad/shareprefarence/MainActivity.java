package com.example.akazad.shareprefarence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameET, designationET;
    TextView nameT, designationT;
    Button saveBtn, loadBtn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    nameET=findViewById(R.id.nameId);
    designationET=findViewById(R.id.desginationId);
    nameT=findViewById(R.id.name);
    designationT=findViewById(R.id.designation);
    saveBtn=findViewById(R.id.saveId);
    loadBtn=findViewById(R.id.loadId);

    saveBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name=nameET.getText().toString();
            String desig=designationET.getText().toString();

            SharedPreferences sharedPreferences=getSharedPreferences("DataFile", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("nameKey", name);
            editor.putString("desigKey", desig);
            editor.commit();
            Toast.makeText(getApplicationContext(),"data save seccessfully", Toast.LENGTH_SHORT).show();
        }
    });

    loadBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sharedPreferences=getSharedPreferences("DataFile", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();

            if (sharedPreferences.contains("nameKey") && sharedPreferences.contains("desigKey") ){

                nameT.setText(sharedPreferences.getString("nameKey","data not found"));
               designationT.setText(sharedPreferences.getString("desigKey", "data not found"));
                Toast.makeText(getApplicationContext(),"data Load seccessfully", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(getApplicationContext(),"Empty", Toast.LENGTH_SHORT).show();
            }

        }
    });

    }
}
