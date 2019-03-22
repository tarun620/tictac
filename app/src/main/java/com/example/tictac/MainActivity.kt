package com.example.tictac

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buclick(view:View)
    {
        val buselected=view as Button
        var cellid:Int=0
        when(buselected.id)
        {
            R.id.bu1->cellid=1
            R.id.bu2->cellid=2
            R.id.bu3->cellid=3
            R.id.bu4->cellid=4
            R.id.bu5->cellid=5
            R.id.bu6->cellid=6
            R.id.bu7->cellid=7
            R.id.bu8->cellid=8
            R.id.bu9->cellid=9
        }

        //Toast.makeText(this,"Cell ID:"+cellid,Toast.LENGTH_LONG).show()
        playgame(cellid,buselected)
    }

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activeplayer=1
    fun playgame(cellid:Int,buselected:Button)
    {
        if(activeplayer==1)
        {
            buselected.text="X"
            buselected.setBackgroundResource(R.color.blue)
            player1.add(cellid)
            activeplayer=2
            autoplay()
        }
        else
        {
            buselected.text="O"
            buselected.setBackgroundColor(Color.RED)
            player2.add(cellid)
            activeplayer=1
        }
        buselected.isEnabled=false
        checkwinner()
    }


    fun checkwinner()
    {
        var winner=-1

        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner=1
        else if (player2.contains(1) && player2.contains(2) && player2.contains(3))
                winner=2

        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner=1
        else if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner=2

        //row1
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner=1
        else if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner=2


        //column1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner=1
        else if (player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner=2

        //column2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner=1
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner=2

        //column3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner=1
        else if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner=2

        //diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner=1
        else if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner=2

        //diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner=1
        else if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner=2




        if(winner!=-1)
        {
            if(winner==1)
                Toast.makeText(this,"PLAYER 1 IS WINNER !",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"PLAYER 2 IS WINNER !",Toast.LENGTH_LONG).show()
        }
    }

    fun autoplay()
    {
        var emptycells=ArrayList<Int>()
        for(cellid in 1..9)
        {
            if(!(player1.contains(cellid) || player2.contains(cellid)))
                emptycells.add(cellid)
        }

        val r=Random()
        val randindex=r.nextInt(emptycells.size-0)+0
        val cellid=emptycells[randindex]

        var buselect:Button?
        when(cellid)
        {
            1->buselect=bu1
            2->buselect=bu2
            3->buselect=bu3
            4->buselect=bu4
            5->buselect=bu5
            6->buselect=bu6
            7->buselect=bu7
            8->buselect=bu8
            9->buselect=bu9
            else->
            {
                buselect=bu1
            }
        }
        playgame(cellid,buselect)
    }

}


