package com.example.flixterplus2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

private const val TAG = "DetailsActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var personImageView: ImageView
    private lateinit var PosterImageView: ImageView
    private lateinit var personTextView: TextView
    private lateinit var knownforTextView: TextView
    private lateinit var overviewTextView: TextView
    private lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        personImageView = findViewById(R.id.PersonImage)
        PosterImageView = findViewById(R.id.posterView)
        personTextView = findViewById(R.id.PersonName)
        knownforTextView = findViewById(R.id.Knownfor)
        overviewTextView = findViewById(R.id.overviewTv)
        titleTextView = findViewById(R.id.movieTittleTv)

        val person = intent.getSerializableExtra((PERSON_EXTRA)) as PeopleDetails

        personTextView.text = person.nombre
        overviewTextView.text = person.overView
        titleTextView.text = person.title



        Glide.with(this)
            .load(person.imageUarl)
            .into(personImageView)

        Glide.with(this)
            .load(person.imageposterurl)
            .into(PosterImageView)


    }
}