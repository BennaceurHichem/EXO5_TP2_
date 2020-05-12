  package com.example.exo5tp2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject


  class MainActivity : AppCompatActivity() {
    var textView: TextView? = null
    private var queue: RequestQueue? = null
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        queue = Volley.newRequestQueue(this);

        val url = "https://jsonplaceholder.typicode.com/posts"






        val request = JsonArrayRequest(
          Request.Method.GET, url, null,
          Response.Listener<JSONArray> { response ->

              //store repsonse in news
              val news= response
            //binding o the jsonArray is on th ExampleAdapter in the bind method
            recycler_view.adapter = ExampleAdapter(news)
          },
          Response.ErrorListener {
            Toast.makeText(this, "That didn't work!", Toast.LENGTH_SHORT).show()
          })





          queue?.add(request);


    }


  }
