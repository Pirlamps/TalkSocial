package br.com.talksocial.application

import android.app.Application
import br.com.talksocial.BuildConfig.DEBUG
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Logger

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        if (DEBUG) {
            FirebaseDatabase.getInstance().setLogLevel(Logger.Level.DEBUG)
        }
    }

}