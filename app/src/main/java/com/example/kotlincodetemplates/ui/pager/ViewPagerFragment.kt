package com.example.kotlincodetemplates.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ViewPagerFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("recycler_view", "code")
            findNavController().navigate(R.id.codePagerFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("recycler_view", "xml")
            findNavController().navigate(R.id.codePagerFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.codeDisplayPagerFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("recycler_view", "start")
            findNavController().navigate(R.id.codePagerFragment, bundle)
        }
    }
}