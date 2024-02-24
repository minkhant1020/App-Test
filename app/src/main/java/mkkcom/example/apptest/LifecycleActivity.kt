package mkkcom.example.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
    }
}