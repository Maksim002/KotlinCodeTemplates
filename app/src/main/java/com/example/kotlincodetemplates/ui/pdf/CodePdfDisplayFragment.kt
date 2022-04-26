package com.example.kotlincodetemplates.ui.pdf

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlincodetemplates.R
import com.rajat.pdfviewer.PdfViewerActivity
import kotlinx.android.synthetic.main.fragment_code_pdf_display.*

class CodePdfDisplayFragment : Fragment() {
    private val PERMISSION_CODE = 4040

    private val requiredPermissionList = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code_pdf_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hotelPdf.setOnClickListener {
            if (checkAndRequestPermission()){
                launchPdf(0)
            }
        }
        androidPdf.setOnClickListener {
            if (checkAndRequestPermission()){
                launchPdf(1)
            }
        }
    }

    private fun launchPdf(id: Int? = null) {
        if (id == 0){
            startActivity(
                PdfViewerActivity.Companion.launchPdfFromPath(
                    requireContext(),
                    "quote.pdf",
                    "Pdf Hotel",
                    "assets",
                    enableDownload = false,
                    fromAssets = true
                )
            )
        }else{
            startActivity(
                PdfViewerActivity.Companion.launchPdfFromPath(
                    requireContext(),
                    "android.pdf",
                    "Pdf Android",
                    "assets",
                    enableDownload = false,
                    fromAssets = true
                )
            )
        }
    }

    private fun checkAndRequestPermission(): Boolean {
        val permissionsNeeded = ArrayList<String>()

        for (permission in requiredPermissionList) {
            if (ContextCompat.checkSelfPermission(requireContext(), permission) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                permissionsNeeded.add(permission)
            }
        }

        if (permissionsNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                permissionsNeeded.toTypedArray(),
                PERMISSION_CODE
            )
            return false
        }

        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_CODE -> if (grantResults.isNotEmpty()) {
                val readPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val writePermission = grantResults[1] == PackageManager.PERMISSION_GRANTED
                if (readPermission && writePermission)
                    launchPdf()
                else {
                    Toast.makeText(requireContext(), " Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:
//    allprojects {
//        repositories {
//            ...
//            maven { url "https://jitpack.io" }
//        }
//    }
//
//    dependencies {
//        implementation 'com.github.afreakyelf:Pdf-Viewer:v1.0.7'
//    }
}