package jp.norihiko.kimura.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SetComplete : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_complete)
    }

    fun onPreViewButtonClick(view: View) {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}
