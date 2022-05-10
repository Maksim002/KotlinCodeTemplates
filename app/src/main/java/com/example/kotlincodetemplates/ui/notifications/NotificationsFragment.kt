package com.example.kotlincodetemplates.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("push_natification", "code")
            findNavController().navigate(R.id.codeNotificationsFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("push_natification", "xml")
            findNavController().navigate(R.id.codeNotificationsFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.codeDisplayNotificationsFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("push_natification", "start")
            findNavController().navigate(R.id.codeNotificationsFragment, bundle)
        }
    }
}