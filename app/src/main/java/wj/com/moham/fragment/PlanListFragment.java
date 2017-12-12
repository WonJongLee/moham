package wj.com.moham.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import wj.com.moham.R;
import wj.com.moham.activity.PlanActivity;
import wj.com.moham.adapter.PlanCardAdapter;
import wj.com.moham.common.model.CardRoomData;

public class PlanListFragment extends Fragment {

    private RecyclerView       mRecyclerPlanList;

    private List<CardRoomData> cardList;
    private CardRoomData       crData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_plan_list, container, false);

        initViews(rootView);

        return rootView;
    }

    private void initViews(View view) {
        mRecyclerPlanList = view.findViewById(R.id.recycler_plan_list);

        setDummyData();

        mRecyclerPlanList.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerPlanList.setAdapter(new PlanCardAdapter(view.getContext(), cardList));
    }

    private void setDummyData() {

        cardList = new ArrayList<>();
        crData = new CardRoomData();
        crData.setCardRoomTitle("test title");
        crData.setCardRoomPersonNum("6/8");
        crData.setCardRoomRecentDate("17.12.11");
        crData.setCardRoomImageUrl("https://firebasestorage.googleapis.com/v0/b/moham-01.appspot.com/o/test1.png?alt=media&token=09c5ef51-aea5-4f12-80f3-4e127207f167");

        cardList.add(crData);
        cardList.add(crData);
        cardList.add(crData);
        cardList.add(crData);
    }
}
