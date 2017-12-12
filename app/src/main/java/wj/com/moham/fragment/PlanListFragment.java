package wj.com.moham.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import wj.com.moham.R;
import wj.com.moham.adapter.PlanCardAdapter;
import wj.com.moham.common.data.Const;
import wj.com.moham.common.model.CardRoomData;
import wj.com.moham.common.util.Util;

public class PlanListFragment extends Fragment {

    private RecyclerView mRecyclerPlanList;
    private FloatingActionButton mFabPlanList;

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_plan_list, container, false);

        init(rootView);

        return rootView;
    }

    private void init(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        getFirebaseDatabase(view);

        initViews(view);
    }

    private void initViews(View view) {

        mRecyclerPlanList = view.findViewById(R.id.recycler_plan_list);
        mFabPlanList = view.findViewById(R.id.fab_plan_list);
        mFabPlanList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.doSignOut(getActivity());
            }
        });
        mRecyclerPlanList.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

    }

    private void getFirebaseDatabase(final View view) {
        final String uId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> roomList = (ArrayList) dataSnapshot.child(Const.FIREBASE_KEY_USER).child(uId).getValue();
                List<CardRoomData> cardList = new ArrayList<>();

                for (int i = 0; i < roomList.size(); i++) {
                    String key = roomList.get(i);
                    CardRoomData crData = new CardRoomData();

//                    try {
                        crData.setCardRoomImageUrl(dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_IMAGE_URL).getValue().toString());
//                    } catch (Exception e) {
//                        crData.setCardRoomImageUrl("");
//                    }
                    crData.setCardRoomTitle(dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_TITLE).getValue().toString());
                    crData.setCardRoomRecentDate(dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_LAST_MODIFY_DATE).getValue().toString());
                    crData.setCardRoomPersonNum(dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_NOW_PERSON_NUM).getValue().toString()
                            + "/"
                            + dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_MAX_PERSON_NUM).getValue().toString()
                    );
                    cardList.add(crData);
                }

                mRecyclerPlanList.setAdapter(new PlanCardAdapter(view.getContext(), cardList));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
