package kr.hs.emirim.w2019.ex14_15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] fruitsArr = {"수박", "참외", "복숭아"};
    int[] imgsArr = {R.drawable.img01, R.drawable.img02, R.drawable.img03};
    Button btnFruits;
    ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDialog = findViewById(R.id.btn_dialog);
        btnFruits = findViewById(R.id.btn_fruits);
        btnDialog.setOnClickListener(btnListener);
        btnFruits.setOnClickListener(btnListener);
        imgV = findViewById(R.id.imgv);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog:
                   /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle(R.string.dialog_title);
                    dialog.setMessage(R.string.dialog_message);
                    dialog.setIcon(R.drawable.warning);
                    dialog.setPositiveButton(R.string.btn_positive, btnPositiveListener);*/
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.dialog_title)
                            .setMessage(R.string.dialog_message)
                            .setIcon(R.drawable.warning)
                            .setPositiveButton(R.string.btn_positive, btnPositiveListener)
                            .show();
                    break;
                case R.id.btn_fruits:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.btn_fruits)
                            .setSingleChoiceItems(fruitsArr, 0, fruitsItemListener)
                            .setIcon(R.drawable.watermelon)
                            .setPositiveButton("닫기", null)
                            .show();
                    break;
            }
        }
    };

    DialogInterface.OnClickListener fruitsItemListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            btnFruits.setText(fruitsArr[which]);
            imgV.setImageResource(imgsArr[which]);
        }
    };

    DialogInterface.OnClickListener btnPositiveListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "대화상자 확인 버튼을 클릭하셨어요~", Toast.LENGTH_SHORT).show();
        }
    };
}