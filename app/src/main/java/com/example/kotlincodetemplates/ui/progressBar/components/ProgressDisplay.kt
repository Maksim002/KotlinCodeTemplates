package com.example.kotlincodetemplates.ui.progressBar.components

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_progress_display.*
import java.lang.Exception

class ProgressDisplay : BaseFragment() {
    private var progressStatus = 0
    private var handler = Handler()
    lateinit var myThread: Thread
    private var second = 2
    private var third = 5
    private var fourth = 10

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_progress_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            progressStatus = 0
            myThread = Thread {
                while (progressStatus < 100) {
                    // update progress status
                    progressStatus += 1

                    // sleep the thread for 100 milliseconds
                    Thread.sleep(100)

                    // update the progress bar
                    handler.post {
                        try {
                            progressBarFirst.progress = progressStatus
                            progressBarSecond.progress = progressStatus + second
                            progressBarThird.progress = progressStatus + third
                            progressBarFourth.progress = progressStatus + fourth
                            textView.text = "$progressStatus%"
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }
            myThread.start()
        }
    }
}