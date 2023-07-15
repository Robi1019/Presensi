package com.example.presensi.MenuUser

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.presensi.LoginActivity
import com.example.presensi.R
import com.example.presensi.databinding.ActivityLoginBinding
import com.example.presensi.databinding.ActivityProfilUserBinding
import com.squareup.picasso.Picasso

class ProfilUser : AppCompatActivity() {
    private lateinit var binding: ActivityProfilUserBinding
    private lateinit var profil: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_profil_user)
        binding = ActivityProfilUserBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        profil = getSharedPreferences("login_session", MODE_PRIVATE)

        //menampilkan data profil
        binding.idname.text = profil.getString("nama_karyawan", null)
        binding.idjabatan.text = profil.getString("id_jabatan", null)
        binding.Idnik.text = profil.getString("nik", null)
        binding.idnotelp.text = profil.getString("no_telp", null)
        binding.idttl.text = profil.getString("tanggal_lahir", null)
        binding.idjk.text = profil.getString("jenkel", null)
        binding.idemail.text = profil.getString("email", null)
        binding.idalamat.text = profil.getString("alamat", null)

        Picasso.get().load(profil.getString("foto", null)).into(binding.imgprofil)

        binding.btnKeluar.setOnClickListener {
//            val i = Intent(this, LoginActivity::class.java)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}