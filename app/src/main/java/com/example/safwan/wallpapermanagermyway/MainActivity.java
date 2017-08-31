package com.example.safwan.wallpapermanagermyway;

import android.support.v7.app.AppCompatActivity;

        import android.support.v7.app.AppCompatActivity;
        import java.io.IOException;

        import android.app.Activity;
        import android.app.WallpaperManager;
        import android.graphics.Bitmap;
        import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {

    Bitmap bitmap;
    private GestureDetector gestureDetector;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.e("onDoubleTap", e.toString());
                //handle double tap
                return true;
            }
        });

        ImageView imagePreview = (ImageView)findViewById(R.id.preview);

        imagePreview.setImageResource(R.drawable.wallpaper);
    }
    public void SetupWalls(View v){
        WallpaperManager myWallpaperManager
                = WallpaperManager.getInstance(getApplicationContext());
        try {
            myWallpaperManager.setResource(R.drawable.wallpaper);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void StopWalls(View v){
        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try{
            myWallpaperManager.clear();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
