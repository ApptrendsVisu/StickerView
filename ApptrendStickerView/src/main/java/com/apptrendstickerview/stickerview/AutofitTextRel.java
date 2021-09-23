package com.apptrendstickerview.stickerview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;

import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;


import com.apptrendstickerview.R;

import java.util.Random;


public class AutofitTextRel extends RelativeLayout implements StickerTouchListener.TouchCallbackListener {
    private static final String TAG = "AutofitTextRel";
    double angle = 0.0d;
    private ImageView background_iv;
    int baseh;
    int basew;
    int basex;
    int basey;
    private int bgAlpha = 255;
    private int bgColor = 0;
    private String bgDrawable = "0";
    private ImageView border_iv;
    float cX = 0.0f;
    float cY = 0.0f;
    private int capitalFlage;
    private Context context;
    double dAngle = 0.0d;
    private ImageView delete_iv;
    private int f27s;
    private String field_four = "";
    private int field_one = 0;
    private String field_three = "";
    private String field_two = "0,0";
    private String fontName = "";
    private GestureDetector gd = null;
    private int he;
    int height;
    private boolean isBold;
    private boolean isBorderVisible = false;
    private boolean isItalic = false;
    public boolean isMultiTouchEnabled = true;
    private boolean isUnderLine = false;
    private int leftMargin = 0;
    private int leftRightShadow = 1;
    private TouchEventListener listener = null;
    private OnTouchListener mTouchListener1 = new C07891();
    int margl;
    int margt;
    private int progress = 0;
    private OnTouchListener rTouchListener = new C07902();
    float ratio;
    private ImageView rotate_iv;
    private float rotation;
    Animation scale;
    private ImageView scale_iv, edit_iv;
    int sh = 1794;
    private int shadowColor = 0;
    private int shadowColorProgress = 255;
    private int shadowProg = 0;
    private int shadowx = 0;
    private int shadowy = 0;
    int sw = 1080;
    private int tAlpha = 100;
    double tAngle = 0.0d;
    private int tColor = ViewCompat.MEASURED_STATE_MASK;
    private String text = "";
    private Path textPath;
    private AutoResizeTextView text_iv;
    private int topBottomShadow = 1;
    private int topMargin = 0;
    double vAngle = 0.0d;
    private int wi;
    int width;
    private int xRotateProg = 0;
    private int yRotateProg = 0;
    private int zRotateProg = 0;
    Animation zoomInScale;
    Animation zoomOutScale;

    class C07891 implements OnTouchListener {
        C07891() {
        }

