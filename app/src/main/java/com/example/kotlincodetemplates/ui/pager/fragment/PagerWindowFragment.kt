package com.example.kotlincodetemplates.ui.pager.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlincodetemplates.R
import kotlinx.android.synthetic.main.fragment_button_display.*
import kotlinx.android.synthetic.main.fragment_button_display.textView
import kotlinx.android.synthetic.main.fragment_pager_window.*

class PagerWindowFragment(
    private val imageBackground: Drawable, private val title: String, private var image: Drawable
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pager_window, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView.setImageDrawable(imageBackground)
        imageViewPager.setImageDrawable(image)
        textView.text = title
    }
}
