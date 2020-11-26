package com.example.kioskmainpage.Utilities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kioskmainpage.R;

public class Senior_MenuViewer extends LinearLayout {

    TextView menu_name_view;
    TextView menu_price_view;
    ImageView menu_image_view;

    public Senior_MenuViewer(Context context) {
        super(context);

        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.senior_menu_item,this,true);

        menu_name_view = (TextView)findViewById(R.id.menu_name_view);
        menu_price_view = (TextView)findViewById(R.id.menu_price_view);
        menu_image_view = (ImageView) findViewById(R.id.menu_image_view);
       // menu_image_view.setBackground(new ShapeDrawable(new OvalShape()));
        //menu_image_view.setClipToOutline(true);
    }

    public void setItem(Senior_MenuItem senior_menuitem){
        menu_name_view.setText(senior_menuitem.getName());
        String menu_name = senior_menuitem.getName();
        int tempIndex = -1;
        if ((tempIndex = menu_name.indexOf("차가운")) > -1){
            Spannable span = (Spannable) menu_name_view.getText();
            span.setSpan(new ForegroundColorSpan(Color.BLUE), tempIndex, tempIndex+3, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        } else if ((tempIndex = menu_name.indexOf("따뜻한")) > -1){
            Spannable span = (Spannable) menu_name_view.getText();
            span.setSpan(new ForegroundColorSpan(Color.RED), tempIndex, tempIndex+3, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        menu_price_view.setText(senior_menuitem.getPrice()+"원");
        menu_image_view.setImageResource(senior_menuitem.getImage());
    }
}
