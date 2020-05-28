package hayden.project.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

enum Player {

    one, two
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    //onClick method
    public void lionImageClicked(View imageView){
        ImageView tappedImageView = (ImageView) imageView;
        tappedImageView.setTranslationX(-2000);
        tappedImageView.setImageResource(R.drawable.tiger);
        tappedImageView.animate().translationXBy(2000).alpha(1).setDuration(1000);



    }





}
