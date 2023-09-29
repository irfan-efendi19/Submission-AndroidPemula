package com.dicoding.ngaos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvJudul = findViewById<TextView>(R.id.textJudul)
        val tvDesc = findViewById<TextView>(R.id.textDesc)
        val ivTokoh = findViewById<ImageView>(R.id.img_photo)
        val tvJabatan = findViewById<TextView>(R.id.textJabatan)
        val data = intent.getParcelableExtra<Hero>("DATAKIAI")

        tvJudul.text = data?.name
        tvDesc.text = data?.description
        tvJabatan.text = data?.data_jabatan
        data?.photo?.let { Picasso.get().load(it).into(ivTokoh) }

        fun share() {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    tvJudul.text.toString() + "\n\n" + tvDesc.text.toString() + "\n"
                )
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        findViewById<Button>(R.id.shareButton).apply {
            setOnClickListener {
                share()
            }
        }

    }


    companion object {
        const val DATAKIAI = "DATAKIAI"
    }

}