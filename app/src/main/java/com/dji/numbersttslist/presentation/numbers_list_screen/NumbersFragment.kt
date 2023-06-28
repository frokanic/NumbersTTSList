package com.dji.numbersttslist.presentation.numbers_list_screen

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dji.numbersttslist.databinding.FragmentNumbersBinding
import java.util.*

class NumbersFragment : Fragment() {

    private val viewModel: NumbersViewModel by viewModels()
    private var _binding: FragmentNumbersBinding? = null
    private val binding get() = _binding!!
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var adapter: NumberListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumbersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textToSpeech = TextToSpeech(requireContext()) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech.language = Locale.US
            }
        }

        adapter = NumberListAdapter(textToSpeech)

        binding.recyclerView.adapter = adapter

        viewModel.numbers.observe(viewLifecycleOwner) { numbers ->
            adapter.submitList(numbers)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        textToSpeech.shutdown()
    }
}
