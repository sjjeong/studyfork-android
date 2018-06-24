package com.googry.studyfork.data.source

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.googry.studyfork.base.source.BaseRepository
import com.googry.studyfork.const.FirestoreConst
import com.googry.studyfork.data.model.Profile


class ProfileRepository(val firestore: FirebaseFirestore) : BaseRepository(), ProfileDataSource {

    init {
        val profile = Profile("https://raw.githubusercontent.com/sjjeong/studyfork-android/profile/profile/sjjeong1225%40gmail.com.jpg",
                "정석준", "sjjeong1225@gmail.com", "01099881129", "Coinone", "Android Developer", "2년차 안드로이드 네이티브 앱 개발자 입니다.")

        firestore.collection("mentors").document(profile.email)
                .set(profile)
                .addOnSuccessListener {
                    Log.d("googry", "DocumentSnapshot added with ID: $it")
                }
                .addOnFailureListener {
                    Log.w("googry", "Error adding document", it)
                }
    }

    override fun getProfile(email: String, receiver: (Profile) -> Unit) {

    }


    override fun getAllMentor(recevier: (List<Profile>) -> Unit) {
        firestore.collection(FirestoreConst.COLLECTION_MENTORS)
                .get()
                .addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        val results = mutableListOf<Profile>()
                        task.result.forEach {
                            results.add(it.toObject(Profile::class.java))
                        }
                        recevier.invoke(results)
                    }
                }
    }
}