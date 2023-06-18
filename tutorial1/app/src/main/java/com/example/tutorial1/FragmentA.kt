package com.example.tutorial1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class FragmentA: Fragment(R.layout.fragment_a) {
    companion object {
        const val KEY_NAME = "name"
        fun newInstance(name: String) = FragmentA().apply {
            val bundle = Bundle()
            bundle.putString(KEY_NAME, name)
            arguments = bundle
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = arguments?.getString(KEY_NAME) ?: ""
        Log.d("#PhucNK1 ", name)
    }
}