package com.oneguygames.animationchallengeone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.AutoTransition
import android.support.transition.Transition
import android.support.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    var changed = false
    val setOne = ConstraintSet()
    val setTwo = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOne.clone(root)

        setTwo.clone(this, R.layout.activity_main_two)

        toolbar.setNavigationOnClickListener {
            animate()
        }

        floatingActionButton.setOnClickListener {
           animate()
        }

    }

    fun animate() {

        val t = AutoTransition()


        TransitionManager.beginDelayedTransition(root, t)
        if (!changed) setTwo.applyTo(root) else setOne.applyTo(root)
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
