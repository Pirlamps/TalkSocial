package br.com.talksocial.timeline

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.talksocial.R

class TimelineActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, TimelineActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline)
    }
}