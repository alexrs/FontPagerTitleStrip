package me.alexrs.fontpagertitlestrip.lib;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

public class Typefaces {

    private static final String TAG = "Typefaces";

    private static final Hashtable<String, Typeface> CACHE = new Hashtable<String, Typeface>();


    public static Typeface get(String fontFamily) {
        Typeface t = get(fontFamily, Typeface.NORMAL);
        return cachedTypeface(fontFamily, t);
    }


    public static Typeface get(String familyName, int style) {
        Typeface t = Typeface.create(familyName, style);
        return cachedTypeface(familyName, t);
    }


    public static Typeface get(Typeface typeface, String id) {
        return cachedTypeface(id, typeface);
    }


    public static Typeface get(Context context, String assetPath) {
        Typeface t = Typeface.createFromAsset(context.getAssets(), assetPath);
        return cachedTypeface(assetPath, t);

    }


    private static Typeface cachedTypeface(String assetPath, Typeface t) {
        synchronized (CACHE) {
            if (!CACHE.containsKey(assetPath)) {
                try {
                    CACHE.put(assetPath, t);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get typeface '" + assetPath
                            + "' because " + e.getMessage());
                    return null;
                }
            }
            return CACHE.get(assetPath);
        }
    }
}
