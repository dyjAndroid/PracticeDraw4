package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Camera mCamera = new Camera();

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int dx1 = point1.x + bitmap.getWidth() / 2;
        int dy1 = point1.y + bitmap.getHeight() / 2;
        int dx2 = point2.x + bitmap.getWidth() / 2;
        int dy2 = point2.y + bitmap.getHeight() / 2;
        canvas.save();
        mCamera.save();
        mCamera.rotateX(30);
        canvas.translate(dx1, dy1);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-dx1, -dy1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        mCamera.restore();
        canvas.restore();


        canvas.save();
        mCamera.save();
        mCamera.rotateY(30);
        canvas.translate(dx2, dy2);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-dx2, -dy2);
        mCamera.restore();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
