package com.example.expensetracker.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.expensetracker.ui.components.MonthSelector
import com.example.expensetracker.ui.screens.ExpenseInputForm
import com.example.expensetracker.ui.screens.MonthlyExpenseList
import com.example.expensetracker.ui.viewmodel.ExpenseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ExpenseViewModel = hiltViewModel()
            Column(modifier = Modifier.padding(16.dp)) {
                ExpenseInputForm(viewModel)
                Spacer(modifier = Modifier.height(16.dp))
                MonthSelector(viewModel)
                Spacer(modifier = Modifier.height(16.dp))
                MonthlyExpenseList(viewModel)
            }
        }
    }
}
