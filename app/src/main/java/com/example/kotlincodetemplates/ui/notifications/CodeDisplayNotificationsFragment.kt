package com.example.kotlincodetemplates.ui.notifications

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_code_display_notifications.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


class CodeDisplayNotificationsFragment : Fragment() {
    private val CHANNEL_1_ID = "channel1"
    private val CHANNEL_2_ID = "channel2"

    private var notificationManager: NotificationManagerCompat? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code_display_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationManager = NotificationManagerCompat.from(requireActivity().applicationContext)

        channelClick1.setOnClickListener {
            sendOnChannel1()
        }

        channelClick2.setOnClickListener {
            sendOnChannel2()
        }
    }

    private fun sendOnChannel1() {
        val title = edit_text_title!!.text.toString()
        val message = edit_text_message!!.text.toString()
        val notification: Notification = NotificationCompat.Builder(requireActivity().applicationContext, CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_pattern)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()
        notificationManager!!.notify(1, notification)
    }

    private fun sendOnChannel2() {
        val title = edit_text_title!!.text.toString()
        val message = edit_text_message!!.text.toString()
        val notification: Notification = NotificationCompat.Builder(requireActivity().applicationContext, CHANNEL_2_ID)
            .setSmallIcon(R.drawable.ic_pattern)
            .setContentTitle(title)
            .setContentText(message)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.ic_pattern))
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
        notificationManager!!.notify(2, notification)
    }
}