package productions.darthplagueis.jsonparsinggridview.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import productions.darthplagueis.jsonparsinggridview.R;
import productions.darthplagueis.jsonparsinggridview.model.Message;
import productions.darthplagueis.jsonparsinggridview.view.DogBreedsViewHolder;

/**
 * Created by oleg on 12/10/17.
 */

public class DogBreedsAdapter extends RecyclerView.Adapter<DogBreedsViewHolder> {
    private List<Message> messageList;

    public DogBreedsAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public DogBreedsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dogbreeds_itemview, parent, false);
        return new DogBreedsViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(DogBreedsViewHolder holder, int position) {
        ((DogBreedsViewHolder) holder).onBind(messageList.get(position));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
