package com.dreamsoft.deliveryapp

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.dreamsoft.deliveryapp.ui.StartFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

       /* window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)*/

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*var intent : Intent(this, StartFragment::class.java); segun programacion y mas c-05-01-21
        startActivity(intent);
        finish();*/
    }
}

//ya se esta investigando como hacer esta app, todavia terminar de ver las ideas c-23-11-20
/*
* Creo que se eliminara el fragment de esta activity...Xd c-02-01-21,y se quedara esta como interfaz principal
* pensar si se va a registrar los usuarios, o se almacenara directamente los datos del ususario en la BD c-09-01-21
* Se recomienda crear imagenes para el splashscreen de diferentes resoluciones, investigar,
* Ya funciona el splashscreen, pero todavia falta crear las resoluciones para diferentes pantallas,
* ademas se esta usando el drawable y no el mipmap investigar un poco mas
* c-12-01-21
* * */