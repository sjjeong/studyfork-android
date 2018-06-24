package com.googry.studyfork.data.source

import com.google.firebase.firestore.FirebaseFirestore
import com.googry.studyfork.base.source.BaseRepository
import com.googry.studyfork.const.FirestoreConst
import com.googry.studyfork.data.model.Profile


class ProfileRepository(val firestore: FirebaseFirestore) : BaseRepository(), ProfileDataSource {

    override fun getProfile(email: String, receiver: (Profile) -> Unit) {

    }


    override fun getAllMentor(recevier: (List<Profile>) -> Unit) {
        firestore.collection(FirestoreConst.COLLECTION_MENTORS)
                .get()
                .addOnCompleteListener { task ->
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