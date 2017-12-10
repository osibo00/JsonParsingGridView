package productions.darthplagueis.jsonparsinggridview.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import productions.darthplagueis.jsonparsinggridview.R;
import productions.darthplagueis.jsonparsinggridview.model.Message;

/**
 * Created by oleg on 12/10/17.
 */

public class DogBreedsViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public DogBreedsViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.itemview_text);
    }

    public void onBind(Message message) {
        textView.setText(message.getMessage());
    }
}
