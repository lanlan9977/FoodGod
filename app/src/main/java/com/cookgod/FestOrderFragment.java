package com.cookgod;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cookgod.menuOrder.MenuOrderVO;
import com.cookgod.R;

public class FestOrderFragment extends Fragment {
    private List<MenuOrderVO> menuOrderVOList;

    public FestOrderFragment() {
//        利用建構子帶入MENU_ORDER VO
        menuOrderVOList = new ArrayList<>();
        MenuOrderVO menuOrderVO = new MenuOrderVO("M02091", "M1", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new Date(), 0, "", "C00001", "C00001", "M00001");

        menuOrderVOList.add(menuOrderVO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_festorder, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.festOrderView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuOrderAdapter(inflater));

        return view;
    }

    private class MenuOrderAdapter extends RecyclerView.Adapter<MenuOrderAdapter.ViewHolder> {
        private LayoutInflater inflater;

        public MenuOrderAdapter(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView idMenu_or_id, idMenu_or_appt;

            public ViewHolder(View itemView) {
                super(itemView);
                idMenu_or_id = itemView.findViewById(R.id.idFesh_or_id);
                idMenu_or_appt = itemView.findViewById(R.id.idFesh_or_appt);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.card_feshorder, parent, false);
            ViewHolder viewHolder = new ViewHolder(itemView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            final MenuOrderVO MenuOrderVO = menuOrderVOList.get(position);
            viewHolder.idMenu_or_id.setText(MenuOrderVO.getMenu_od_ID());
            viewHolder.idMenu_or_appt.setText((MenuOrderVO.getMenu_od_book()).toString());

            viewHolder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return menuOrderVOList.size();
        }

    }
}