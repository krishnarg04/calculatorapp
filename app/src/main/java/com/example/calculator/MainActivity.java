package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;


public class MainActivity extends AppCompatActivity {
    private EditText display ;
    private SwitchCompat swi;
    SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.editTextNumber);
        display.setShowSoftInputOnFocus(false);
        swi= findViewById(R.id.switc1);
        sharedPreferences = getSharedPreferences("night",0);
        Boolean booleanValue = sharedPreferences.getBoolean("night_mode",true);
        if (booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            swi.setChecked(true);
        }

        swi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    swi.setChecked(true);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("night_mode", true);
                    editor.commit();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    swi.setChecked(false);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("night_mode", false);
                    editor.commit();

                }
            }
        });

    }
    public void text (String strupda ){
        String oristring= display.getText().toString();
        int cur=display.getSelectionStart();
        String lstring=oristring.substring(0,cur);
        String rstring=oristring.substring(cur);
        display.setText(String.format("%s%s%s",lstring,strupda,rstring));

        display.setSelection(cur+1);
    }
    public void zerobtn (View view){
       text("0");
    }
    public void onebtn (View view){
        text("1");
    }
    public void twobtn (View view){
        text("2");
    }
    public void threebtn (View view){
        text("3");
    }
    public void fourbtn (View view){
        text("4");
    }
    public void fivebtn (View view){
        text("5");
    }
    public void sixbtn (View view){
        text("6");
    }
    public void sevenbtn (View view){
        text("7");
    }
    public void eightbtn (View view){
        text("8");
    }
    public void ninebtn (View view){
        text("9");
    }
    public void addbtn (View view){
        text("+");
    }
    public void minusbtn (View view){
        text("-");
    }
    public void multiplybtn (View view){
        text("x");
    }
    public void dotbtn (View view){
        text(".");
    }
    public void dividebtn (View view){
        text("/");
    }
    public void equalbtn (View view){
        String curr=display.getText().toString();
        curr=curr.replace("×","*");
        curr=curr.replace("÷","/");
        Expression e=new Expression(curr);
        String res=String.valueOf(e.calculate());
        display.setText(res);
        display.setSelection(res.length());

    }
    public  void cbtn(View view){
        String text="";
        display.setText(text);
    }
    public void backbtn(View view){
        int cur=display.getSelectionStart();
        int a =display.getText().length();
        if(cur!=0&&a!=0) {
            SpannableStringBuilder select = (SpannableStringBuilder) display.getText();
            select.replace(cur - 1, cur, "");
            display.setText(select);
            display.setSelection(cur - 1);
        }
    }
    public void clparabtn(View view){
            text(")");
    }
    public void oparabtn(View view){
        text("(");
    }
    public void opt(View view){
        Intent i= new Intent(this,options.class);
        startActivity(i);}
}
