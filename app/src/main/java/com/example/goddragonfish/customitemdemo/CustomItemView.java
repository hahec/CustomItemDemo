package com.example.goddragonfish.customitemdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by GodDragonFish on 2017/12/25.
 */

public class CustomItemView extends RelativeLayout{

    private Context c;
    private TypedArray t;
    private ImageView head;
    private TextView name;
    private TextView tv1;
    private TextView tv2;
    private ImageView enter;
    private RelativeLayout.LayoutParams p;

    public CustomItemView(Context context) {
        super(context);
        c=context;
        init(context,null);
    }


    public CustomItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        c=context;
        init(context,attrs);
    }

    public CustomItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        c=context;
        init(context,attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        initView(context,attrs);
        initHead(context,attrs);
        initItem(context,attrs);
        initTv1(context,attrs);
        initTv2(context,attrs);
        initEnter(context,attrs);
        recycleTypeArray();
        }


        //回收资源
    private void recycleTypeArray() {
        t.recycle();
    }


    private void initEnter(Context context, AttributeSet attrs) {
        if(t!=null){
            //设置右边箭头的图片
            int enterSrc=t.getResourceId(R.styleable.custItem_enter_src,0);
            enter.setImageResource(enterSrc);
        }
    }

    private void initTv2(Context context, AttributeSet attrs) {
        //设置tv2的内容
        String tvc2=t.getString(R.styleable.custItem_tv2_content);
        if(!TextUtils.isEmpty(tvc2)){
            tv2.setText(tvc2);
        }
        //设置tv2的颜色
        int color2=t.getColor(R.styleable.custItem_tv2_color,Color.BLACK);
        tv2.setTextColor(color2);
        //设置tv2的大小
        int size2=t.getDimensionPixelSize(R.styleable.custItem_tv2_size,dpsp2px(context,5));
        tv2.setTextSize(size2);
        //设置tv2的背景
        int tv2Bg=t.getResourceId(R.styleable.custItem_tv2_bg,0);
        tv2.setBackgroundResource(tv2Bg);
        //设置tv2到箭头的距离
        int tv22enter=t.getDimensionPixelSize(R.styleable.custItem_tv2_to_enter,dpsp2px(context,8));
        p=(RelativeLayout.LayoutParams)tv2.getLayoutParams();
        p.rightMargin=tv22enter;
        tv2.setLayoutParams(p);
        //设置tv2的可见与否
        int visibility2=t.getInt(R.styleable.custItem_tv2_visibility,0);
        switch (visibility2) {
            case 0:
                tv2.setVisibility(VISIBLE);
                break;
            case 1:
                tv2.setVisibility(INVISIBLE);
                break;
            case 2:
                tv2.setVisibility(GONE);
                break;
        }
    }

    private void initTv1(Context context, AttributeSet attrs) {
        if(t!=null){
            //设置tv1的内容
            String tvc1=t.getString(R.styleable.custItem_tv1_content);
            if(!TextUtils.isEmpty(tvc1)){
                tv1.setText(tvc1);
            }
            //设置tv1的颜色
            int color1=t.getColor(R.styleable.custItem_tv1_color,Color.BLACK);
            tv1.setTextColor(color1);
            //设置tv1的大小,默认5sp
            int size1=t.getDimensionPixelSize(R.styleable.custItem_tv1_size,dpsp2px(context,5));
            tv1.setTextSize(size1);
            //设置tv1的背景
            int tv1Bg=t.getResourceId(R.styleable.custItem_tv1_bg,0);
            tv1.setBackgroundResource(tv1Bg);
            //设置tv1到tv2的距离
            int tv12tv2=t.getDimensionPixelSize(R.styleable.custItem_tv1_to_tv2,dpsp2px(context,8));
            p=(RelativeLayout.LayoutParams)tv1.getLayoutParams();
            p.rightMargin=tv12tv2;
            tv1.setLayoutParams(p);
            //设置tv1的可见与否
            int visibility1=t.getInt(R.styleable.custItem_tv1_visibility,0);
            switch (visibility1){
                case 0: tv1.setVisibility(VISIBLE);
                    break;
                case 1: tv1.setVisibility(INVISIBLE);
                    break;
                case 2: tv1.setVisibility(GONE);
                    break;
            }

        }

    }

    private void initItem(Context context, AttributeSet attrs) {
        if(t!=null){
            //设置item名字
            String itemName=t.getString(R.styleable.custItem_item_name);
            if(!TextUtils.isEmpty(itemName)){
                name.setText(itemName);
            }

            //设置head与item之间的距离,默认10dp
            int head2name=t.getDimensionPixelSize(R.styleable.custItem_head_to_name,dpsp2px(context,10));
            p=(RelativeLayout.LayoutParams)name.getLayoutParams();
            p.leftMargin=head2name;
            name.setLayoutParams(p);

            //设置item的颜色
            int color=t.getColor(R.styleable.custItem_name_color, Color.BLACK);
            name.setTextColor(color);
            //设置item的大小,默认5sp
            int size=t.getDimensionPixelSize(R.styleable.custItem_name_size,dpsp2px(context,5));
            name.setTextSize(size);

            //设置Item的background
            int bg=t.getResourceId(R.styleable.custItem_name_bg,0);
            name.setBackgroundResource(bg);
        }


    }

    private void initHead(Context context, AttributeSet attrs) {
        if(t!=null){
            //设置head的图片
            int headSrc=t.getResourceId(R.styleable.custItem_head_src,0);
            head.setImageResource(headSrc);
        }

    }

    public void initView(Context context,AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.custom_item,this,true);
        head=findViewById(R.id.icon_head);
        name=findViewById(R.id.item_name);
        tv1=findViewById(R.id.tv_1);
        tv2=findViewById(R.id.tv_2);
        enter=findViewById(R.id.icon_enter);
        t=context.obtainStyledAttributes(attrs,R.styleable.custItem);
    }



    //设置头标
    public void setHeadIcon(int srcUrl){
        head.setImageResource(srcUrl);
    }


    //设置名字
    public void setItemName(String itemName){
        name.setText(itemName);
    }

    //设置名字颜色
    public void setNameColor(int color){
        name.setTextColor(color);
    }

    //设置名字大小
    public void setNameSize(int size){
        name.setTextSize(dpsp2px(c,size));
    }

    //设置名字与head间距
    public void setHead2Name(int margin){
        p=(RelativeLayout.LayoutParams)name.getLayoutParams();
        p.leftMargin=dpsp2px(c,margin);
        name.setLayoutParams(p);
    }

    //设置头标背景
    public void setNameBg(int bgResId){
        name.setBackgroundResource(bgResId);
    }


    //设置tv1内容
    public void setTv1Content(String content){
        tv1.setText(content);
    }

    //设置tv1颜色
    public void setTv1Color(int color){
        tv1.setTextColor(color);

    }

    //设置tv1大小
    public void setTv1Size(int size){
        tv1.setTextSize(dpsp2px(c,size));
    }

    //设置tv1背景
    public void setTv1Bg(int bgResId){
        tv1.setBackgroundResource(bgResId);
    }

    //设置tv1与tv2的距离
    public void settv12tv2(int margin){
        p=(RelativeLayout.LayoutParams)tv1.getLayoutParams();
        p.rightMargin=dpsp2px(c,margin);
        tv1.setLayoutParams(p);
    }

    //设置tv2内容
    public void setTv2Content(String content){
        tv1.setText(content);

    }

    //设置tv2颜色
    public void setTv2Color(int color){
        tv1.setTextColor(color);
    }

    //设置tv2大小
    public void setTv2Size(int size){
        tv1.setTextSize(dpsp2px(c,size));
    }

    public void setTv2Bg(int bgResId){
        tv2.setBackgroundResource(bgResId);
    }

    //设置tv2到center的距离
    public void settv22enter(int margin){
        p=(RelativeLayout.LayoutParams)tv2.getLayoutParams();
        p.rightMargin=dpsp2px(c,margin);
        tv2.setLayoutParams(p);
    }

    //设置进入图标
    public void setEnterIcon(int srcUrl){
        enter.setImageResource(srcUrl);
    }

    //设置tv1显示
    public void setTv1Visibility(int v){
        tv1.setVisibility(v);
    }

    //设置tv2显示
    public void setTv2Visibility(int v){
        tv2.setVisibility(v);
    }


    //公式：density=densityDpi/160，px=dp*density
    //根据自定义的高(dp)获取px单位的高
    //在java中，强制转换符把float转换为int时，是直接丢掉小数部分的，
    //加0.5f起到了四舍五入的作用，可以减小误差。
    public int dpsp2px(Context context,int dpsp){
        float density=context.getResources().getDisplayMetrics().density;
        return (int)(dpsp*density+0.5f);
    }


}
