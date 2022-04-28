package com.example.storyapp.view.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.example.storyapp.databinding.ActivityRegisterBinding
import com.example.storyapp.model.RegisterUser
import com.example.storyapp.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val userViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        startAnimation()
        checkUserStatus()
        setupAction()


        userViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        userViewModel.userStatus.observe(this) {
            if(!it) {
                Toast.makeText(this, "Email Sudah Digunakan, Silakan Masukan Email Lain!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkUserStatus() {
        userViewModel.getUserPreferences().observe(this) {
            if(it.token.trim() != "") {
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
    }

    private fun setupAction() {
        binding.apply {
            masukText.setOnClickListener {
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            }

            daftarBtn.setOnClickListener{
                userRegister()
            }
        }
    }


    private fun userRegister() {
        val name = binding.nameEdit.text.toString()
        val email = binding.emailEdit.text.toString()
        val password = binding.passwordEdit.text.toString()

        when{
            name.isEmpty() -> {
                binding.nameEdit.error = "Field Tidak Boleh Kosong"
            }
            email.isEmpty() -> {
                binding.emailEdit.error = "Field Tidak Boleh Kosong"
            }
            password.isEmpty() -> {
                binding.passwordEdit.error = "Field Tidak Boleh Kosong"
            }
            else -> {
                if(checkEmail(email) &&  password.length >= 6) {
                    userViewModel.userRegister(RegisterUser(name, email, password))
                } else {
                    Toast.makeText(this, "Silakan Isi Field Dengan Benar", Toast.LENGTH_SHORT).show()
                }

                userViewModel.loginResult.observe(this) {
                    if(it.token != "") {
                        userViewModel.saveUserPreference(it)
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
            daftarBtn.isEnabled = !isLoading
            masukText.isEnabled = !isLoading
            nameEdit.isEnabled = !isLoading
            emailEdit.isEnabled = !isLoading
            passwordEdit.isEnabled =!isLoading
        }
    }

    private fun startAnimation() {
        binding.apply {
            val titleText = ObjectAnimator.ofFloat(titleText, View.ALPHA, 1f).setDuration(500)
            val messageText = ObjectAnimator.ofFloat(messageText, View.ALPHA, 1f).setDuration(500)
            val nameText = ObjectAnimator.ofFloat(nameText, View.ALPHA, 1f).setDuration(500)
            val nameEdit = ObjectAnimator.ofFloat(nameEditLayout, View.ALPHA, 1f).setDuration(500)
            val emailText = ObjectAnimator.ofFloat(emailText, View.ALPHA, 1f).setDuration(500)
            val emailEdit = ObjectAnimator.ofFloat(emailEditLayout, View.ALPHA, 1f).setDuration(500)
            val passwordText = ObjectAnimator.ofFloat(passwordText, View.ALPHA, 1f).setDuration(500)
            val passwordEdit = ObjectAnimator.ofFloat(passwordEditLayout, View.ALPHA, 1f).setDuration(500)
            val loginBtn = ObjectAnimator.ofFloat(daftarBtn, View.ALPHA, 1f).setDuration(500)
            val masukMessage = ObjectAnimator.ofFloat(masukMessage, View.ALPHA, 1f).setDuration(500)
            val masukText = ObjectAnimator.ofFloat(masukText, View.ALPHA, 1f).setDuration(500)

            AnimatorSet().apply {
                playSequentially(titleText, messageText, nameText, nameEdit, emailText, emailEdit, passwordText, passwordEdit, loginBtn, masukMessage, masukText)
                startDelay = 500
            }.start()
        }
    }

    private fun checkEmail(email : String) : Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
