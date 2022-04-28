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
import com.example.storyapp.databinding.ActivityLoginBinding
import com.example.storyapp.helper.wrapEspressoIdleResource
import com.example.storyapp.model.LoginUser
import com.example.storyapp.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val userViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        startAnimation()
        setupAction()
        checkUserStatus()

        userViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        userViewModel.userStatus.observe(this) {
            if (!it) {
                Toast.makeText(this, "Email atau Password Salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkUserStatus() {
        userViewModel.getUserPreferences().observe(this) {
            if (it.token.trim() != "") {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
    }

    private fun setupAction() {
        binding.apply {
            daftarText.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
            masukBtn.setOnClickListener {
                userLogin()
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
            masukBtn.isEnabled = !isLoading
            daftarText.isEnabled = !isLoading
            emailEdit.isEnabled = !isLoading
            passwordEdit.isEnabled = !isLoading
        }
    }


    private fun userLogin() {
        val email = binding.emailEdit.text.toString()
        val password = binding.passwordEdit.text.toString()

        when {
            email.isEmpty() -> {
                binding.emailEdit.error = "Field Tidak Boleh Kosong"
            }
            password.isEmpty() -> {
                binding.passwordEdit.error = "Field Tidak Boleh Kosong"
            }
            else -> {
                if(checkEmail(email) &&  password.length >= 6) {
                    userViewModel.userLogin(LoginUser(email, password))
                } else {
                    Toast.makeText(this, "Silakan Isi Field Dengan Benar", Toast.LENGTH_SHORT).show()
                }

                userViewModel.loginResult.observe(this) {
                    userViewModel.saveUserPreference(it)
                }
            }
        }

    }

    private fun startAnimation() {
        binding.apply {
            val titleText = ObjectAnimator.ofFloat(titleText, View.ALPHA, 1f).setDuration(500)
            val messageText = ObjectAnimator.ofFloat(messageText, View.ALPHA, 1f).setDuration(500)
            val emailText = ObjectAnimator.ofFloat(emailText, View.ALPHA, 1f).setDuration(500)
            val emailEdit = ObjectAnimator.ofFloat(emailEditLayout, View.ALPHA, 1f).setDuration(500)
            val passwordText = ObjectAnimator.ofFloat(passwordText, View.ALPHA, 1f).setDuration(500)
            val passwordEdit =
                ObjectAnimator.ofFloat(passwordEditLayout, View.ALPHA, 1f).setDuration(500)
            val loginBtn = ObjectAnimator.ofFloat(masukBtn, View.ALPHA, 1f).setDuration(500)
            val daftarMessage =
                ObjectAnimator.ofFloat(daftarMessage, View.ALPHA, 1f).setDuration(500)
            val daftarText = ObjectAnimator.ofFloat(daftarText, View.ALPHA, 1f).setDuration(500)

            AnimatorSet().apply {
                playSequentially(
                    titleText,
                    messageText,
                    emailText,
                    emailEdit,
                    passwordText,
                    passwordEdit,
                    loginBtn,
                    daftarMessage,
                    daftarText
                )
                startDelay = 500
            }.start()
        }
    }

    private fun checkEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}