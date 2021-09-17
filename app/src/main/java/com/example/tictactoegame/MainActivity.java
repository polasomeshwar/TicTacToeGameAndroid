package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    TextView text;
    TextView wintext;
    TextView moves;
    TextView playerx;
    TextView playero;
    int PX=0;
    int PO=1;
    int pxcount=0;
    int pocount=0;
    int activeplayer = PX;
    int winclick = -1;
    boolean isGameActive = true;
    int[] position = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text1);
        wintext = findViewById(R.id.winnertext);
        moves = findViewById(R.id.moves);
        playerx = findViewById(R.id.plx);
        playero = findViewById(R.id.plo);
        moves.setText("' X ' MOVE");
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(!isGameActive)
        {
            return;
        }
        Button clickbutton = (Button)findViewById(v.getId());
        int clickedtag = Integer.parseInt(v.getTag().toString());
        Log.i("Hello",clickedtag+"");
        Log.i("Hello player",activeplayer+"");
        if(position[clickedtag]!=-1)
        {
            return;
        }
        if(activeplayer==PX)
        {
            clickbutton.setText("X");
            Log.i("Hello","Hello player x marked");
            activeplayer = PO;
            position[clickedtag]=PX;
            winclick = 1;
            moves.setText("' O ' MOVE");
            //Log.i("TAG",clickbutton.getText().toString());
       }
        else
        {
            clickbutton.setText("O");
            activeplayer = PX;
            position[clickedtag]=PO;
            winclick = 0;
            moves.setText("' X ' MOVE");
        }
        checkwinner();
    }
    public void checkwinner()
    {
        if(position[0]!=-1 &&position[0]==position[1] && position[0]==position[2] ||
                position[0]!=-1 &&position[0]==position[3] && position[0]==position[6] ||
                position[0]!=-1 &&position[0]==position[4] && position[0]==position[8] ||
                position[1]!=-1 &&position[1]==position[4] && position[1]==position[7] ||
                position[2]!=-1 &&position[2]==position[5] && position[2]==position[8] ||
                position[2]!=-1 &&position[2]==position[4] && position[2]==position[6] ||
                position[3]!=-1 &&position[3]==position[4] && position[3]==position[5] ||
                position[6]!=-1 &&position[6]==position[7] && position[6]==position[8] )
        {
            if(winclick==1)
            {
                wintext.setText("Winner  is  ' X '  congrats");
                pxcount++;
                isGameActive = false;
                moves.setText("");
                playerx.setText("SCORE : "+pxcount);
            }
            else
            {
                wintext.setText("Winner  is  ' O '  congrats");
                pocount++;
                isGameActive = false;
                moves.setText("");
                playero.setText("");
                playero.setText("SCORE : "+pocount);
            }
        }
        else
        {
            int count=0;
            for(int i=0;i<position.length;i++)
            {
                if(position[i]>=0)
                {
                    count++;
                }
            }
            if(count==position.length)
            {
                wintext.setText("Draw");
                moves.setText("");
            }
        }
    }
    public void restart(android.view.View v)
    {
       position= new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
       activeplayer = PX;
       btn0.setText("");
       btn1.setText("");
       btn2.setText("");
       btn3.setText("");
       btn4.setText("");btn5.setText("");btn6.setText("");btn7.setText("");
       btn8.setText("");
       wintext.setText("");
       moves.setText("' X ' MOVE");
       isGameActive = true;
    }
}
