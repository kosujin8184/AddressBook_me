package com.example.imageviewerapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //멤버변수 ============================================================================================
    private EditText nameTXT, numTXT, emailTXT; //EditText 변수
    private TextView textTXT;   //TextView 변수
    private Button addBTN, delBTN, resBTN;  //Button 변수

    private Address SetAddr;///////////////////////////////////////////////// Class 객체 선언

    private ArrayList<String> Addr = new ArrayList<String>();////////////////   Class객체를 담기위한 ArrayList 객체

    String temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //초기화===========================================================================================
        numTXT = (EditText) findViewById(R.id.nameTXT);
        nameTXT = (EditText) findViewById(R.id.numTXT);
        emailTXT = (EditText) findViewById(R.id.emailTXT);

        textTXT = (TextView) findViewById(R.id.textTXT);

        addBTN = (Button) findViewById(R.id.addBTN);
        resBTN = (Button) findViewById(R.id.addBTN);
        delBTN = (Button) findViewById(R.id.addBTN);


    }


    public void onClick(View v) {


        temp = "";

        //추가 버튼//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (v.getId() == R.id.addBTN) {

            if ((nameTXT.getText().toString().length() > 0) && (numTXT.getText().toString().length() > 0) && (emailTXT.getText().toString().length() > 0)) {
                //각 TextView에 내용이 담겨져 있다면!

                String fx;
                fx = SetAddr.arrPrint(nameTXT.getText().toString(), numTXT.getText().toString(), emailTXT.getText().toString());
                //Class의 arrPrint함수를 통해 TextView에 담긴 String문자열을 각 name number email 변수에  내용 갱신

                Addr.add(fx);
                //Addr, ArrayList객체에 입력된 Class객체 담기

                System.out.println(Addr);   //잘 담긴지 확인하기 위한 프린트문

                for (int i = 0; i < Addr.size(); i++) { //ArrayList에 담긴 내용 TextView에 나타내기 위해 String문자열로 담아 캐스팅

                    temp += Addr.get(i) + "\n";
                }


            }
            else {
                Toast.makeText(getApplicationContext(), "추가하고자하는 내용을 넣으세요!!!!!!!!!!!", Toast.LENGTH_LONG).show();
                //View에 담긴 내용이 없다면 토스트 메시지
            }


        }


        //삭제 버튼/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (v.getId() == R.id.delBTN) {


            ArrayList<String> exam = new ArrayList<String>();   //삭제하기 전 비교하기 위한 ArrayList 객체 선언

            String yx;

            yx = SetAddr.arrPrint(nameTXT.getText().toString(), numTXT.getText().toString(), emailTXT.getText().toString());
            //현재 View에 입력된 문자열 클래스에 담기
            exam.add(yx);
            //클래스에 담긴 내용 ArrayList에 담기

            System.out.println(temp);   //잘 지워진지 확인 위함

            if((nameTXT.getText().toString().length() > 0) && (numTXT.getText().toString().length() > 0) && (emailTXT.getText().toString().length() > 0)){
                //지울게 있을 때

                for(int i=0; i<Addr.size(); i++) {

                    if (exam.contains(Addr.get(i)) == true){    //비교한다. Addr에 담긴 i번째 list와 현재 exzm에담긴(지우기 위한) 내용이 같다면~
                        Addr.remove(i); // Addr의 i번째 list 삭제

                        for(int j=0; j<Addr.size(); j++) {  //지우고 나서 재갱신
                            temp += Addr.get(j) + "\n";
                        }

                    }
                    else    //현재 입력된(지우기 위한) 문자열과 같은 내용이 list에 없다면
                    {
                        Toast.makeText(getApplicationContext(), "없는 내용 입니다.!!!!!!!!!!!", Toast.LENGTH_LONG).show();
                    }

                }

            }
            else {  //더 이상 list에 담긴내용이 없다면 토스트 메시지!!
                Toast.makeText(getApplicationContext(), "지울 내용이 없습니다.!!!!!!!!!!!", Toast.LENGTH_LONG).show();
            }

        }



        //보기 버튼//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (v.getId() == R.id.resBTN) {

            for (int i = 0; i < Addr.size(); i++) { //list갱신
                temp += Addr.get(i) + "\n";
            }

            textTXT.setText(temp);  //Textview에 담긴 리스트 내용들 출력
            System.out.print(temp); //잘 담긴지 확인하기 위한 print구문
        }

    }

}