package com.example.examendadubay

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Pantallas(){
    Login,
    Principal
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Materiasl 3") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),

                navigationIcon = {/*
                    IconButton(onClick = {  }) {   NO ME FUNCIONA LA IMPLEMENTACION DE LOS ICONOS
                        Icons.Filled.Search
                    }*/
                }
            )
        }
    ){
            innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Pantallas.Login.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ){
            composable(Pantallas.Login.name){
                Login(onNextButtonClicked = {
                    navController.navigate(Pantallas.Principal.name)
                }
                )
            }
            composable(Pantallas.Principal.name){
                Principal(onNextButtonClicked = {
                    navController.navigate(Pantallas.Principal.name)
                })
            }
        }
    }
}