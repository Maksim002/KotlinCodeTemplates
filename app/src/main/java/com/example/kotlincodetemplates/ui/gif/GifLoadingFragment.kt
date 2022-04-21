package com.example.kotlincodetemplates.ui.gif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_shimmer.*

class GifLoadingFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gif_loading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("shimmer_view", "code")
            findNavController().navigate(R.id.codeGifFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("shimmer_view", "xml")
            findNavController().navigate(R.id.codeGifFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.displayGifFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("shimmer_view", "start")
            findNavController().navigate(R.id.codeGifFragment, bundle)
        }
    }
}