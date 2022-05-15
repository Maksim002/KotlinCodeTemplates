package com.example.kotlincodetemplates.ui.swipe

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.kotlincodetemplates.R
import com.sourcerebels.swiperefreshprogressview.SwipeRefreshProgressView
import com.squareup.okhttp.Headers
import io.grpc.okhttp.internal.framed.Header
import kotlinx.android.synthetic.main.fragment_display_swipe.*
import java.util.*
import kotlin.collections.ArrayList


class DisplaySwipeFragment : Fragment() {

    private var position = 0
    private var positionOne = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_swipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MyRecyclerViewAdapter()
        recycler_view.adapter = adapter

        swipe_refresh!!.setOnRefreshListener {
            Handler().postDelayed({
                refresh(adapter)
            }, 1000)
        }

        swipe_refresh!!.setColorSchemeResources(R.color.red, R.color.grey, R.color.black)
        refresh(adapter)
    }

    private fun refresh(adapter: MyRecyclerViewAdapter) {
        adapter.delete()
        for (i in position..positionOne){
            adapter.listAdd("item " + i)
            recycler_view.adapter = adapter
            if (i == positionOne){
                swipe_refresh.isRefreshing = false
                position += i
                positionOne += i
            }
        }
    }
}

class MyRecyclerViewAdapter: RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewHolder>() {

    private val items: ArrayList<String> = arrayListOf()

    fun delete(){
        items.clear()
    }

    fun listAdd(item: String){
        items.add(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyRecyclerViewHolder(
            inflater.inflate(R.layout.adapter_my_recycler_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var title: TextView? = null

        fun bind(item: String?) {
            title = itemView.findViewById<View>(R.id.title_view) as TextView
            title!!.text = item
        }
    }
}