package vn.tiki.home.presentation.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.play.core.splitcompat.SplitCompat
import kotlinx.android.synthetic.main.activity_home.*
import vn.tiki.extensions.appComponent
import vn.tiki.home.R
import vn.tiki.home.presentation.di.component.HomeComponent
import vn.tiki.home.presentation.ui.fragment.HomeFragment

/**
 * Created by phatvt2 on 8/4/20
 */

class HomeActivity : AppCompatActivity() {
    internal lateinit var homeComponent: HomeComponent

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        homeComponent = HomeComponent.create(this, appComponent())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bindEvent()
        loadFragment(HomeFragment())
    }

    private fun bindEvent() {
        viewBottomNavigation.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.item_home -> loadFragment(HomeFragment())
                else -> Unit // not available
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        with(supportFragmentManager.beginTransaction()) {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}