package com.example.navigationgdsc.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationgdsc.R
import com.example.navigationgdsc.navigation.BottomNavigation
import com.example.navigationgdsc.navigation.NavGraph

@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               ){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        
        Text(text = "Home", fontSize = 20.sp)
        
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Home")
        }

    }
}

@Composable
fun CartScreen(modifier: Modifier =Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Cart", fontSize = 20.sp)

        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "cart")
        }

    }
}

@Composable
fun AccountScreen(modifier: Modifier =Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Account", fontSize = 20.sp)

        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "account")
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompleteScreen(modifier: Modifier =Modifier, navHostController: NavHostController = rememberNavController()){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "GDSC Android")},
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue
                ),
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription =null)
                    }
                })
        },
        bottomBar = {
            BottomNavigation(navHostController = navHostController)
        }

    ){
        paddingValues ->
        NavGraph(modifier= modifier.padding(paddingValues))
    }


}



@Composable
@Preview(showSystemUi = true, showBackground = true)
fun AccounPrev(){
    CompleteScreen()
}