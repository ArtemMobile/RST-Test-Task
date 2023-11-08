package com.example.rst_test.presentaion.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rst_test.presentaion.ui.theme.Typography

// Не совсем понял какая логика применяется к отображению изначального (уменьшенного)
// размера списка, поэтому кнопка является заглушкой, а списки отображается полностью
@Composable
fun ShowAllButton(size: Int, onClick : () ->Unit = {}) {
    OutlinedButton(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        onClick = { onClick() },
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.tertiary
        ),
    ) {
        Text(
            text = "Показать все ($size)",
            style = Typography.bodyMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}