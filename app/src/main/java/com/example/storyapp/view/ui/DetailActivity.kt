package com.example.storyapp.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.storyapp.R
import com.example.storyapp.databinding.ActivityDetailBinding
import com.example.storyapp.model.ListStoryItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.detailStory)
        val storyData = intent.getParcelableExtra<ListStoryItem>(STORY_DATA) as ListStoryItem

        setDataView(storyData)
    }

    private fun setDataView(storyData: ListStoryItem) {
        binding.apply {
            tvName.text = storyData.name
            tvDate.text = storyData.createdAt
            tvDescription.text = storyData.description
            tvId.text = storyData.id
            Glide.with(this@DetailActivity).load(storyData.photoUrl).into(imgPicture)
        }
    }

    companion object {
        const val STORY_DATA = "STORY_DATA"
    }
}