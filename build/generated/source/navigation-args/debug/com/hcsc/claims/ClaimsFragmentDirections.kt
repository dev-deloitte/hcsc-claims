package com.hcsc.claims

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class ClaimsFragmentDirections private constructor() {
  private data class ActionClaimsFragmentToClaimsDetailFragment(
    public val claim: Claim
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_claimsFragment_to_claimsDetailFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Claim::class.java)) {
        result.putParcelable("claim", this.claim as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Claim::class.java)) {
        result.putSerializable("claim", this.claim as Serializable)
      } else {
        throw UnsupportedOperationException(Claim::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  public companion object {
    public fun actionClaimsFragmentToClaimsDetailFragment(claim: Claim): NavDirections =
        ActionClaimsFragmentToClaimsDetailFragment(claim)
  }
}
