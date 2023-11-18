package com.example.mochi_feel.ui.screen.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mochi_feel.R
import com.example.mochi_feel.data.AuthRepository
import com.example.mochi_feel.ui.theme.inter
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpView(
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()

    var username by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var birth_day by rememberSaveable { mutableStateOf("") }
    var birth_month by rememberSaveable { mutableStateOf("") }
    var birth_year by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Let’s Sign you in.",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 21.sp,
                    fontFamily = inter,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF238A91),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(start = 3.dp)
            )
            Box(
                modifier = Modifier
                    .width(101.05117.dp)
                    .height(85.90945.dp)
                    .offset(x = (70).dp) // Adjust the negative margin to control how much of the image is outside the screen
            ) {
                Image(
                    painter = painterResource(id = R.drawable.signup),
                    contentDescription = "image description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
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
                    bottom = 10.dp
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
                text = "What Should we call you",
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
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(
                    text = "Enter Your Name",
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
                text = "Birth Date",
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DateOutlinedTextField("Day", birth_day, { birth_day = it }, 1,31)
            DateOutlinedTextField("Month", birth_month, { birth_month = it }, 1, 12)
            DateOutlinedTextField("Year", birth_year, { birth_year = it }, 1970, 2023)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Adjust horizontal padding as needed
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Email",
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
            value = email,
            onValueChange = { email = it },
            placeholder = {
                Text(
                    text = "Enter Email",
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
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {

        }
        TextButton(
            onClick = {
                scope.launch {
                    viewModel.registerUser(email, password, username, name, birth_day, birth_month, birth_year)
                }
            },
            modifier = Modifier
                .width(325.dp)
                .height(50.dp)
                .background(color = Color(0xFF238A91), shape = RoundedCornerShape(size = 10.dp))
//                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
        ) {
            Text(
                text = "Sign Up",
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateOutlinedTextField(
    label: String, value: String, onValueChange: (String) -> Unit, start: Int, end: Int
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(96.dp)
            .height(52.dp)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    "$label",
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
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFF238A91),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .background(Color.Transparent)
                .width(96.dp)
                .height(52.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                cursorColor = Color(0xFF238A91),
                textColor = Color(0xFF238A91)
            )
        )

        IconButton(
            onClick = {
                expanded = !expanded
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 2.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Expand",
                tint = Color(0xFF238A91)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(10.dp)) // Change the background color
                .border(
                    width = 1.dp,
                    color = Color(0xFF238A91),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(8.dp)
        ) {
            (start..end).forEach { day ->
                DropdownMenuItem(
                    text = { Text(text = day.toString()) },
                    onClick = {
                        onValueChange(day.toString())
                        expanded = false
                    }
                )
            }
        }
    }


}


//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun SignUpPreview() {
//    val viewModel: SignUpViewModel = hiltViewModel()
//    SignUpView(viewModel)
//}