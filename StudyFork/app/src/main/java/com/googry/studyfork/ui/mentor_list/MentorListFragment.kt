package com.googry.studyfork.ui.mentor_list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.FirebaseFirestore
import com.googry.studyfork.R
import com.googry.studyfork.base.ui.BaseFragment
import com.googry.studyfork.base.ui.BaseRecyclerViewAdapter
import com.googry.studyfork.base.ui.BaseViewHolder
import com.googry.studyfork.data.model.Profile
import com.googry.studyfork.data.source.ProfileRepository
import com.googry.studyfork.databinding.MentorListFragmentBinding
import com.googry.studyfork.databinding.MentorListItemBinding

class MentorListFragment :
        BaseFragment<MentorListFragmentBinding>(R.layout.mentor_list_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            vm = ViewModelProviders.of(this@MentorListFragment, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                        MentorListViewModel(ProfileRepository(FirebaseFirestore.getInstance())) as T
            })[MentorListViewModel::class.java]

            setLifecycleOwner(this@MentorListFragment)

            rvContent.adapter = object : BaseRecyclerViewAdapter<Profile>() {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
                        object : BaseViewHolder<Profile, MentorListItemBinding>(
                                R.layout.mentor_list_item,
                                parent
                        ) {
                            override fun onViewCreated(item: Profile?) {
                                binding?.run {
                                    profile = item
                                }
                            }
                        }
            }
        }
    }
}