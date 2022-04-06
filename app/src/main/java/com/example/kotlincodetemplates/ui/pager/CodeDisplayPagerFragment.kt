package com.example.kotlincodetemplates.ui.pager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.ui.pager.fragment.PagerWindowFragment
import kotlinx.android.synthetic.main.fragment_code_display_pager.*

class CodeDisplayPagerFragment : Fragment() {
    private var list = mutableListOf<PagerWindowFragment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code_display_pager, container, false)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.add(PagerWindowFragment(resources.getDrawable(R.drawable.ic_second),
            "Look at everything upside down", resources.getDrawable(R.drawable.ic_second)))
        list.add(PagerWindowFragment(resources.getDrawable(R.drawable.ic_third),
            "The evening for grilled barbecue", resources.getDrawable(R.drawable.ic_third)))
        list.add(PagerWindowFragment(resources.getDrawable(R.drawable.ic_lake),
            "A place to surf", resources.getDrawable(R.drawable.ic_lake)))
        list.add(PagerWindowFragment(resources.getDrawable(R.drawable.ic_first),
            "Crazy lady", resources.getDrawable(R.drawable.ic_first)))
        list.add(PagerWindowFragment( resources.getDrawable(R.drawable.ic_road),
            "Border of two roads", resources.getDrawable(R.drawable.ic_road)))

        val adapters = PagerAdapters(childFragmentManager)
        list.forEachIndexed { _, element ->
            adapters.addFragment(element)
        }
        mViewPagers.adapter = adapters
    }
}

class PagerAdapters (fm: FragmentManager): FragmentPagerAdapter(fm){
    private val fragmentList: MutableList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
    }
}