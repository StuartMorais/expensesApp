package com.example.expensetracker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insert(expense: Expense)

    @Query("SELECT * FROM expenses WHERE strftime('%m/%Y', date/1000, 'unixepoch') = :monthYear")
    fun getExpensesForMonth(monthYear: String): Flow<List<Expense>>

    @Query("SELECT strftime('%m/%Y', date/1000, 'unixepoch') as monthYear, SUM(amount) as total FROM expenses GROUP BY monthYear")
    fun getMonthlySummaries(): Flow<List<MonthlySummary>>
}