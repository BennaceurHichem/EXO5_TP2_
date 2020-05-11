package com.example.exo5tp2

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import kotlinx.android.synthetic.main.example_item.view.*
import org.json.JSONArray
import org.json.JSONObject

class ExampleAdapter(private val news: JSONArray) :



    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false)




        return ExampleViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {

        holder.bind(news.getJSONObject(position), position)





    }
    override fun getItemCount() = news.length()
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(newsItem: JSONObject, position: Int) {
            val title = itemView.findViewById(R.id.title) as TextView
            val description = itemView.findViewById(R.id.description) as TextView
            //val image = itemView.findViewById(R.id.image) as NetworkImageView
            title.text = Html.fromHtml(newsItem["title"].toString(), 0)
            description.text = Html.fromHtml(newsItem["body"].toString(), 0)

        }

    }
}

