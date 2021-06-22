package com.hcsc.claims

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.hcsc.commonui.KeyValueText
import com.hcsc.commonui.ListHeaderText
import com.hcsc.commonui.PrimaryButton
import com.hcsc.core.navigation.InternalDeeplink
import com.hscs.myhealth.theme.AppTheme


class ClaimsDetailFragment : Fragment() {
    val args: ClaimsDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    val claim = args.claim
                    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
                        item {
                            ListHeaderText(
                                text = "Claim Detail",
                                modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)
                            )
                        }
                        item {
                            ClaimDetailScreen(claim = claim)
                        }
                        item {
                            PrimaryButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                text = "Go to Benefits Screen",
                                enabled = true,
                                onClick = {
                                    val uri = Uri.parse(InternalDeeplink.BENEFITS)
                                    findNavController().navigate(uri)
                                })
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ClaimDetailScreen(claim: Claim) {
        Column(modifier = Modifier.padding(24.dp)) {
            val claimStatus = claim.claim_status
            ClaimTextWithStatus(claim.claim_requestor, claimStatus)
            val claimMap = ClaimUtils().getClaimDetailMap(claim)
            claimMap.forEach { (claimLabel, claimValue) ->
                KeyValueText(name = stringResource(id = claimLabel), value = claimValue)
            }

        }
    }

}








