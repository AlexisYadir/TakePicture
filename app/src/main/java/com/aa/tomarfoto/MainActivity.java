package com.aa.tomarfoto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button btnImage;
    ImageView Image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnImage = (Button) findViewById(R.id.Imagebtn);
        Image = (ImageView) findViewById(R.id.Image);

        btnImage.setOnClickListener(view -> {
            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePicture.resolveActivity(getPackageManager()) != null ) {

                startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extra = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extra.get("data");
            Image.setImageBitmap(imageBitmap);
        }
    }
}
