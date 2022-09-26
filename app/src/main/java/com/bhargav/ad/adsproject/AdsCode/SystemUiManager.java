package com.bhargav.ad.adsproject.AdsCode;

import static android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.view.ViewCompat;

import java.lang.reflect.InvocationTargetException;

public class SystemUiManager {

    public SystemUiManager() {

    }


    public static int getStatusBarHeight(Activity activity) {
        final Resources resources = activity.getResources();
        final int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            return resources.getDimensionPixelSize(resId);
        }
        return 0;
    }

    public static int getNavigationBarHeight(Activity activity, int statusBarHeight) {
        Point point = getNavigationBarSize(activity);
        int height = point.y;
        if (isNotchDisplay(statusBarHeight)) {
            height = height - statusBarHeight;
        }
        return height;
    }

    private static Point getNavigationBarSize(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Point appUsableSize = getAppUsableScreenSize(context);
            Point realScreenSize = getRealScreenSize(context);

            // navigation bar on the right
            if (appUsableSize.x < realScreenSize.x) {
                return new Point(realScreenSize.x - appUsableSize.x, appUsableSize.y);
            }

            // navigation bar at the bottom
            if (appUsableSize.y < realScreenSize.y) {
                return new Point(appUsableSize.x, realScreenSize.y - appUsableSize.y);
            }

            // navigation bar is not present
            return new Point();
        }
        return new Point();
    }

    private static Point getAppUsableScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        if (null != windowManager) {
            Display display = windowManager.getDefaultDisplay();
            display.getSize(size);
        }
        return size;
    }

    private static Point getRealScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        if (null != windowManager) {
            Display display = windowManager.getDefaultDisplay();

            if (Build.VERSION.SDK_INT >= 17) {
                display.getRealSize(size);
            } else {
                try {
                    size.x = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
                    size.y = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        return size;
    }

    private static boolean isNotchDisplay(int statusBarHeight) {
        int normalStatusBarHeight = dpToPxForNav(25);
        return statusBarHeight > normalStatusBarHeight;
    }

    private static int dpToPxForNav(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    public static void setNavigationBarHeight(Activity activity, View navBarBackground) {
        ViewCompat.setOnApplyWindowInsetsListener(navBarBackground, (v, insets) -> {
            int navBarHeight = insets.getSystemWindowInsetBottom();
            navBarBackground.getLayoutParams().height = navBarHeight;
            return insets.consumeSystemWindowInsets();
        });
    }

    public static int getNavigationBarHeight(Activity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private static void changeSystemUiContrastStyle(Window window, Boolean lightIcons) {
        View decorView = window.getDecorView();
        if (lightIcons) {
            // Draw light icons on a dark background color
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            // Draw dark icons on a light background color
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public static void setStatusBarNormal(Activity activity, boolean isLight) {

        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setStatusLight(activity, isLight);

        changeSystemUiContrastStyle(activity.getWindow(), isLight);

    }

    public static void setStatusLight(Activity activity, boolean isLightStatusBar) {
        View decor = activity.getWindow().getDecorView();
        if (isLightStatusBar) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            decor.setSystemUiVisibility(0);
        } else {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(android.R.color.white));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public static void setStatusBarColor(Activity activity, int color) {
        activity.getWindow().setStatusBarColor(color);
    }

    public static void setTransparentStatus(Activity activity, boolean isLightIcon) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        if (Build.VERSION.SDK_INT >= 30) {
            if (isLightIcon) {
                activity.getWindow().getDecorView().getWindowInsetsController().setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS);
            } else {
                activity.getWindow().getDecorView().getWindowInsetsController().setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS);
            }
        } else {
            changeSystemUiContrastStyle(activity.getWindow(), isLightIcon);
        }
    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private void initStatusNavBar(Activity activity) {
        int statusBarHeight = getStatusBarHeight(activity);
        int navBarHeight = getNavigationBarHeight(activity, statusBarHeight);
    }

    public static int getColumnWidth(Activity activity, int column, int gridPadding) {
        Resources r = activity.getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, gridPadding, r.getDisplayMetrics());
        return (int) ((getScreenWidth(activity) - ((column + 1) * padding)) / column);
    }

}
