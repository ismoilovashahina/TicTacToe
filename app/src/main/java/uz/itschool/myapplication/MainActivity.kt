package uz.itschool.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_add_players.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var active = true
    var matrix = Array(3){IntArray(3){-1} }
    var imgArray:MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var getPlayerOneName = getIntent().getStringExtra("playerOne")
        var getPlayerTwoName = getIntent().getStringExtra("playerTwo")

        playerOneName.setText(getPlayerOneName)
        playerTwoName.setText(getPlayerTwoName)

        imgArray.add(R.id.zero_zero)
        imgArray.add(R.id.zero_one)
        imgArray.add(R.id.zero_two)
        imgArray.add(R.id.one_zero)
        imgArray.add(R.id.one_one)
        imgArray.add(R.id.one_two)
        imgArray.add(R.id.two_zero)
        imgArray.add(R.id.two_one)
        imgArray.add(R.id.two_two)

        zero_zero.setOnClickListener(this)
        zero_one.setOnClickListener(this)
        zero_two.setOnClickListener(this)
        one_zero.setOnClickListener(this)
        one_one.setOnClickListener(this)
        one_two.setOnClickListener(this)
        two_zero.setOnClickListener(this)
        two_one.setOnClickListener(this)
        two_two.setOnClickListener(this)

        active_player.text="Player X"

        restart.setOnClickListener {
            restart()
        }

    }

    fun restart(){
        zero_zero.isEnabled = true
        zero_one.isEnabled = true
        zero_two.isEnabled = true
        one_zero.isEnabled = true
        one_one.isEnabled = true
        one_two.isEnabled = true
        two_zero.isEnabled = true
        two_one.isEnabled = true
        two_two.isEnabled = true

        zero_zero.setImageDrawable(null)
        zero_one.setImageDrawable(null)
        zero_two.setImageDrawable(null)
        one_zero.setImageDrawable(null)
        one_one.setImageDrawable(null)
        one_two.setImageDrawable(null)
        two_zero.setImageDrawable(null)
        two_one.setImageDrawable(null)
        two_two.setImageDrawable(null)

        active = true
        matrix = Array(3){ IntArray(3){-1} }

        active_player.text="Player X"
        winner.text = ""
        restart.visibility=View.INVISIBLE

    }



    override fun onClick(p0: View?) {
        var img = findViewById<ImageView>(p0!!.id)
        var tag = img.tag.toString().toInt()



        var col: Int = tag / 3
        var row: Int = tag % 3

        var counter = 0

        if (matrix[col][row] == -1){
            if (active){
                img.setImageResource(R.drawable.x)
                counter++
                active=false
                matrix[col][row] = 1
                active_player.text="Player O"

                isWinner(1)




            }else{
                img.setImageResource(R.drawable.o)
                counter++
                active=true
                matrix[col][row] = 0
                active_player.text="Player X"

                isWinner(0)


            }


        }







    }





    fun isWinner(p:Int){

        var count = 0

        for (i in 0..2){
            for (j in 0..2){
                if (matrix[i][j]==p) {
                    count++
                }
                if (count==9){
                    winner.text="Draw"
                    finishGame()
                    return
                }
            }


        }

        count = 0

        for(i in 0..2){
            for(j in 0..2){
                if (matrix[i][j]==p){
                    count++
                }
            }
            if (count==3){
                winner.text="Winner is " + p
                finishGame()
                return
            }

            count = 0
        }
        count = 0




        for(i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[i][j] == p) {
                        count++
                    }
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + p
                finishGame()
                return
            }

        }

        count = 0



        for(i in 0..2){
            for(j in 0..2) {
                if (i + j == 2) {
                    if (matrix[i][j] == p) {
                        count++
                    }
                }
            }
                if (count==3){
                    winner.text="Winner is " + p
                    finishGame()
                    return
            }

        }



        count = 0

        for(i in 0..2){
            for(j in 0..2){
                    if (matrix[j][i]==p){
                        count++
                    }
            }
            if (count==3){
                winner.text="Winner is " + p
                finishGame()
                return
            }
            count=0
        }

        var c = 0

        for(i in 0..2){
            for(j in 0..2) {
                    if ((matrix[i][j] == p)) {
                        c++
                    }
            }
            if (c==9){
                winner.text="Draw"
                finishGame()
                return
            }
        }



    }

    fun finishGame(){
        zero_zero.isEnabled=false
        zero_one.isEnabled=false
        zero_two.isEnabled=false
        one_zero.isEnabled=false
        one_one.isEnabled=false
        one_two.isEnabled=false
        two_zero.isEnabled=false
        two_one.isEnabled=false
        two_two.isEnabled=false

        restart.visibility=View.VISIBLE


    }

}

