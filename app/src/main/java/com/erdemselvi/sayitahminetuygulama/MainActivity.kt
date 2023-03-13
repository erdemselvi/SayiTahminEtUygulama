package com.erdemselvi.sayitahminetuygulama

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sonuc.*

class MainActivity : AppCompatActivity() ,SearchView.OnQueryTextListener{

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="Sayı Tahmin Oyunu"
        toolbar.subtitle="5 kez tahmin etme hakkı"
        toolbar.setLogo(R.drawable.ust_logo)
        toolbar.setTitleTextColor(YELLOW)
        toolbar.setSubtitleTextColor(YELLOW)

        setSupportActionBar(toolbar)

        buttonBasla.setOnClickListener {

            startActivity(Intent(this@MainActivity,TahminActivity::class.java))

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        val item=menu!!.findItem(R.id.action_ara)
        val searchView=item.actionView as SearchView

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_bilgi->{
                Toast.makeText(applicationContext,"Bilgi",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_ayarlar->{
                Toast.makeText(applicationContext,"Ayarlar",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_ekle->{
                Toast.makeText(applicationContext,"Ekle",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_cikis->{
                Toast.makeText(applicationContext,"Çıkış",Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}