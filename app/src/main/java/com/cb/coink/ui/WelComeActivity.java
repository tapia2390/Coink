package com.cb.coink.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.cb.coink.R;
import com.cb.coink.model.Modelo;

public class WelComeActivity extends Activity {

    Modelo modelo = Modelo.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wel_come);


        Log.v("Datos Usuarios",modelo.person.toString());

    }
}