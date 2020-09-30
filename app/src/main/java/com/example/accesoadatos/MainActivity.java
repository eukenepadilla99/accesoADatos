package com.example.accesoadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    private Button butSave;
    private Button butRecover;
    private TextView tvShowSaved;
    private EditText etSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butSave=findViewById(R.id.butSave);
        butRecover=findViewById(R.id.butRecover);
        tvShowSaved=findViewById(R.id.tvShowSaved);
        etSave=findViewById(R.id.etSave);

        Context context = getBaseContext();

        sharedPref=this.getPreferences(Context.MODE_PRIVATE);
        editor =sharedPref.edit();

        String value=sharedPref.getString(getString(R.string.key),getString(R.string.defaultKeyTxt));

        tvShowSaved.setText(value);

        butSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(getString(R.string.key),etSave.getText().toString());
                //editor.commit();
                editor.apply();
            }
        });

        butRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor=
                        sharedPref.getString(getString(R.string.key),getString(R.string.defaultKeyTxt));
                //editor.commit();
                tvShowSaved.setText(valor);
            }
        });

    }
}