/**
 * @copyright
 * This code is licensed under the Rekisoft Public License.
 * See http://www.rekisoft.eu/licenses/rkspl.html for more information.
 */
/**
 * @package eu.rekisoft.android.tinteddrawable
 * This package contains the TintedDrawable class by [rekisoft.eu](http://rekisoft.eu/).
 */
package eu.rekisoft.android.tinteddrawable;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/**
 * Abstract base class for tinting drawables.
 *
 * Created on 02.12.2014.
 * @author René Kilczan
 */
public abstract class TintedDrawable extends InsetDrawable {
    public TintedDrawable(Drawable image) {
        super(image, 0);
        setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
    }

    @Override
    public final boolean onStateChange(int[] states) {
        boolean isPressed = false;
        boolean isFocused = false;
        boolean isActive = false;
        for(int state : states) {
            if(state == android.R.attr.state_pressed) {
                isPressed = true;
            } else if(state == android.R.attr.state_focused) {
                isFocused = true;
            } else if(state == android.R.attr.state_active) {
                isActive = true;
            }
        }
        int color = getColor(isPressed, isFocused, isActive);
        super.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        super.setAlpha(Color.alpha(color));
        return super.onStateChange(states);
    }

    protected abstract int getColor(boolean isPressed, boolean isFocused, boolean isActive);

    @Override
    public boolean isStateful() {
        return true;
    }
}