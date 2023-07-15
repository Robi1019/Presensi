package com.example.presensi.MenuAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.presensi.MenuUser.HistoriUser
import com.example.presensi.MenuUser.ProfilUser
import com.example.presensi.R
import com.example.presensi.databinding.ActivityHomeAdminBinding
import com.example.presensi.databinding.ActivityHomeUserBinding

class HomeAdmin : AppCompatActivity() {
    private lateinit var binding: ActivityHomeAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home_admin)
        binding = ActivityHomeAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // assigning ID of the toolbar to a variable
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        // using toolbar as ActionBar
        setSupportActionBar(toolbar)

        binding.cardhistori.setOnClickListener {
            val i = Intent(this, HistoriAdmin::class.java)
            startActivity(i)
        }

        binding.cardprofil.setOnClickListener {
            val i = Intent(this, ProfilAdmin::class.java)
            startActivity(i)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notif -> Toast.makeText(this, "Kamu menekan tombol notif", Toast.LENGTH_LONG)
                .show()
        }
        return true
    }
}