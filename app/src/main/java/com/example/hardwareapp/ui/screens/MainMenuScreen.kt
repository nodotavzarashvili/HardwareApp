package com.example.hardwareapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hardwareapp.ui.viewmodel.HardwareViewModel

@Composable
fun MainMenuScreen(navController: NavController, viewModel: HardwareViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hardware Specs App", fontSize = 28.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate("list") },
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("View CPU & GPU List")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.addSampleData() },
            modifier = Modifier.fillMaxWidth(0.6f),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text("Load Sample Hardware")
        }
    }
}