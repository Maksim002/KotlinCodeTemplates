package com.example.kotlincodetemplates.ui.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_card_view.*

class CardViewFragment  : BaseFragment() {
    private val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codeBtn.setOnClickListener {
            bundle.putString("card_view", "code")
            findNavController().navigate(R.id.codeCardFragment, bundle)
        }

        xmlBtn.setOnClickListener {
            bundle.putString("card_view", "xml")
            findNavController().navigate(R.id.codeCardFragment, bundle)
        }

        progressDisplayBtn.setOnClickListener {
            findNavController().navigate(R.id.cardDisplayFragment)
        }

        releaseBtn.setOnClickListener {
            bundle.putString("card_view", "start")
            findNavController().navigate(R.id.codeCardFragment, bundle)
        }
    }
}