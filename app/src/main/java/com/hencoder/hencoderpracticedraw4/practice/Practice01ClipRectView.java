package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice01ClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice01ClipRectView(Context context) {
        super(context);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

         /*
            看了视频后，发现 Camera x y z 各轴的旋转方向 是有规律可循的。
            给大家分享一个方便记忆 Camera x y z 各轴的旋转方向 的通用方法：
            伸出你的右手，大拇指翘起，四指回握，摆出手动赞👍的手势。
            然后大拇指朝着某一坐标轴（如 x 轴）的 负方向，
            此时四指的回握方向即是该坐标轴的旋转方向。
            小伙伴们，赶快对照着视频中 Camera x y z 各轴的旋转方向示意图，试试吧～
         */


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;

        canvas.save();
        canvas.clipRect(left + bitmap.getWidth()/8,top + bitmap.getHeight()/4,left + bitmap.getWidth()/8 *7,top+bitmap.getHeight()/4 *3);
        canvas.drawBitmap(bitmap, left, top, paint);
        canvas.restore();


    }
}
