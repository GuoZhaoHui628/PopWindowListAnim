package guo.popwindowlistanim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import guo.popwindowlistanim.R;

/**
 * Created by ${GuoZhaoHui} on 2017/11/29.
 * Email:guozhaohui628@gmail.com
 */

public class PowerAdapter extends RecyclerView.Adapter<PowerAdapter.ViewHolder> {

    private List<String> mDatas;
    private Context mContext;

    public PowerAdapter(List<String> Datas, Context Context) {
        this.mDatas = Datas;
        this.mContext = Context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_pop_powerlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s = mDatas.get(position);
        holder.itemPopPowerName.setText(s);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemPopPowerName;

        public ViewHolder(View itemView) {
            super(itemView);
            itemPopPowerName = itemView.findViewById(R.id.item_pop_power_name);
        }
    }

}
