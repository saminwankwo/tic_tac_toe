package com.example.root.tic_tac_toe;

import java.util.Random;

public class GameEngine {
    private static final Random RANDOM = new Random();
    private char[] elts;
    private char currentPlayer;
    private boolean ended;

    public GameEngine() {
        elts = new char[9];
        newgame();

    }

    public boolean isEnded() {
        return ended;
    }

    public char play(int x, int y){
        if (!ended && elts[3 * y + x] == ' ' ){
           elts[3 * y + x ] = currentPlayer;
           changePlayer();
        }

        return checkEnd();
    }

    public void changePlayer(){
        currentPlayer = (currentPlayer == 'X' ? '0'  : 'X' );
    }

    public char elt(int x, int y){
        return elts[3 * y + x];
    }

    public void newgame(){
        for (int i = 0; i < elts.length; i++){

            elts[i] = ' ';
        }

        currentPlayer = 'X';
        ended =false;
    }

    public char checkEnd(){

        for (int i = 0; i < 3; i++){
            if (elt(i, 0) != ' ' && elt(i, 0) == elt(i, 1) && elt(i, 1) == elt(i, 2) ){
                ended = true;
                return elt(i, 0);
            }

            if (elt(0, i) != ' ' && elt(0, i) == elt(1, i) && elt(1, i) == elt(2, i) ){
                ended = true;
                return elt(0, i);
            }
        }

        if (elt(0, 0) != ' ' && elt(0, 0) == elt(1, 1) && elt(1, 1) == elt(2, 2) ){

            ended = true;
            return elt(0,0);
        }

        if (elt(2, 0) != ' '&& elt(2, 0) == elt(1,1) && elt(1, 1) == elt(0,2)){
            ended = true;
            return elt(2, 0);
        }

        for (int i = 0; i < 9; i++){
            if (elts[i] == ' ')
                return ' ';
        }

        return 'T'; //tie
    }

    public char computer(){
        if (!ended){
            int postion = -1;

            do {

                postion = RANDOM.nextInt(9);

            } while (elts[postion] != ' ');

            elts[postion] = currentPlayer;
            changePlayer();
        }
        return checkEnd();
    }

}