        @SuppressLint({"NewApi"})
        public boolean onTouch(View view, MotionEvent event) {
            AutofitTextRel rl = (AutofitTextRel) view.getParent();
            int j = (int) event.getRawX();
            int i = (int) event.getRawY();
            LayoutParams layoutParams = (LayoutParams) AutofitTextRel.this.getLayoutParams();
            switch (event.getAction()) {
                case 0:
                    if (rl != null) {
                        rl.requestDisallowInterceptTouchEvent(true);
                    }
                    if (AutofitTextRel.this.listener != null) {
                        AutofitTextRel.this.listener.onScaleDown(AutofitTextRel.this);
                    }
                    AutofitTextRel.this.invalidate();
                    AutofitTextRel.this.basex = j;
                    AutofitTextRel.this.basey = i;
                    AutofitTextRel.this.basew = AutofitTextRel.this.getWidth();
                    AutofitTextRel.this.baseh = AutofitTextRel.this.getHeight();
                    AutofitTextRel.this.getLocationOnScreen(new int[2]);
                    AutofitTextRel.this.margl = layoutParams.leftMargin;
                    AutofitTextRel.this.margt = layoutParams.topMargin;
                    break;
                case 1:
                    AutofitTextRel.this.wi = AutofitTextRel.this.getLayoutParams().width;
                    AutofitTextRel.this.he = AutofitTextRel.this.getLayoutParams().height;
                    AutofitTextRel.this.leftMargin = ((LayoutParams) AutofitTextRel.this.getLayoutParams()).leftMargin;
                    AutofitTextRel.this.topMargin = ((LayoutParams) AutofitTextRel.this.getLayoutParams()).topMargin;
                    AutofitTextRel.this.field_two = String.valueOf(AutofitTextRel.this.leftMargin) + "," + String.valueOf(AutofitTextRel.this.topMargin);
                    if (AutofitTextRel.this.listener != null) {
                        AutofitTextRel.this.listener.onScaleUp(AutofitTextRel.this);
                        break;
                    }
                    break;
                case 2:
                    if (rl != null) {
                        rl.requestDisallowInterceptTouchEvent(true);
                    }
                    if (AutofitTextRel.this.listener != null) {
                        AutofitTextRel.this.listener.onScaleMove(AutofitTextRel.this);
                    }
                    float f2 = (float) Math.toDegrees( Math.atan2((double) (i - AutofitTextRel.this.basey), (double) (j - AutofitTextRel.this.basex)));
                    float f1 = f2;
                    if (f2 < 0.0f) {
                        f1 = f2 + 360.0f;
                    }
                    j -= AutofitTextRel.this.basex;
                    int k = i - AutofitTextRel.this.basey;
                    i = (int) (Math.sqrt((double) ((j * j) + (k * k))) * Math.cos( Math.toRadians((double) (f1 - AutofitTextRel.this.getRotation()))));
                    j = (int) (Math.sqrt((double) ((i * i) + (k * k))) * Math.sin( Math.toRadians((double) (f1 - AutofitTextRel.this.getRotation()))));
                    k = (i * 2) + AutofitTextRel.this.basew;
                    int m = (j * 2) + AutofitTextRel.this.baseh;
                    if (k > AutofitTextRel.this.f27s) {
                        layoutParams.width = k;
                        layoutParams.leftMargin = AutofitTextRel.this.margl - i;
                    }
                    if (m > AutofitTextRel.this.f27s) {
                        layoutParams.height = m;
                        layoutParams.topMargin = AutofitTextRel.this.margt - j;
                    }
                    AutofitTextRel.this.setLayoutParams(layoutParams);
                    if (!AutofitTextRel.this.bgDrawable.equals("0")) {
                        AutofitTextRel.this.wi = AutofitTextRel.this.getLayoutParams().width;
                        AutofitTextRel.this.he = AutofitTextRel.this.getLayoutParams().height;
                        AutofitTextRel.this.setBgDrawable(AutofitTextRel.this.bgDrawable);
                        break;
                    }
                    break;
            }
            return true;
        }
    }

    class C07902 implements OnTouchListener {
        C07902() {
        }

        public boolean onTouch(View view, MotionEvent event) {
            AutofitTextRel rl = (AutofitTextRel) view.getParent();
            switch (event.getAction()) {
                case 0:
                    if (rl != null) {
                        rl.requestDisallowInterceptTouchEvent(true);
                    }
                    if (AutofitTextRel.this.listener != null) {
                        AutofitTextRel.this.listener.onRotateDown(AutofitTextRel.this);
                    }
                    Rect rect = new Rect();
                    ((View) view.getParent()).getGlobalVisibleRect(rect);
                    AutofitTextRel.this.cX = rect.exactCenterX();
                    AutofitTextRel.this.cY = rect.exactCenterY();
                    AutofitTextRel.this.vAngle = (double) ((View) view.getParent()).getRotation();
                    AutofitTextRel.this.tAngle = (Math.atan2((double) (AutofitTextRel.this.cY - event.getRawY()), (double) (AutofitTextRel.this.cX - event.getRawX())) * 180.0d) / 3.141592653589793d;
                    AutofitTextRel.this.dAngle = AutofitTextRel.this.vAngle - AutofitTextRel.this.tAngle;
                    break;
                case 1:
                    if (AutofitTextRel.this.listener != null) {
                        AutofitTextRel.this.listener.onRotateUp(AutofitTextRel.this);
                        break;
                    }
                    break;
                case 2:
                    if (rl != null) {
                        rl.requestDisallowInterceptTouchEvent(true);
                    }
                    if (AutofitTextRel.this.listener != null) {
                        AutofitTextRel.this.listener.onRotateMove(AutofitTextRel.this);
                    }
                    AutofitTextRel.this.angle = (Math.atan2((double) (AutofitTextRel.this.cY - event.getRawY()), (double) (AutofitTextRel.this.cX - event.getRawX())) * 180.0d) / 3.141592653589793d;
                    ((View) view.getParent()).setRotation((float) (AutofitTextRel.this.angle + AutofitTextRel.this.dAngle));
                    ((View) view.getParent()).invalidate();
                    ((View) view.getParent()).requestLayout();
                    break;
            }
            return true;
        }
    }

