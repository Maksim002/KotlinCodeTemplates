package com.example.kotlincodetemplates.ui.scrollVertical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_scroll_view.*

class ScrollVerticalFragment : BaseFragment(){
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
            bundle.putString("scroll_vertical", "code")
            findNavController().navigate(R.id.codeScrollVerticalFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("scroll_vertical", "xml")
            findNavController().navigate(R.id.codeScrollVerticalFragment, bundle)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("scroll_vertical", "start")
            findNavController().navigate(R.id.codeScrollVerticalFragment, bundle)
        }

        displayBtn.setOnClickListener {
            findNavController().navigate(R.id.scrollDisplayFragment, bundle)
        }
    }
}