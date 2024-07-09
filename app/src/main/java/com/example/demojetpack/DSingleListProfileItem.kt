package com.example.demojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class DSingleListProfileItem : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListVerticalItem()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFBFE)
@Composable
fun ViewProfileItem() {
    //static by reusing component
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())){
//        getProfileList().map { item ->
//            ProfileItem(image = item.image, title = item.title, description = item.description)
//        }
//    }
    LazyListVerticalItem()
}

@Composable
private fun LazyListVerticalItem() {
    //Vertical  recyclerview
//    LazyColumn(content = {
//        items(getProfileList()) { item ->
//            ProfileItem(image = item.image, title = item.title, description = item.description)
//        }
//    })

    //Horizontal Recyclerview
//    LazyRow(content = {
//        items(getProfileList()) { item ->
//            ProfileHorizontalItem(
//                image = item.image,
//                title = item.title,
//                description = item.description
//            )
//        }
//    })
    
    //Grid vertical
//    LazyVerticalGrid(columns = GridCells.Fixed(3) , content = {
//        items(getProfileList()) { item ->
//            ProfileGrid(
//                image = item.image
//            )
//        }
//    } )

    //Grid Horizontal
    LazyHorizontalGrid(rows = GridCells.Fixed(3) , content = {
        items(getProfileList()) { item ->
            ProfileGrid(
                image = item.image
            )
        }
    } )


}

@Composable
fun ProfileItem(image: Int, title: String, description: String) {
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(8.dp)
            .background(colorResource(id = R.color.white))
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .background(colorResource(id = R.color.white)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    id = image
                ),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(50.dp)
                    .weight(.04f)
                    .clip(CircleShape)
                    .border(2.dp, color = colorResource(id = R.color.black), shape = CircleShape)

            )
            SetTitleAndDec(
                modifier = Modifier.weight(.28f),
                title = title,
                description = description
            )
        }
    }
}

@Composable
fun ProfileHorizontalItem(image: Int, title: String, description: String) {
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(8.dp)
            .background(colorResource(id = R.color.white))
            .size(150.dp, 200.dp)
    ) {
        Column(modifier = Modifier
            .padding(5.dp)
            .background(colorResource(id = R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(
                    id = image
                ),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = colorResource(id = R.color.black), shape = CircleShape)

            )
            Text(
                text = title,
                color = colorResource(id = R.color.heading_gray),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = description,
                color = colorResource(id = R.color.sudetails_gray),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun SetTitleAndDec(modifier: Modifier, title: String, description: String) {
    Column(modifier = modifier.padding(5.dp)) {
        Text(
            text = title,
            color = colorResource(id = R.color.heading_gray),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = description,
            color = colorResource(id = R.color.sudetails_gray),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun ProfileGrid(image: Int){
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(8.dp)
            .background(colorResource(id = R.color.white))
            .size(150.dp, 150.dp)
    ) {
        Image(
            painter = painterResource(
                id = image
            ),
            contentDescription = "Avatar",
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
//                .size(50.dp)
//                .clip(CircleShape)
//                .border(2.dp, color = colorResource(id = R.color.black), shape = CircleShape)
        )
    }
}

data class Profile(val image: Int, val title: String, val description: String)

fun getProfileList(): MutableList<Profile> {
    val profileList = mutableListOf<Profile>()
    profileList.add(Profile(R.drawable.profile_a, "Jonathan Disney", "Carpenter"))
    profileList.add(Profile(R.drawable.profile_b, "Aly white", "Software Engineer"))
    profileList.add(Profile(R.drawable.profile_c, "Brain Test", "Auto Tester"))
    profileList.add(Profile(R.drawable.profile_d, "Nesty Disney", "Technical Leader"))
    profileList.add(Profile(R.drawable.profile_e, "Lesha Rapper", "Mechanic"))
    profileList.add(Profile(R.drawable.profile_f, "Nancy Disney", "Washer"))
    profileList.add(Profile(R.drawable.profile_a, "Jessy Less", "Java Developer"))
    profileList.add(Profile(R.drawable.profile_b, "Michel Rent  ", "React Native Developer"))
    profileList.add(Profile(R.drawable.profile_a, "Jonathan Disney", "Carpenter"))
    profileList.add(Profile(R.drawable.profile_b, "Aly white", "Software Engineer"))
    profileList.add(Profile(R.drawable.profile_c, "Brain Test", "Auto Tester"))
    profileList.add(Profile(R.drawable.profile_d, "Nesty Disney", "Technical Leader"))
    profileList.add(Profile(R.drawable.profile_e, "Lesha Rapper", "Mechanic"))
    profileList.add(Profile(R.drawable.profile_f, "Nancy Disney", "Washer"))
    profileList.add(Profile(R.drawable.profile_a, "Jessy Less", "Java Developer"))
    profileList.add(Profile(R.drawable.profile_b, "Michel Rent  ", "React Native Developer"))
    profileList.add(Profile(R.drawable.profile_a, "Jonathan Disney", "Carpenter"))
    profileList.add(Profile(R.drawable.profile_b, "Aly white", "Software Engineer"))
    profileList.add(Profile(R.drawable.profile_c, "Brain Test", "Auto Tester"))
    profileList.add(Profile(R.drawable.profile_d, "Nesty Disney", "Technical Leader"))
    profileList.add(Profile(R.drawable.profile_e, "Lesha Rapper", "Mechanic"))
    profileList.add(Profile(R.drawable.profile_f, "Nancy Disney", "Washer"))
    profileList.add(Profile(R.drawable.profile_a, "Jessy Less", "Java Developer"))
    profileList.add(Profile(R.drawable.profile_b, "Michel Rent  ", "React Native Developer"))
    return profileList
}

