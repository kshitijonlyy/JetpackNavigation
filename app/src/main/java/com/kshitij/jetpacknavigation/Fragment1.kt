package com.kshitij.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import com.kshitij.jetpacknavigation.databinding.Fragment1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainActivity: MainActivity
    lateinit var binding: Fragment1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = Fragment1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            if (binding.txtName.text.toString().isEmpty()) {
                binding.txtName.error = "Enter Name"
                binding.txtName.requestFocus()
            } else if (binding.txtPhone.text.toString().isEmpty()) {
                binding.txtPhone.error = "Enter Phone Number"
                binding.txtPhone.requestFocus()
            } else if (binding.txtMoney.text.toString().isEmpty()) {
                binding.txtMoney.error = "Enter Amount"
                binding.txtMoney.requestFocus()
            } else if (binding.txtMoney.text.isDigitsOnly()) {
                binding.txtMoney.error = "Enter a Decimal Value"
                binding.txtMoney.requestFocus()
            } else {
                var bundle = Bundle()
                bundle.putString("name", binding.txtName.text.toString())
                bundle.putString("phone", binding.txtPhone.text.toString())
                bundle.putDouble("money", binding.txtMoney.text.toString().toDouble())

                if (binding.True.isChecked) {
                    bundle.putBoolean("bool", true)
                } else {
                    bundle.putBoolean("bool", false)
                }
                mainActivity.navController.navigate(R.id.fragment2, bundle)

            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}