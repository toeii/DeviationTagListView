package com.toeii.deviationtag

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var listView: ListView? = null
    private var scrollImageView: ScrollImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<View>(R.id.listview) as ListView
        listView!!.adapter = MyAdapter()
    }


    private inner class MyAdapter : BaseAdapter() {

        override fun getCount(): Int {
            return 50
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
            var imageLayout = layoutInflater.inflate(R.layout.item_image, null)
            scrollImageView = imageLayout.findViewById(R.id.image)
            when (position % 5) {
                0 -> scrollImageView!!.setImageResource(R.mipmap.test)
                else -> {
                    imageLayout = layoutInflater.inflate(R.layout.item_text, null)
                    val textView = imageLayout.findViewById<TextView>(R.id.tv_content)
                    textView.text = "Content Item - > $position"
                }
            }
            return imageLayout

        }
    }
}
