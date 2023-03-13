package com.erdemselvi.sayitahminetuygulama

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sonuc.*

class SonucActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        val gelenMesaj=intent.getStringExtra("mesaj")
        if (gelenMesaj=="doğru"){
            textViewSonuc.text="Tebrikler"
            textViewSayi.text= "Sayı= "+intent.getIntExtra("sayi",0).toString()
            imageViewSonuc.setImageResource(R.drawable.mutlu_resim)

        }
        if (gelenMesaj=="yanlış"){
            textViewSonuc.text="Kaybettiniz"
            textViewSayi.text= "Sayı= "+intent.getIntExtra("sayi",0).toString()
            imageViewSonuc.setImageResource(R.drawable.uzgun_resim)
        }

       buttonTekrar.setOnClickListener {
           val intent= Intent(this@SonucActivity,TahminActivity::class.java)
           finish()
           startActivity(intent)
       }

    }
}