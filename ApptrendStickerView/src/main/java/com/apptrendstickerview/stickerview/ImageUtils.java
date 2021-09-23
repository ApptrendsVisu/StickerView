package com.apptrendstickerview.stickerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.net.Uri;
import android.os.Build.VERSION;

import java.io.IOException;


public class ImageUtils {

    public static Bitmap getResampleImageBitmap(Uri uri, Context context, int maxDim) throws IOException {
        Bitmap bmp = null;
        try {
            bmp = resampleImage(getRealPathFromURI(uri, context), maxDim);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }

    @SuppressLint({"UseValueOf"})
    public static Bitmap resampleImage(String path, int maxDim) throws Exception {
        try {
            Options bfo = new Options();
            bfo.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, bfo);
            Options optsDownSample = new Options();
            optsDownSample.inSampleSize = getClosestResampleSize(bfo.outWidth, bfo.outHeight, maxDim);
            Bitmap bmpt = BitmapFactory.decodeFile(path, optsDownSample);
            if (bmpt == null) {
                return null;
            }
            Matrix m = new Matrix();
            if (bmpt.getWidth() > maxDim || bmpt.getHeight() > maxDim) {
                Options optsScale = getResampling(bmpt.getWidth(), bmpt.getHeight(), maxDim);
                m.postScale(((float) optsScale.outWidth) / ((float) bmpt.getWidth()), ((float) optsScale.outHeight) / ((float) bmpt.getHeight()));
            }
            if (new Integer( VERSION.SDK).intValue() > 4) {
                int rotation = ExifUtils.getExifRotation(path);
                if (rotation != 0) {
                    m.postRotate((float) rotation);
                }
            }
            return Bitmap.createBitmap(bmpt, 0, 0, bmpt.getWidth(), bmpt.getHeight(), m, true);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Options getResampling(int cx, int cy, int max) {
        float scaleVal;
        Options bfo = new Options();
        if (cx > cy) {
            scaleVal = ((float) max) / ((float) cx);
        } else if (cy > cx) {
            scaleVal = ((float) max) / ((float) cy);
        } else {
            scaleVal = ((float) max) / ((float) cx);
        }
        bfo.outWidth = (int) ((((float) cx) * scaleVal) + 0.5f);
        bfo.outHeight = (int) ((((float) cy) * scaleVal) + 0.5f);
        return bfo;
    }

    public static int getClosestResampleSize(int cx, int cy, int maxDim) {
        int max = Math.max(cx, cy);
        int resample = 1;
        while (resample < 10000) {
            if (resample * maxDim > max) {
                resample--;
                break;
            }
            resample++;
        }
        return resample > 0 ? resample : 1;
    }

    public static String getRealPathFromURI(Uri contentURI, Context context) {
        try {
            Cursor cursor = context.getContentResolver().query(contentURI, null, null, null, null);
            if (cursor == null) {
                return contentURI.getPath();
            }
            cursor.moveToFirst();
            String result = cursor.getString(cursor.getColumnIndex("_data"));
            cursor.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return contentURI.toString();
        }
    }

    public static Bitmap resizeBitmap(Bitmap bit, int width, int height) {
        if (bit == null) {
            return null;
        }
        float wr = (float) width;
        float hr = (float) height;
        float wd = (float) bit.getWidth();
        float he = (float) bit.getHeight();
        float rat1 = wd / he;
        float rat2 = he / wd;
        if (wd > wr) {
            if (wr * rat2 > hr) {
                he = hr;
                wd = he * rat1;
            } else {
                wd = wr;
                he = wd * rat2;
            }
        } else if (he > hr) {
            he = hr;
            wd = he * rat1;
            if (wd > wr) {
                wd = wr;
                he = wd * rat2;
            }
        } else if (rat1 > 0.75f) {
            if (wr * rat2 > hr) {
                he = hr;
                wd = he * rat1;
            } else {
                wd = wr;
                he = wd * rat2;
            }
        } else if (rat2 > 1.5f) {
            he = hr;
            wd = he * rat1;
            if (wd > wr) {
                wd = wr;
                he = wd * rat2;
            }
        } else if (wr * rat2 > hr) {
            he = hr;
            wd = he * rat1;
        } else {
            wd = wr;
            he = wd * rat2;
        }
        return Bitmap.createScaledBitmap(bit, (int) wd, (int) he, false);
    }

    public static int dpToPx(Context c, int dp) {
        float f = (float) dp;
        c.getResources();
        return (int) (Resources.getSystem().getDisplayMetrics().density * f);
    }

    public static Bitmap getTiledBitmap(Context ctx, int resId, int width, int height) {
        Rect rect = new Rect(0, 0, width, height);
        Paint paint = new Paint();
        Options options = new Options();
        options.inScaled = false;
        paint.setShader(new BitmapShader( BitmapFactory.decodeResource(ctx.getResources(), resId, options), TileMode.REPEAT, TileMode.REPEAT));
        Bitmap b = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        new Canvas(b).drawRect(rect, paint);
        return b;
    }

    public static Bitmap scaleCenterCrop(Bitmap source, int newHeight, int newWidth) {
        int sourceWidth = source.getWidth();
        int sourceHeight = source.getHeight();
        float scale = Math.max(((float) newWidth) / ((float) sourceWidth), ((float) newHeight) / ((float) sourceHeight));
        float scaledWidth = scale * ((float) sourceWidth);
        float scaledHeight = scale * ((float) sourceHeight);
        float left = (((float) newWidth) - scaledWidth) / 2.0f;
        float top = (((float) newHeight) - scaledHeight) / 2.0f;
        RectF targetRect = new RectF(left, top, left + scaledWidth, top + scaledHeight);
        Bitmap dest = Bitmap.createBitmap(newWidth, newHeight, source.getConfig());
        new Canvas(dest).drawBitmap(source, null, targetRect, null);
        return dest;
    }

}
