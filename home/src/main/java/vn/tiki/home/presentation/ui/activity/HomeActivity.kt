package vn.tiki.home.presentation.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitcompat.SplitCompat
import vn.tiki.extensions.appComponent
import vn.tiki.home.R
import vn.tiki.home.presentation.di.component.HomeComponent

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
    }
}