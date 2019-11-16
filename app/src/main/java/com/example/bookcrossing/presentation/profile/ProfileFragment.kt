package com.example.bookcrossing.presentation.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bookcrossing.App
import com.example.bookcrossing.entities.Table
import com.example.bookcrossing.entities.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.profile_fragment.*


class ProfileFragment : Fragment(){

    val ref = FirebaseDatabase.getInstance().reference.child(Table.USER).child(App.firebaseUser?.uid!!)
    var user: User ?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.example.bookcrossing.R.layout.profile_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                user = dataSnapshot.getValue(User::class.java)
                updateProfileUI()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("tag", "loadPost:onCancelled", databaseError.toException())
            }
        }
        ref.addListenerForSingleValueEvent(postListener)
    }

    private fun updateProfileUI() {
        nameEditText.text = user?.name
    }

}