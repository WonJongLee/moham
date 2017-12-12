package wj.com.moham.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import wj.com.moham.R;
import wj.com.moham.common.model.RoomData;
import wj.com.moham.databinding.ItemPlanListBinding;

public class PlanCardAdapter extends BaseRecyclerViewAdapter<RoomData, PlanCardAdapter.PlanCardViewHolder> {


    public PlanCardAdapter(Context context) {
        super(context);
    }

    public PlanCardAdapter(Context context, List<RoomData> arrayList) {
        super(context, arrayList);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_list, parent, false);
        return new PlanCardViewHolder(view);
    }

    @Override
    public void onBindView(final PlanCardViewHolder holder, final int position) {

        RoomData rData = getItem(position);
        holder.binding.setRData(rData);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("asdf", ""+ holder.binding.getRData().getRoomTitle());
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.e("asdf", ""+ holder.binding.getRData().getRoomTitle());
                return true;
            }
        });
    }

    class PlanCardViewHolder extends RecyclerView.ViewHolder {
        ItemPlanListBinding binding;

        public PlanCardViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}