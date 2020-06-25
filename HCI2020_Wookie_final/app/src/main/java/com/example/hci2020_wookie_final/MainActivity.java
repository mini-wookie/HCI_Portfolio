package com.example.hci2020_wookie_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] items = {"DSC KMOU", "해대인", "부산정보문화센터", "해대인사이트",
            "제어자동화공학부", "LINC+", "아라누리", "CodingIsLand", "Github"};
    private String[] dscrt = {"Lead", "관리자", "ICT 서포터즈", "학회장",
            "학부생", "발표 수상", "영자 신문 기자", "기획자", "mini-wookie"};
    private String[] detail = {"Google Developers에서 지원하는 Developer Student Clubs KMOU를 설립하였으며, 1년동안 Lead직을 수행하였다.\n\n" +
            "한국해양대학교에서 웹개발, 앱개발, 딥러닝이 하고 싶은 인원들을 모아서 활동하였다." +
            "전공자와 비전공자 모두 참여가 가능하도록 하였고, 최대한 많은 이들이 개발을 경험할 수 있도록 하는 것을 목표로 했다.",
            "해대인의 관리자직을 위임받아 2019년부터 관리 및 기획을 진행하였다.\n\n" +
            "해양대 정보 제공 서비스인 해대인(카카오 챗봇)을 개발자로부터 위임 받았다." +
            "한국해양대학교를 방문하는 모든 이들이 해양대의 정보를 조금 더 쉽게 접할 수 있도록 하는 것을 목표로 했다.",
            "부산정보문화센터에서 진행하는 ICT 서포터즈를 수행하였다.\n\n" +
            "ICT 서포터즈를 진행하며, 부산 내의 교육기관 등을 방문하여 코딩 교육 보조를 하였다." +
            "IT융합 전공으로 배운 내용들을 다른 이들에게 활용할 수 있도록 하기 위해 시작하였다.",
            "해대인사이트 학생연구회 설립 후 회장으로 활동하였다.\n\n" +
            "해대인사이트라는 제어자동화공학부 소속의 학생연구회를 신규 개설했다." +
            "학과 과목보다는 개발에 조금 더 집중할 수 있도록 지원하는 학회이다.",
            "제어자동화공학부에서 학부과정을 이수하고 있다.\n\n" +
            "한국해양대학교 제어자동화공학부에서 IT융합전공을 하고 있으며, 제어와 IT의 다양한 과목들을 수료하였다.",
            "LINC+에서 다양한 활동을 체험해보며 경험을 쌓았다.\n\n" +
            "오션 해커톤 대회 우수상, 글로벌 발표대회 최우수상, 글로컬마케터 외국어 발표 경진대회 우승 등 다양한 활동을 통해 수상경력을 보유했다.",
            "아라누리에서 영자신문 기자로 활동하였다.\n\n" +
            "한국해양대학교 영자신문국 아라누리에서 영문기사 기자를 하였다." +
            "교내의 다양한 소식들은 영문으로 전하는 역할을 하였다.",
            "CodingIsLand에서 개발, 디자인, 기획 등 다양한 부분을 공동 담당하였다.\n\n" +
            "CodingIsland에서의 앱개발 프로젝트 진행에 있어서 전체적인 앱 기획을 진행하였다." +
            "앱 개발에서 메인 페이지와 디자인을 추가로 담당하였다.",
            "Github에 mini-wookie라는 닉네임으로 활동하고 있다.\n\n" +
            "주로 앱개발 프로젝트들을 업로드하고 있으며, 깃헙으로 팀프로젝트도 진행해보았다."};
    private int[] icons ={R.mipmap.dsc,R.mipmap.kmouin, R.mipmap.bicc,R.mipmap.kmouinsight,R.mipmap.ca,R.mipmap.linc,R.mipmap.aranuri,R.mipmap.codingisland,R.mipmap.github};
    private int location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                location = position;
                String item = String.valueOf(parent.getItemAtPosition(position));
                String des = String.valueOf(dscrt[position]);
                TextView stat = (TextView) findViewById(R.id.textView);
                stat.setText(item + "에서 " + des);
            }
        });

        Button detail = (Button) findViewById(R.id.button);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(location);
            }
        });
    }

    private void showAlertDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);

        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView);
        imageView2.setImageResource(icons[position]);

        TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        textView2.setText(detail[position]);

        builder.setView(view);

        final AlertDialog dialog = builder.create();

        dialog.show();
    }
}