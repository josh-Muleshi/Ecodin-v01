package com.joshMuleshi.ecodim.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joshMuleshi.ecodim.app.navigation.Screen
import com.joshMuleshi.ecodim.presentation.splash.business.SplashState
import com.joshMuleshi.ecodim.presentation.splash.business.SplashViewModel
import com.joshMuleshi.ecodim.ui.theme.Back1
import com.joshMuleshi.ecodim.ui.theme.Back2
import com.joshMuleshi.ecodim.ui.theme.Back3
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, splashViewModel: SplashViewModel = hiltViewModel()) {

    val state by splashViewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state) {
        delay(2000)
        when(state) {
            is SplashState.Success -> {
                if ((state as SplashState.Success).isAuth) {
                    navController.navigate(Screen.Home.route)
                } else {
                    navController.navigate(Screen.Auth.route)
                }
            }
            is SplashState.Error -> {
                snackbarHostState.showSnackbar((state as SplashState.Error).errorMessage)
            }
            else -> {}
        }
    }

    Scaffold(
        scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState),
        backgroundColor = Color.Transparent,
        modifier = Modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Back1,
                    Back2,
                    Back3
                ),
                startY = 100.0f,
                endY = 2100f
            )
        )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = "PUB-Resultat",
                style = MaterialTheme.typography.h1.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            )

            Text(
                text = "Consulter votre resultat",
                style = MaterialTheme.typography.body2.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = Color.White
                ),
                modifier = Modifier.padding(16.dp).align(Alignment.BottomCenter)
            )
        }
    }
}