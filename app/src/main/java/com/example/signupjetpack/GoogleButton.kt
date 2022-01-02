package com.example.signupjetpack

import android.graphics.drawable.Icon
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.signupjetpack.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun GoogleButton(
    text:String = "Sign In With Google",
    loadingText:String = "Creating Account....",
    icon: Painter = painterResource(id = R.drawable.google)
){
    var clicked by remember {
        mutableStateOf(false)
    }
    Surface(
        onClick = {clicked = !clicked},
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        color = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 14.dp,
                    end = 14.dp,
                    top = 7.dp,
                    bottom = 7.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = LinearOutSlowInEasing
                    )
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = icon,
                contentDescription = "Google Buttons",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(text = if (clicked) loadingText else text, textAlign = TextAlign.Center)
            if (clicked){
                Spacer(modifier = Modifier.width(7.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(14.dp)
                        .height(14.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colors.primary
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun googleButtonView(){
    GoogleButton()
}