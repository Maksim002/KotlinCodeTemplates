package com.example.kotlincodetemplates.ui.scrollVertical.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import com.pddstudio.highlightjs.models.Language
import com.pddstudio.highlightjs.models.Theme
import kotlinx.android.synthetic.main.fragment_code_scroll.*

class CodeScrollFragment : BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_code_scroll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //change theme and set language to auto detect
        codeViewHigh.theme = Theme.ANDROID_STUDIO
        codeViewHigh.highlightLanguage = Language.AUTO_DETECT
        codeViewHigh.setSource(" //change theme and set language to auto detect\n" +
                "        codeViewHigh.theme = Theme.ANDROID_STUDIO\n" +
                "        codeViewHigh.highlightLanguage = Language.AUTO_DETECT\n" +
                "        codeViewHigh.setSource(\"\")")

        //change theme and set language to auto detect
        xmlViewHigh.theme = Theme.ANDROID_STUDIO
        xmlViewHigh.highlightLanguage = Language.AUTO_DETECT
        xmlViewHigh.setSource("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:orientation=\"vertical\"\n" +
                "    android:layout_height=\"match_parent\">\n" +
                "\n" +
                "    <com.pddstudio.highlightjs.HighlightJsView\n" +
                "        android:id=\"@+id/codeViewHigh\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"match_parent\" />\n" +
                "\n" +
                "    <com.pddstudio.highlightjs.HighlightJsView\n" +
                "        android:id=\"@+id/xmlViewHigh\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"match_parent\" />\n" +
                "</LinearLayout>")
    }
}