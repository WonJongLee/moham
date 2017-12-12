package wj.com.moham.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import wj.com.moham.R;
import wj.com.moham.common.model.CardRoomData;
import wj.com.moham.databinding.ItemPlanListBinding;

public class PlanCardAdapter extends BaseRecyclerViewAdapter<CardRoomData, PlanCardAdapter.PlanCardViewHolder> {


    public PlanCardAdapter(Context context) {
        super(context);
    }

    public PlanCardAdapter(Context context, List<CardRoomData> arrayList) {
        super(context, arrayList);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_list, parent, false);
        return new PlanCardViewHolder(view);
    }

    @Override
    public void onBindView(PlanCardViewHolder holder, int position) {

        CardRoomData crData = getItem(position);
        holder.binding.setCrData(crData);
    }

    class PlanCardViewHolder extends RecyclerView.ViewHolder {
        ItemPlanListBinding binding;

        public PlanCardViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}