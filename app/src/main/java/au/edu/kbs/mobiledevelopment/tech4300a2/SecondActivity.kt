package au.edu.kbs.mobiledevelopment.tech4300a2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnSecondToMain = findViewById<Button>(R.id.btn_goto_main_activity)

        btnSecondToMain.setOnClickListener{
            val secondToMain = Intent(this, MainActivity::class.java)
            startActivity(secondToMain)
        }
    }
}