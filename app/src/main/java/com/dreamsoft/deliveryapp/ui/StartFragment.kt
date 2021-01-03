package com.dreamsoft.deliveryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            Toast.makeText(context, "Trabajando",Toast.LENGTH_SHORT).show()
        }
    }


}

/*
* seguir investigando c-29-11-20,
* corregir el splash screen c-02-01-21
* ver como hacer la app
*
* */