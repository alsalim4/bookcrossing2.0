package com.example.bookcrossing.presentation.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bookcrossing.App
import com.example.bookcrossing.base.BaseViewModel
import com.example.bookcrossing.entities.Table
import com.example.bookcrossing.entities.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileViewModel() : BaseViewModel() {
    val profilelivedata = MutableLiveData<User>()
    val ref = FirebaseDatabase.getInstance().reference.child(Table.USER).child(App.firebaseUser?.uid!!)

    fun onViewInitizialized(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                profilelivedata.value = dataSnapshot.getValue(User::class.java)
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("tag", "loadPost:onCancelled", databaseError.toException())
            }
        }
        ref.addListenerForSingleValueEvent(postListener)
    }
}