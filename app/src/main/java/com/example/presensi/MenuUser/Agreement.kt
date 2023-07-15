package com.example.presensi.MenuUser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.presensi.R
import com.github.barteksc.pdfviewer.PDFView

class Agreement : AppCompatActivity() {
    lateinit var pdfView: PDFView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agreement)

        pdfView = findViewById(R.id.idPDFView)


        val assetManager = this.assets
        val inputStream = assetManager.open("kontrak_kerja.pdf")
        pdfView.fromStream(inputStream).load()


        val btn = findViewById<Button>(R.id.btnkirim)
        btn.setOnClickListener {
            val intent = Intent(this, HomeUser::class.java)
            startActivity(intent)
        }

    }
}