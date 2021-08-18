package com.mubaracktahir.sampleapp.ui.screens

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mubaracktahir.sampleapp.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenDesign(application.applicationContext)
            }
        }
    }


}



@Composable
fun MyApp(content : @Composable ()->Unit){
    SampleAppTheme(darkTheme = false) {
        Surface(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}

@Composable
fun MyScreenDesign(context : Context){
    
    val textToRemember = remember {
        mutableStateOf("")
    }
    
    val textViewText = remember {
        mutableStateOf("")
    }
    
    Column(modifier = Modifier.padding(20.dp)
    ,horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(){
            textToRemember.value = it
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { textViewText.value = textToRemember.value
            Toast.makeText(context, textViewText.value, Toast.LENGTH_SHORT).show()
        },modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Show Input")
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = textViewText.value, style = TextStyle(textAlign = TextAlign.Center) )
    }

}
g
@Composable
fun TextField(content : (String) -> Unit){

    var text =  remember { mutableStateOf("") }

    TextField(
        value = text.value,
        onValueChange = { char ->
            content(char)
            text.value =  char
        },
        modifier = Modifier.fillMaxWidth()
    )
}