package org.loader.autohideime;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qibin on 2016/6/2.
 */

public class HideIMEUtil {

    public static void wrap(Activity activity) {
        ViewGroup contentParent = (ViewGroup) activity.findViewById(android.R.id.content);
        wrap(contentParent);
    }

    public static void wrap(Fragment fragment) {
        ViewGroup contentParent = (ViewGroup) fragment.getView().getParent();
        wrap(contentParent);
    }

    public static void wrap(ViewGroup contentParent) {
        View content = contentParent.getChildAt(0);
        contentParent.removeView(content);

        ViewGroup.LayoutParams p = content.getLayoutParams();
        AutoHideIMEFrameLayout layout = new AutoHideIMEFrameLayout(content.getContext());
        layout.addView(content);

        contentParent.addView(layout, new ViewGroup.LayoutParams(p.width, p.height));
    }
}