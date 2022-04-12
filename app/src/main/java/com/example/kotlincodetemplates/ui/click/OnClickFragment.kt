package com.example.kotlincodetemplates.ui.click

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_on_click.*

class OnClickFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_click, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("recycler_view", "code")
            findNavController().navigate(R.id.codeRecyclerFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("recycler_view", "xml")
            findNavController().navigate(R.id.codeRecyclerFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.codeClickDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("recycler_view", "start")
            findNavController().navigate(R.id.codeRecyclerFragment, bundle)
        }
    }
}