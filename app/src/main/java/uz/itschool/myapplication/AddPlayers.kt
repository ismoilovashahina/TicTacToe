package uz.itschool.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_players.*

class AddPlayers : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_players)
        startGameBtn.setOnClickListener(this)

    }


    override fun onClick(v: View?) {

        var getPlayerOneName = playerOneName.text.toString()
        var getPlayerTwoName = playerTwoName.text.toString()

        if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
            Toast.makeText(this, "Please enter player names", Toast.LENGTH_SHORT).show()
        }
        else{
            intent = Intent(this, MainActivity::class.java)
            intent.putExtra("playerOne", getPlayerOneName)
            intent.putExtra("playerTwo", getPlayerTwoName)

            startActivity(intent)

        }



    }
}