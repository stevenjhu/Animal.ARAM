package com.idtech.shiqihu.animalaram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import java.util.Random;
import android.widget.TextView;
import android.media.MediaPlayer;


import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    public int computerScore = 0;
    public int playerScore = 0;


    public int determineWinner() {
        if (playerChoice == computerChoice) {
            resultTextView.setText("Tie. Nothing happens. So boring! Continue!");
            tietie();
        }
        else if ((playerChoice == Choice.ELEPHANT && computerChoice == Choice.LION )
                || (playerChoice == Choice.ELEPHANT && computerChoice == Choice.LEOPARD)
                || (playerChoice == Choice.ELEPHANT &&computerChoice == Choice.CAT)

                || (playerChoice == Choice.LION && computerChoice == Choice.TIGER)
                || (playerChoice == Choice.LION && computerChoice == Choice.LEOPARD)
                || (playerChoice == Choice.LION && computerChoice == Choice.WOLF)

                || (playerChoice == Choice.TIGER && computerChoice == Choice.ELEPHANT)
                || (playerChoice == Choice.TIGER && computerChoice == Choice.LEOPARD)
                || (playerChoice == Choice.TIGER && computerChoice == Choice.WOLF)

                || (playerChoice == Choice.LEOPARD && computerChoice == Choice.WOLF)
                || (playerChoice == Choice.LEOPARD && computerChoice == Choice.CAT)
                || (playerChoice == Choice.LEOPARD && computerChoice == Choice.MOUSE)

                || (playerChoice == Choice.WOLF && computerChoice == Choice.CAT)
                || (playerChoice == Choice.WOLF && computerChoice == Choice.MOUSE)
                || (playerChoice == Choice.WOLF && computerChoice == Choice.ELEPHANT)

                || (playerChoice == Choice.CAT && computerChoice == Choice.LION)
                || (playerChoice == Choice.CAT && computerChoice == Choice.TIGER)
                || (playerChoice == Choice.CAT && computerChoice == Choice.MOUSE)

                || (playerChoice == Choice.MOUSE && computerChoice == Choice.LION)
                || (playerChoice == Choice.MOUSE && computerChoice == Choice.TIGER)
                || (playerChoice == Choice.MOUSE && computerChoice == Choice.ELEPHANT)
                ){
            resultTextView.setText("Player wins! Congrats! You are so lucky!");
            wow();
            playerScore++;
            player_score.setText(""+playerScore);
            return playerScore;
        } else {
            resultTextView.setText("Computer wins! Don't worry. You are not suppose to win anyway ^_^");
            boo();
            computerScore++;
            computer_score.setText(""+computerScore);
            return computerScore;
        }
       return playerScore;
    }

    public enum Choice {
        ELEPHANT,LION,TIGER,LEOPARD,WOLF,CAT,MOUSE
    }
    ImageView imageView1;
    ImageView imageView2;
    Choice playerChoice;
    Choice computerChoice;
    TextView resultTextView;
    TextView player_score ;
    TextView computer_score;
    ImageView greybox1;

    public void makeComputerChoice(){
        Random generator = new Random(); //generate number from 0-2
        int randnum = generator.nextInt(7);

        if (randnum == 0){
            computerChoice = Choice.ELEPHANT;
            imageView2.setImageResource(R.drawable.elephant);
            imageView2.findViewById(R.id.imageView2);
        }
        else if (randnum == 1){
            computerChoice = Choice.LION;
            imageView2.setImageResource(R.drawable.lion);
            imageView2.findViewById(R.id.imageView2);

        }
        else if (randnum == 2){
            computerChoice = Choice.TIGER;
            imageView2.setImageResource(R.drawable.tiger);
            imageView2.findViewById(R.id.imageView2);
        }
        else if (randnum == 3){
            computerChoice = Choice.LEOPARD;
            imageView2.setImageResource(R.drawable.leopard);
            imageView2.findViewById(R.id.imageView2);
        }
        else if (randnum == 4){
            computerChoice = Choice.WOLF;
            imageView2.setImageResource(R.drawable.wolf);
            imageView2.findViewById(R.id.imageView2);
        }
        else if (randnum == 5){
            computerChoice = Choice.CAT;
            imageView2.setImageResource(R.drawable.cat);
            imageView2.findViewById(R.id.imageView2);
        }
        else {
            computerChoice = Choice.MOUSE;
            imageView2.setImageResource(R.drawable.mouse);
            imageView2.findViewById(R.id.imageView2);
        }
    }
    public void wow(){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.wow);
        mp.start();
    }
    public void boo(){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.boo);
        mp.start();
    }
    public void tietie(){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.wind);
        mp.start();
    }

//player choice
    public void elephantButtonPressed(View view) {
        imageView1.setImageResource(R.drawable.elephant);
        playerChoice = Choice.ELEPHANT;
        makeComputerChoice();
        determineWinner();
    }
    public void lionButtonPressed(View view) {

        imageView1.setImageResource(R.drawable.lion);
        playerChoice = Choice.LION;
        makeComputerChoice();
        determineWinner();
    }
    public void tigerButtonPressed(View view) {
        imageView1.setImageResource(R.drawable.tiger);
        playerChoice = Choice.TIGER ;
        makeComputerChoice();
        determineWinner();
    }
    public void leopardButtonPressed(View view) {
        imageView1.setImageResource(R.drawable.leopard);
        playerChoice = Choice.LEOPARD;
        makeComputerChoice();
        determineWinner();
    }
    public void wolfButtonPressed(View view) {
        imageView1.setImageResource(R.drawable.wolf);
        playerChoice = Choice.WOLF;
        makeComputerChoice();
        determineWinner();
    }
    public void catButtonPressed(View view) {
        imageView1.setImageResource(R.drawable.cat);
        playerChoice = Choice.CAT;
        makeComputerChoice();
        determineWinner();
    }
    public void mouseButtonPressed(View view) {
        imageView1.setImageResource(R.drawable.mouse);
        playerChoice = Choice.MOUSE;
        makeComputerChoice();
        determineWinner();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        player_score = (TextView)findViewById(R.id.player_score);
        computer_score = (TextView)findViewById(R.id.computer_score);
        greybox1 = (ImageView)findViewById(R.id.greybox1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
