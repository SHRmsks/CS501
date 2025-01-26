package com.first_project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.first_project.ui.theme.First_ProjectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            First_ProjectTheme {
                Main()
            }
        }
    }

@Composable
fun Main (){
        var show by remember { mutableStateOf(false) }
        Scaffold(modifier = Modifier.fillMaxSize()
        )


        { padding ->
          Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
            Row(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Greeting(
                    name = "World",
                    modifier = Modifier.padding(padding)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth().height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                FloatButton(name = "Click Me!", onclick = {
                    show = true
                    Log.d("MainScreen", "Button clicked! show = $show")
                })

                if (show) {
                    Box(
                        modifier = Modifier.fillMaxSize().zIndex(2f).background(Color.White),
                        contentAlignment = Alignment.Center

                    ) {
                        Welcome()
                    }

                }

            }
        }
        }

    }
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        fontSize=20.sp,
        fontWeight = W400,
        color= Color(0xFF19a9c2),
        modifier = modifier
    )
}
    @Composable
    fun Welcome(){
        Text(text="You Just Clicked!",
            fontSize=20.sp,
            fontWeight = W400,
            style = TextStyle(brush=  Brush.linearGradient(
                colors=listOf(Color(0xFF3ef097), Color (0xFF37ccb1), Color(0xFF3179ad)),
                start= Offset(0f,0f),
                end = Offset.Infinite,
            ),
                textAlign = TextAlign.Center


            ))
    }
@Composable
fun FloatButton (name: String, onclick: ()-> Unit ){

    ElevatedButton(onClick={onclick()},
            colors = ButtonDefaults.buttonColors(  containerColor =  Color (0xFF4831ad), contentColor = Color.White,),



        ){

        Text (name)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    First_ProjectTheme {
      Main()
    }
}}