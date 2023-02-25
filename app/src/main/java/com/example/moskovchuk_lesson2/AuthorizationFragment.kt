package com.example.moskovchuk_lesson2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moskovchuk_lesson2.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {

    private var key1: String? = null
    private var key2: String? = null

    lateinit var binding: FragmentAuthorizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            key1 = it.getString(ARG_AUTHO_KEY1)
            key2 = it.getString(ARG_AUTHO_KEY2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorizationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPassword()
        changePassButton()
        checkPassword()

    }

    private fun changePassButton() {
        binding.password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.comeInButton.isEnabled = true
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun checkPassword(){
        binding.password.setOnClickListener() {
            if (binding.password.toString() == CORRECT_PASS) {
                goToMainScreen()
            } else {TODO()}
        }
    }

    private fun showPassword() {
        binding.switchForPassword.setOnClickListener{
            binding.password.isEnabled = binding.switchForPassword.isChecked
        }
    }

    private fun goToMainScreen(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .remove(this)
            .commit()
    }

    companion object {

        private const val CORRECT_PASS = "12345"
        const val ARG_AUTHO_KEY1 = "AUTHO_KEY1"
        const val ARG_AUTHO_KEY2 = "AUTHO_KEY2"

        fun newInstance() = AuthorizationFragment()

        fun newInstance(param1: String, param2: String) =
            AuthorizationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_AUTHO_KEY1, param1)
                    putString(ARG_AUTHO_KEY2, param2)
                }
            }
    }
}

