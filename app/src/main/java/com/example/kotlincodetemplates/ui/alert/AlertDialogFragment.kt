package com.example.kotlincodetemplates.ui.alert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_alert_dialog.*

class AlertDialogFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alert_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("alert_dialog", "code")
            findNavController().navigate(R.id.codeAlertFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("alert_dialog", "xml")
            findNavController().navigate(R.id.codeAlertFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.alertDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("alert_dialog", "start")
            findNavController().navigate(R.id.codeAlertFragment, bundle)
        }
    }
}