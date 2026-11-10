package com.maxstudio.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxstudio.app.ui.CreateProjectScreen
import com.maxstudio.app.ui.HomeScreen
import com.maxstudio.app.ui.MaxStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaxStudioTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MaxStudioNavigation()
                }
            }
        }
    }
}

@Composable
private fun MaxStudioNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onCreateProject = { navController.navigate("create") })
        }
        composable("create") {
            CreateProjectScreen(onBack = { navController.popBackStack() })
        }
    }
}
