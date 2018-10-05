package com.example.ghozy.myapplication

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView {
                id = club_image
            }.lparams(width = 50.dp, height = 50.dp)

            textView {
                id = club_name
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)
            }
        }
    }
}