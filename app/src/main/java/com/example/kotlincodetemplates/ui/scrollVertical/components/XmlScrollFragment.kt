package com.example.kotlincodetemplates.ui.scrollVertical.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_xml_scroll.*

class XmlScrollFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_xml_scroll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("user", "code")
            findNavController().navigate(R.id.codeScrollFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("user", "xml")
            findNavController().navigate(R.id.codeScrollFragment, bundle)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("user", "start")
            findNavController().navigate(R.id.codeScrollFragment, bundle)
        }
    }
}