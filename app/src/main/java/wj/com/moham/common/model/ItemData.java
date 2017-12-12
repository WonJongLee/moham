package wj.com.moham.common.model;

import android.graphics.Bitmap;

/**
 * Created by user on 2017-12-11.
 */

public class ItemData {
    private String itemId;
    private String itemTitle;
    private String itemContents;
    private String itemRecentDate;
    private Bitmap itemImage;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemContents() {
        return itemContents;
    }

    public void setItemContents(String itemContents) {
        this.itemContents = itemContents;
    }

    public String getItemRecentDate() {
        return itemRecentDate;
    }

    public void setItemRecentDate(String itemRecentDate) {
        this.itemRecentDate = itemRecentDate;
    }

    public Bitmap getItemImage() {
        return itemImage;
    }

    public void setItemImage(Bitmap itemImage) {
        this.itemImage = itemImage;
    }
}
