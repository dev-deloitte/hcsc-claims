package com.hcsc.claims

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Claim(
    val claim_id: String,
    val claim_in_network_discount: Int,
    val claim_requestor: String,
    val claim_service_date: String,
    val claim_status: String,
    val claim_submission_date: String,
    val claim_total: Int,
    val claim_type: String,
    val last_updated: String,
    val member_name: String,
    val owed_by_member: Int
) : Parcelable