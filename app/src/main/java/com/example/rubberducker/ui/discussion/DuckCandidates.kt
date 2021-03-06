package com.example.rubberducker.ui.discussion

import java.lang.IllegalArgumentException

data class DuckCandidates(val candidates: List<DuckCandidate> )

data class DuckCandidate(val name: String, val ranking: Ranking, val availability: Availability)

@Suppress("DataClassPrivateConstructor")
data class Ranking private constructor(val percent: Float): Comparable<Ranking> {
  companion object {
    fun create(percent: Float): Ranking {
      if (percent > 0 || percent < 100f)
        return Ranking(percent)
      else
        throw IllegalArgumentException("Percent has illegal value: $percent")
    }
  }

  override fun toString(): String {
    return "$percent%"
  }

  override fun compareTo(other: Ranking): Int =
    this.percent.compareTo(other.percent)
}



enum class Availability {
  AVAILABLE,
  UNAVAILABLE
}
