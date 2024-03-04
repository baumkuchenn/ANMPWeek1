package com.misoramen.anmpweek1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.misoramen.anmpweek1.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number1 = Random.nextInt(0, 100)
        val number2 = Random.nextInt(0, 100)
        binding.txtNumber1.text = number1.toString()
        binding.txtNumber2.text = number2.toString()

        binding.btnSubmit.setOnClickListener {
            val answer = binding.txtAnswer.text.toString().toInt()
            var number1 = binding.txtNumber1.text.toString().toInt()
            var number2 = binding.txtNumber2.text.toString().toInt()
            var hasil = number1 + number2

            if (hasil == answer){
                score ++
                binding.txtAnswer.setText("")
            }
            else{
                val action = MainFragmentDirections.actionGameFragment(score)
                Navigation.findNavController(it).navigate(action)
                score = 0
            }
            number1 = Random.nextInt(0, 100)
            number2 = Random.nextInt(0, 100)
            binding.txtNumber1.text = number1.toString()
            binding.txtNumber2.text = number2.toString()
        }
    }
}