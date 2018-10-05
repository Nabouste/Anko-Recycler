package com.example.ghozy.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ghozy.myapplication.R.id.club_logo
import com.example.ghozy.myapplication.R.id.club_name
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class ClubAdapter(private val context: Context, private val items: List<ClubItem>) : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindItem(items[position])
        /*
        * kalo mau pake listener jadi gini
        * holder.bindItem(items[position], listener)
         */
    }

class ClubUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.VERTICAL

                imageView {
                    id = R.id.club_logo
                }.lparams{
                    height = dip(50)
                    width = dip(50)
                }

                textView{
                    id = R.id.club_name
                    textSize = 14f
                }.lparams{
                    margin = dip(16)
                }


            }
        }
    }
}


    override fun getItemCount(): Int = items.size

    class ClubViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val clubLogo: ImageView = view.find(club_logo)
        private val clubName: TextView = view.find(club_name)


        fun bindItem(items: ClubItem){
//            clubLogo.tex
            clubName.text = items.name
            items.image?.let {
                Picasso.get().load(it).into(clubLogo)
            }
        }



    }


}