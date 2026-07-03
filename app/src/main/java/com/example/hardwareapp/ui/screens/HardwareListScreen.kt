package com.example.hardwareapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hardwareapp.ui.viewmodel.HardwareViewModel

@Composable
fun HardwareListScreen(navController: NavController, viewModel: HardwareViewModel) {
    val hardwareList by viewModel.hardwareList.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(hardwareList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        navController.navigate("detail/${item.name}/${item.specs}/${item.description}/${item.performanceScore}")
                    },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {

                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = item.imageResId),
                        contentDescription = "Hardware Image",
                        modifier = Modifier.size(64.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(text = item.name, style = MaterialTheme.typography.titleLarge)
                        Text(text = "Type: ${item.type}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}