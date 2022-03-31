package com.example.kotlincodetemplates.ui.gallery

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.kotlincodetemplates.models.GalleryModel
import com.example.kotlincodetemplates.ui.gallery.rv.GalleryAdapter
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_gallery.*


class GalleryFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initRecyclerView() {
        val adapters = GalleryAdapter(object : GalleryAdapter.Listener{
            override fun setOnClickListener(position: Int) {
                when(position){
                    0 -> Navigation.findNavController(view!!).navigate(R.id.webViewFragment)
                    1 -> Navigation.findNavController(view!!).navigate(R.id.scrollVerticalFragment)
                    2 -> Navigation.findNavController(view!!).navigate(R.id.progressBarFragment)
                    3 -> Navigation.findNavController(view!!).navigate(R.id.cardViewFragment)
                    4 -> Navigation.findNavController(view!!).navigate(R.id.buttonFragment)
                }
            }
        })

        val list: ArrayList<GalleryModel> = arrayListOf()
        list.add(GalleryModel("Installing Android", R.drawable.ic_installing))
        list.add(GalleryModel("Scroll View", R.drawable.ic_scroll_view))
        list.add(GalleryModel("Progress Bar", R.drawable.ic_progress))
        list.add(GalleryModel("Card View", R.drawable.ic_card))
        list.add(GalleryModel("Button", R.drawable.ic_baseline_touch_app_24))

        adapters.update(list)
        recyclerView.adapter = adapters
    }
}