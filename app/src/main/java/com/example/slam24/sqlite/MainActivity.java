package com.example.slam24.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity {
    TextView tvSignUp;
    Button btnlogin;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSignUp = (TextView)findViewById(R.id.textViewSignUp);
        btnlogin = (Button)findViewById(R.id.buttonLogin);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signup.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusu = (EditText)findViewById(R.id.editTextEmail);
                EditText txtpas = (EditText)findViewById(R.id.editTextPass);

                try {
                    Cursor cursor = helper.login(txtusu.getText().toString(),txtpas.getText().toString());
                    if (cursor.getCount() > 0){
                        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Error en el logeo",Toast.LENGTH_LONG).show();
                    }
                    txtusu.setText("");
                    txtpas.setText("");
                }catch (SQLException e){
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
