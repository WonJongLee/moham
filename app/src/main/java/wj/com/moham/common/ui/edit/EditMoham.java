package wj.com.moham.common.model.ui.edit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import wj.com.moham.R;
import wj.com.moham.common.util.StrUtil;

/**
 * Created by admin on 2017. 12. 5..
 */

public class EditMoham extends AppCompatEditText implements TextWatcher, View.OnTouchListener, View.OnFocusChangeListener {
    private Drawable                clearDrawable;
    private OnFocusChangeListener   onFocusChangeListener;
    private OnTouchListener         onTouchListener;
    private Drawable                tempDrawable;
    private Context                 con;
    private String                  hintText;

    InputMethodManager inputMethodManager;

    public EditMoham(final Context context) {
        super(context);
        con = context;
        init();
    }

    public EditMoham(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        con = context;
        init();
    }

    public EditMoham(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        con = context;
        init();
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.onFocusChangeListener = onFocusChangeListener;
    }

    @Override
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    private void init() {
        setTempDrawable(R.drawable.ic_input_del_n);

        setClearIconVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);

        setBackgroundResource(R.drawable.edit_nor);

        if (!StrUtil.isNull(getHint()))
            hintText = getHint().toString();
        else
            hintText = "";

        setHintTextColor(getResources().getColor(R.color.mono_8));

        DisplayMetrics dm = getResources().getDisplayMetrics();
        int padding = Math.round(8 * dm.density);
        setPadding(padding, padding, padding, padding);

        inputMethodManager = (InputMethodManager) con.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    public void onFocusChange(final View view, final boolean hasFocus) {
        if (hasFocus) {
            setHint("");
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            setTextColor(getResources().getColor(R.color.mono_0));
            setTempDrawable(R.drawable.ic_input_del_p);
            setClearIconVisible(getText().length() > 0);
            super.setBackgroundResource(R.drawable.edit_pre);

            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        } else {
            if (getText().toString().length() == 0) {
                setHint(hintText);
                setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
            } else {
                setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            }

            setTempDrawable(R.drawable.ic_input_del_n);
            setClearIconVisible(getText().length() > 0);
            super.setBackgroundResource(R.drawable.edit_nor);
        }
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, hasFocus);
        }
    }

    @Override
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int x = (int) motionEvent.getX();
        if (clearDrawable.isVisible() && x > getWidth() - getPaddingRight() - clearDrawable.getIntrinsicWidth()) {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                setError(null);
                setText(null);
            }
            return true;
        }
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        } else {
            return false;
        }
    }

    @Override
    public final void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
        if (isFocused()) {
            setClearIconVisible(s.length() > 0);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    private void setClearIconVisible(boolean visible) {
        clearDrawable.setVisible(visible, false);
        setCompoundDrawables(null, null, visible ? clearDrawable : null, null);
    }

    public void setTempDrawable(int drawable) {
        tempDrawable = ContextCompat.getDrawable(getContext(), drawable);
        clearDrawable = DrawableCompat.wrap(tempDrawable);
        clearDrawable.setBounds(
                0,
                0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, getResources().getDisplayMetrics())
        );
    }

    public void setErrorImage(boolean b) {
        tempDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_input_check);
        clearDrawable = DrawableCompat.wrap(tempDrawable);
        clearDrawable.setBounds(
                0,
                0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, getResources().getDisplayMetrics())
        );
        super.setBackgroundResource(R.drawable.edit_pre);
        setClearIconVisible(b);
    }

    public void setDisable() {
        setEnabled(false);
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        setTextColor(getResources().getColor(R.color.mono_bf));
        setClearIconVisible(true);
        super.setBackgroundResource(R.drawable.edit_dis);
    }
}
