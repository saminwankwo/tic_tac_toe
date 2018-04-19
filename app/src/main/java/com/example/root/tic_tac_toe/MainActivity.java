package com.example.root.tic_tac_toe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BoardView boardView;
    private GameEngine gameEngine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardView = (BoardView) findViewById(R.id.board);
        gameEngine = new GameEngine();
        boardView.setGameEngine(gameEngine);
        boardView.setMainActivity(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_new_game){
            newGame();
        }

        return super.onOptionsItemSelected(item);
    }

    public void gameEnded(char c){

        String msg = (c == 'T') ? "Game Ended. Tie" : "Game Ended. " + c + " win";

        new AlertDialog.Builder(this).setTitle("tic tac toe").
                setMessage(msg).
                setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        newGame();
                    }
                }).show();

    }

    private void newGame(){
        gameEngine.newgame();
        boardView.invalidate();
    }



}