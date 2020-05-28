package hayden.project.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  private   ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
  private   ImageView tigerImg1,tigerImg2,tigerImg3,tigerImg4,tigerImg5,tigerImg6,tigerImg7,tigerImg8,tigerImg9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lion ImageViews
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);

        //tiger ImageView
        tigerImg1 = findViewById(R.id.tigerImg1);
        tigerImg2 = findViewById(R.id.tigerImg2);
        tigerImg3 = findViewById(R.id.tigerImg3);
        tigerImg4 = findViewById(R.id.tigerImg4);
        tigerImg5 = findViewById(R.id.tigerImg5);
        tigerImg6 = findViewById(R.id.tigerImg6);
        tigerImg7 = findViewById(R.id.tigerImg7);
        tigerImg8 = findViewById(R.id.tigerImg8);
        tigerImg9 = findViewById(R.id.tigerImg9);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lionPictureSwitch();
            }
        });
    }

    public void lionPictureSwitch(){
        img1.animate().translationX(-400).rotation(-360).setDuration(3000);

    }



}
