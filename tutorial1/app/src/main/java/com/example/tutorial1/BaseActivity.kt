package com.example.tutorial1

import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity: AppCompatActivity() {
    abstract val binding: ViewBinding
}