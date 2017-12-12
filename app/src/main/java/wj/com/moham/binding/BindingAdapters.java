package wj.com.moham.binding;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import wj.com.moham.R;
import wj.com.moham.common.util.StrUtil;

public class BindingAdapters {

    @BindingAdapter({"bind:imageUrl", "bind:error"})
    public static void loadImage(ImageView imageView, String url, Drawable errorDrawable) {
        if (StrUtil.isNull(url)) {
            Picasso.with(imageView.getContext())
                    .load(R.drawable.img_no_pic)
                    .error(errorDrawable)
                    .fit()
                    .into(imageView);
        } else {
            Picasso.with(imageView.getContext())
                    .load(url)
                    .error(errorDrawable)
                    .fit()
                    .into(imageView);
        }
    }
}
