package com.example.kotlincodetemplates.ui.scrollVertical.components

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import com.example.kotlincodetemplates.models.ModelElements
import com.example.kotlincodetemplates.utils.MyConverters.deletingCharacters
import com.google.firebase.firestore.FirebaseFirestore
import com.pddstudio.highlightjs.models.Language
import com.pddstudio.highlightjs.models.Theme
import kotlinx.android.synthetic.main.fragment_code_scroll.*


class CodeScrollFragment : BaseFragment(){
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_code_scroll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alertDialog.show()
        db = FirebaseFirestore.getInstance()
        db.collection("user").addSnapshotListener { value, error ->
            error?.message
            val result = value!!.documents[0].toObject(ModelElements::class.java)
            val sendPicture = try {
                requireArguments().getString("user")
            } catch (e: Exception) {
                ""
            }
            if (sendPicture == "code"){
                codeText.isVisible = true
                codeViewHigh.isVisible = true
                codeViewHigh.theme = Theme.ANDROID_STUDIO
                codeViewHigh.highlightLanguage = Language.AUTO_DETECT
                codeViewHigh.setBackgroundColor(resources.getColor(R.color.darkBlack))
                codeViewHigh.setSource(deletingCharacters(result!!.code!!))
            }else if (sendPicture == "xml"){
                xmlText.isVisible = true
                xmlViewHigh.isVisible = true
                xmlViewHigh.theme = Theme.ANDROID_STUDIO
                xmlViewHigh.highlightLanguage = Language.AUTO_DETECT
                xmlViewHigh.setBackgroundColor(resources.getColor(R.color.darkBlack))
                xmlViewHigh.setSource(deletingCharacters(result!!.xml!!))
            }else if (sendPicture == "start"){
                scrollView.isVisible = true
            }

            Handler().postDelayed(Runnable { // Do something after 5s = 500ms
                alertDialog.hide()
            }, 1000)
        }
    }
}