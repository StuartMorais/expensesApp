package com.example.expensetracker.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val expenseDao: ExpenseDao) {
    fun getAvailableMonths(): Flow<List<String>> = expenseDao.getAvailableMonths()
    fun getExpensesByMonth(monthYear: String): Flow<List<Expense>> = expenseDao.getExpensesByMonth(monthYear)
    suspend fun addExpense(expense: Expense) {
        expenseDao.insert(expense)
    }
}
