package com.example.expensetracker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense)

    @Query("SELECT strftime('%Y-%m', datetime(date / 1000, 'unixepoch')) AS monthYear FROM expenses GROUP BY monthYear ORDER BY monthYear DESC")
    fun getAvailableMonths(): Flow<List<String>>

    @Query("SELECT * FROM expenses WHERE strftime('%Y-%m', datetime(date / 1000, 'unixepoch')) = :monthYear ORDER BY date DESC")
    fun getExpensesByMonth(monthYear: String): Flow<List<Expense>>
}
