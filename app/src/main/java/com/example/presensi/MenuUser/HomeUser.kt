package com.example.presensi.MenuUser

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.presensi.R
import com.example.presensi.databinding.ActivityHomeUserBinding
import com.example.presensi.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso

class HomeUser : AppCompatActivity() {

    private var binding: ActivityHomeUserBinding? = null
    private lateinit var profil: SharedPreferences

    private var isExpanded = false

    private val fromBottomFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.from_bottom_fab)
    }
    private val toBottomFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.to_bottom_fab)
    }
    private val rotateClockWiseFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_clock_wise)
    }
    private val rotateAntiClockWiseFabAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_anti_clock_wise)
    }
    private val fromBottomBgAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)
    }
    private val toBottomBgAnim: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home_user)
        binding = ActivityHomeUserBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // assigning ID of the toolbar to a variable
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        // using toolbar as ActionBar
        setSupportActionBar(toolbar)

        profil = getSharedPreferences("login_session", MODE_PRIVATE)

        //menampilkan data profil
        binding?.IdPgw?.text = profil.getString("email", null)
        binding?.namapgw?.text = profil.getString("nama_karyawan", null)
        binding?.jabatanPgw?.text = profil.getString("id_jabatan", null)

        //menampilkan foto profil dengan picasso
        Picasso.get().load(profil.getString("foto", null)).into(binding?.imgProfil)


        binding?.cardhistori?.setOnClickListener {
            val i = Intent(this, HistoriUser::class.java)
            startActivity(i)
        }

//        binding.cardlaporan.setOnClickListener {
//            val i = Intent(this, LaporanUser::class.java)
//            startActivity(i)
//        }

        binding?.cardprofil?.setOnClickListener {
            val i = Intent(this, ProfilUser::class.java)
            startActivity(i)
        }

        binding?.mainFabBtn?.setOnClickListener {
            if (isExpanded){
                shrinkFab()
            } else {
                expandFab()
            }
        }

        binding?.izinFabBtn?.setOnClickListener {
            onIzinClicked()
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.bottom_izin, null)

            val btnClose = view.findViewById<ImageView>(R.id.cancelButton)
            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            val btnIzin = view.findViewById<Button>(R.id.btnIzin)
            btnIzin.setOnClickListener {
                Toast.makeText(this, "Presensi Izin Terkirim!", Toast.LENGTH_SHORT).show()
                val i = Intent(this, HomeUser::class.java)
                startActivity(i)
            }

            dialog.setContentView(view)
            dialog.show()
        }
        binding?.izinTv?.setOnClickListener {
            onIzinClicked()
        }

        binding?.pulangFabBtn?.setOnClickListener {
            onPulangClicked()
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.bottom_keluar, null)

            val btnClose = view.findViewById<ImageView>(R.id.cancelButton)
            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            val btnPpulang = view.findViewById<Button>(R.id.btnPpulang)
            btnPpulang.setOnClickListener {
                val i = Intent(this, HomeUser::class.java)
                startActivity(i)
            }

            dialog.setContentView(view)
            dialog.show()
        }
        binding?.pulangTv?.setOnClickListener {
            onPulangClicked()
        }

        binding?.masukFabBtn?.setOnClickListener {
            onMasukClicked()
            val dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = layoutInflater.inflate(R.layout.bottom_masuk, null)

            val btnClose = view.findViewById<ImageView>(R.id.cancelButton)
            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            val btnPmasuk = view.findViewById<Button>(R.id.btnPmasuk)
            btnPmasuk.setOnClickListener {
                val i = Intent(this, HomeUser::class.java)
                startActivity(i)
            }

            dialog.setContentView(view)
            dialog.show()
        }
        binding?.masukTv?.setOnClickListener {
            onMasukClicked()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.notif -> Toast.makeText(this, "Kamu menekan tombol notif", Toast.LENGTH_LONG).show()
        }
        return true
    }


    private fun onIzinClicked() {
        Toast.makeText(this, "Izin Clicked", Toast.LENGTH_SHORT).show()
    }

    private fun onPulangClicked() {
        Toast.makeText(this, "Presensi Pulang Clicked", Toast.LENGTH_SHORT).show()
    }

    private fun onMasukClicked() {
        Toast.makeText(this, "Presensi Masuk Clicked", Toast.LENGTH_SHORT).show()
    }

    private fun shrinkFab() {

        binding?.transparentBg?.startAnimation(toBottomBgAnim)
        binding?.mainFabBtn?.startAnimation(rotateAntiClockWiseFabAnim)
        binding?.izinFabBtn?.startAnimation(toBottomFabAnim)
        binding?.pulangFabBtn?.startAnimation(toBottomFabAnim)
        binding?.masukFabBtn?.startAnimation(toBottomFabAnim)
        binding?.izinTv?.startAnimation(toBottomFabAnim)
        binding?.pulangTv?.startAnimation(toBottomFabAnim)
        binding?.masukTv?.startAnimation(toBottomFabAnim)

        isExpanded = !isExpanded
    }

    private fun expandFab() {

        binding?.transparentBg?.startAnimation(fromBottomBgAnim)

        binding?.mainFabBtn?.startAnimation(rotateClockWiseFabAnim)
        binding?.izinFabBtn?.startAnimation(fromBottomFabAnim)
        binding?.pulangFabBtn?.startAnimation(fromBottomFabAnim)
        binding?.masukFabBtn?.startAnimation(fromBottomFabAnim)
        binding?.izinTv?.startAnimation(fromBottomFabAnim)
        binding?.pulangTv?.startAnimation(fromBottomFabAnim)
        binding?.masukTv?.startAnimation(fromBottomFabAnim)


        isExpanded = !isExpanded
    }

    override fun onBackPressed() {

        if (isExpanded) {
            shrinkFab()
        } else {
            super.onBackPressed()

        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        if (ev?.action == MotionEvent.ACTION_DOWN) {

            if (isExpanded) {
                val outRect = Rect()
                binding?.fabConstraint?.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
                    shrinkFab()
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}