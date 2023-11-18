package com.imtiaz.composenavigation

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CustomNav2(){
    val navController = rememberNavController() 
    
    NavHost(navController = navController, startDestination = "registration"){
        composable(route = "main"){
            MainScreen()
        }

        composable(route = "login"){
            LoginScreen()
        }

        composable(route = "registration"){
            RegistrationScreen(navController)
        }
    }

}


@Composable
fun RegistrationScreen(navController: NavController){
    Text(text = "Registration", style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.clickable {
            navController.navigate("login")
        })
}

@Composable
fun LoginScreen(){
    Text(text = "Login", style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun MainScreen(){
    Text(text = "Main", style = MaterialTheme.typography.headlineLarge)
}

