package edu.temple.dicethrow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit



/*
Our DieThrow application has been refactored to move the dieRoll() logic
into the ViewModel instead of the Fragment.
Study the DieViewModel, ButtonFragment, and DieFragment classes to
see the changes.

Follow the requirements below to have this app function
in both portrait and landscape configurations.
The Activity layout files for both Portrait and Landscape are already provided
*/

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* TODO 1: Load fragment(s)
            - Show _only_ ButtonFragment if portrait
            - show _both_ fragments if Landscape
          */
        if (findViewById<androidx.fragment.app.FragmentContainerView>(R.id.container2) != null) {
            supportFragmentManager.commit {
                replace(R.id.container1, ButtonFragment())
                replace(R.id.container2, DieFragment())
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.container1, ButtonFragment())
            }
        }
    }


    /* TODO 2: switch fragments if die rolled and in portrait (no need to switch fragments if Landscape)
            */
    override fun buttonClicked() {
        if (findViewById<androidx.fragment.app.FragmentContainerView>(R.id.container2) == null) {
            supportFragmentManager.commit {
                replace(R.id.container1, DieFragment())
                addToBackStack(null)
            }
        }
    }
}