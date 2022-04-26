package com.example.kotlincodetemplates.ui.pdf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_pdf_file.*

class PdfFileFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pdf_file, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("pdf_view", "code")
            findNavController().navigate(R.id.codePdfFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("pdf_view", "xml")
            findNavController().navigate(R.id.codePdfFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.codePdfDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("pdf_view", "start")
            findNavController().navigate(R.id.codePdfFragment, bundle)
        }
    }
}