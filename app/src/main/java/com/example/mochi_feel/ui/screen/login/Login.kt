import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mochi_feel.ui.theme.inter

@Composable
fun LoginView() {
    Column {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp), // Adjust horizontal padding as needed
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Text(
//                text = "Email",
//                style = TextStyle(
//                    fontSize = 16.sp,
//                    lineHeight = 21.sp,
//                    fontFamily = inter,
//                    fontWeight = FontWeight(600),
//                    color = Color(0xFF238A91),
//                ),
//                modifier = Modifier.padding(
//                    start = 20.dp,
//                    end = 10.dp,
//                    bottom = 10.dp,
//                    top = 10.dp
//                ) // Adjust padding as needed
//            )
//        }
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            placeholder = {
//                Text(
//                    text = "Enter Email",
//                    style = TextStyle(
//                        fontSize = 16.sp,
//                        lineHeight = 21.sp,
//                        fontFamily = inter,
//                        fontWeight = FontWeight(500),
//                        color = Color(0xFF238A91),
//                    )
//                )
//            },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Text,
//                imeAction = ImeAction.Next
//            ),
//            modifier = Modifier
//                .border(
//                    width = 1.dp,
//                    color = Color(0xFF238A91),
//                    shape = RoundedCornerShape(size = 10.dp)
//                )
//                .background(Color.Transparent)
//                .width(325.dp)
//                .height(52.dp),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                unfocusedBorderColor = Color.Transparent,
//                focusedBorderColor = Color.Transparent,
//                cursorColor = Color(0xFF238A91),
//                textColor = Color(0xFF238A91)
//            )
//        )
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp), // Adjust horizontal padding as needed
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Text(
//                text = "Password",
//                style = TextStyle(
//                    fontSize = 16.sp,
//                    lineHeight = 21.sp,
//                    fontFamily = inter,
//                    fontWeight = FontWeight(600),
//                    color = Color(0xFF238A91),
//                ),
//                modifier = Modifier.padding(
//                    start = 20.dp,
//                    end = 10.dp,
//                    bottom = 10.dp,
//                    top = 10.dp
//                ) // Adjust padding as needed
//            )
//        }
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            placeholder = {
//                Text(
//                    text = "Enter Password",
//                    style = TextStyle(
//                        fontSize = 16.sp,
//                        lineHeight = 21.sp,
//                        fontFamily = inter,
//                        fontWeight = FontWeight(500),
//                        color = Color(0xFF238A91),
//                    )
//                )
//            },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Password,
//                imeAction = ImeAction.Done
//            ),
//            modifier = Modifier
//                .border(
//                    width = 1.dp,
//                    color = Color(0xFF238A91),
//                    shape = RoundedCornerShape(size = 10.dp)
//                )
//                .background(Color.Transparent)
//                .width(325.dp)
//                .height(52.dp),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                unfocusedBorderColor = Color.Transparent,
//                focusedBorderColor = Color.Transparent,
//                cursorColor = Color(0xFF238A91),
//                textColor = Color(0xFF238A91)
//            )
//        )
    }
}