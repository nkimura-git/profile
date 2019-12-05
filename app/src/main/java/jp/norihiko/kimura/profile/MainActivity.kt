package jp.norihiko.kimura.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileltbt = findViewById<Button>(R.id.profile_lt_button)
        val newbt = findViewById<Button>(R.id.new_button)

        val listener = ClickMethod()

        profileltbt.setOnClickListener(listener)
        newbt.setOnClickListener(listener)

    }

    private inner class ClickMethod : View.OnClickListener {
        override fun onClick(v: View?) {
            when (v!!.id) {
                R.id.profile_lt_button -> {
                    val intent = Intent(applicationContext, ProfileList::class.java)
                    startActivity(intent)
                }
                R.id.new_button -> {
                    val intent = Intent(applicationContext, New::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}
