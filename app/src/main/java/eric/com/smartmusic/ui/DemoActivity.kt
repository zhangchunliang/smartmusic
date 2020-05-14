package eric.com.smartmusic.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eric.com.smartmusic.R

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        val intent = Intent(this@DemoActivity, MainActivity::class.java)
        startActivity(intent)
    }
}