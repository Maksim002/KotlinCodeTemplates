package com.example.kotlincodetemplates.ui.swipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_swipe.*

class SwipeFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_swipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("swipe_view", "code")
            findNavController().navigate(R.id.codeSwipeFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("swipe_view", "xml")
            findNavController().navigate(R.id.codeSwipeFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.displaySwipeFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("swipe_view", "start")
            findNavController().navigate(R.id.codeSwipeFragment, bundle)
        }
    }
}