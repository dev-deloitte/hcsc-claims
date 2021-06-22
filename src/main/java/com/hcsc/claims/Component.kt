package com.hcsc.claims

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClaimTextWithStatus(name: String, claimStatus: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h5.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = claimStatus,
            modifier =
            Modifier
                .background(
                    ClaimUtils().getColorBasedOnStatus(claimStatus),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(4.dp),
            color = MaterialTheme.colors.surface,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.body1
        )
    }
}




