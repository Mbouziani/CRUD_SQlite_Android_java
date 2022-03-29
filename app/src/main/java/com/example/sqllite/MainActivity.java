package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insert , Delete ,Update ,Read ;
    EditText tb_N, tb_A;
    Db_healpear db_hlp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = (Button) findViewById(R.id.insert);
        Delete = (Button) findViewById(R.id.delete);
        Update = (Button) findViewById(R.id.updt);
        Read = (Button) findViewById(R.id.read);
        tb_N = (EditText) findViewById(R.id.tb_name);
        tb_A = (EditText) findViewById(R.id.tb_prename);
        db_hlp= new Db_healpear(this);




        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db_hlp.insertdata(tb_N.getText().toString(),tb_A.getText().toString());
            }
        });


        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db_hlp.Delete(tb_N.getText().toString());
                Toast.makeText(MainActivity.this,"Data Deleted Succefully",Toast.LENGTH_LONG).show();


            }
        });


        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 db_hlp.update(tb_N.getText().toString(),tb_A.getText().toString());

            }
        });




        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cu = db_hlp.readData();
                StringBuffer SB = new StringBuffer("");
                while(cu.moveToNext())
                {
                    SB.append("Name: "+cu.getString(0)+"\n");
                    SB.append("Age: "+cu.getString(1)+"\n");
                }
                Toast.makeText(MainActivity.this,SB.toString(),Toast.LENGTH_LONG).show();


            }
        });






    }

}