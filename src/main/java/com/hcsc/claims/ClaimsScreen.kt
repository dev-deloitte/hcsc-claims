package com.hcsc.claims

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hcsc.commonui.KeyValueText
import com.hcsc.commonui.ListHeaderText
import com.hcsc.commonui.VectorIcon


@Composable
fun ClaimList(claims: List<Claim>, onClaimClick: (Claim) -> Unit) {

    LazyColumn(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
        item {
            ListHeaderText(
                text = "Claims",
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)
            )
        }
        items(claims) {
            ClaimItem(claim = it) {
                onClaimClick(it)
            }
        }
    }
}


@Composable
fun ClaimItem(claim: Claim, onClaimClick: (Claim) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClaimClick(claim)
            },
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            val claimStatus = claim.claim_status

            ClaimTextWithStatus(claim.claim_requestor, claimStatus)

            val claimMap = ClaimUtils().getClaimMap(claim)
            claimMap.forEach { (claimLabel, claimValue) ->
                KeyValueText(name = stringResource(id = claimLabel), value = claimValue)
            }
        }
    }
}


@Composable
fun ClaimItemSecond(claim: Claim, onClaimClick: (Claim) -> Unit) {
//    var isSelected by remember { mutableStateOf(false) }
//    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onClaimClick(claim)
        }
    ) {
        Text(
            text = claim.member_name,
            modifier = Modifier
                .weight(1f)
                .padding(24.dp)
        )
        VectorIcon(imageVector = Icons.Filled.KeyboardArrowRight)
    }

}