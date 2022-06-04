package com.example.loginappcomposesmaat.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.extendtaskfoodapp.Greeting
import com.example.extendtaskfoodapp.LoginRegisterButton
import com.example.extendtaskfoodapp.R
import com.example.extendtaskfoodapp.mainText
import com.example.extendtaskfoodapp.ui.theme.Red700
import com.example.extendtaskfoodapp.ui.theme.Red800
import com.example.myapplication.ui.theme.LoginAppComposeSmaatTheme


@Composable
fun chooseCountry(){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
            .padding(8.dp)) {
        Image(painter = painterResource(id = R.drawable.ksa),
            contentDescription = "KSA Image",
            modifier = Modifier
                .fillMaxHeight()
                .width(48.dp))
        Text(text = "+996", modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(8.dp))
        MyTextField()
    }
}

@Composable
fun MyTextField() {

    var textFieldState by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(start = 16.dp, end = 16.dp),
        value = textFieldState,
        onValueChange = {
            textFieldState = it
        },
        placeholder = {
            Text(text = "Enter your name")
        },
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone)
    )
}

@Composable
fun TextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    androidx.compose.material.TextField(modifier = Modifier
        .fillMaxWidth(1f)
        .height(78.dp)
        .padding(8.dp),
        value = text,
        label = { Text(text = "Enter you name") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        shape = RoundedCornerShape(8.dp),
        onValueChange = { it ->
            text = it
        }
    )
}

@Composable
fun TermsAndConditionsText() {

    val annotatedString = buildAnnotatedString {
        append("By registering you agree to the")
        withStyle(style = SpanStyle(Red700)) {
            append(" Terms and Condition")
        }
        append("and the ")
        withStyle(style = SpanStyle(Red700)){
            append("Privacy policy")
        }
    }

    Surface(modifier = Modifier.padding(16.dp)) {
        Text(text = annotatedString, fontSize = 16.sp)
    }

}

@Composable
fun LoginText(){
    val annotatedString = buildAnnotatedString {
        append("Have an Account? ")
        withStyle(style = SpanStyle(Red700)){
            append("LOGIN")
        }
    }
    Surface(modifier = Modifier.padding(4.dp)) {
        Text(text = annotatedString, fontSize = 16.sp)
    }
}
@Composable
fun registerView(modifier: Modifier){
    Surface() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Red800),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Greeting( "Welcome to", "Platraw ...")
            Card(
                Modifier.fillMaxSize(),
                elevation = 4.dp,
                backgroundColor = Red700,
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp)
            ){
                Card(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                    elevation = 4.dp,
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp)
                ) {
                    Column (horizontalAlignment = Alignment.CenterHorizontally){
                        mainText(modifier = Modifier,
                            "Register",
                            "Start your journey with Platrow...")
                        TextField()
                        chooseCountry()
                        PasswordField()
                        TermsAndConditionsText()
                        LoginRegisterButton ("Register")
                        LoginText()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewRegister() {
    LoginAppComposeSmaatTheme {
        registerView(modifier = Modifier.fillMaxSize())
    }
    }