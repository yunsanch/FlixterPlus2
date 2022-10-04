package com.example.flixterplus2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val PERSON_EXTRA = "PERSON_EXTRA"
private const val TAG = "PersonAdapter"

class PersonRecyclerViewAdapter(
    private val context: Context, private val people: List<PeopleDetails>):
    RecyclerView.Adapter<PersonRecyclerViewAdapter.ViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.person_item,parent,false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val person = people[position]
            holder.bind(holder, person)
        }

        override fun getItemCount() = people.size


        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
            View.OnClickListener {

            private val personImageView = itemView.findViewById<ImageView>(R.id.PersonImage)
            private val personNameTextView = itemView.findViewById<TextView>(R.id.PersonName)
//            private val movieTittleTextView = itemView.findViewById<TextView>(R.id.movieTittleTv)

            init {
                itemView.setOnClickListener(this)
            }
            override fun onClick(v: View?) {
                val person = people[absoluteAdapterPosition]
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(PERSON_EXTRA,person)
                context.startActivity(intent)
            }

            fun bind(holder: ViewHolder, people: PeopleDetails) {

                personNameTextView.text = people.nombre




                Glide.with(holder.itemView)
                    .load(people.imageUarl)
                    .centerInside()
                    .into(personImageView)
            }


        }




//        override fun onBindViewHolder(holder: personViewHolder, position: Int) {
//            val person = Person[position]
//
//            holder.mItem = person
//
//            holder.personNameTextView.text = person.name
//
//            Glide.with(holder.itemView)
//                .load("https://image.tmdb.org/t/p/w500/" + person.profilePath)
//                .centerInside()
//                .into(holder.personImageView)
//
//            holder.mView.setOnClickListener{
//                holder.mItem?.let {
//                    people?.onItemClick(Person())
//                }
//            }
//        }
//        override fun getItemCount(): Int {
//            return Person.size
//        }

//             = person.name
//
//            Glide.with(holder.mView)
//                .load("https://image.tmdb.org/t/p/w500/" + person.personPosterImageUrl)
//                .centerInside()
//                .into(holder.mPersonImage)
//
//            holder.mView.setOnClickListener {
//                holder.mItem?.let { person ->
//                    mlistener?.onItemClick(person)





    }
