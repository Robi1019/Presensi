package com.example.presensi.MenuAdmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.presensi.MenuUser.FirstFragment
import com.example.presensi.MenuUser.ViewPagerAdapter
import com.example.presensi.R
import com.example.presensi.databinding.ActivityHistoriAdminBinding
import com.example.presensi.databinding.ActivityHistoriUserBinding

class HistoriAdmin : AppCompatActivity() {

    private lateinit var binding: ActivityHistoriAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_histori_admin)
        binding = ActivityHistoriAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter= ViewPagerAdminAdapter(supportFragmentManager)
        adapter.addFragmentAdmin(FirstAdminFragment(),"First")
        adapter.addFragmentAdmin(FirstAdminFragment(),"Second")
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