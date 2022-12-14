package com.example.simplecamera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends Activity {
	 private static final int CAMERA_REQUEST = 1888;
	 ImageView imageView;
	 public void onCreate(Bundle savedInstanceState) {

	     super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         imageView = (ImageView) this.findViewById(R.id.imageView1);
         Button photoButton = (Button) this.findViewById(R.id.button1);

         photoButton.setOnClickListener(new View.OnClickListener() {

	     @Override
	     public void onClick(View v) {
              Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
              startActivityForResult(cameraIntent, CAMERA_REQUEST);
         }
        });
       }

     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      if (requestCode == CAMERA_REQUEST) {
       Bitmap photo = (Bitmap) data.getExtras().get("data");
       imageView.setImageBitmap(photo);
      }
   }
   private void saveToGallery(){
	     BitmapDrawable bitmapDrawable =(BitmapDrawable)imageView.getDrawable();
	     Bitmap bitmap = bitmapDrawable.getBitmap();
       FileOutputStream outputStream =null;
       File file = Environment.getExternalStorageDirectory();
       File dir = new File(file.getAbsolutePath() + */Mypics*);
       dir.mkdirs();

   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
