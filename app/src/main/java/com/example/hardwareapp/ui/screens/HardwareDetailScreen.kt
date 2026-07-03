package com.example.hardwareapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hardwareapp.ui.components.PerformanceGauge

@Composable
fun HardwareDetailScreen(name: String, specs: String, description: String, score: Float) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Specs: $specs", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = description, style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Performance Score: ${score.toInt()}/100")
        Spacer(modifier = Modifier.height(16.dp))


        PerformanceGauge(score = score)
    }
}