package com.example.kioskmainpage.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kioskmainpage.Activity.Senior_MenuOption.Senior_MenuSelected_Check;
import com.example.kioskmainpage.Adapter.Senior_MenuAdapter;
import com.example.kioskmainpage.R;
import com.example.kioskmainpage.Utilities.Senior_MenuItem;

public class Senior_Tab_Fragment extends Fragment {

    public static final String ARG_PAGE="ARG_PAGE";

    private int mpage;
    GridView gridView;
    Senior_MenuAdapter senior_menuAdapter;
    ScrollView scrollView;
    private com.melnykov.fab.FloatingActionButton fab;
    int scrollY = 0;
    Context context;

    public static Senior_Tab_Fragment newinstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,page);
        Senior_Tab_Fragment fragment = new Senior_Tab_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mpage = getArguments().getInt(ARG_PAGE);
        context = getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_senior__tab_, container, false);
        final GridView gridView = (GridView)view.findViewById(R.id.gridView);
        scrollView = (ScrollView)view.findViewById(R.id.scrollView);
        fab = (com.melnykov.fab.FloatingActionButton) view.findViewById(R.id.fab);

        senior_menuAdapter = new Senior_MenuAdapter(getActivity());

        if(mpage == 1) {
            senior_menuAdapter.addItem(new Senior_MenuItem("따뜻한 아메리카노", "2500", R.drawable.imgn1_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("차가운 아메리카노", "2500", R.drawable.imgn2_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("따뜻한 카페라떼", "3000", R.drawable.imgn3_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("차가운 카페라떼", "3000", R.drawable.imgn4_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("따뜻한 카페모카", "3500", R.drawable.imgn5_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("차가운 카페모카", "3500", R.drawable.imgn6_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("따뜻한 카라멜 마끼아또", "4000", R.drawable.imgn7_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("차가운 카라멜 마끼아또", "4000", R.drawable.imgn8_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("자바칩 프라푸치노", "4500", R.drawable.imgn9_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("초콜릿 크림 프라푸치노", "4500", R.drawable.imgn10_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("카라멜 프라푸치노", "4500", R.drawable.imgn11_1));
            senior_menuAdapter.addItem(new Senior_MenuItem("바닐라 크림", "4500", R.drawable.imgn12_1));
        }

       if(mpage == 2) {
            senior_menuAdapter.addItem(new Senior_MenuItem("딸기 요거트", "5000", R.drawable.imgn1_2));
            senior_menuAdapter.addItem(new Senior_MenuItem("망고 블렌디드", "5000", R.drawable.imgn2_2));
            senior_menuAdapter.addItem(new Senior_MenuItem("자몽 셔벗 블렌디드", "5000", R.drawable.imgn3_2));
            senior_menuAdapter.addItem(new Senior_MenuItem("쿨 라임 피지오", "5000", R.drawable.imgn4_2));
            senior_menuAdapter.addItem(new Senior_MenuItem("라임 패션 티", "5000", R.drawable.imgn5_2));
            senior_menuAdapter.addItem(new Senior_MenuItem("아이스 라임 티", "5000", R.drawable.imgn6_2));
            senior_menuAdapter.addItem(new Senior_MenuItem("민트 블렌드", "4000", R.drawable.imgn7_2));
            senior_menuAdapter.addItem(new Senior_MenuItem("얼그레이", "4000", R.drawable.imgn8_2));
            senior_menuAdapter.addItem(new Senior_MenuItem("캐모마일 블렌드", "5500", R.drawable.imgn9_2));
           senior_menuAdapter.addItem(new Senior_MenuItem("자몽 허니 블랙 티", "5500", R.drawable.imgn10_2));
           senior_menuAdapter.addItem(new Senior_MenuItem("히비스커스 블렌드", "5500", R.drawable.imgn11_2));
        }

        if(mpage == 3) {
            senior_menuAdapter.addItem(new Senior_MenuItem("가나슈 케이크", "5000", R.drawable.imgn1_3));
            senior_menuAdapter.addItem(new Senior_MenuItem("치즈 케이크", "5000", R.drawable.imgn2_3));
            senior_menuAdapter.addItem(new Senior_MenuItem("블루베리 치즈케이크", "5000", R.drawable.imgn3_3));
            senior_menuAdapter.addItem(new Senior_MenuItem("레드벨벳 케이크", "5000", R.drawable.imgn4_3));
            senior_menuAdapter.addItem(new Senior_MenuItem("스콘", "2000", R.drawable.imgn5_3));
            senior_menuAdapter.addItem(new Senior_MenuItem("카스테라", "4000", R.drawable.imgn6_3));
            senior_menuAdapter.addItem(new Senior_MenuItem("티라미수", "4000", R.drawable.imgn7_3));
        }

        if(mpage == 4) {
            senior_menuAdapter.addItem(new Senior_MenuItem("스타벅스 텀블러", "15000", R.drawable.imgn1_4));
            senior_menuAdapter.addItem(new Senior_MenuItem("그린 워터마크 텀블러", "37000", R.drawable.imgn2_4));
            senior_menuAdapter.addItem(new Senior_MenuItem("블랙 머그", "11000", R.drawable.imgn3_4));
            senior_menuAdapter.addItem(new Senior_MenuItem("그린 텀블러 세트", "48800", R.drawable.imgn4_4));
            senior_menuAdapter.addItem(new Senior_MenuItem("클래식 텀블러 세트", "37900", R.drawable.imgn5_4));
            senior_menuAdapter.addItem(new Senior_MenuItem("컨투어 텀블러 세트", "37900", R.drawable.imgn6_4));
            senior_menuAdapter.addItem(new Senior_MenuItem("그린 클래식 머그 세트", "38800", R.drawable.imgn7_4));
        }

        gridView.setAdapter(senior_menuAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(),"이름 : "+ senior_menuAdapter.getItem(i).getName().toString() + " , Price : "+senior_menuAdapter.getItem(i).getPrice().toString(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, Senior_MenuSelected_Check.class);
                intent.putExtra("category",mpage);
                intent.putExtra("menu_image",senior_menuAdapter.getItem(i).getImage());
                intent.putExtra("menu_name",senior_menuAdapter.getItem(i).getName().toString());
                intent.putExtra("menu_price",senior_menuAdapter.getItem(i).getPrice().toString());
                context.startActivity(intent);
                
            }
        });

        fab.attachToListView(gridView);

        // 이벤트 적용
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollY = gridView.getScrollY();
                //gridView.setScrollY(gridView.getBottom());
            }
        });

        return view;
    }

}
