package com.example.a2doparciallogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PANTALLAELEGIR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaelegir);

        public void IrAPizzas (View Object view = null;
        view){
            Intent i = new Intent(this, pizzas.class);
            startActivity(i);
    }
}