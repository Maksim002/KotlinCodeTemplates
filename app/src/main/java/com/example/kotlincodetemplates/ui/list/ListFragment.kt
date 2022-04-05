package com.example.kotlincodetemplates.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment  : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("list_view", "code")
            findNavController().navigate(R.id.codeListFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("list_view", "xml")
            findNavController().navigate(R.id.codeListFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.codeDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("list_view", "start")
            findNavController().navigate(R.id.codeListFragment, bundle)
        }
    }
}