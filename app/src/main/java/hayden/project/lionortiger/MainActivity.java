package hayden.project.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView whoTurn;

        enum Player {

            one, two
        }

        Player currentPlayer = Player.one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whoTurn = findViewById(R.id.whosTurn);


    }

    //onClick method
    public void lionImageClicked(View imageView){

        ImageView tappedImageView = (ImageView) imageView;
        tappedImageView.setTranslationX(-2000);

        if(currentPlayer == Player.one) {
            tappedImageView.setImageResource(R.drawable.lion);
            whoTurn.setText(R.string.player2);
            currentPlayer = Player.two;
        }
        else if(currentPlayer == Player.two){
            tappedImageView.setImageResource(R.drawable.tiger);
            whoTurn.setText(R.string.player1);
            currentPlayer = Player.one;
        }
        tappedImageView.animate().translationXBy(2000).alpha(1).rotation(720).setDuration(1000);



    }





}
