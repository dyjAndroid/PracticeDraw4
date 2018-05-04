package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice03TranslateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice03TranslateView(Context context) {
        super(context);
    }

    public Practice03TranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03TranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(500, 0);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();

        Log.d("dyj","1");
        canvas.translate(500, 0);
        Log.d("dyj","2");
        canvas.rotate(30, point1.x + bitmap.getWidth() / 2, point1.y + bitmap.getHeight() / 2);
        Log.d("dyj","3");
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        Log.d("dyj","4");
        canvas.restore();

        canvas.save();
        canvas.rotate(30, point1.x + bitmap.getWidth() / 2, point1.y + bitmap.getHeight() / 2);
        canvas.translate(500, 0);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


//        canvas.save();
//        canvas.translate(100,100);
//        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
//        canvas.restore();
    }
}