package com.example.kotlincodetemplates.ui.toast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_toast_view.*

class ToastViewFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_toast_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("code_toast", "code")
            findNavController().navigate(R.id.codeToastFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("code_toast", "xml")
            findNavController().navigate(R.id.codeToastFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.codeDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("code_toast", "start")
            findNavController().navigate(R.id.codeToastFragment, bundle)
        }
    }
}