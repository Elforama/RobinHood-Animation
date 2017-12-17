package com.oneguygames.animationchallengeone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.AutoTransition
import android.support.transition.Transition
import android.support.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.purchase_details_layout.*

class MainActivity: AppCompatActivity() {

    private var changed = false
    private val setOne = ConstraintSet()
    private val setTwo = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        description.visibility = View.INVISIBLE

        setOne.clone(root)
        setTwo.clone(this, R.layout.activity_main_two)

        toolbar.setNavigationOnClickListener {
            animate()
        }

        floatingActionButton.setOnClickListener {
           animate()
        }

    }

    private fun animate() {
        TransitionManager.beginDelayedTransition(root)
        if (!changed) {
            setTwo.applyTo(root)
            description.visibility = View.VISIBLE
        } else {
            setOne.applyTo(root)
            description.visibility = View.INVISIBLE
        }
        changed = !changed
    }

    override fun onBackPressed() {
        if (changed) {
            animate()
        } else {
            super.onBackPressed()
        }
    }
}
