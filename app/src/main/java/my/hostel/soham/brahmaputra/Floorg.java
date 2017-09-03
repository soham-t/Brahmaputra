package my.hostel.soham.brahmaputra;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Soham on 7/18/2017.
 */

public class Floorg extends AppCompatActivity {
    private float preX;
    private float preY;
    private Matrix matrix = new Matrix();
    private float scale = 1f;
    private ScaleGestureDetector SGD;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floorg);
        Intent intent = getIntent();
        imageView =(ImageView)findViewById(R.id.mapg);
        SGD = new ScaleGestureDetector(this,new ScaleListener());

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float currentX, currentY;

                switch (event.getAction()& MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN:
                        preX = event.getX();
                        preY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        currentX = event.getX();
                        currentY = event.getY();
                        imageView.scrollBy((int) (preX - currentX), (int) (preY - currentY));
                        preX = currentX;
                        preY = currentY;
                        break;
                    case MotionEvent.ACTION_UP:
                        currentX = event.getX();
                        currentY = event.getY();
                        imageView.scrollBy((int) (preX - currentX), (int) (preY - currentY));
                        break;
                }
                SGD.onTouchEvent(event);
                return true;
            }
        });


    }


    public boolean onTouchEvent(MotionEvent ev) {
        SGD.onTouchEvent(ev);
        return true;
    }


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            matrix.setScale(scale, scale);
            imageView.setImageMatrix(matrix);

            return true;
        }
    }
}
