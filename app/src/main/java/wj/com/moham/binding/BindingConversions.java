package wj.com.moham.binding;

import android.databinding.BindingConversion;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BindingConversions {

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    @BindingConversion
    public static String convertDateToDisplayedText(Date date) {
        return new SimpleDateFormat("yy.MM.dd").format(date);
    }
}
