package com.example.kotlincodetemplates.ui.menuBar

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlincodetemplates.R
import kotlinx.android.synthetic.main.fragment_code_menu_display.*

class CodeMenuDisplayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code_menu_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
        menu.add(2, 4, 4, "item4").isCheckable = true
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_mail).isVisible = checkBox2.isChecked
        menu.setGroupVisible(R.id.group1, checkBox.isChecked)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> Toast.makeText(
                requireContext(),
                getString(R.string.action_settings),
                Toast.LENGTH_LONG
            ).show()
            R.id.action_item1 -> Toast.makeText(
                requireContext(),
                getString(R.string.action_item1),
                Toast.LENGTH_LONG
            ).show()
            R.id.action_item2 -> Toast.makeText(
                requireContext(),
                getString(R.string.action_item2),
                Toast.LENGTH_LONG
            ).show()
            R.id.action_item3 -> Toast.makeText(
                requireContext(),
                getString(R.string.action_item3),
                Toast.LENGTH_LONG
            ).show()
            4 -> item.isChecked = !item.isChecked
        }
        return super.onOptionsItemSelected(item)
    }
}