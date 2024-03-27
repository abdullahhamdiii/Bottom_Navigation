package com.hamdiiii.materialdesign

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hamdiiii.materialdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val fragment1 = OneFragment()
    val fragment2 = TwoFragment()
    val fragment3 = ThreeFragment()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initSubView()
        addNavigationListner()
    }

    private fun addNavigationListner() {
        binding.btnNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(fragment1)
                    true
                }

                R.id.noti ->{
                    replaceFragment(fragment2)
                    true
                }
                R.id.sett ->{
                    replaceFragment(fragment3)
                    true
                }
                else -> false
            }
        }
    }

    private fun initSubView() {
        addFragment(fragment1)
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.continer, fragment)
        transaction.commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.continer, fragment)
        transaction.commit()
    }
}