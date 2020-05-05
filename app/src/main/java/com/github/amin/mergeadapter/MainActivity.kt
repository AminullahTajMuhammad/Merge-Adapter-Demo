package com.github.amin.mergeadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.MergeAdapter
import com.github.amin.mergeadapter.adapters.FeedAdapter
import com.github.amin.mergeadapter.adapters.MediaAdapter
import com.github.amin.mergeadapter.adapters.ProfileAdapter
import com.github.amin.mergeadapter.models.FeedModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list = arrayListOf<FeedModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileAdapter = ProfileAdapter(this)
        val mediaAdapter = MediaAdapter(this)

        addDummyData()
        val feedAdapter = FeedAdapter(this, list)

        recycler.apply {
            adapter = MergeAdapter(profileAdapter, mediaAdapter, feedAdapter)
        }
    }

    private fun addDummyData() {
        list.add(FeedModel(R.drawable.one, "username", R.drawable.four))
        list.add(FeedModel(R.drawable.two, "my_user", R.drawable.three))
        list.add(FeedModel(R.drawable.three, "user_one", R.drawable.two))
        list.add(FeedModel(R.drawable.four, "user.me", R.drawable.one))
    }
}