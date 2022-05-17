package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.Expression;

public class square extends AppCompatActivity {
    private EditText input;
    private EditText output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        input = findViewById(R.id.sqinp);
        output = findViewById(R.id.sqop);
        input.setShowSoftInputOnFocus(false);
    }

    private void tex(String strupda) {
        String oristring= input.getText().toString();
        int cur=input.getSelectionStart();
        String lstring=oristring.substring(0,cur);
        String rstring=oristring.substring(cur);
        input.setText(String.format("%s%s%s",lstring,strupda,rstring));

        input.setSelection(cur+1);
    }

    public void zero(View view) {
        tex("0");
    }

    public void one(View view) {
        tex("1");
    }

    public void two(View view) {
        tex("2");
    }

    public void three(View view) {
        tex("3");
    }

    public void four(View view) {
        tex("4");
    }

    public void five(View view) {
        tex("5");
    }

    public void six(View view) {
        tex("6");
    }

    public void seven(View view) {
        tex("7");
    }

    public void eight(View view) {
        tex("8");
    }

    public void nine(View view) {
        tex("9");
    }
    public void dot(View view) { tex("."); }

    public void equal(View view) {
        String s = input.getText().toString();
        String a = s+"*"+s;
        Expression e=new Expression(a);
        String res=String.valueOf(e.calculate());
        output.setText(res);
    }
    public void cbtn(View view){
         String s="";
        input.setText(s);
        output.setText(s);
    }
    public void bcktn(View view){
        Intent i = new Intent(this,options.class);
        startActivity(i);
    }
}