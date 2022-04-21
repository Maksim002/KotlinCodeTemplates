package com.example.kotlincodetemplates.ui.shimmer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_shimmer.*

class ShimmerFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shimmer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("shimmer_view", "code")
            findNavController().navigate(R.id.codeShimmerFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("shimmer_view", "xml")
            findNavController().navigate(R.id.codeShimmerFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.shimmerDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("shimmer_view", "start")
            findNavController().navigate(R.id.codeShimmerFragment, bundle)
        }
    }
}