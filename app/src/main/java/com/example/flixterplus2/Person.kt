package com.example.flixterplus2
import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//
//@Keep
//@Serializable
//data class Results(
//    @SerialName("results")
//    val response: List<PeopleDetails>?
////    val response: List<Person>?
//)
//
//@Keep
//@Serializable
//data class PeopleDetails(
//    @SerialName("name")
//    val name: String?,
//    @SerialName("profile_path")
//    val profilePath: String?,
//    @SerialName("Known_for")
//    val KnownFor: List<MovieDetails>? = null,
//    @SerialName("known_for_department")
//    val knownForDepartment: String?,
//) : java.io.Serializable {
//    val imageUrl = "https://image.tmdb.org/t/p/w500/${profilePath}"
//}
//
////@Keep
////@Serializable
////data class Person(
////
////
////) : java.io.Serializable
//
//@Keep
//@Serializable
//data class MovieDetails(
//    @SerialName("poster_path")
//    val poster: String?,
//
//    @SerialName("overview")
//    val overview: String?,
//
//    @SerialName("original_title")
//    val title: String? ,
//    @SerialName("backdrop_path")
//    val backdrop: String?,
//) :java.io.Serializable {
//    val imageUrlBackdrop = "https://image.tmdb.org/t/p/w500/${backdrop}"
//    val imageUrlPoster = "https://image.tmdb.org/t/p/w500/${poster}"
//}
//
//class movies {
//    @SerializedName("poster_path")
//    val poster: String? = null
//
//    @SerializedName("overView")
//    val overview: String? = null
//
//    @SerializedName("original_title")
//    val title: String? = null
//    @SerializedName("backdrop_path")
//    val backdrop: String?= null
//}

@Keep
@Serializable
data class baseRespon(
    @SerialName("results")
    val results: List<PeopleDetails>?
)

@Keep
@Serializable
data class PeopleDetails(
    @SerialName("profile_path")
    val profileP: String?,
    @SerialName("name")
    val nombre : String?,
    @SerialName("known_for")
    val knowntwo: List<movieDetails>?
) : java.io.Serializable {

    val title = knowntwo?.firstOrNull{it.originalTitle != null}?.originalTitle ?: ""
    val overView = knowntwo?.firstOrNull{it.overvi != null}?.overvi ?: ""
    val imageUarl = "https://image.tmdb.org/t/p/w500/${profileP}"
    val imageposterurl = "https://image.tmdb.org/t/p/w500/${knowntwo?.firstOrNull{it.postel != null}?.postel ?: ""}"
}

@Keep
@Serializable
data class movieDetails(
    @SerialName("poster_path")
    val postel: String?,
    @SerialName("overview")
    val overvi: String? ,
    @SerialName("title")
    val originalTitle: String? = null ,
    @SerialName("backdrop_path")
    val backdro: String? = null
) : java.io.Serializable
//data class SearchResponse(
//
//    @SerialName("results")
//    val results: baseResults?
//)
//
//@Keep
//@Serializable
//data class baseResults(
//    @SerialName("known_for")
//    val knownFor: List<Person>?
//)
//
//@Keep
//@Serializable
//
//data class Person(
//    @SerialName("name")
//    val name: String?,
//    @SerialName("profile_path")
//    val personPosterImageUrl: String?,
//    @SerialName("poster_path")
//    val posterPath: List<Movies>,
//    @SerialName("overview")
//    val overview: String?,
//    @SerialName("known_for")
//    val knownForr: List<Movies>
//
//) : java.io.Serializable {
//    val imageUrl = "https://image.tmdb.org/t/p/w500/${personPosterImageUrl}"
//}
//
//@Keep
//@Serializable
//data class Movies(
//    @SerialName("poster_path")
//    val posterPath: String?,
//    @SerialName("title")
//    val title: String?
//) : java.io.Serializable