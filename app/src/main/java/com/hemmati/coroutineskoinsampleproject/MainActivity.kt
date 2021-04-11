package com.hemmati.coroutineskoinsampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        loadFragment(VideosFragment())


    }

//    private fun loadFragment(fragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.apply {
//            add(R.id.screenContainer, fragment)
//            commit()
//        }

//    }
}