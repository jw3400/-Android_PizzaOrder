package practice.android_pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    EditText e2;
    EditText e3;
    CheckBox ch;
    RadioButton r1;
    RadioButton r2;
    Button b1;
    TextView label1;
    TextView label2;
    TextView label3;
    TextView label4;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("피자 주문하기");

        label1 = (TextView) findViewById(R.id.textView4);
        label2 = (TextView) findViewById(R.id.textView5);
        label3 = (TextView) findViewById(R.id.textView6);
        label4 = (TextView) findViewById(R.id.textView7);
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        iv = (ImageView) findViewById(R.id.imageView);
        ch = (CheckBox) findViewById(R.id.checkBox);

        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked() == true) {
                    iv.setImageResource(R.drawable.pickle);
                }
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r2.isChecked() == true) {
                    iv.setImageResource(R.drawable.source);
                }
            }
        });

        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String input1 = e1.getText().toString();
                String input2 = e2.getText().toString();
                String input3 = e3.getText().toString();

                int result1;
                double result2;
                double result3;

                if (input1.equals("") || input2.equals("") || input3.equals("")) {
                    label4.setText("공백 없이 입력해야 합니다.");
                }
                else if(Integer.parseInt(input1.toString()) < 0 || Integer.parseInt(input2.toString()) < 0 || Integer.parseInt(input3.toString()) < 0) {
                    label4.setText("양수만 입력해야 합니다.");
                }
                else {
                    label4.setText("");
                    result1 = Integer.parseInt(input1) + Integer.parseInt(input2) + Integer.parseInt(input3);
                    label1.setText("주문 개수 : " + result1);

                    if (ch.isChecked()) {
                        result2 = (16000 * Double.parseDouble(input1)) + (11000 * Double.parseDouble(input2)) + (4000 * Double.parseDouble(input3));
                        result3 = result2 - (result2 * 0.07);
                        label2.setText("주문 금액 : " + result3);
                    } else {
                        result2 = (16000 * Double.parseDouble(input1)) + (11000 * Double.parseDouble(input2)) + (4000 * Double.parseDouble(input3));
                        label2.setText("주문 금액 : " + result2);
                    }
                }

                if(r1.isChecked() == true) {
                    label3.setText("피클을 선택하셨습니다.");
                }
                else if(r2.isChecked() == true) {
                    label3.setText("소스를 선택하셨습니다.");
                }
                else
                    label3.setText("");
            }
        });





    }
}
