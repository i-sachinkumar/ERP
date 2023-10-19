package com.ihrsachin.apostle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import com.ihrsachin.apostle.interfaces.BackPressed

class MainActivity : AppCompatActivity(), BackPressed{
    lateinit var mainViewModel: MainViewModel
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        mainViewModel.mDrawerLayout = findViewById(R.id.drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, mainViewModel.mDrawerLayout, R.string.nav_open, R.string.nav_close)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        mainViewModel.mDrawerLayout!!.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navigationView : NavigationView = findViewById(R.id.navigation_view)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item1 -> {
                    if (mainViewModel.mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                        mainViewModel.mDrawerLayout!!.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.item2 -> {
                    if (mainViewModel.mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                        mainViewModel.mDrawerLayout!!.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                else -> {
                    if (mainViewModel.mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                        mainViewModel.mDrawerLayout!!.closeDrawer(GravityCompat.START)
                    }
                    false
                }
            }
        }
    }


    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}