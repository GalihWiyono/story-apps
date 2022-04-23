package com.example.storyapp.view.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.storyapp.R
import com.example.storyapp.databinding.ActivityAddStoryBinding
import com.example.storyapp.helper.Helper.createFileTemp
import com.example.storyapp.helper.Helper.reduceImageSize
import com.example.storyapp.helper.Helper.uriToFile
import com.example.storyapp.viewmodel.StoryViewModel
import com.example.storyapp.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

@AndroidEntryPoint
class AddStoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStoryBinding
    private val userViewModel by viewModels<UserViewModel>()
    private val storyViewModel by viewModels<StoryViewModel>()
    private lateinit var photoPath: String
    private var imgFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.addStory)

        setupPermission()
        setupAction()
        getToken()

        storyViewModel.isLoading.observe(this) {
            showLoading(it)
        }
    }

    private fun setupPermission() {
        if (!allPermissionsGrant()) {
            ActivityCompat.requestPermissions(this, PERMISSION_REQUIRED, REQUEST_CODE)
        }
    }


    private fun getToken() {
        userViewModel.getUserPreferences().observe(this) {
            if (it.token.trim() != "") {
                EXTRA_TOKEN = it.token
            }
        }
    }

    private fun setupAction() {
        if (imgFile == null) {
            Glide.with(this).load(imgFile).placeholder(R.drawable.ic_baseline_image_24)
                .fallback(R.drawable.ic_baseline_image_24).into(binding.imgUpload)
        }

        binding.apply {
            btnCamera.setOnClickListener {
                accessCamera()
            }
            btnGallery.setOnClickListener {
                accessGallery()
            }
            btnUpload.setOnClickListener {
                uploadStory()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            if (!allPermissionsGrant()) {
                Toast.makeText(this, "Silakan Berikan Permission.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun allPermissionsGrant() = PERMISSION_REQUIRED.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    private fun accessCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.resolveActivity(packageManager)

        createFileTemp(application).also {
            val photoUri: Uri =
                FileProvider.getUriForFile(this@AddStoryActivity, "com.example.storyapp", it)
            photoPath = it.absolutePath
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            launchCamera.launch(intent)
        }
    }

    private val launchCamera =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val file = File(photoPath)
                imgFile = file
                val photoResult = BitmapFactory.decodeFile(file.path)
                binding.imgUpload.setImageBitmap(photoResult)
            }
        }

    private fun accessGallery() {
        val intent = Intent().apply {
            action = Intent.ACTION_GET_CONTENT
            type = "image/*"
        }

        val imgChooser = Intent.createChooser(intent, "Choose Picture")
        launchGallery.launch(imgChooser)
    }

    private val launchGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val selectedImage: Uri = it.data?.data as Uri
                val file = uriToFile(selectedImage, this)
                imgFile = file
                binding.imgUpload.setImageURI(selectedImage)
            }
        }

    private fun uploadStory() {
        val description = binding.editDescription.text.toString()

        when {
            imgFile == null -> {
                Toast.makeText(
                    this@AddStoryActivity,
                    "Silakan masukkan berkas image/gambar.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            description.trim().isEmpty() -> {
                Toast.makeText(
                    this@AddStoryActivity,
                    "Field description tidak boleh kosong.",
                    Toast.LENGTH_SHORT
                ).show()
                binding.editDescription.error = "Field description tidak boleh kosong"
            }
            else -> {
                val file = reduceImageSize(imgFile as File)

                storyViewModel.uploadStory(EXTRA_TOKEN, description, file)

                storyViewModel.responseUpload.observe(this) { response ->
                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                    if (!response.error) {
                        val intent = Intent(this@AddStoryActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingBar.visibility = View.VISIBLE
        } else {
            binding.loadingBar.visibility = View.GONE
        }

        binding.apply {
            btnCamera.isEnabled = !isLoading
            btnUpload.isEnabled = !isLoading
            btnGallery.isEnabled = !isLoading
            editDescription.isEnabled = !isLoading
        }
    }

    companion object {
        private var EXTRA_TOKEN = "token"

        private val PERMISSION_REQUIRED = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE = 10
    }
}