package com.example.kotlincodetemplates.ui.toast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.emreesen.sntoast.SnToast
import com.emreesen.sntoast.SnToast.Custom
import com.emreesen.sntoast.Type
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_code_toast_display.*

class CodeDisplayToastFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_code_toast_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        normalToast(normalButton)
        customToast(customButton)
    }
    private fun normalToast(view: View) {
        view.setOnClickListener {
            val type = ResourcesCompat.getFont(requireContext(), R.font.example)
            SnToast.Standard()
                .context(requireContext())
                .type(Type.SUCCESS)
                .message("Success !") //.typeface(type) Optional Default: sans-serif-condensed
                //.cancelable(false or true) Optional Default: False
                // .iconSize(int size) Optional Default: 34dp
                // .textSize(int size) Optional Default 18sp
                // .animation(false or true) Optional Default: True
                // .duration(int ms) Optional Default: 3000ms
                .build()
        }
    }

    private fun customToast(view: View) {
        view.setOnClickListener {
            val type = ResourcesCompat.getFont(requireContext(), R.font.example)
            Custom()
                .context(requireContext())
                .backgroundColor(R.color.teal_200)
                .textColor(R.color.white)
                .icon(R.drawable.ic_launcher_foreground)
                .message("Custom !!!")
                .typeface(type) //.typeface(type) Optional Default: sans-serif-condensed
                //.cancelable(false or true) Optional Default: False
                // .iconSize(int size) Optional Default: 34dp
                // .textSize(int size) Optional Default 18sp
                // .animation(false or true) Optional Default: True
                // .duration(int ms) Optional Default: 3000ms
                .build()
        }
    }

//Don't forget to add the following
//    allprojects {
//        repositories {
//            ...
//            maven { url 'https://jitpack.io' }
//        }
//    }
//
//    dependencies {
//        implementation 'com.github.emreesen27:Android-Custom-Toast-Message:1.0.4'
//    }
}