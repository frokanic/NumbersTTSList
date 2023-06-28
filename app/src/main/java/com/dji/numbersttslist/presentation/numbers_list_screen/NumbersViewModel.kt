package com.dji.numbersttslist.presentation.numbers_list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibm.icu.text.RuleBasedNumberFormat
import com.ibm.icu.util.ULocale
import kotlinx.coroutines.launch

class NumbersViewModel : ViewModel() {

    private val _numbers = MutableLiveData<List<String>>()
    val numbers: LiveData<List<String>> = _numbers

    private val formatter = RuleBasedNumberFormat(ULocale.US, RuleBasedNumberFormat.SPELLOUT)

    init {
        generateNumbers()
    }

    private fun generateNumbers() = viewModelScope.launch {
        val numbersList = (0..1000).map { numberToWords(it) }
        _numbers.value = numbersList
    }

    private fun numberToWords(number: Int): String {
        return formatter.format(number)
    }
}