package guo.popwindowlistanim;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import guo.popwindowlistanim.adapter.PowerAdapter;

/**
 * @author Guo
 */
public class MainActivity extends AppCompatActivity {

    private List<String> stringList = new ArrayList<>();
    private PopupWindow popPower;
    private RecyclerView recyPopPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        this.findViewById(R.id.tv_loc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPowerPop();
            }
        });
    }

    /**
     * 显示pop
     */
    private void showPowerPop() {

        if(popPower==null){
            initPop();
        }
        if (popPower.isShowing()){
            popPower.dismiss();
            return;
        }

        PowerAdapter adapter = new PowerAdapter(stringList, this);
        recyPopPower.setAdapter(adapter);

        //pop弹出锚点
        RelativeLayout rlDeviceListChoose = (RelativeLayout)this.findViewById(R.id.rl_device_list_choose);
        popPower.showAsDropDown(rlDeviceListChoose);
    }

    /**
     * 初始化pop
     */
    private void initPop() {
        View popupListView = LayoutInflater.from(this).inflate(R.layout.popup_power_list, null);
        popPower = new PopupWindow(popupListView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popPower.setTouchable(true);
        popPower.setFocusable(true);
        popPower.setOutsideTouchable(true);
        popPower.setBackgroundDrawable(new BitmapDrawable(getResources()));
        popPower.setAnimationStyle(R.style.popup_device_choose);

        recyPopPower = popupListView.findViewById(R.id.recy_pop_power);
        recyPopPower.setLayoutManager(new LinearLayoutManager(this));
    }


    /**
     * 从接口获取数据
     */
    private void getData(){
        stringList.add("闪电侠");
        stringList.add("冰与火之歌");
        stringList.add("绿箭侠");
        stringList.add("蝙蝠侠：侠影");
        stringList.add("黑暗骑士");
        stringList.add("神盾局");
    }


}
