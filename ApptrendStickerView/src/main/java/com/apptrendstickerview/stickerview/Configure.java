package com.apptrendstickerview.stickerview;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class Configure {
    public static File GetFileDir(Context context) {
        if ("mounted".equals( Environment.getExternalStorageState())) {
            return context.getExternalFilesDir(null);
        }
        return context.getFilesDir();
    }

    public static File GetFontDir(Context context) {
        File dir = GetFileDir(context);
        File result = new File(dir.getPath() + File.separator + "font");
        if (result.exists() || result.mkdirs()) {
            return result;
        }
        return dir;
    }

}
