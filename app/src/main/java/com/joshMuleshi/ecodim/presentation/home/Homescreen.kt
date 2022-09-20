package com.joshMuleshi.ecodim.presentation.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joshMuleshi.ecodim.presentation.home.business.HomeState
import com.joshMuleshi.ecodim.presentation.home.business.HomeViewModel
import com.joshMuleshi.ecodim.presentation.home.component.CircularProgressBar
import com.joshMuleshi.ecodim.R
import com.joshMuleshi.ecodim.ui.theme.Back1
import com.joshMuleshi.ecodim.ui.theme.Black_ic
import com.joshMuleshi.ecodim.ui.theme.Purple500

@Composable
fun Homescreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val posts by viewModel.data.collectAsState()
    val percentage = 0.60f

    BackHandler(enabled = true) {
        (context as? Activity)?.finish()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(text = "Welcome,", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Medium)
                    if(posts is HomeState.Success){
                        Text(text = (posts as HomeState.Success).student!!.nom, color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Normal)
                    }
                }

                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                        .size(40.dp)
                        .clip(RoundedCornerShape(25))
                        .border(0.dp, Color.Gray, RoundedCornerShape(25))
                )
            }
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Column(modifier = Modifier
            .background(Color.White)
            .size(400.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center){
                CircularProgressIndicator(progress = 1f , modifier = Modifier.size(179.dp), strokeWidth = 9.dp, color = Black_ic)
                CircularProgressBar(percentage = percentage, number = 100, isPercentage = true, color = Purple500)
                CircularProgressIndicator(progress = 1f , modifier = Modifier.size(200.dp), strokeWidth = 9.dp, color = Back1)
            }
            Spacer(modifier = Modifier.padding(2.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
                Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center){
                    CircularProgressIndicator(progress = 1f , modifier = Modifier.size(110.dp), strokeWidth = 9.dp, color = Black_ic)
                    CircularProgressBar(percentage = 0.4f, number = 100, radius = 45.dp, color = Purple500)
                }
                Box(modifier = Modifier.size(150.dp), contentAlignment = Alignment.Center){
                    Text(
                        text = "V",
                        color = Color.Black,
                        fontSize = 55.sp,
                        fontWeight = FontWeight.Bold
                    )
                    CircularProgressIndicator(progress = 1f , modifier = Modifier.size(150.dp), strokeWidth = 9.dp)
                }
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), contentAlignment = Alignment.BottomCenter)
        {
            Button(
                onClick = {
                    //navController.navigate(Screen.Result.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(8.dp),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.5.dp,
                    pressedElevation = 4.dp,
                    disabledElevation = 0.dp
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Purple500
                ),
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "See More",
                            style = MaterialTheme.typography.body2
                                .copy(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    color = Color.Black
                                )
                        )
                    }
                }
            )
        }
    }
}