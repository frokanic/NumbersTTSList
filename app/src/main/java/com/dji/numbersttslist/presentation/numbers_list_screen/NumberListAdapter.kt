package com.dji.numbersttslist.presentation.numbers_list_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import android.speech.tts.TextToSpeech
import androidx.recyclerview.widget.RecyclerView
import com.dji.numbersttslist.databinding.ItemNumberBinding

class NumberListAdapter(
    private val textToSpeech: TextToSpeech
) : RecyclerView.Adapter<NumberListAdapter.NumberViewHolder>() {

    private var numbers: List<String> = listOf()

    fun submitList(numbers: List<String>) {
        this.numbers = numbers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = ItemNumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(numbers[position])
    }

    override fun getItemCount() = numbers.size

    inner class NumberViewHolder(private val binding: ItemNumberBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(number: String) {
            binding.tvNumberName.text = number
            binding.btnPlay.setOnClickListener {
                textToSpeech.speak(number, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
    }
}
