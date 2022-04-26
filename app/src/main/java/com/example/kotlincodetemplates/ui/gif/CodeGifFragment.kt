package com.example.kotlincodetemplates.ui.gif

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.isVisible
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import com.example.kotlincodetemplates.models.ModelElements
import com.example.kotlincodetemplates.utils.MyConverters
import com.google.firebase.firestore.FirebaseFirestore
import com.pddstudio.highlightjs.models.Language
import com.pddstudio.highlightjs.models.Theme
import kotlinx.android.synthetic.main.fragment_code_gif.*

class CodeGifFragment : BaseFragment() {
    var url = "https://github.com/koral--/android-gif-drawable"
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_code_gif, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alertDialog.show()
        db = FirebaseFirestore.getInstance()
        db.collection("gif_view").addSnapshotListener { value, error ->
            error?.message
            val result = value!!.documents[0].toObject(ModelElements::class.java)
            val sendPicture = try {
                requireArguments().getString("gif_view")
            } catch (e: Exception) {
                ""
            }
            when (sendPicture) {
                "code" -> {
                    codeViewHighProgress.theme = Theme.ANDROID_STUDIO
                    codeViewHighProgress.highlightLanguage = Language.AUTO_DETECT
                    codeViewHighProgress.setBackgroundColor(resources.getColor(R.color.darkBlack))
                    codeViewHighProgress.setSource(MyConverters.deletingCharacters(result!!.code!!))
                    codeTextProgress.isVisible = true
                    codeViewHighProgress.isVisible = true
                }
                "xml" -> {
                    xmlViewHighProgress.theme = Theme.ANDROID_STUDIO
                    xmlViewHighProgress.highlightLanguage = Language.AUTO_DETECT
                    xmlViewHighProgress.setBackgroundColor(resources.getColor(R.color.darkBlack))
                    xmlViewHighProgress.setSource(MyConverters.deletingCharacters(result!!.xml!!))
                    xmlTextProgress.isVisible = true
                    xmlViewHighProgress.isVisible = true
                }
                "start" -> {
                    initWebView()
                }
            }

            Handler().postDelayed(Runnable { // Do something after 5s = 500ms
                alertDialog.hide()
            }, 1000)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webViewStile.isVisible = true
        // включаем поддержку JavaScript
        webViewStile.settings.javaScriptEnabled = true
        // указываем страницу загрузки
        webViewStile.loadUrl(url)

        // слушатель прогруски
        webViewStile.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                if (progress == 100) {
                    alertDialog.hide()
                } else {
                    alertDialog.show()
                }
            }
        }
        // отключение клика по ссылкам
        webViewStile.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return true
            }
        }
    }
}