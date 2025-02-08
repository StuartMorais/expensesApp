package com.example.expensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.data.Repository
import com.example.expensetracker.data.Expense
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    fun addExpense(name: String, amount: Double, date: Long, type: String) {
        viewModelScope.launch {
            repository.addExpense(Expense(name = name, amount = amount, date = date, type = type))
        }
    }
}