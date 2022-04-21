package com.example.kotlincodetemplates.ui.spin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlincodetemplates.R
import com.github.ybq.android.spinkit.style.*
import kotlinx.android.synthetic.main.fragment_dispaly_spin_kit.*


class DisplaySpinKitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dispaly_spin_kit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spin_kit1.setIndeterminateDrawable(Wave())

        spin_kit2.setIndeterminateDrawable(WanderingCubes())

        spin_kit4.setIndeterminateDrawable(ChasingDots())

        spin_kit5.setIndeterminateDrawable(ThreeBounce())

        spin_kit6.setIndeterminateDrawable(Circle())

        spin_kit7.setIndeterminateDrawable(CubeGrid())

        spin_kit8.setIndeterminateDrawable(FadingCircle())

        spin_kit9.setIndeterminateDrawable(FoldingCube())

        spin_kit10.setIndeterminateDrawable(DoubleBounce())
    }

//    Add the gradle library
//    dependencies {
//        implementation 'com.github.ybq:Android-SpinKit:1.4.0'
//    }
}