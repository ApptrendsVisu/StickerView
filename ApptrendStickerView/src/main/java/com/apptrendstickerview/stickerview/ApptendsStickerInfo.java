package com.apptrendstickerview.stickerview;

import androidx.core.view.ViewCompat;

public class ApptendsStickerInfo {
    private int BG_ALPHA = 255;
    private int BG_COLOR = 0;
    private String BG_DRAWABLE = "0";
    int CurveRotateProg;
    private String FIELD_FOUR = "";
    int FIELD_ONE = 0;
    private String FIELD_THREE = "";
    private String FIELD_TWO = "";
    private String FONT_NAME = "";
    private int HEIGHT;
    private int ORDER;
    private float POS_X = 0.0f;
    private float POS_Y = 0.0f;
    private float ROTATION;
    private int SHADOW_COLOR = 0;
    private int SHADOW_PROG = 0;
    private int SHADOW_X = 0;
    private int SHADOW_Y = 0;
    private int TEMPLATE_ID;
    private String TEXT = "";
    private int TEXT_ALPHA = 100;
    private int TEXT_COLOR = ViewCompat.MEASURED_STATE_MASK;
    private int TEXT_ID;
    private String TYPE = "";
    private int WIDTH;
    int XRotateProg;
    int YRotateProg;
    int ZRotateProg;

    public ApptendsStickerInfo(int TEMPLATE_ID, String TEXT, String FONT_NAME, int TEXT_COLOR, int TEXT_ALPHA, int SHADOW_COLOR, int SHADOW_PROG, int SHADOW_X, int SHADOW_Y, String BG_DRAWABLE, int BG_COLOR, int BG_ALPHA, float POS_X, float POS_Y, int WIDTH, int HEIGHT, float ROTATION, String TYPE, int ORDER, int XRotateProg, int YRotateProg, int ZRotateProg, int CurveRotateProg, int field_one, String field_two, String field_three, String field_four) {
        this.TEMPLATE_ID = TEMPLATE_ID;
        this.TEXT = TEXT;
        this.FONT_NAME = FONT_NAME;
        this.TEXT_COLOR = TEXT_COLOR;
        this.TEXT_ALPHA = TEXT_ALPHA;
        this.SHADOW_COLOR = SHADOW_COLOR;
        this.SHADOW_PROG = SHADOW_PROG;
        this.SHADOW_X = SHADOW_X;
        this.SHADOW_Y = SHADOW_Y;
        this.BG_DRAWABLE = BG_DRAWABLE;
        this.BG_COLOR = BG_COLOR;
        this.BG_ALPHA = BG_ALPHA;
        this.POS_X = POS_X;
        this.POS_Y = POS_Y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.ROTATION = ROTATION;
        this.TYPE = TYPE;
        this.ORDER = ORDER;
        this.XRotateProg = XRotateProg;
        this.YRotateProg = YRotateProg;
        this.ZRotateProg = ZRotateProg;
        this.CurveRotateProg = CurveRotateProg;
        this.FIELD_ONE = field_one;
        this.FIELD_TWO = field_two;
        this.FIELD_THREE = field_three;
        this.FIELD_FOUR = field_four;
    }

    public ApptendsStickerInfo() {

    }