    class C07923 implements OnClickListener {
        C07923() {
        }

        public void onClick(View v) {
            final ViewGroup parent = (ViewGroup) AutofitTextRel.this.getParent();
            AutofitTextRel.this.zoomInScale.setAnimationListener(new AnimationListener() {
                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    parent.removeView(AutofitTextRel.this);
                }

                public void onAnimationRepeat(Animation animation) {
                }
            });
            AutofitTextRel.this.text_iv.startAnimation(AutofitTextRel.this.zoomInScale);
            AutofitTextRel.this.background_iv.startAnimation(AutofitTextRel.this.zoomInScale);
            AutofitTextRel.this.setBorderVisibility(false);
            if (AutofitTextRel.this.listener != null) {
                AutofitTextRel.this.listener.onDelete(AutofitTextRel.this);
            }
        }
    }

    class C07934 extends SimpleOnGestureListener {
        C07934() {
        }

        public boolean onDoubleTap(MotionEvent e) {
            if (AutofitTextRel.this.listener != null) {
                AutofitTextRel.this.listener.onDoubleTap();
            }
            return true;
        }

        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            return true;
        }

        public boolean onDown(MotionEvent e) {
            return true;
        }
    }

    public interface TouchEventListener {
        void onDelete(View view);

        void onDoubleTap();

        void onEdit(View view);

        void onRotateDown(View view);

        void onRotateMove(View view);

        void onRotateUp(View view);

        void onScaleDown(View view);

        void onScaleMove(View view);

        void onScaleUp(View view);

        void onTouchDown(View view);

        void onTouchMove(View view);

        void onTouchUp(View view);
    }

    public AutofitTextRel(Context context) {
        super(context);
        init(context);
    }

    public AutofitTextRel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AutofitTextRel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public AutofitTextRel setOnTouchCallbackListener(TouchEventListener l) {
        this.listener = l;
        return this;
    }

    public void setDrawParams() {
        invalidate();
    }

    public void init(Context ctx) {
        this.context = ctx;
        Display display = ((Activity) this.context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        this.width = size.x;
        this.height = size.y;
        this.ratio = ((float) this.width) / ((float) this.height);
        this.text_iv = new AutoResizeTextView(this.context);
        this.scale_iv = new ImageView(this.context);
        this.edit_iv = new ImageView(this.context);
        this.border_iv = new ImageView(this.context);
        this.background_iv = new ImageView(this.context);
        this.delete_iv = new ImageView(this.context);
        this.rotate_iv = new ImageView(this.context);
        this.f27s = dpToPx(this.context, 30);
        this.wi = dpToPx(this.context, 200);
        this.he = dpToPx(this.context, 200);
        this.scale_iv.setImageResource(R.drawable.scale);
        this.edit_iv.setImageResource( R.drawable.edit);
        this.background_iv.setImageResource(0);
        this.rotate_iv.setImageResource(R.drawable.sticker_rotate);
        this.delete_iv.setImageResource( R.drawable.close);
        LayoutParams lp = new LayoutParams(this.wi, this.he);
        LayoutParams slp = new LayoutParams(this.f27s, this.f27s);
        slp.addRule(12);
        slp.addRule(11);
        LayoutParams elp = new LayoutParams(this.f27s, this.f27s);
        elp.addRule(12);
        elp.addRule(9);
        LayoutParams tlp = new LayoutParams(-1, -1);
        tlp.addRule(17);
        LayoutParams dlp = new LayoutParams(this.f27s, this.f27s);
        dlp.addRule(10);
        dlp.addRule(9);
        LayoutParams blp = new LayoutParams(-1, -1);
        LayoutParams bglp = new LayoutParams(-1, -1);
        setLayoutParams(lp);

        LayoutParams dlp_edit = new LayoutParams(this.f27s, this.f27s);
        dlp_edit.addRule(10);
        dlp_edit.addRule(11);


        addView(this.edit_iv);
        this.edit_iv.setLayoutParams(dlp_edit);
        this.edit_iv.setTag("edit_iv");
        this.edit_iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AutofitTextRel.this.listener != null) {
                    AutofitTextRel.this.listener.onEdit(AutofitTextRel.this);
                }
            }
        });


        setBackgroundResource(R.drawable.sticker_border_gray);
        addView(this.background_iv);
        this.background_iv.setLayoutParams(bglp);
        this.background_iv.setScaleType( ScaleType.FIT_XY);
        addView(this.border_iv);
        this.border_iv.setLayoutParams(blp);
        this.border_iv.setTag("border_iv");
        addView(this.text_iv);
        this.text_iv.setText(this.text);
        this.text_iv.setTextColor(this.tColor);
        this.text_iv.setTextSize(400.0f);
        this.text_iv.setLayoutParams(tlp);
        this.text_iv.setGravity(17);
        this.text_iv.setMinTextSize(10.0f);
        addView(this.delete_iv);
        this.delete_iv.setLayoutParams(dlp);
        this.delete_iv.setOnClickListener(new C07923());
        addView(this.rotate_iv);
        this.rotate_iv.setLayoutParams(elp);
        this.rotate_iv.setOnTouchListener(this.rTouchListener);
        addView(this.scale_iv);
        this.scale_iv.setLayoutParams(slp);
        this.scale_iv.setTag("scale_iv");
        this.scale_iv.setOnTouchListener(this.mTouchListener1);
        this.rotation = getRotation();
        this.scale = AnimationUtils.loadAnimation(getContext(), R.anim.sticker_scale_anim);
        this.zoomOutScale = AnimationUtils.loadAnimation(getContext(), R.anim.sticker_scale_zoom_out);
        this.zoomInScale = AnimationUtils.loadAnimation(getContext(), R.anim.sticker_scale_zoom_in);
        initGD();
        this.isMultiTouchEnabled = setDefaultTouchListener(true);
    }

    public void applyLetterSpacing(float letterSpacing) {
        if (this != null && this.text != null) {
            int i;
            StringBuilder builder = new StringBuilder();
            for (i = 0; i < this.text.length(); i++) {
                builder.append("" + this.text.charAt(i));
                if (i + 1 < this.text.length()) {
                    builder.append(" ");
                }
            }
            SpannableString finalText = new SpannableString(builder.toString());
            if (builder.toString().length() > 1) {
                for (i = 1; i < builder.toString().length(); i += 2) {
                    finalText.setSpan(new ScaleXSpan((1.0f + letterSpacing) / 10.0f), i, i + 1, 33);
                }
            }
            this.text_iv.setText(finalText, BufferType.SPANNABLE);
        }
    }

    public void applyLineSpacing(float linespacing) {
        this.text_iv.setLineSpacing(linespacing, 1.0f);
    }

    public void setBoldFont() {
        if (this.isBold) {
            this.isBold = false;
            this.text_iv.setTypeface( Typeface.DEFAULT);
            return;
        }
        this.isBold = true;
        this.text_iv.setTypeface( Typeface.DEFAULT_BOLD);
    }

    public void setCapitalFont() {
        if (this.capitalFlage == 0) {
            this.capitalFlage = 1;
            this.text_iv.setText(this.text_iv.getText().toString().toUpperCase());
            return;
        }
        this.capitalFlage = 0;
        this.text_iv.setText(this.text_iv.getText().toString().toLowerCase());
    }

    public void setUnderLineFont() {
        if (this.isUnderLine) {
            this.isUnderLine = false;
            this.text_iv.setText( Html.fromHtml(this.text.replace("<u>", "").replace("</u>", "")));
            return;
        }
        this.isUnderLine = true;
        this.text_iv.setText( Html.fromHtml("<u>" + this.text + "</u>"));
    }

    public void setItalicFont() {
        TextView textView;
        if (this.isItalic) {
            this.isItalic = false;
            textView = new TextView(this.context);
            textView.setText(this.text);
            if (this.isBold) {
                textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
            } else {
                textView.setTypeface(textView.getTypeface(), Typeface.NORMAL);
            }
            this.text_iv.setTypeface(textView.getTypeface());
            return;
        }
        this.isItalic = true;
        textView = new TextView(this.context);
        textView.setText(this.text);
        if (this.isBold) {
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD_ITALIC);
        } else {
            textView.setTypeface(textView.getTypeface(), Typeface.ITALIC);
        }
        this.text_iv.setTypeface(textView.getTypeface());
    }

    public void setLeftAlignMent() {
        this.text_iv.setGravity(19);
    }

    public void setCenterAlignMent() {
        this.text_iv.setGravity(17);
    }

    public void setRightAlignMent() {
        this.text_iv.setGravity(21);
    }

    public boolean setDefaultTouchListener(boolean enable) {
        if (enable) {
            setOnTouchListener(new StickerTouchListener().enableRotation(true).setOnTouchCallbackListener(this).setGestureListener(this.gd));
            return true;
        }
        setOnTouchListener(null);
        return false;
    }

    public boolean getBorderVisibility() {
        return this.isBorderVisible;
    }

    public void setBorderVisibility(boolean ch) {
        this.isBorderVisible = ch;
        if (!ch) {
            this.border_iv.setVisibility(GONE);
            this.scale_iv.setVisibility(GONE);
            this.delete_iv.setVisibility(GONE);
            this.rotate_iv.setVisibility(GONE);
            this.edit_iv.setVisibility(GONE);
            setBackgroundResource(0);
        } else if (this.border_iv.getVisibility() != VISIBLE) {
            this.border_iv.setVisibility(VISIBLE);
            this.scale_iv.setVisibility(VISIBLE);
            this.delete_iv.setVisibility(VISIBLE);
            this.rotate_iv.setVisibility(VISIBLE);
            this.edit_iv.setVisibility(VISIBLE);

            setBackgroundResource(R.drawable.sticker_border_gray);
            this.text_iv.startAnimation(this.scale);
        }
    }

    public String getText() {
        return this.text_iv.getText().toString();
    }

    public void setText(String text) {
        this.text_iv.setText(text);
        this.text = text;
        this.text_iv.startAnimation(this.zoomOutScale);
    }

    public void setTextFont(String fontName) {
        try {
            this.text_iv.setTypeface( Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName));
            this.fontName = fontName;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setScaleIncrease() {
        this.text_iv.setScaleX(text_iv.getScaleX() + 0.05f);
        this.text_iv.setScaleY(text_iv.getScaleY() + 0.05f);
    }

    public void setScaleDecrease() {
        this.text_iv.setScaleX(text_iv.getScaleX() - 0.05f);
        this.text_iv.setScaleY(text_iv.getScaleY() - 0.05f);
    }

    public String getFontName() {
        return this.fontName;
    }

    public int getTextColor() {
        return this.tColor;
    }

    public void setTextColor(int color) {
//        this.text_iv.setTextColor(color);
//        this.tColor = color;
//        invalidate();
        Spannable span = new SpannableString(text_iv.getText());
        for (int i = 0; i < text_iv.getText().length(); i++) {
            span.setSpan(new ForegroundColorSpan(color), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        text_iv.getPaint().setShader(null);
        text_iv.setText(span);
        invalidate();
    }

    public void setMulticolor() {
        Spannable span = new SpannableString(text_iv.getText());
        for (int i = 0; i < text_iv.getText().length(); i++) {
            span.setSpan(new ForegroundColorSpan(getRandomColor()), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        text_iv.getPaint().setShader(null);
        text_iv.setText(span);
        invalidate();
    }

    public void setGradient(int color1, int color2) {
        BitmapShader shader = new BitmapShader(gradientgenertor(color1, color2), TileMode.MIRROR, TileMode.MIRROR);
        text_iv.getPaint().setShader(shader);
        text_iv.invalidate();
    }


    public void setGradientBitmap(Bitmap gradientBitmap) {
        BitmapShader shader = new BitmapShader(gradientBitmap, TileMode.MIRROR, TileMode.MIRROR);
        text_iv.getPaint().setShader(shader);
        text_iv.invalidate();
    }


    public Bitmap gradientgenertor(int color1, int color2) {
        GradientDrawable result = new GradientDrawable();
        Bitmap maskbitmap;
        result.setColors(new int[]{color1, color2});
        result.setGradientType( GradientDrawable.LINEAR_GRADIENT);
        result.setShape( GradientDrawable.RECTANGLE);
        result.setSize(100, 100);
        maskbitmap = drawableToBitmap(result);
        return maskbitmap;
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }


    private LinearGradient generategradientcolors() {
        return new LinearGradient(0, 0, 0, 50, getRandomColor(), getRandomColor(), TileMode.MIRROR);
    }

    private int getRandomColor() {
        Random random = new Random();
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public int getTextAlpha() {
        return this.tAlpha;
    }

    public void setTextAlpha(int prog) {
        this.text_iv.setAlpha(((float) prog) / 100.0f);
        this.tAlpha = prog;
    }

    public int getTextShadowColor() {
        return this.shadowColor;
    }

    public void setTextShadowColor(int color) {
        text_iv.getPaint().setShader(null);
        this.shadowColor = color;
        this.shadowColor = ColorUtils.setAlphaComponent(this.shadowColor, this.shadowColorProgress);
        this.text_iv.setShadowLayer((float) this.shadowProg, this.leftRightShadow, this.topBottomShadow, this.shadowColor);
    }

    public void setTextShadowOpacity(int prog) {
        text_iv.getPaint().setShader(null);
        this.shadowColorProgress = prog;
        this.shadowColor = ColorUtils.setAlphaComponent(this.shadowColor, prog);
        this.text_iv.setShadowLayer((float) this.shadowProg, this.leftRightShadow, this.topBottomShadow, this.shadowColor);
    }

    public void setLeftRightShadow(int shadow) {
        this.leftRightShadow = shadow;
        this.text_iv.setShadowLayer((float) this.shadowProg, this.leftRightShadow, this.topBottomShadow, this.shadowColor);
    }

    public void setTopBottomShadow(int shadow) {
        this.topBottomShadow = shadow;
        this.text_iv.setShadowLayer((float) this.shadowProg, this.leftRightShadow, this.topBottomShadow, this.shadowColor);
    }

    public int getTextShadowProg() {
        return this.shadowProg;
    }

    public void setTextShadowProg(int prog) {
//        text_iv.getPaint().setShader(null);
        this.shadowProg = prog;
        this.text_iv.setShadowLayer((float) this.shadowProg, this.leftRightShadow, this.topBottomShadow, this.shadowColor);
    }

    public void setRotationX(int x) {
        this.xRotateProg = x;
        this.text_iv.setRotationX(x);
        this.text_iv.invalidate();
    }

    public void setRotationY(int y) {
        this.yRotateProg = y;
        this.text_iv.setRotationY(y);
        this.text_iv.invalidate();
    }

    public String getBgDrawable() {
        return this.bgDrawable;
    }

    public void setBgDrawable(String did) {
        this.bgDrawable = did;
        this.bgColor = 0;
        this.background_iv.setImageBitmap(getTiledBitmap(this.context, getResources().getIdentifier(did, "drawable", this.context.getPackageName()), this.wi, this.he));
        this.background_iv.setBackgroundColor(this.bgColor);
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(int c) {
        this.bgDrawable = "0";
        this.bgColor = c;
        this.background_iv.setImageBitmap(null);
        this.background_iv.setBackgroundColor(c);
    }

    public int getBgAlpha() {
        return this.bgAlpha;
    }

    public void setBgAlpha(int prog) {
        this.background_iv.setAlpha(((float) prog) / 255.0f);
        this.bgAlpha = prog;
    }

    public ApptendsStickerInfo getTextInfo() {
        ApptendsStickerInfo apptendsStickerInfo = new ApptendsStickerInfo();
        apptendsStickerInfo.setPOS_X(getX());
        apptendsStickerInfo.setPOS_Y(getY());
        apptendsStickerInfo.setWIDTH(this.wi);
        apptendsStickerInfo.setHEIGHT(this.he);
        apptendsStickerInfo.setTEXT(this.text);
        apptendsStickerInfo.setFONT_NAME(this.fontName);
        apptendsStickerInfo.setTEXT_COLOR(this.tColor);
        apptendsStickerInfo.setTEXT_ALPHA(this.tAlpha);
        apptendsStickerInfo.setSHADOW_COLOR(this.shadowColor);
        apptendsStickerInfo.setSHADOW_PROG(this.shadowProg);
        apptendsStickerInfo.setSHADOW_X(this.leftRightShadow);
        apptendsStickerInfo.setSHADOW_Y(this.topBottomShadow);
        apptendsStickerInfo.setBG_COLOR(this.bgColor);
        apptendsStickerInfo.setBG_DRAWABLE(this.bgDrawable);
        apptendsStickerInfo.setBG_ALPHA(this.bgAlpha);
        apptendsStickerInfo.setROTATION(getRotation());
        apptendsStickerInfo.setXRotateProg(this.xRotateProg);
        apptendsStickerInfo.setYRotateProg(this.yRotateProg);
        apptendsStickerInfo.setZRotateProg(this.zRotateProg);
        apptendsStickerInfo.setCurveRotateProg(this.progress);
        apptendsStickerInfo.setFIELD_ONE(this.field_one);
        apptendsStickerInfo.setFIELD_TWO(this.field_two);
        apptendsStickerInfo.setFIELD_THREE(this.field_three);
        apptendsStickerInfo.setFIELD_FOUR(this.field_four);
        return apptendsStickerInfo;
    }

    public void setTextInfo(ApptendsStickerInfo apptendsStickerInfo, boolean b) {
        Log.e("set Text value", "" + apptendsStickerInfo.getPOS_X() + " ," + apptendsStickerInfo.getPOS_Y() + " ," + apptendsStickerInfo.getWIDTH() + " ," + apptendsStickerInfo.getHEIGHT() + " ," + apptendsStickerInfo.getFIELD_TWO());
        this.wi = apptendsStickerInfo.getWIDTH();
        this.he = apptendsStickerInfo.getHEIGHT();
        this.text = apptendsStickerInfo.getTEXT();
        this.fontName = apptendsStickerInfo.getFONT_NAME();
        this.tColor = apptendsStickerInfo.getTEXT_COLOR();
        this.tAlpha = apptendsStickerInfo.getTEXT_ALPHA();
        this.shadowColor = apptendsStickerInfo.getSHADOW_COLOR();
        this.shadowProg = apptendsStickerInfo.getSHADOW_PROG();
        this.leftRightShadow = apptendsStickerInfo.getSHADOW_X();
        this.topBottomShadow = apptendsStickerInfo.getSHADOW_Y();
        this.bgColor = apptendsStickerInfo.getBG_COLOR();
        this.bgDrawable = apptendsStickerInfo.getBG_DRAWABLE();
        this.bgAlpha = apptendsStickerInfo.getBG_ALPHA();
        this.rotation = apptendsStickerInfo.getROTATION();
        this.field_two = apptendsStickerInfo.getFIELD_TWO();
        setText(this.text);
        setTextFont(this.fontName);
        setTextColor(this.tColor);
        setTextAlpha(this.tAlpha);
        setTextShadowColor(this.shadowColor);
        setTextShadowProg(this.shadowProg);
        setLeftRightShadow(this.leftRightShadow);
        setTopBottomShadow(this.topBottomShadow);
        if (this.bgColor != 0) {
            setBgColor(this.bgColor);
        } else {
            this.background_iv.setBackgroundColor(0);
        }
        if (this.bgDrawable.equals("0")) {
            this.background_iv.setImageBitmap(null);
        } else {
            setBgDrawable(this.bgDrawable);
        }
        setBgAlpha(this.bgAlpha);
        setRotation( apptendsStickerInfo.getROTATION());
        if (this.field_two.equals("")) {
            getLayoutParams().width = this.wi;
            getLayoutParams().height = this.he;
            setX( apptendsStickerInfo.getPOS_X());
            setY( apptendsStickerInfo.getPOS_Y());
            return;
        }
        String[] parts = this.field_two.split(",");
        int leftMergin = Integer.parseInt(parts[0]);
        int topMergin = Integer.parseInt(parts[1]);
        ((LayoutParams) getLayoutParams()).leftMargin = leftMergin;
        ((LayoutParams) getLayoutParams()).topMargin = topMergin;
        getLayoutParams().width = this.wi;
        getLayoutParams().height = this.he;
        setX( apptendsStickerInfo.getPOS_X() + ((float) (leftMergin * -1)));
        setY( apptendsStickerInfo.getPOS_Y() + ((float) (topMergin * -1)));
    }

    public void optimize(float wr, float hr) {
        setX(getX() * wr);
        setY(getY() * hr);
        getLayoutParams().width = (int) (((float) this.wi) * wr);
        getLayoutParams().height = (int) (((float) this.he) * hr);
    }

    public void incrX() {
        setX(getX() + 2.0f);
    }

    public void decX() {
        setX(getX() - 2.0f);
    }

    public void incrY() {
        setY(getY() + 2.0f);
    }

    public void decY() {
        setY(getY() - 2.0f);
    }

    public int dpToPx(Context c, int dp) {
        float f = (float) dp;
        c.getResources();
        return (int) (Resources.getSystem().getDisplayMetrics().density * f);
    }

    private Bitmap getTiledBitmap(Context ctx, int resId, int width, int height) {
        Rect rect = new Rect(0, 0, width, height);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader( BitmapFactory.decodeResource(ctx.getResources(), resId, new Options()), TileMode.REPEAT, TileMode.REPEAT));
        Bitmap b = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        new Canvas(b).drawRect(rect, paint);
        return b;
    }

    private void initGD() {
        this.gd = new GestureDetector(this.context, new C07934());
    }

    public void onTouchCallback(View v) {
        if (this.listener != null) {
            this.listener.onTouchDown(v);
        }
    }

    public void onTouchUpCallback(View v) {
        if (this.listener != null) {
            this.listener.onTouchUp(v);
        }
    }

    public void onTouchMoveCallback(View v) {
        if (this.listener != null) {
            this.listener.onTouchMove(v);
        }
    }

    public float getNewX(float x) {
        return ((float) this.width) * (x / ((float) this.sw));
    }

    public float getNewY(float y) {
        return ((float) this.height) * (y / ((float) this.sh));
    }
}
