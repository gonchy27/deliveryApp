package com.dreamsoft.deliveryapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dreamsoft.DeliveryActivity
import com.dreamsoft.deliveryapp.MainActivity
import com.dreamsoft.deliveryapp.R
import com.dreamsoft.deliveryapp.databinding.FragmentStartBinding
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment() {

    private lateinit var bindingStart: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingStart = FragmentStartBinding.bind(view)

        bindingStart.btnStart.setOnClickListener {
            var intent = Intent(context,DeliveryActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }


}

/*
* seguir investigando c-29-11-20,
* corregir el splash screen c-02-01-21
* ver como hacer la app
*Ya se nos ocurrio algo!, jeje añadir imagenes al momento de presionar las opciones del navigation drawer c-12-01-21
* quizas deba ser con 000webhost, ir pensando, hasta mientras crear los demas fragments e ir agregando al navigation
* */