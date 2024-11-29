package com.example.dogs_and_cats_app
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapteri(val context:Context,val tietolahde:ArrayList<Any>):BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return tietolahde.size
    }

    override fun getItem(p0: Int): Any {
        return tietolahde[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val riviView = inflater.inflate(R.layout.omarivi,p2, false)
        val nimi: TextView = riviView.findViewById(R.id.Eläinrodut)
        nimi.text = tietolahde.get(p0).toString()
        val elain = getItem(p0)
        when (elain) {
            is Koirat -> nimi.text = elain.rotu
            is Kissat -> nimi.text = elain.rotu
        }
        return riviView
    }

}