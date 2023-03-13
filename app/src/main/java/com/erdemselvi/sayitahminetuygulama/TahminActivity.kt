package com.erdemselvi.sayitahminetuygulama

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sonuc.*
import kotlinx.android.synthetic.main.activity_tahmin.*
import java.util.*

class TahminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        var tahmin=5
        var tahminSayisi:Int=0
        val random = Random()
        val sayi=random.nextInt(50)+1
        Log.e("mesaj","$sayi")




        buttonTahmin.setOnClickListener {
            if (!editTextTahmin.text.isEmpty()){
                tahminSayisi=editTextTahmin.text.toString().toInt()
                Log.e("tahminSayisi", "$tahminSayisi")



            if(tahminSayisi==sayi && tahmin!=0){

                val intent=Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("mesaj","doğru")
                intent.putExtra("sayi",sayi)
                finish()
                startActivity(intent)

            }
            if (tahminSayisi!=sayi && tahmin>0){
                tahmin--;
                textViewKalanHak.text="Kalan:$tahmin"
                if (tahminSayisi<sayi){
                    textViewYardım.text="Arttır"
                }
                else{
                    textViewYardım.text="Azalt"
                }
            }
            if (tahminSayisi!=sayi && tahmin==0){

                val intent=Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("mesaj","yanlış")
                intent.putExtra("sayi",sayi)
                finish()
                startActivity(intent)
            }

            editTextTahmin.setText("")
            }
            else{
                Toast.makeText(this,"Lütfen bir sayı giriniz",Toast.LENGTH_SHORT).show()
            }
        }
    }
}