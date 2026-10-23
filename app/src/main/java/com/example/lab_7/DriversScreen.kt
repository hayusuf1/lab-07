package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun DriversScreen(navController: NavController){

    var driver by remember { mutableStateOf("") }
    val drivers = remember { mutableListOf<String>() }




    Column(
        modifier = Modifier.padding(16.dp)
        , verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier.testTag("goHome"),
            onClick = {
                navController.popBackStack()
            }
        ) {Text("Go Home") }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "FormulaZero Drivers",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row() {

            TextField(
                value = driver,
                onValueChange = {driver = it},
                label = {Text("Driver Name")},
                modifier = Modifier.testTag("driverInput")
            )

            Button(
                modifier = Modifier.testTag("addButton"),
                onClick = {
                    if(driver.isNotBlank()){
                        drivers.add(driver)
                        driver = ""
                    }

                }
            ) {Text("Add Driver") }

        }

        Spacer(modifier = Modifier.height(16.dp))

    LazyColumn {
        items(drivers) { driver ->

            Text(
                text = driver,
                fontSize = 24.sp
            )
        }

    }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.testTag("clearButton"),
            onClick = {
                drivers.clear()
            }
        ) { Text("Clear Drivers") }

    }
}
