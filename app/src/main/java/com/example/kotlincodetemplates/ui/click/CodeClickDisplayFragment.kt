package com.example.kotlincodetemplates.ui.click

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_code_click_display.*

class CodeClickDisplayFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_code_click_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            layoutResult.isVisible = true
            layoutTransition.isVisible = false
            resultText.text = etPersonnelNumber.text
            resultEdit.setText("")
            layoutGeneral.setBackgroundColor(resources.getColor(R.color.light_green_color))
        }

        buttonResult.setOnClickListener {
            layoutResult.isVisible = false
            layoutTransition.isVisible = true
            transitionText.text = resultEdit.text
            etPersonnelNumber.setText("")
            layoutGeneral.setBackgroundColor(resources.getColor(R.color.blue_color))
        }
    }
}