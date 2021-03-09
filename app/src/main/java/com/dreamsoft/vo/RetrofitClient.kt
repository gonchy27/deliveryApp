package com.dreamsoft.vo

import android.app.VoiceInteractor
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.coroutines.coroutineContext

object RetrofitClient {

    /*val webservice by lazy{
        Retrofit.Builder()
            .baseUrl("https://databases-auth.000webhost.com/index.php")
        Log.i("RetrofitClient","Trabajando")
    }*/

    //aca codigo de conexion a la bd
   /* val queue = Volley.newRequestQueue(this)
    val url =""
    val stringRequest = StringRequest(Request.Method.GET, url, Response.Listener { response->

    },Response.ErrorListener{error->

                        })
    queue.add(stringResponse)*/

   /* val queue = Volley.newRequestQueue(this)
    val url = "https://databases-auth.000webhost.com/index.php";
    val stringRequest = StringRequest(Request.Method.GET, url, com.android.volley.Response.Listener { response ->
        Toast.makeText(context,"conexion?, probando",Toast.LENGTH_SHORT).show()
        Log.i("SlideShow", "conectado?")
    }, com.android.volley.Response.ErrorListener { error ->
        Toast.makeText(context,"trabajando error",Toast.LENGTH_SHORT).show()
    })*/

}

//esto sera un poco diferente al video, desde aqui conectaremos a la bd y realizaremos consultas
/*
* c-13-02-21, se puede modificar el codigo si es necesario
* investigar codigo conexion 000webhost y android con kotlin
* */