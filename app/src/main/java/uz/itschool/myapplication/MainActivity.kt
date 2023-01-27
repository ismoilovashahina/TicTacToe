package uz.itschool.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var player = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    override fun onClick(p0: View?) {
        var img = findViewById<ImageView>(p0!!.id)
        if (player==1){
            img.setImageResource(R.drawable.o)
            player=2
        }
        else{
            img.setImageResource(R.drawable.x)
        }
    }
}