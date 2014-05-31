package me.alexrs.fontpagertitlestrip.lib;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

/**
 * Created by Alejandro on 26/05/14.
 */
public class Typefaces {

    private static final String TAG = "Typefaces";

    private static final Hashtable<String, Typeface> CACHE = new Hashtable<String, Typeface>();

    /**
     * @param fontFamily
     * @return
     */
    public static Typeface get(String fontFamily) {
        Typeface t = get(fontFamily, Typeface.NORMAL);
        return cachedTypeface(fontFamily, t);
    }

    /**
     * @param familyName
     * @param style
     * @return
     */
    public static Typeface get(String familyName, int style) {
        Typeface t = Typeface.create(familyName, style);
        return cachedTypeface(familyName, t);
    }


    /**
     * @param typeface
     * @param id
     * @return
     */
    public static Typeface get(Typeface typeface, String id) {
        return cachedTypeface(id, typeface);
    }

    /**
     * @param context
     * @param assetPath
     * @return
     */
    public static Typeface get(Context context, String assetPath) {
        Typeface t = Typeface.createFromAsset(context.getAssets(), assetPath);
        return cachedTypeface(assetPath, t);

    }

    /**
     * @param assetPath
     * @param t
     * @return
     */
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
