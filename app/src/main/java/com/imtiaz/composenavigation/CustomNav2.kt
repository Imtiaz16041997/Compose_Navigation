package com.imtiaz.composenavigation

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun CustomNav2(){
    val navController = rememberNavController() 
    
    NavHost(navController = navController, startDestination = "registration"){
        composable(route = "registration"){
//            RegistrationScreen(navController)
            RegistrationScreen{
                navController.navigate("main/${it}")
            }
        }


        composable(route = "login"){
            LoginScreen()
        }

        composable(route = "main/{email}", arguments = listOf(
            navArgument("email"){
                type = NavType.StringType
            }
        )){
            val email = it.arguments!!.getString("email")
            MainScreen2(email!!)
        }
    }

}


@Composable
fun RegistrationScreen(/*navController: NavController*/onClick: (email:String)-> Unit){
    Text(text = "Registration", style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.clickable {
            onClick("it@gmail.com")
        })
}

@Composable
fun LoginScreen(){
    Text(text = "Login", style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun MainScreen2(email:String){
    Text(text = "Main$email", style = MaterialTheme.typography.headlineLarge)
}

