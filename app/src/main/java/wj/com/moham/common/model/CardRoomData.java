package wj.com.moham.common.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;

public class CardRoomData extends BaseObservable {
    private String cardRoomTitle;
    private String cardRoomRecentDate;
    private String cardRoomPersonNum;
    private String cardRoomImageUrl;

    @Bindable
    public String getCardRoomTitle() {
        return cardRoomTitle;
    }

    public void setCardRoomTitle(String cardRoomTitle) {
        this.cardRoomTitle = cardRoomTitle;
    }

    @Bindable
    public String getCardRoomRecentDate() {
        return cardRoomRecentDate;
    }

    public void setCardRoomRecentDate(String cardRoomRecentDate) {
        this.cardRoomRecentDate = cardRoomRecentDate;
    }

    @Bindable
    public String getCardRoomPersonNum() {
        return cardRoomPersonNum;
    }

    public void setCardRoomPersonNum(String cardRoomPersonNum) {
        this.cardRoomPersonNum = cardRoomPersonNum;
    }

    @Bindable
    public String getCardRoomImageUrl() {
        return cardRoomImageUrl;
    }

    public void setCardRoomImageUrl(String cardRoomImageUrl) {
        this.cardRoomImageUrl = cardRoomImageUrl;
    }
}
