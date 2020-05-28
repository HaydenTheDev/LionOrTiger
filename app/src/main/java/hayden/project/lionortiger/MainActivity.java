package hayden.project.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private TextView whoTurn;


        enum Player {
            one, two, none;
        }
        Player currentPlayer = Player.one;

        //array
        Player[] playerChoice = new Player[9];

        //2D array for winner.
        int [][] arrayWinner = {{0,1,2},{3,4,5},{6,7,8}, {0,3,6},{1,4,7},{2,5,8}, {0,4,8},{2,4,6}};

        private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whoTurn = findViewById(R.id.whosTurn);

        playerChoice[0] = Player.none;
        playerChoice[1] = Player.none;
        playerChoice[2] = Player.none;
        playerChoice[3] = Player.none;
        playerChoice[4] = Player.none;
        playerChoice[5] = Player.none;
        playerChoice[6] = Player.none;
        playerChoice[7] = Player.none;
        playerChoice[8] = Player.none;

    }

    //onClick method
    public void lionImageClicked(View imageView) {
        ImageView tappedImageView = (ImageView) imageView;
        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());

        if(playerChoice[tiTag] == Player.none && !gameOver) {
            tappedImageView.setTranslationX(-2000);
            playerChoice[tiTag] = currentPlayer;

            if (currentPlayer == Player.one) {
                tappedImageView.setImageResource(R.drawable.lion);
                whoTurn.setText(R.string.player2);
                currentPlayer = Player.two;

            } else if (currentPlayer == Player.two) {
                tappedImageView.setImageResource(R.drawable.tiger);
                whoTurn.setText(R.string.player1);
                currentPlayer = Player.one;
            }
            tappedImageView.animate().translationXBy(2000).
                    alpha(1).rotation(720).setDuration(1000);

//        Toast.makeText(this, tappedImageView.getTag().
//                toString(),Toast.LENGTH_SHORT).show();

            for (int[] winnerArray : arrayWinner) {
                if (playerChoice[winnerArray[0]] == playerChoice[winnerArray[1]]
                        && playerChoice[winnerArray[1]] == playerChoice[winnerArray[2]]
                        && playerChoice[winnerArray[0]] != Player.none) {
                        gameOver = true;

                    if (currentPlayer == Player.one) {
                        Toast.makeText(this, "Player 1 is the Winner", Toast.LENGTH_SHORT).show();

                    } else if (currentPlayer == Player.two) {
                        Toast.makeText(this, "Player 2 is the Winner", Toast.LENGTH_SHORT).show();
                    } else if (currentPlayer == Player.none) {
                        Toast.makeText(this, "Nobody won!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
