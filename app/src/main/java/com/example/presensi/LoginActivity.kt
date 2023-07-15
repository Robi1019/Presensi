package com.example.presensi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.presensi.MenuAdmin.HomeAdmin
import com.example.presensi.MenuUser.Agreement
import com.example.presensi.MenuUser.HomeUser
import com.example.presensi.databinding.ActivityLoginBinding
import com.example.presensi.login.model.ResponseLogin
import com.example.presensi.login.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null
//    private var user: String = ""
    private var email: String = ""
    private var pass: String = ""
    private lateinit var profil: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //cek session
        profil = getSharedPreferences("login_session", MODE_PRIVATE)
        if (profil.getString("email", null) != null){
            if (profil.getString("level", null) == "1"){
                startActivity(Intent(this@LoginActivity, HomeAdmin::class.java))
                finish()
            }else{
                startActivity(Intent(this@LoginActivity, HomeUser::class.java))
                finish()
            }
        }

        binding!!.btnLogin.setOnClickListener {
            email = binding!!.etusername.text.toString()
            pass = binding!!.etpassword.text.toString()

            when{
                email == "" ->{
                    binding!!.etusername.error = "Email tidak boleh kosong"
                }
                pass == "" ->{
                    binding!!.etpassword.error = "Pasword tidak boleh kosong"
                }
                else -> {
                    binding!!.loading.visibility = View.VISIBLE
                    getData()
                }
            }
        }

//        val btn = findViewById<Button>(R.id.btnLogin)
//        btn.setOnClickListener {
//            val intent = Intent(this, Agreement::class.java)
//            startActivity(intent)
//        }
    }

    private fun getData() {
        val api = RetrofitClient().getInstance()
        api.login(email, pass).enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>){
                if (response.isSuccessful){
                    if (response.body()?.response == true) {

                        //buat session
                        getSharedPreferences("login_session", MODE_PRIVATE)
                            .edit()
                            .putString("email", response.body()?.payload?.email)
                            .putString("nama_karyawan", response.body()?.payload?.nama_karyawan)
                            .putString("foto", response.body()?.payload?.foto)
                            .putString("id_jabatan", response.body()?.payload?.id_jabatan)
                            .apply()

                        if (response.body()?.payload?.level_user == "1") {
                            binding!!.loading.visibility = View.GONE
                            startActivity(Intent(this@LoginActivity, HomeAdmin::class.java))
                            finish()
                        } else {
                            binding!!.loading.visibility = View.GONE
                            startActivity(Intent(this@LoginActivity, HomeUser::class.java))
                            finish()
                        }
                    }else{
                        binding!!.loading.visibility = View.GONE
                        Toast.makeText(
                            this@LoginActivity,
                            "Login gagal, Periksa kembali username dan password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }else{
                    Toast.makeText(
                        this@LoginActivity,
                        "Login gagal, Terjadi kesalahan",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("Pesan error", "${t.message}")
            }
        })
    }
}