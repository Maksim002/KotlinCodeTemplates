package com.example.kotlincodetemplates.ui.alert

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.developer.kalert.KAlertDialog
import com.example.kotlincodetemplates.R
import kotlinx.android.synthetic.main.fragment_alert_display.*


class AlertDisplayFragment : Fragment(), View.OnClickListener {

    private var i = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basic_test.setOnClickListener(this)
        under_text_test.setOnClickListener(this)
        error_text_test.setOnClickListener(this)
        success_text_test.setOnClickListener(this)
        warning_confirm_test.setOnClickListener(this)
        warning_cancel_test.setOnClickListener(this)
        custom_img_test.setOnClickListener(this)
        progress_dialog.setOnClickListener(this)

        checkbox1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.basic_test ->{
                val sd = KAlertDialog(requireContext())
                sd.titleText = "Title"
                sd.contentText = "Content"
                sd.confirmText = "Ok"
                sd.setCancelable(true)
                sd.setCanceledOnTouchOutside(true)
                sd.show()
            }
            R.id.under_text_test ->{
                KAlertDialog(requireContext())
                    .setTitleText("Title Text")
                    .setContentText("Hello")
                    .setConfirmText("Ok")
                    .show()
            }
            R.id.error_text_test ->{
                KAlertDialog(requireContext(), KAlertDialog.ERROR_TYPE)
                    .setTitleText("Opps.")
                    .setContentText("Something went wrong!")
                    .setConfirmText("Ok")
                    .show()
            }
            R.id.success_text_test ->{
                KAlertDialog(requireContext(), KAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("You clicked the button!")
                    .setConfirmText("Ok")
                    .show()
            }
            R.id.warning_confirm_test ->{
                KAlertDialog(requireContext(), KAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("Won't be able to recover this file!")
                    .setConfirmText("Yes,delete it!")
                    .setConfirmClickListener { sDialog ->
                        sDialog.setTitleText("Deleted!")
                            .setContentText("Your imaginary file has been deleted!")
                            .setConfirmText("OK")
                            .setConfirmClickListener(null)
                            .changeAlertType(KAlertDialog.SUCCESS_TYPE)
                    }
                    .show()
            }
            R.id.warning_cancel_test ->{
                KAlertDialog(requireContext(), KAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("Won't be able to recover this file!")
                    .setCancelText("No,cancel plx!")
                    .setConfirmText("Yes,delete it!")
                    .showCancelButton(true)
                    .setCancelClickListener { sDialog ->
                        sDialog.setTitleText("Cancelled!")
                            .setContentText("Your imaginary file is safe :)")
                            .setConfirmText("OK")
                            .showCancelButton(false)
                            .setCancelClickListener(null)
                            .setConfirmClickListener(null)
                            .changeAlertType(KAlertDialog.ERROR_TYPE)
                    }
                    .setConfirmClickListener { sDialog ->
                        sDialog
                            .setConfirmText("OK")
                            .showCancelButton(false)
                            .setCancelClickListener(null)
                            .setConfirmClickListener(null)
                            .changeAlertType(KAlertDialog.SUCCESS_TYPE)
                    }
                    .show()
            }
            R.id.custom_img_test ->{
                KAlertDialog(requireContext(), KAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("KAlertDialog")
                    .setContentText("Here's a custom image.")
                    .setCustomImage(R.mipmap.ic_launcher, requireContext())
                    .setConfirmText("OK")
                    .show();
            }
            R.id.progress_dialog ->{
                val pDialog = KAlertDialog(requireContext(), KAlertDialog.PROGRESS_TYPE)
                    .setTitleText("Loading")
                pDialog.show()
                pDialog.setCancelable(false)
                object : CountDownTimer(800 * 7, 800) {
                    override fun onTick(millisUntilFinished: Long) {
                        i++
                        when (i) {
                            0 -> pDialog.progressHelper.barColor = ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                            1 -> pDialog.progressHelper.barColor = ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                            2, 6 -> pDialog.progressHelper.barColor = ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                            3 -> pDialog.progressHelper.barColor = ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                            4 -> pDialog.progressHelper.barColor = ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                            5 -> pDialog.progressHelper.barColor = ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                        }
                    }

                    override fun onFinish() {
                        i = -1
                        pDialog.setTitleText("Success!")
                            .setConfirmText("OK")
                            .changeAlertType(KAlertDialog.SUCCESS_TYPE)
                    }
                }.start()
            }
            R.id.checkbox1 -> KAlertDialog.DARK_STYLE = (v as CheckBox).isChecked
        }
    }
}