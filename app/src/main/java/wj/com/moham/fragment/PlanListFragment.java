package wj.com.moham.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import wj.com.moham.R;
import wj.com.moham.activity.WritePlanActivity;
import wj.com.moham.adapter.PlanCardAdapter;
import wj.com.moham.common.data.Const;
import wj.com.moham.common.model.RoomData;
import wj.com.moham.common.ui.dialog.DialogMoham;
import wj.com.moham.common.util.Util;

public class PlanListFragment extends Fragment {
    private ViewGroup mRootView;

    private RecyclerView mRecyclerPlanList;
    private FloatingActionButton mFabPlanList;
    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_plan_list, container, false);

        init(mRootView);

        return mRootView;
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
                goWritePlanAct();
            }
        });
        mRecyclerPlanList.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

    }

    private void getFirebaseDatabase(final View view) {
        final String uId = Util.extractEmail(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> roomList = (ArrayList) dataSnapshot.child(Const.FIREBASE_KEY_USER).child(uId).getValue();
                List<RoomData> cardList = new ArrayList<>();

                for (int i = 0; i < roomList.size(); i++) {
                    String key = roomList.get(i);
                    RoomData crData = new RoomData();

                    try {
                        crData.setRoomImageUrl(dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_IMAGE_URL).getValue().toString());
                    } catch (Exception e) {
                        crData.setRoomImageUrl("");
                    }
                    crData.setRoomTitle(dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_TITLE).getValue().toString());
                    crData.setRoomRecentDate(dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_LAST_MODIFY_DATE).getValue().toString());
                    crData.setRoomPersonNum(dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_NOW_PERSON_NUM).getValue().toString()
                            + "/"
                            + dataSnapshot.child(Const.FIREBASE_KEY_ROOM).child(key).child(Const.FIREBASE_KEY_ROOM_MAX_PERSON_NUM).getValue().toString()
                    );
                    cardList.add(crData);
                }

                mRecyclerPlanList.setAdapter(new PlanCardAdapter(view.getContext(), cardList));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                new DialogMoham().showConfirmFinishDialog(getActivity(), getString(R.string.error), getString(R.string.msg_network_error));
            }
        });
    }

    private void goWritePlanAct() {
        startActivity(new Intent(getActivity(), WritePlanActivity.class));
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        getActivity().finish();
    }
}
