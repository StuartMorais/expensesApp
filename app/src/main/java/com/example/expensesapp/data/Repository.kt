package com.example.expensetracker.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val expenseDao: ExpenseDao) {
    fun getMonthlySummaries(): Flow<List<MonthlySummary>> = expenseDao.getMonthlySummaries()

    suspend fun addExpense(expense: Expense) {
        expenseDao.insert(expense)
    }
}