    public int getWIDTH() {
        return this.WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return this.HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public String getFONT_NAME() {
        return this.FONT_NAME;
    }

    public void setFONT_NAME(String FONT_NAME) {
        this.FONT_NAME = FONT_NAME;
    }

    public String getTEXT() {
        return this.TEXT;
    }

    public void setTEXT(String TEXT) {
        this.TEXT = TEXT;
    }

    public int getTEXT_COLOR() {
        return this.TEXT_COLOR;
    }

    public void setTEXT_COLOR(int TEXT_COLOR) {
        this.TEXT_COLOR = TEXT_COLOR;
    }

    public int getTEXT_ALPHA() {
        return this.TEXT_ALPHA;
    }

    public void setTEXT_ALPHA(int TEXT_ALPHA) {
        this.TEXT_ALPHA = TEXT_ALPHA;
    }

    public int getSHADOW_PROG() {
        return this.SHADOW_PROG;
    }

    public void setSHADOW_PROG(int SHADOW_PROG) {
        this.SHADOW_PROG = SHADOW_PROG;
    }

    public void setSHADOW_X(int SHADOW_X) {
        this.SHADOW_X = SHADOW_X;
    }

    public void setSHADOW_Y(int SHADOW_Y) {
        this.SHADOW_Y = SHADOW_Y;
    }

    public int getSHADOW_X() {
        return this.SHADOW_X;
    }

    public int getSHADOW_Y() {
        return this.SHADOW_Y;
    }

    public int getSHADOW_COLOR() {
        return this.SHADOW_COLOR;
    }

    public void setSHADOW_COLOR(int SHADOW_COLOR) {
        this.SHADOW_COLOR = SHADOW_COLOR;
    }

    public String getBG_DRAWABLE() {
        return this.BG_DRAWABLE;
    }

    public void setBG_DRAWABLE(String BG_DRAWABLE) {
        this.BG_DRAWABLE = BG_DRAWABLE;
    }

    public int getBG_COLOR() {
        return this.BG_COLOR;
    }

    public void setBG_COLOR(int BG_COLOR) {
        this.BG_COLOR = BG_COLOR;
    }

    public int getBG_ALPHA() {
        return this.BG_ALPHA;
    }

    public void setBG_ALPHA(int BG_ALPHA) {
        this.BG_ALPHA = BG_ALPHA;
    }

    public float getPOS_X() {
        return this.POS_X;
    }

    public void setPOS_X(float POS_X) {
        this.POS_X = POS_X;
    }

    public float getPOS_Y() {
        return this.POS_Y;
    }

    public void setPOS_Y(float POS_Y) {
        this.POS_Y = POS_Y;
    }

    public float getROTATION() {
        return this.ROTATION;
    }

    public void setROTATION(float ROTATION) {
        this.ROTATION = ROTATION;
    }

    public String getTYPE() {
        return this.TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public int getORDER() {
        return this.ORDER;
    }

    public void setORDER(int ORDER) {
        this.ORDER = ORDER;
    }

    public int getTEXT_ID() {
        return this.TEXT_ID;
    }

    public void setTEXT_ID(int TEXT_ID) {
        this.TEXT_ID = TEXT_ID;
    }

    public int getTEMPLATE_ID() {
        return this.TEMPLATE_ID;
    }

    public void setTEMPLATE_ID(int TEMPLATE_ID) {
        this.TEMPLATE_ID = TEMPLATE_ID;
    }

    public int getXRotateProg() {
        return this.XRotateProg;
    }

    public void setXRotateProg(int XRotateProg) {
        this.XRotateProg = XRotateProg;
    }

    public int getYRotateProg() {
        return this.YRotateProg;
    }

    public void setYRotateProg(int YRotateProg) {
        this.YRotateProg = YRotateProg;
    }

    public int getZRotateProg() {
        return this.ZRotateProg;
    }

    public void setZRotateProg(int ZRotateProg) {
        this.ZRotateProg = ZRotateProg;
    }

    public int getCurveRotateProg() {
        return this.CurveRotateProg;
    }

    public void setCurveRotateProg(int CurveRotateProg) {
        this.CurveRotateProg = CurveRotateProg;
    }

    public int getFIELD_ONE() {
        return this.FIELD_ONE;
    }

    public void setFIELD_ONE(int FIELD_ONE) {
        this.FIELD_ONE = FIELD_ONE;
    }

    public String getFIELD_TWO() {
        return this.FIELD_TWO;
    }

    public void setFIELD_TWO(String FIELD_TWO) {
        this.FIELD_TWO = FIELD_TWO;
    }

    public String getFIELD_THREE() {
        return this.FIELD_THREE;
    }

    public void setFIELD_THREE(String FIELD_THREE) {
        this.FIELD_THREE = FIELD_THREE;
    }

    public String getFIELD_FOUR() {
        return this.FIELD_FOUR;
    }

    public void setFIELD_FOUR(String FIELD_FOUR) {
        this.FIELD_FOUR = FIELD_FOUR;
    }
}
