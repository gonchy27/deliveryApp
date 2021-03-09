package com.dreamsoft.ui.slideshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.load.engine.Resource
import com.dreamsoft.data.DataSource
import com.dreamsoft.data.model.Dish
import com.dreamsoft.deliveryapp.R
import com.dreamsoft.domain.RepoImpl
import com.dreamsoft.ui.DishAdapter
import com.dreamsoft.ui.viewmodel.DishViewModel
import com.dreamsoft.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_slideshow.*
import org.json.JSONObject

//import com.dreamsoft.R

class SlideshowFragment : Fragment(),DishAdapter.OnDishClickListener{

    private lateinit var slideshowViewModel: SlideshowViewModel

    lateinit var request: RequestQueue;
    lateinit var jsonObjectRequest: JsonObjectRequest;


    private val viewModel by viewModels<DishViewModel>{ VMFactory(RepoImpl(DataSource()))}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        //val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
           // textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        setUpObserver()
        //aca searchView por defecto

        //conectar descomentar si es necesario
        //conectar()

        request = Volley.newRequestQueue(context);
        conectar()

    }

    /*private fun conectar(){
        //var url = "https://databases-auth.000webhost.com/conectarse.php";
        //var url ="https://deliverynation.000webhostapp.com/conectarse.php"192:168.100.4
        var url ="https://192:168.100.4/deliverynation.000webhostapp.com"; //probar
        //var url ="https://databases-auth.000webhost.com/sql.php?db=id16125523_delivery&table=dish&pos=0", probar con POST
        //url = url.replace("", "%20")
        jsonObjectRequest= JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);


    }*/
    private fun conectar() {
        val queue = Volley.newRequestQueue(context);
        //https://deliverynation.000webhostapp.com/conectarse.php, probar con este otro si no funciona
        val url = "https://deliverynation.000webhostapp.com";
        //val url = "https://databases-auth.000webhost.com/conectarse.php";
        val stringRequest = StringRequest(Request.Method.GET, url, Response.Listener { response ->
            Toast.makeText(context,"conexion?, probando" + response,Toast.LENGTH_SHORT).show()
            Log.i("SlideShow", "conectado?")
        }, Response.ErrorListener { error ->
            Toast.makeText(context,"trabajando error",Toast.LENGTH_SHORT).show()
        })
        queue.add(stringRequest);
    }

    private fun setUpObserver() {
        viewModel.fetchDishList.observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is com.dreamsoft.vo.Resource.Loading ->{
                    progressBar.visibility= View.VISIBLE
                }
                is com.dreamsoft.vo.Resource.Success ->{
                    progressBar.visibility= View.GONE
                    rv_dish.adapter = DishAdapter(requireContext(), result.data, this)
                }
                is com.dreamsoft.vo.Resource.Failure ->{
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),"Something is wrong ${result.exception}",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupRecyclerView(){
        rv_dish.layoutManager = LinearLayoutManager(requireContext())
        rv_dish.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onDishClick(dish: Dish) {
        val bundle = Bundle()
        bundle.putParcelable("dish", dish)
        //Toast.makeText(context, "datos dish" + dish, Toast.LENGTH_SHORT).show()

        Toast.makeText(context, "trabajando", Toast.LENGTH_SHORT).show()

        //conectar
        //conectar()
        //Toast.makeText(context, "paso por conectar", Toast.LENGTH_SHORT).show()
    }

    /*override fun onResponse(response: JSONObject?) {
        Toast.makeText(context, "Conectado", Toast.LENGTH_SHORT).show()
    }

    override fun onErrorResponse(error: VolleyError?) {
        Toast.makeText(context, "Error",Toast.LENGTH_SHORT).show()
        Log.i("Error", error.toString());
    }*/


}

/*
* esto es dish c-21-01-21
* ir probando a medida que avanza el video c-23-01-21
* ahora ir construyendo el tutorial 3 c-25-01-21
* min 24:18 continuar viendo c-29-01-21, no se puede usar el glyde sin internet....ummm, eso es un problema,
* en onDishClick hay que implementar el navigation a a la siguiente pagina c-31-01-21
*
* Analizar un poco mas, esta semana tiene que morir esto c-07-02-21,

* finalmenete funciona la conexion ahora mockear la app c-05-03-21 y ver si se puede hacerlo de la mejor manera posible
* el mockeo
*
* */