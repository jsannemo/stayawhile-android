package se.kth.csc.stayawhile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QueueAdapter extends RecyclerView.Adapter<QueueAdapter.ViewHolder> {

    private JSONArray mDataset;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mCardView;
        public JSONObject mData;

        public ViewHolder(View v) {
            super(v);
            mCardView = v;
        }

        public void setData(JSONObject data) {
            this.mData = data;
            try {
                TextView title = (TextView) mCardView.findViewById(R.id.queuee_name);
                title.setText(data.getString("realname"));
                TextView length = (TextView) mCardView.findViewById(R.id.queuee_location);
                length.setText(data.getString("location"));
            } catch (JSONException e) {
                //TODO
            }
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public QueueAdapter(JSONArray myDataset, Context context) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public QueueAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.queuee, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            JSONObject queue = mDataset.getJSONObject(position);
            holder.setData(queue);
        } catch (JSONException e) {
            e.printStackTrace();
            // TODO
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length();
    }

}
