package com.example.kotlincodetemplates.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlincodetemplates.R
import kotlinx.android.synthetic.main.fragment_code_list_display.*

class CodeListDisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code_list_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListView()
    }

    private fun initListView() {
        // defining a string array
        val catNames = arrayOf(
            "1  Ginger", "2  Badger", "3  Maurizio", "4  Murky", "5  Get off",
            "6  Tomasina", "7  Kristina", "8  Fluff", "9  Haze", "10  Length",
            "11  Kitty", "12  Masanao", "13  Simba",
            "14  Ginger", "15  Badger", "16  Maurizio", "17  Murky", "18  Get off",
            "19  Tomasina", "20  Kristina", "21  Fluff", "22  Haze", "23  Length",
            "24  Kitty", "25  Masanao", "26  Simba"
        )

        // using a data adapter
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_list_item_1, catNames
        )
        listView.setOnItemClickListener { _, _, position, _ ->
            val text = position + 1
            Toast.makeText(requireContext(), "Position $text", Toast.LENGTH_SHORT).show()
        }
        listView.adapter = adapter
    }
}