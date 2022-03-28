package com.example.kotlincodetemplates.ui.progressBar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_progress_bar.*
import kotlinx.android.synthetic.main.fragment_scroll_view.*
import kotlinx.android.synthetic.main.fragment_scroll_view.codeBtn
import kotlinx.android.synthetic.main.fragment_scroll_view.releaseBtn
import kotlinx.android.synthetic.main.fragment_scroll_view.xmlBtn

class ProgressBar: BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_progress_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("progress_bar", "code")
            findNavController().navigate(R.id.codeProgressBarFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("progress_bar", "xml")
            findNavController().navigate(R.id.codeProgressBarFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.progressDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("progress_bar", "start")
            findNavController().navigate(R.id.codeProgressBarFragment, bundle)
        }
    }
}