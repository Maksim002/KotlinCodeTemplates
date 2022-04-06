package com.example.kotlincodetemplates.ui.recyclerView

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_code_recycler_display.*
import kotlinx.android.synthetic.main.layout_blod_list_item.view.*

class CodeRecyclerDisplayFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_code_recycler_display, container, false)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: ArrayList<Model> = arrayListOf()
        list.add(Model("The girl of the sleeping bag boy", resources.getDrawable(R.drawable.ic_girls, null)))
        list.add(Model("A fabulous dream picture", resources.getDrawable(R.drawable.ic_drops, null)))
        list.add(Model("The house of the baby under the little finger of Zeus", resources.getDrawable(R.drawable.ic_hom, null)))
        list.add(Model("Night lighting for adventure", resources.getDrawable(R.drawable.ic_luna, null)))
        list.add(Model("A forest of stoned hedgehogs", resources.getDrawable(R.drawable.ic_forest, null)))

        val adapter = AdapterRecyclerView()
        adapter.update(list)
        recyclerView.adapter = adapter
    }
}

class AdapterRecyclerView(var items: List<Model> = ArrayList()) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    fun update(list: List<Model>){
        items = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolders(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_blod_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolders ->{
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolders constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(model: Model) = with(itemView){
            textView.text = model.title
            imageView.setImageDrawable(model.image)
        }
    }
}

class Model(
    val title: String,
    val image: Drawable
)