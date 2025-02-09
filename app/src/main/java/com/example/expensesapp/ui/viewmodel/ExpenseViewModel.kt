package com.example.expensetracker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracker.data.Repository
import com.example.expensetracker.data.Expense
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _selectedMonth = MutableStateFlow<String?>(null)
    val selectedMonth: StateFlow<String?> = _selectedMonth

    val availableMonths: StateFlow<List<String>> = repository.getAvailableMonths()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val expensesForSelectedMonth: StateFlow<List<Expense>> = selectedMonth
        .filterNotNull()
        .flatMapLatest { monthYear ->
            repository.getExpensesByMonth(monthYear)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun selectMonth(monthYear: String) {
        _selectedMonth.value = monthYear
    }

    fun addExpense(name: String, amount: Double, date: Long, type: String) {
        viewModelScope.launch {
            repository.addExpense(Expense(name = name, amount = amount, date = date, type = type))
        }
    }
}
