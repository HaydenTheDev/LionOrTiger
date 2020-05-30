package hayden.project.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private TextView whoTurn;

    private GridLayout gridLayout;
    private Button resetBtn;

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

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-"); //took out real id
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        gridLayout = findViewById(R.id.gridLayout);
        resetBtn = findViewById(R.id.reset);
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

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

    }

    //onClick method
    public void lionImageClicked(View imageView) throws InterruptedException {
        ImageView tappedImageView = (ImageView) imageView;
        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());

        if(playerChoice[tiTag] == Player.none && !gameOver) {
            tappedImageView.setTranslationX(-2000);
            playerChoice[tiTag] = currentPlayer;

            if (currentPlayer == Player.one) {
                tappedImageView.setImageResource(R.mipmap.carol_baskin_foreground);//Changed picture
                whoTurn.setText(R.string.player2);
                currentPlayer = Player.two;

            } else if (currentPlayer == Player.two) {
                tappedImageView.setImageResource(R.mipmap.joe_exotic_foreground);
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
                    //set button to visible after game completion
                        resetBtn.setVisibility(View.VISIBLE);
                        gameOver = true;

                    if (currentPlayer == Player.one) {
                        whoTurn.setText("Tiger King has won!");
                        whoTurn.setTextColor(getResources().getColor(R.color.winnerColor));
                        whoTurn.setTextSize(20f);
                        whoTurn.animate().scaleX(2).scaleY(2).translationY(400).setDuration(1000);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                    } else if (currentPlayer == Player.two) {
                        whoTurn.setText("Carol Baskin has won!");
                        whoTurn.setTextSize(20f);
                        whoTurn.setTextColor(getResources().getColor(R.color.winnerColor));
                        whoTurn.animate().scaleX(2).scaleY(2).translationY(400).setDuration(1000);

                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                    } else if (currentPlayer == Player.none) {
                        whoTurn.setText("Nobody won!");
                        whoTurn.setTextColor(getResources().getColor(R.color.winnerColor));
                        whoTurn.animate().scaleX(2).scaleY(2).translationY(400).setDuration(1000);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }

                    }
                }
            }
        }
    }
    private void resetGame(){
        //will return the amount of grid space or children in grid
        for (int index = 0; index < gridLayout.getChildCount(); index++){

            ImageView imageView = (ImageView) gridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.2f);
            whoTurn.animate().translationY(-400).setDuration(1000);
        }

        currentPlayer = Player.one;

        playerChoice[0] = Player.none;
        playerChoice[1] = Player.none;
        playerChoice[2] = Player.none;
        playerChoice[3] = Player.none;
        playerChoice[4] = Player.none;
        playerChoice[5] = Player.none;
        playerChoice[6] = Player.none;
        playerChoice[7] = Player.none;
        playerChoice[8] = Player.none;

        gameOver = false;

    }
}
