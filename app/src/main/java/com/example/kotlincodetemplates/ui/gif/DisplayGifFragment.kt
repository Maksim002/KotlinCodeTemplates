package com.example.kotlincodetemplates.ui.gif

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincodetemplates.R
import com.example.kotlincodetemplates.utils.com.GifLoadingView
import kotlinx.android.synthetic.main.fragment_display_gif.*

open class DisplayGifFragment : Fragment() {

    var IDS = intArrayOf(
        R.drawable.num0, R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4,
        R.drawable.num5, R.drawable.num6, R.drawable.num7, R.drawable.num8, R.drawable.num9,
        R.drawable.num10, R.drawable.num11, R.drawable.num12, R.drawable.num13, R.drawable.num14,
        R.drawable.num15, R.drawable.num16, R.drawable.num17, R.drawable.num18, R.drawable.num19,
        R.drawable.num20, R.drawable.num21, R.drawable.num22, R.drawable.num23, R.drawable.num24,
        R.drawable.num25, R.drawable.num26, R.drawable.num27, R.drawable.num28, R.drawable.num29,
        R.drawable.num30, R.drawable.num31, R.drawable.num32, R.drawable.num33, R.drawable.num34,
        R.drawable.num35, R.drawable.num36, R.drawable.num37, R.drawable.num38, R.drawable.num39,
        R.drawable.num40, R.drawable.num41, R.drawable.num42, R.drawable.num43, R.drawable.num44,
        R.drawable.num45, R.drawable.num46, R.drawable.num47, R.drawable.num48, R.drawable.num49,
        R.drawable.num50, R.drawable.num51, R.drawable.num52, R.drawable.num53, R.drawable.num54,
        R.drawable.num55, R.drawable.num56, R.drawable.num57, R.drawable.num58, R.drawable.num59,
        R.drawable.num60, R.drawable.num61, R.drawable.num62, R.drawable.num63, R.drawable.num64,
        R.drawable.num65, R.drawable.num66, R.drawable.num67, R.drawable.num68, R.drawable.num69,
        R.drawable.num70, R.drawable.num71, R.drawable.num72, R.drawable.num73, R.drawable.num74,
        R.drawable.num75, R.drawable.num76, R.drawable.num77, R.drawable.num78, R.drawable.num79,
        R.drawable.num80, R.drawable.num81, R.drawable.num82, R.drawable.num83, R.drawable.num84,
        R.drawable.num85
    )

    private var mDatas: List<String>? = null
    private var mAdapter: HomeAdapter? = null
    private var mGifLoadingView: GifLoadingView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_gif, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        mGifLoadingView = GifLoadingView()
        mAdapter =  HomeAdapter(requireContext(), mDatas!!, mGifLoadingView!!, IDS, this)
        id_recyclerview!!.adapter = mAdapter
        id_recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initData() {
        mDatas = ArrayList()
        for (i in IDS.indices) {
            (mDatas as ArrayList<String>).add("GifLoadingView : $i")
        }
    }

    internal class HomeAdapter(
        private var con: Context,
        private var mDatas: List<String>,
        private var mGifLoadingView: GifLoadingView,
        var list: IntArray,
        var fragment: Fragment
    ) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyViewHolder {
            return MyViewHolder(
                LayoutInflater.from(con).inflate(R.layout.layout_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
            with(fragment.requireActivity()) {
                holder.ImageButton.text = mDatas.get(position)
                holder.ImageButton.setOnClickListener {
                    mGifLoadingView.setImageResource(list[position])
                    mGifLoadingView.show(fragmentManager)
                }
            }

        override fun getItemCount(): Int {
            return mDatas.size
        }

        internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var ImageButton: Button = view.findViewById<View>(R.id.mButton) as Button
        }
    }
}