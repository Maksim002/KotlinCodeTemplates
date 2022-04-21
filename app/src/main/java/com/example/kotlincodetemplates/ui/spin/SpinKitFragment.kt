package com.example.kotlincodetemplates.ui.spin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_spin_kit.*

class SpinKitFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spin_kit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("Spin_kit", "code")
            findNavController().navigate(R.id.codeSpinKitFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("Spin_kit", "xml")
            findNavController().navigate(R.id.codeSpinKitFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.displaySpinKitFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("Spin_kit", "start")
            findNavController().navigate(R.id.codeSpinKitFragment, bundle)
        }
    }
}