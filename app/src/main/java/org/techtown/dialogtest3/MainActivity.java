package org.techtown.dialogtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPicture = findViewById(R.id.btn_picture);
        btnPicture.setOnClickListener(btnPictureListener);
    }

    View.OnClickListener btnPictureListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogView = View.inflate(MainActivity.this, R.layout.dialog1, null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setView(dialogView);
            dlg.setNegativeButton("닫기", negativeButtonListener);
            dlg.show();
        }
    };
}