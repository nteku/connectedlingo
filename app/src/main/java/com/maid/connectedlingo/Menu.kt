package com.maid.connectedlingo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavView.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.menu_item1 -> {
                    replaceFragment( Translator()) // Replace 'fragme()' with the actual Fragment you want to show
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_item2 ->                     // Handle click for Item 2
                    return@setOnNavigationItemSelectedListener true
                R.id.menu_item3 ->                     // Handle click for Item 3
                    return@setOnNavigationItemSelectedListener true
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        /*
        val fragmentManager = supportFragmentManager
        val containerId: Int =
            R.id.frameLayout // Replace with the actual ID of your FrameLayout container
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(containerId, fragment)
        fragmentTransaction.commit()

         */
    }
}