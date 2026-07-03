package com.example.hardwareapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hardwareapp.data.local.HardwareDatabase
import com.example.hardwareapp.data.repository.HardwareRepository
import com.example.hardwareapp.ui.screens.HardwareDetailScreen
import com.example.hardwareapp.ui.screens.HardwareListScreen
import com.example.hardwareapp.ui.screens.MainMenuScreen
import com.example.hardwareapp.ui.viewmodel.HardwareViewModel
import com.example.hardwareapp.ui.viewmodel.HardwareViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val context = LocalContext.current
                    val database = HardwareDatabase.getDatabase(context)
                    val repository = HardwareRepository(database.hardwareDao())


                    val viewModel: HardwareViewModel = viewModel(
                        factory = HardwareViewModelFactory(repository)
                    )


                    val navController = rememberNavController()


                    NavHost(navController = navController, startDestination = "main_menu") {
                        composable("main_menu") {
                            MainMenuScreen(navController, viewModel)
                        }
                        composable("list") {
                            HardwareListScreen(navController, viewModel)
                        }
                        composable(
                            route = "detail/{name}/{specs}/{desc}/{score}",
                            arguments = listOf(
                                navArgument("name") { type = NavType.StringType },
                                navArgument("specs") { type = NavType.StringType },
                                navArgument("desc") { type = NavType.StringType },
                                navArgument("score") { type = NavType.FloatType }
                            )
                        ) { backStackEntry ->

                            val name = backStackEntry.arguments?.getString("name") ?: ""
                            val specs = backStackEntry.arguments?.getString("specs") ?: ""
                            val desc = backStackEntry.arguments?.getString("desc") ?: ""
                            val score = backStackEntry.arguments?.getFloat("score") ?: 0f

                            HardwareDetailScreen(name, specs, desc, score)
                        }
                    }
                }
            }
        }
    }
}