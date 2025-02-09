package com.example.expensetracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.expensetracker.ui.viewmodel.ExpenseViewModel

@Composable
fun MonthSelector(viewModel: ExpenseViewModel) {
    val availableMonths by viewModel.availableMonths.collectAsState()
    val selectedMonth by viewModel.selectedMonth.collectAsState()

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        TextButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = selectedMonth ?: "Select Month",
                modifier = Modifier.fillMaxWidth()
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            availableMonths.forEach { monthYear ->
                DropdownMenuItem(
                    text = { Text(monthYear) },
                    onClick = {
                        viewModel.selectMonth(monthYear)
                        expanded = false
                    }
                )
            }
        }
    }
}
