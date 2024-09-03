package com.example.listview_2
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<user>):
  ArrayAdapter<user>(context, R.layout.eachitem, arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflator=LayoutInflater.from(context)
        val view=inflator.inflate(R.layout.eachitem,null) // each item view
        val image=view.findViewById<CircleImageView>(R.id.profile_image)
        val name=view.findViewById<TextView>(R.id.textView1)
        val lastmsg=view.findViewById<TextView>(R.id.textView2)
        val lastseen=view.findViewById<TextView>(R.id.textView3)
        name.text=arrayList[position].name
        lastmsg.text=arrayList[position].lastmsg
        lastseen.text=arrayList[position].lastseen

        image.setImageResource(arrayList[position].image)
        return view
    }
  }