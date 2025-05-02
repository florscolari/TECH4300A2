package au.edu.kbs.mobiledevelopment.tech4300a2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMainToSecond = findViewById<Button>(R.id.btn_goto_second_activity)

        btnMainToSecond.setOnClickListener{
            val mainToSecond = Intent(this, SecondActivity::class.java)
            startActivity(mainToSecond)
        }

    }
}