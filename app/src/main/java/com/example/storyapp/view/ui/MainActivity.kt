package com.example.storyapp.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storyapp.R
import com.example.storyapp.databinding.ActivityMainBinding
import com.example.storyapp.view.adapter.LoadingPagingAdapter
import com.example.storyapp.view.adapter.StoryListAdapter
import com.example.storyapp.viewmodel.StoryViewModel
import com.example.storyapp.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel by viewModels<UserViewModel>()
    private val storyViewModel by viewModels<StoryViewModel>()
    private lateinit var storiesAdapter: StoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.story_title)

        setupAdapter()
        setupAction()
        checkUserStatus()

        storyViewModel.isLoading.observe(this) {
            showLoading(it)
        }
    }

    private fun checkUserStatus() {
        userViewModel.getUserPreferences().observe(this) {
            if (it.token.trim() == "") {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            } else {
                setupData()
            }
        }
    }

    private fun setupAction() {
        binding.fabAddStory.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddStoryActivity::class.java))
        }
    }

    private fun setupAdapter() {
        storiesAdapter = StoryListAdapter()
        binding.rvStory.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvStory.adapter = storiesAdapter.withLoadStateFooter(
            footer = LoadingPagingAdapter {
                storiesAdapter.retry()
            }
        )
    }

    private fun setupData() {
        storyViewModel.allStory.observe(this) { pagingData ->
            storiesAdapter.submitData(lifecycle, pagingData)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.action_bar_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logoutUser()
                true
            }
            R.id.action_maps -> {
                startActivity(Intent(this@MainActivity, MapsActivity::class.java))
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
             }
        }
    }

    private fun logoutUser() {
        userViewModel.clearUserPreference()
        checkUserStatus()
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingBar.visibility = View.VISIBLE
        } else {
            binding.loadingBar.visibility = View.GONE
        }
    }
}