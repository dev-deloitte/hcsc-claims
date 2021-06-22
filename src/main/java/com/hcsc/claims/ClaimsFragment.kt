package com.hcsc.claims

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hcsc.myhealth.network.JsonUtils
import com.hscs.myhealth.theme.AppTheme


class ClaimsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {
                val benefits = getClaims()
                AppTheme {
                    ClaimList(claims = benefits) {
                        val action =
                            ClaimsFragmentDirections.actionClaimsFragmentToClaimsDetailFragment(it)
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }

    fun getClaims(): List<Claim> {
        val jsonFileString = JsonUtils.getJsonDataFromAsset(requireContext(), "claims.json")
        val gson = Gson()
        val listClaimType = object : TypeToken<List<Claim>>() {}.type
        var claims: List<Claim> = gson.fromJson(jsonFileString, listClaimType)
        return claims
    }


}
