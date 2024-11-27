package com.example.calc_1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val buttonlist = listOf(
    "AC","%","(",")",
    "7","8","9","/",
    "4","5","6","*",
    "1","2","3","-",
    "C","0","=","+",

)


@Composable
fun calc_1(modifier: Modifier = Modifier, viewModel: CalculatorViewModel) {

    val _equationText = viewModel.equationText.observeAsState()
    val _resultText = viewModel.resultText.observeAsState()

    Box(modifier = modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,

        ) {
            Text(
                text = _equationText.value?:"",
                style = TextStyle(
                    fontSize = 40.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = _resultText.value?:"",
                style = TextStyle(
                    fontSize = 60.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 2,
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
            ) {
                items(buttonlist){
                    calc_1_buttons(btn = it, onClick = {
                        viewModel.onButtonClick(it)
                    })
                }
            }
        }
    }
}

@Composable
fun calc_1_buttons(btn : String, onClick: () -> Unit = {}) {
    Box(modifier = Modifier.padding(8.dp)){
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier.size(80.dp),
            shape = CircleShape,
            containerColor = Color.White,
            contentColor = Color.Black
        ) {
            Text(text = btn, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

    }
}