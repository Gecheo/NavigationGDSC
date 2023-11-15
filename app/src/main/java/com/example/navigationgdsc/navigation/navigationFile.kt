package com.example.navigationgdsc.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navigationgdsc.R
import com.example.navigationgdsc.screens.AccountScreen
import com.example.navigationgdsc.screens.CartScreen
import com.example.navigationgdsc.screens.HomeScreen

sealed class NavigationClass (val label :String, val icon:Int, val route:String){
    object Home:NavigationClass(label = "Home", icon = R.drawable.baseline_home_24,"home")
    object Cart:NavigationClass(label = "Cart", icon = R.drawable.baseline_shopping_cart_24,"cart")
    object Account:NavigationClass(label = "Account", icon = R.drawable.baseline_person_3_24,"account")
}

@Composable
fun NavGraph(modifier:Modifier = Modifier,navHostController: NavHostController = rememberNavController()){

    NavHost(navController = navHostController, startDestination = NavigationClass.Home.route ){
        composable(route =NavigationClass.Home.route ){
            HomeScreen()
        }
        composable(route =NavigationClass.Cart.route ){
            CartScreen()
        }
        composable(route =NavigationClass.Account.route ){
            AccountScreen()
        }

    }

}


@Composable
fun BottomNavigation(modifier:Modifier = Modifier,navHostController: NavHostController ){
    val screenList = listOf(
        NavigationClass.Home,NavigationClass.Cart,NavigationClass.Account
    )

    NavigationBar(
        containerColor = Color.Black
    ) {

        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screenList.forEach {
            item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                          navHostController.navigate(item.route){
                              navHostController.graph.startDestinationRoute.let{
                                  route ->
                                  if (route != null) {
                                      popUpTo(route){
                                          saveState = true
                                      }
                                  }
                              }
                          }
                },
                icon = {
                    Icon(painter = painterResource(id = item.icon),
                        contentDescription = null,
                        tint = Color.White)
                })
        }


    }


}
