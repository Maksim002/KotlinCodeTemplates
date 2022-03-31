package com.example.kotlincodetemplates.ui.bottom.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_button_display.*


class ButtonDisplayFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClick(arrayListOf(
            bottom0, bottom1, bottom2, bottom3, bottom4,
            bottom5, buttonGroup1, buttonGroup2, buttonGroup3))
    }

    private fun initClick(view: ArrayList<Button>){

        for (btn in view) {
            btn.setOnClickListener {
                when(btn){
                    view[0] -> getText(text = "Mad Cat")
                    view[1] -> getText(text = "Mad Fox")
                    view[2] -> getText(text = "Seventh heaven")
                    view[3] -> getText(text = "White larch")
                    view[4] -> getText(text = "Eggs of destiny")
                    view[5] -> getText(text = "Crazy thoughts")
                    view[6] -> getText(text = "first")
                    view[7] -> getText(text = "second")
                    view[8] -> getText(text = "third")
                }
            }
        }
    }

    private fun getText(text: String){
        textView.isVisible = true
        textView.text = text
    }
}