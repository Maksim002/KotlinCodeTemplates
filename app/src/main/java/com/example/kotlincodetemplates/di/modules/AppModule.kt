package com.example.kotlincodetemplates.di.modules

import android.content.Context
import com.example.kotlincodetemplates.base.BaseFragment
import toothpick.config.Module

class AppModule(context: Context) : Module() {

    init {
        bind(Context::class.java).toInstance(context)
        bind(BaseFragment::class.java)
    }
}