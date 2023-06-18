package com.example.tutorial1

import androidx.fragment.app.Fragment

class DialogAnimationFragment : Fragment(R.layout.animation_layout) {
    companion object {
        fun newInstance(title: String, name: String) = DialogAnimationFragment()
    }
}