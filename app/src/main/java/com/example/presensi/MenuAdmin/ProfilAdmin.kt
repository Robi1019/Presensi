package com.example.presensi.MenuAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presensi.LoginActivity
import com.example.presensi.R
import com.example.presensi.databinding.ActivityProfilAdminBinding
import com.example.presensi.databinding.ActivityProfilUserBinding

class ProfilAdmin : AppCompatActivity() {
    private lateinit var binding: ActivityProfilAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profil_admin)
        binding = ActivityProfilAdminBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding.btnKeluar.setOnClickListener {
//            val i = Intent(this, LoginActivity::class.java)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}