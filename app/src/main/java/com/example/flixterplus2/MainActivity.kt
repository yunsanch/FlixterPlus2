package com.example.flixterplus2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.codepath.articlesearch.PersonFragment
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.flixterplus2.databinding.ActivityMainBinding
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException

fun createJson()= Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private const val TAG = "MainActivity/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val POPULAR_PERSON_SEARCH_URL = "https://api.themoviedb.org/3/person/popular?api_key=${SEARCH_API_KEY}"

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val supportFragmentManager = supportFragmentManager
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(id.content, PersonFragment(), null).commit()
//
//    }
//}

class MainActivity : AppCompatActivity() {
    private val people = mutableListOf<PeopleDetails>()
    private lateinit var personRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        personRecyclerView = findViewById(R.id.listPeople)

        val personAdapter = PersonRecyclerViewAdapter(this,people)
        personRecyclerView.adapter = personAdapter

        personRecyclerView.layoutManager = GridLayoutManager(this,2)
//            LinearLayoutManager(this).also {
//            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
//            personRecyclerView.addItemDecoration(dividerItemDecoration)
//        }

        val client = AsyncHttpClient()
        client.get(POPULAR_PERSON_SEARCH_URL,object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG,"Failed to fetch People: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                Log.i(TAG,"succesfully fetched peoppleL : $json")
                try {
                    val parsedJson = createJson().decodeFromString(
                        baseRespon.serializer(),
                        json.jsonObject.toString()
                    )
                    parsedJson.results?.let { list ->
                        people.addAll(list)
                        personAdapter.notifyDataSetChanged()
                    }
//                    val resultsJson = json.jsonObject.get("results").toString()
//                    val gson = Gson()
//                    val arraPeopleType = object : TypeToken<List<BaseResponse>>() {}.type
//
//                    val models: List<BaseResponse> = gson.fromJson(resultsJson,arraPeopleType)
//
//                    personRecyclerView.adapter = PersonRecyclerViewAdapter(this@MainActivity,models)
//                    print(resultsJson)
////
//                    personAdapter.notifyDataSetChanged()
                } catch (e: JSONException) {
                    Log.e(TAG,"Exception: $e")
                }
            }
        })

//        personRecyclerView.layoutManager = LinearLayoutManager(this).also {
//            val dividerItemDecoration = DividerItemDecoration(this,it.orientation)
//            personRecyclerView.addItemDecoration(dividerItemDecoration)
//        }

//        val client = AsyncHttpClient()
//        val params = RequestParams()
//
//        params["api-key"] = SEARCH_API_KEY
//
//        client[
//                POPULAR_PERSON_SEARCH_URL,
//                params,
//                object : JsonHttpResponseHandler() {
//                    override fun onSuccess(
//                        statusCode: Int,
//                        headers: Headers?,
//                        json: JsonHttpResponseHandler.JSON
//                    ) {
////                        progressBar.hide()
//                        val resultsJson = json.jsonObject.get("results").toString()
//
//                        val gson = Gson()
//                        val arrayPersonType = object : TypeToken<List<BaseResponse>>() {}.type
//
//                        val models: List<BaseResponse> = gson.fromJson(resultsJson, arrayPersonType)
////                        val adapterTrending = PersonRecyclerViewAdapter(people)
//                        personRecyclerView.adapter = PersonRecyclerViewAdapter(this@MainActivity,models)
//
//                        Log.d("personFRagment", "reponse successful")
//                    }
//
//                    override fun onFailure(
//                        statusCode: Int,
//                        headers: Headers?,
//                        ErrorResponse: String,
//                        throwable: Throwable?
//                    ) {
//
////                        progressBar.hide()
//                        throwable?.message?.let {
//                            Log.e("personPolular", ErrorResponse)
//                        }
//                    }
//                }
//                ]
//
    }
}