package org.techtown.dialogtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton radioSolar, radioMoonbyul, radioWheein, radioHwasa;
    View dialogView;
    ImageView dlgImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        radioSolar = findViewById(R.id.radio_solar);
        radioMoonbyul = findViewById(R.id.radio_moonbyul);
        radioWheein = findViewById(R.id.radio_wheein);
        radioHwasa = findViewById(R.id.radio_hwasa);
        Button btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(btnShowListener);
    }

    View.OnClickListener btnShowListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogView = View.inflate(MainActivity.this, R.layout.dialog1, null);
            dlgImg = dialogView.findViewById(R.id.img);
            int selectedId = 0;
            String selectedTitle = "";
            switch (rg.getCheckedRadioButtonId()) {
                case R.id.radio_solar:
                    selectedId = R.drawable.solar;
                    selectedTitle = radioSolar.getText().toString();
                    break;
                case R.id.radio_moonbyul:
                    selectedId = R.drawable.moonstar;
                    selectedTitle = radioMoonbyul.getText().toString();
                    break;
                case R.id.radio_wheein:
                    selectedId = R.drawable.wheein;
                    selectedTitle = radioWheein.getText().toString();
                    break;
                case R.id.radio_hwasa:
                    selectedId = R.drawable.hwasa;
                    selectedTitle = radioHwasa.getText().toString();
                    break;
            }
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle(selectedTitle);
            dlgImg.setImageResource(selectedId);
            dlg.setView(dialogView);
            dlg.setNegativeButton("닫기", null);
            dlg.show();
        }
    };
}