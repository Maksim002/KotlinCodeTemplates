package com.example.kotlincodetemplates.ui.menuBar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("menu_view", "code")
            findNavController().navigate(R.id.codeMenuFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("menu_view", "xml")
            findNavController().navigate(R.id.codeMenuFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.codeMenuDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("menu_view", "start")
            findNavController().navigate(R.id.codeMenuFragment, bundle)
        }
    }
}