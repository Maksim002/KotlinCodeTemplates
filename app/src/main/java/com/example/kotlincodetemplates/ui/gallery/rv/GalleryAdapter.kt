package com.example.kotlincodetemplates.ui.gallery.rv

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsurs.base.rv.GenericRecyclerAdapter
import com.example.androidsurs.base.rv.ViewHolder
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.models.GalleryModel
import kotlinx.android.synthetic.main.item_gallery.view.*

class GalleryAdapter(var listener: Listener, item: ArrayList<GalleryModel> = arrayListOf()): GenericRecyclerAdapter<GalleryModel>(item) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_gallery)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun bind(item: GalleryModel, holder: ViewHolder) = with(holder.itemView) {
        textGallery.text = item.name
        imageGallery.setImageDrawable(resources.getDrawable(item.image, null))

        this.setOnClickListener {
            listener.setOnClickListener(holder.adapterPosition)
        }
    }

    interface Listener{
        fun setOnClickListener(position: Int)
    }
}