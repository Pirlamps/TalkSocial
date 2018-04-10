package br.com.talksocial.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginViewModel : ViewModel() {

    val authUser : MutableLiveData<FirebaseUser?> = MutableLiveData()
    val authError : MutableLiveData<String?> = MutableLiveData()
    val auth = FirebaseAuth.getInstance()

    init {
        authUser.postValue(auth.currentUser)
    }

    fun signIn(email:String, password:String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                Log.d("SignIn:", "Success")
                authUser.postValue(auth.currentUser)
            }else{
                Log.d("SignIn:", "Failed")
                authError.postValue(it.exception?.localizedMessage)
            }
        }
    }

}