package com.example.newpaper_assign_2

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter(
    private val context: Activity,
    private val title: Array<String>,
    private val body: Array<String>,
    private val img: Array<Int>
)  : ArrayAdapter<String>(context, R.layout.listview_design, title)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.listview_design, null, true)

        val title_val = rowView.findViewById(R.id.title) as TextView
        val body_val = rowView.findViewById(R.id.body) as TextView
        val img_val = rowView.findViewById(R.id.img) as ImageView


        title_val.text = title[position]
        body_val.text = body[position]
        img_val.setImageResource(img[position])

        return rowView

    }
}