package com.hcsc.claims

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ClaimsDetailFragmentArgs(
  public val claim: Claim
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ClaimsDetailFragmentArgs {
      bundle.setClassLoader(ClaimsDetailFragmentArgs::class.java.classLoader)
      val __claim : Claim?
      if (bundle.containsKey("claim")) {
        if (Parcelable::class.java.isAssignableFrom(Claim::class.java) ||
            Serializable::class.java.isAssignableFrom(Claim::class.java)) {
          __claim = bundle.get("claim") as Claim?
        } else {
          throw UnsupportedOperationException(Claim::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__claim == null) {
          throw IllegalArgumentException("Argument \"claim\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"claim\" is missing and does not have an android:defaultValue")
      }
      return ClaimsDetailFragmentArgs(__claim)
    }
  }
}
