package com.hcsc.claims

import androidx.compose.ui.graphics.Color
import com.hcsc.core.utils.toDollar
import com.hscs.myhealth.theme.Blue
import com.hscs.myhealth.theme.Green
import com.hscs.myhealth.theme.Red

class ClaimUtils {

    fun getClaimMap(claim: Claim): MutableMap<Int, String> {
        val numbersMap = mutableMapOf<Int, String>()
        numbersMap.apply {
            put(R.string.label_member, claim.member_name)
            put(R.string.label_claim_id, claim.claim_id)
            put(R.string.label_claim_submitted, claim.claim_submission_date)
            put(R.string.label_claim_total, claim.claim_total.toDollar())
            put(R.string.label_you_may_owe, claim.claim_in_network_discount.toDollar())
        }
        return numbersMap
    }

    fun getClaimDetailMap(claim: Claim): MutableMap<Int, String> {
        val numbersMap = mutableMapOf<Int, String>()

        numbersMap.apply {
            put(R.string.label_member, claim.member_name)
            put(R.string.label_claim_id, claim.claim_id)
            put(R.string.label_claim_type, claim.claim_type)
            put(R.string.label_claim_status, claim.claim_status)
            put(R.string.label_claim_service, claim.claim_service_date)
            put(R.string.label_claim_submitted, claim.claim_submission_date)
            put(R.string.label_last_updated, claim.last_updated)
        }
        return numbersMap
    }

    fun getColorBasedOnStatus(text: String): Color {
        val color = when (text) {
            "Processed" -> {
                Blue
            }
            "Denied" -> {
                Red
            }
            "Paid" -> {
                Green
            }
            else -> {
                Color.DarkGray
            }
        }
        return color
    }
}