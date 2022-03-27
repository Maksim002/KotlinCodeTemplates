package com.example.kotlincodetemplates.ui.scrollVertical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_scroll_view.*

class ScrollHorizontal : BaseFragment(){
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scroll_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("scroll_horizontal", "code")
            findNavController().navigate(R.id.codeScrollHorizontalFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("scroll_horizontal", "xml")
            findNavController().navigate(R.id.codeScrollHorizontalFragment, bundle)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("scroll_horizontal", "start")
            findNavController().navigate(R.id.codeScrollHorizontalFragment, bundle)
        }
    }
}