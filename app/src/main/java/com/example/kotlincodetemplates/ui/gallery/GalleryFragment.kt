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
                    5 -> Navigation.findNavController(view!!).navigate(R.id.listFragment)
                    6 -> Navigation.findNavController(view!!).navigate(R.id.recyclerViewFragment)
                    7 -> Navigation.findNavController(view!!).navigate(R.id.viewPagerFragment)
                    8 -> Navigation.findNavController(view!!).navigate(R.id.onClickFragment)
                    9 -> Navigation.findNavController(view!!).navigate(R.id.toastViewFragment)
                    10 -> Navigation.findNavController(view!!).navigate(R.id.shimmerFragment)
                    11 -> Navigation.findNavController(view!!).navigate(R.id.spinKitFragment)
                    12 -> Navigation.findNavController(view!!).navigate(R.id.gifLoadingFragment)
                    13 -> Navigation.findNavController(view!!).navigate(R.id.pdfFileFragment)
                    14 -> Navigation.findNavController(view!!).navigate(R.id.menuFragment)
                    15 -> Navigation.findNavController(view!!).navigate(R.id.notificationsFragment)
                    16 -> Navigation.findNavController(view!!).navigate(R.id.swipeFragment)
                    17 -> Navigation.findNavController(view!!).navigate(R.id.alertDialogFragment)
                }
            }
        })

        val list: ArrayList<GalleryModel> = arrayListOf()
        list.add(GalleryModel("Installing Android", R.drawable.ic_installing))
        list.add(GalleryModel("Scroll View", R.drawable.ic_scroll_view))
        list.add(GalleryModel("Progress Bar", R.drawable.ic_progress_bar))
        list.add(GalleryModel("Card View", R.drawable.ic_card))
        list.add(GalleryModel("Button", R.drawable.ic_button))
        list.add(GalleryModel("List View", R.drawable.ic_list))
        list.add(GalleryModel("Recycler View", R.drawable.ic_recycler))
        list.add(GalleryModel("Pager View", R.drawable.ic_pager))
        list.add(GalleryModel("On Click", R.drawable.ic_click))
        list.add(GalleryModel("Toast View", R.drawable.ic_toast))
        list.add(GalleryModel("Shimmer View", R.drawable.ic_shimmer))
        list.add(GalleryModel("Spin Kit View", R.drawable.ic_spin_kit))
        list.add(GalleryModel("Gif View", R.drawable.ic_gif_loading))
        list.add(GalleryModel("Pdf View", R.drawable.ic_pdf))
        list.add(GalleryModel("Menu View", R.drawable.ic_menu))
        list.add(GalleryModel("Push Notification", R.drawable.ic_notification))
        list.add(GalleryModel("Swipe View", R.drawable.ic_swipe))
        list.add(GalleryModel("Alert Dialog", R.drawable.ic_alert))

        adapters.update(list)
        recyclerView.adapter = adapters
    }
}