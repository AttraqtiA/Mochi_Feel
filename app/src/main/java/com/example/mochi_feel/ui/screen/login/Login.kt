
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mochi_feel.R
import com.example.mochi_feel.ui.MochiFeel_Screen
import com.example.mochi_feel.ui.screen.login.LoginViewModel
import com.example.mochi_feel.ui.theme.inter
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
//    val uid = viewModel.userManager.getUserUid()
//    DisposableEffect(viewModel) {
//        if (uid != null) {
//            viewModel.fetchUserData(uid)
//        }
//        onDispose { /* Cleanup or handle disposal if needed */ }
//    }
//    val userData by viewModel.userData.collectAsState()
//
//    if (userData != null) {
//        // User data is available, render UI
//        Column {
//            Text("username: ${userData!!.username}")
//            Text("Name: ${userData!!.name}")
//        }
//    } else {
//        CircularProgressIndicator()
//    }
//    val n = android.icu.util.Calendar.getInstance().time
//    Text(text = n.toString())
    val scope = rememberCoroutineScope()

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val state = viewModel.signInState.collectAsState(initial = null)

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "It’s great to see you again!",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 21.sp,
                fontFamily = inter,
                fontWeight = FontWeight(700),
                color = Color(0xFF238A91),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .padding(bottom = 40.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Adjust horizontal padding as needed
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Username",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF238A91),
                ),
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 10.dp,
                    bottom = 10.dp,
                    top = 10.dp
                ) // Adjust padding as needed
            )
        }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = {
                Text(
                    text = "Enter Username",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF238A91),
                    )
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFF238A91),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .background(Color.Transparent)
                .width(325.dp)
                .height(52.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                cursorColor = Color(0xFF238A91),
                textColor = Color(0xFF238A91)
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Adjust horizontal padding as needed
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Password",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF238A91),
                ),
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 10.dp,
                    bottom = 10.dp,
                    top = 10.dp
                ) // Adjust padding as needed
            )
        }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(
                    text = "Enter Password",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF238A91),
                    )
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFF238A91),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .background(Color.Transparent)
                .width(325.dp)
                .height(52.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                cursorColor = Color(0xFF238A91),
                textColor = Color(0xFF238A91)
            ),
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisibility = !passwordVisibility },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Toggle password visibility",
                        tint = Color.Gray
                    )
                }
            }
        )

        val text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF238A91)
                )
            ) {
                append("Don't have an account? ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF238A91))) {
                append("Sign Up")
                // Add click event here, for example, on click navigate to sign-in screen
                addStringAnnotation(
                    tag = "SignIn",
                    annotation = "ClickSignIn",
                    start = length - "Sign In".length,
                    end = length
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Adjust horizontal padding as needed
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF238A91),
                ),
                modifier = Modifier
                    .padding(
                        start = 20.dp,
                        end = 10.dp,
                    )
                    .clickable {
                        navController.navigate(MochiFeel_Screen.SignUp.name)
                    }
            )
        }
        Row(
            modifier = Modifier.padding(start = 10.dp, top = 20.dp, bottom = 20.dp, end = 10.dp)
        ) {
            TextButton(
                onClick = {
                    scope.launch {
                        viewModel.loginUser(username, password, navController)
                    }
                },
                modifier = Modifier
                    .width(325.dp)
                    .height(50.dp)
                    .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 10.dp))
//                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 21.sp,
                        fontFamily = inter,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            if (state.value?.isLoading == true) {
                CircularProgressIndicator()
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                modifier = Modifier
                    .padding(0.dp)
                    .width(162.00502.dp)
                    .height(137.72986.dp)
                    .offset(x = (33).dp, y = 130.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.signin),
                    contentDescription = "image description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
    LaunchedEffect(key1 = state.value?.isSuccess) {
        scope.launch {
            if (state.value?.isSuccess?.isNotEmpty() == true) {
                val success = state.value?.isSuccess
                Toast.makeText(context, "$success", Toast.LENGTH_LONG).show()
            }
        }
    }
    LaunchedEffect(key1 = state.value?.isError) {
        scope.launch {
            if (state.value?.isError?.isNotBlank() == true) {
                val error = state.value?.isError
                Toast.makeText(context, "$error", Toast.LENGTH_LONG).show()
            }
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun LoginPreview() {
//    LoginView()
//}