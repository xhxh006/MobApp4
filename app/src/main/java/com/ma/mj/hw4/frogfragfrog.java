package com.ma.mj.hw4;

import android.app.Activity;
import android.content.DialogInterface;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by KimMinJung on 2017-03-30.
 */

public class frogfragfrog extends Fragment{
    TextView t2,t4,t6,t8,t10,t12;
    Button b1,b2,b3,b4,b5,b6,b7;
    TableLayout tttable;
    View view;

    String time, pasta, pizza, membership;

    Data apple, redorange, grape, kiwi;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragfrogfrag,container,false);//프레그먼트 레이아웃

        //주문정보
        tttable = (TableLayout) view.findViewById(R.id.tttable);//주문정보 레이아웃

        t2 = (TextView)view.findViewById(R.id.textView2);//테이블명
        t4 = (TextView)view.findViewById(R.id.textView4);//입장시간
        t6 = (TextView)view.findViewById(R.id.textView6);//스파게티 개수
        t8 = (TextView)view.findViewById(R.id.textView8);//피자 개수
        t10 = (TextView)view.findViewById(R.id.textView10);//멤버십 종류
        t12 = (TextView)view.findViewById(R.id.textView12);//총액

        //테이블버튼
        b1 = (Button)view.findViewById(R.id.button);//사과
        b2 = (Button)view.findViewById(R.id.button2);//자몽
        b3 = (Button)view.findViewById(R.id.button3);//키위
        b4 = (Button)view.findViewById(R.id.button4);//포도
        //주문버튼
        b5 = (Button)view.findViewById(R.id.button5);//새주문
        b6 = (Button)view.findViewById(R.id.button6);//주문수정
        b7 = (Button)view.findViewById(R.id.button7);//초기화

        //데이터 관리
        apple = new Data("","0개","0개","없음");
        redorange = new Data("","0개","0개","없음");
        grape = new Data("","0개","0개","없음");
        kiwi = new Data("","0개","0개","없음");

        //사과테이블 선택
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText("사과테이블");
                if(apple.getEntrance().equals("")){
                    Toast.makeText(getActivity(),
                            "비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
                    t4.setVisibility(View.INVISIBLE);
                    t6.setVisibility(View.INVISIBLE);
                    t8.setVisibility(View.INVISIBLE);
                    t10.setVisibility(View.INVISIBLE);
                    t12.setVisibility(View.INVISIBLE);

                }
                else{
                    showInfo(apple.getEntrance(),apple.getPasta(),apple.getPizza(),apple.getMem());
                }
                tttable.setVisibility(View.VISIBLE);
            }
        });
        //자몽테이블 선택
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText("자몽테이블");
                if(redorange.getEntrance() == ""){
                    Toast.makeText(getActivity(),
                            "비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
                    t4.setVisibility(View.INVISIBLE);
                    t6.setVisibility(View.INVISIBLE);
                    t8.setVisibility(View.INVISIBLE);
                    t10.setVisibility(View.INVISIBLE);
                    t12.setVisibility(View.INVISIBLE);
                }
                else{
                    showInfo(redorange.getEntrance(),redorange.getPasta(),redorange.getPizza(),redorange.getMem());
                }
                tttable.setVisibility(View.VISIBLE);
            }
        });
        //키위테이블 선택
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText("키위테이블");
                if(kiwi.getEntrance() == "") {
                    Toast.makeText(getActivity(),
                            "비어있는 테이블입니다.", Toast.LENGTH_SHORT).show();
                    t4.setVisibility(View.INVISIBLE);
                    t6.setVisibility(View.INVISIBLE);
                    t8.setVisibility(View.INVISIBLE);
                    t10.setVisibility(View.INVISIBLE);
                    t12.setVisibility(View.INVISIBLE);
                }
                else{
                    showInfo(kiwi.getEntrance(),kiwi.getPasta(),kiwi.getPizza(),kiwi.getMem());
                }
                tttable.setVisibility(View.VISIBLE);
            }
        });
        //포도테이블 선택
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2.setText("포도테이블");
                if(grape.getEntrance() == ""){
                    Toast.makeText(getActivity(),
                            "비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
                    t4.setVisibility(View.INVISIBLE);
                    t6.setVisibility(View.INVISIBLE);
                    t8.setVisibility(View.INVISIBLE);
                    t10.setVisibility(View.INVISIBLE);
                    t12.setVisibility(View.INVISIBLE);
                }
                else{
                    showInfo(grape.getEntrance(),grape.getPasta(),grape.getPizza(),grape.getMem());
                }
                tttable.setVisibility(View.VISIBLE);
            }
        });

        //새주문 선택
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //대화상자 구성
                View dlgview = inflater.inflate(R.layout.dialog_info, null);//대화상자 레이아웃

                final EditText e1 = (EditText)dlgview.findViewById(R.id.editText);//파스타 개수
                final EditText e2 = (EditText)dlgview.findViewById(R.id.editText2);//피자 개수

                final RadioButton r1 = (RadioButton) dlgview.findViewById(R.id.radioButton);//없음
                final RadioButton r2 = (RadioButton) dlgview.findViewById(R.id.radioButton2);//기본
                final RadioButton r3 = (RadioButton) dlgview.findViewById(R.id.radioButton3);//VIP

                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                time = format.format(date);

                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                dlg.setTitle("새로 주문하기")
                        .setNegativeButton("닫기", null)
                        .setPositiveButton("주문", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                pasta = e1.getText().toString();
                                pizza = e2.getText().toString();

                                if (r1.isChecked()){
                                    membership = "없음";
                                }
                                else if(r2.isChecked()){
                                    membership = "기본";
                                }
                                else if (r3.isChecked()){
                                    membership = "VIP";
                                }
                                store (time, pasta, pizza, membership);
                                showInfo(time, pasta, pizza, membership);

                                t4.setVisibility(View.VISIBLE);
                                t6.setVisibility(View.VISIBLE);
                                t8.setVisibility(View.VISIBLE);
                                t10.setVisibility(View.VISIBLE);
                                t12.setVisibility(View.VISIBLE);

                                if(t2.getText() == "사과테이블"){
                                    b1.setText("사과테이블");
                                }
                                else if(t2.getText() == "자몽테이블"){
                                    b2.setText("자몽테이블");
                                }
                                else if (t2.getText() == "키위테이블"){
                                    b3.setText("키위테이블");
                                }
                                else if(t2.getText() == "포도테이블"){
                                    b4.setText("포도테이블");
                                }

                                Snackbar.make(getView(), "정보가 입력되었습니다.", Snackbar.LENGTH_SHORT).show();
                            }})
                        .setView(dlgview).show();
            }
        });
        //주문수정 선택
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //대화상자 구성
                View dlgview = View.inflate(getActivity(),R.layout.dialog_info, null);//대화상자 레이아웃

                final EditText e1 = (EditText)dlgview.findViewById(R.id.editText);//파스타 개수
                final EditText e2 = (EditText)dlgview.findViewById(R.id.editText2);//피자 개수

                final RadioButton r1 = (RadioButton) dlgview.findViewById(R.id.radioButton);//없음
                final RadioButton r2 = (RadioButton) dlgview.findViewById(R.id.radioButton2);//기본
                final RadioButton r3 = (RadioButton) dlgview.findViewById(R.id.radioButton3);//VIP

                AlertDialog.Builder dlg = new AlertDialog.Builder(getActivity());
                dlg.setTitle("주문 수정하기")
                        .setNegativeButton("닫기",null)
                        .setPositiveButton("주문", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                if (t4.getText() == ""){
                                    Snackbar.make(getView(), "사람이 없습니다.", Snackbar.LENGTH_SHORT).show();
                                }
                                else {
                                    pasta = e1.getText().toString();
                                    pizza = e2.getText().toString();

                                    if (r1.isChecked()) {
                                        membership = "없음";
                                    } else if (r2.isChecked()) {
                                        membership = "기본";
                                    } else if (r3.isChecked()) {
                                        membership = "VIP";
                                    }
                                    store (time, pasta, pizza, membership);
                                    showInfo(time, pasta, pizza, membership);

                                    Snackbar.make(getView(), "정보가 입력되었습니다.", Snackbar.LENGTH_SHORT).show();
                                }
                            }})
                        .setView(dlgview)
                        .show();
            }
        });
        //초기화 선택
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = "";
                pasta = "0";
                pizza = "0";
                membership = "없음";
                store(time,pasta,pizza,membership);

                //정보내용 가리기
                t4.setVisibility(View.INVISIBLE);
                t6.setVisibility(View.INVISIBLE);
                t8.setVisibility(View.INVISIBLE);
                t10.setVisibility(View.INVISIBLE);
                t12.setVisibility(View.INVISIBLE);
                tttable.setVisibility(View.INVISIBLE);

                //버튼 내용 바꾸기
                if(t2.getText() == "사과테이블"){
                    b1.setText("사과 Table (비어있음)");
                }
                else  if(t2.getText() == "자몽테이블"){
                    b2.setText("자몽 Table (비어있음)");
                }
                else if(t2.getText() == "키위테이블"){
                    b3.setText("키위 Table (비어있음)");
                }
                else if(t2.getText() == "포도테이블"){
                    b4.setText("포도 Table (비어있음)");
                }

                Toast.makeText(getActivity(),"초기화 되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    //데이터 저장하는 메소드
    public void store(String time, String pasta, String pizza,String membership){
        if (pasta.equals("")){
            pasta ="0";
        }
        if(pizza.equals("")){
            pizza = "0";
        }
        if(t2.getText() == "사과테이블"){
            apple.setEntrance(time);
            apple.setPasta(pasta);
            apple.setPizza(pizza);
            apple.setMem(membership);

        }
        else if(t2.getText() == "자몽테이블"){
            redorange.setEntrance(time);
            redorange.setPasta(pasta);
            redorange.setPizza(pizza);
            redorange.setMem(membership);
        }
        else if(t2.getText() == "포도테이블"){
            grape.setEntrance(time);
            grape.setPasta(pasta);
            grape.setPizza(pizza);
            grape.setMem(membership);
        }
        else if(t2.getText() == "키위테이블"){
            kiwi.setEntrance(time);
            kiwi.setPasta(pasta);
            kiwi.setPizza(pizza);
            kiwi.setMem(membership);
        }
    }

    //데이터 보여주는 메소드
    public void showInfo(String time, String pasta, String pizza, String membership){
        if (pasta.equals("")){
            pasta = "0";
        }
        if(pizza.equals("")){
            pizza = "0";
        }
        t4.setText(time);
        t6.setText(pasta + "개");
        t8.setText(pizza + "개");
        if (membership.equals("없음")){
            t10.setText(membership);
        }
        else {
            t10.setText(membership + "멤버십");
        }
        t12.setText(Integer.toString(calculator(pasta,pizza,membership)) + "원");

        t4.setVisibility(View.VISIBLE);
        t6.setVisibility(View.VISIBLE);
        t8.setVisibility(View.VISIBLE);
        t10.setVisibility(View.VISIBLE);
        t12.setVisibility(View.VISIBLE);
    }

    //총액 계산하는 메소드
    public int calculator(String pasta, String pizza, String mem){
        int total = Integer.parseInt(pasta)*10000 + Integer.parseInt(pizza)*12000;
        int discount = 100;

        if (mem.equalsIgnoreCase("기본")){
            discount = 90;
        }
        else if(mem.equalsIgnoreCase("VIP")){
            discount = 70;
        }

        return  total * discount /100;
    }
}
