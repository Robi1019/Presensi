package com.example.presensi.MenuUser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.presensi.R
import com.example.presensi.databinding.ActivityHistoriUserBinding
import com.google.android.material.tabs.TabLayout

class HistoriUser : AppCompatActivity() {
//    private lateinit var tabLayout: TabLayout
//    private lateinit var viewPager2: ViewPager2

    private lateinit var binding: ActivityHistoriUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_histori_user)
        binding = ActivityHistoriUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstFragment(),"Kehadiran")
        adapter.addFragment(FirstFragment(),"Izin")
        binding.viewPager.adapter=adapter
        binding.tbLayout.setupWithViewPager(binding.viewPager)
//        tabLayout = findViewById(R.id.tabLayout)
//        viewPager2 = findViewById(R.id.viewPager2)

        // calling the action bar
        setSupportActionBar(findViewById(R.id.toolbar))
        var actionBar = getSupportActionBar()
        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    // this event will enable the back
    // function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}