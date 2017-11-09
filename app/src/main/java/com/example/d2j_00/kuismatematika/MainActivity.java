package com.example.d2j_00.kuismatematika;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String opr;
    EditText angka1,angka2,operator,isi;
    TextView txtjwb,txtjb,txtjs,txt7,txt8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1=(EditText)findViewById(R.id.rndmangk1);
        operator=(EditText)findViewById(R.id.editoperator);
        angka2=(EditText)findViewById(R.id.rndmangk2);
        isi=(EditText)findViewById(R.id.editisi);
        txtjwb=(TextView)findViewById(R.id.text4);
        txtjb=(TextView)findViewById(R.id.text5);
        txtjs=(TextView)findViewById(R.id.text6);
        txt7=(TextView)findViewById(R.id.text7);
        txt8=(TextView)findViewById(R.id.text8);
    }
    public void newpr(View view) {
        int a,b;
        opr=operator();
        operator.setText(opr);
        a=(int)(Math.random()*100+1);
        b=(int)(Math.random()*a+1);
        angka1.setText(Integer.toString(a));
        angka2.setText(Integer.toString(b));
    }
    public void cekans(View view) {
        int a,b,c,d,hasil=0;
        d=(int)(Math.random()*100+1);
        a=Integer.parseInt(angka1.getText().toString());
        b=Integer.parseInt(angka2.getText().toString());
        c=Integer.parseInt(isi.getText().toString());
        if(opr=="+"){
            hasil=a+b;
        }else if(opr=="-"){
            hasil=a-b;
        }else if(opr=="x"){
            hasil=a*b;
        }else if(opr=="/"){
            hasil=a/b;
        }
        txtjb.setText(Integer.toString(hasil));
        if(c==hasil){
            txtjwb.setText("Your Answer Is Correct");
            txtjs.setText(Integer.toString(d));
        }else {
            txtjwb.setText("Your Answer is Wrong");
            txtjs.setText(isi.getText());
        }

        SharedPreferences sh=getSharedPreferences("MyOwnShared",MODE_PRIVATE);
        SharedPreferences.Editor myshedt=sh.edit();
        myshedt.putString("user",txtjb.getText().toString());
        myshedt.putString("age",txtjs.getText().toString());
        myshedt.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences shd=getSharedPreferences("MyOwnShared",MODE_APPEND);
        String s1=shd.getString("user","");
        String i1=shd.getString("age",""); //mendapatkan nilai yang telah disave
        txtjb.setText(s1);
        txtjs.setText(i1);
    }

    public String operator(){
        String opr="s";
        int a=(int)(Math.random()*4+1);
        switch (a){
            case 1:opr="+"; break;
            case 2:opr="-"; break;
            case 3:opr="x"; break;
            case 4:opr="/"; break;
        }
        return opr;
    }

}