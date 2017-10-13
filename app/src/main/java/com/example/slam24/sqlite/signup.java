package com.example.slam24.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import OpenHelper.SQLite_OpenHelper;

public class signup extends AppCompatActivity {
    Button btnSaveUsu;
    EditText txtNameUsu, txtDisUsui, txtEmailUsu, txtPassUsu;
    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSaveUsu = (Button)findViewById(R.id.buttonSigUp);
        txtNameUsu = (EditText)findViewById(R.id.editTextSUName);
        txtDisUsui = (EditText)findViewById(R.id.editTextSUDistritic);
        txtEmailUsu = (EditText)findViewById(R.id.editTextSUEmail);
        txtPassUsu = (EditText)findViewById(R.id.editTextSUPass);

        btnSaveUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.open();
                helper.insertRow(String.valueOf(txtNameUsu.getText()), String.valueOf(txtDisUsui.getText()),String.valueOf(txtEmailUsu.getText()),String.valueOf(txtPassUsu.getText()));
                helper.close_();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
