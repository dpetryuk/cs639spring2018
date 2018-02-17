package com.pace.cs639spring.hw2;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pace.cs639spring.hw2.Animal;
import com.pace.cs639spring.hw2.R;

import java.util.List;

/**
 * Created by kachi on 2/7/18.
 */

public class AnimalDisplayListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<Animal> mAnimalList;
    private int mSelectedPosition;

    AnimalDisplayListViewAdapter(Context context, List<Animal> animalObjectList) {
        mContext = context;
        mAnimalList = animalObjectList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item, null);
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        final Animal animal = (Animal) getItem(position);
        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.mTextView.setText(String.format("%s\n%s", animal.getmName(), animal.getmFactList().get(animal.getCurrentFactIndex())));
        viewHolder.mTextView.setTag(position);
        // Checks to see if item is clicked with position check. If it is, make the textView visible, if not, it disappears
        viewHolder.mTextView.setVisibility(mSelectedPosition== position ? View.VISIBLE: View.GONE);
        viewHolder.mImageView.setImageResource(animal.getmImageId());
        viewHolder.mImageView.setColorFilter(animal.getmColorFilter(), PorterDuff.Mode.SRC_IN);
        viewHolder.mNextFact.setTag(position);
        //sets visibility of buttons to the same as the textview, following the same logic.
        viewHolder.mNextFact.setVisibility(viewHolder.mTextView.getVisibility());
        viewHolder.mDeleteFact.setTag(position);
        viewHolder.mDeleteFact.setVisibility(viewHolder.mNextFact.getVisibility());

        View.OnClickListener itemBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.nextFactBtn:
                        int nextFactIndex = animal.getNextFactIndex();
                        viewHolder.mTextView.setText(String.format("%s\n%s", animal.getmName(), animal.getmFactList().get(nextFactIndex)));
                        break;
                    case R.id.deleteFactBtn:
                        if(animal.deleteFact()){
                            int prevFactIndex = animal.getPrevFactIndex();
                            Toast.makeText(mContext, "Fact deleted", Toast.LENGTH_SHORT).show();
                            Log.e("updated fact list", animal.getmFactList().toString());
                            viewHolder.mTextView.setText(String.format("%s\n%s", animal.getmName(), animal.getmFactList().get(prevFactIndex)));
                        } else{
                            Toast.makeText(mContext, "Cannot delete the initial fact", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        };

        viewHolder.mNextFact.setOnClickListener(itemBtnListener);
        viewHolder.mDeleteFact.setOnClickListener(itemBtnListener);

        return convertView;
    }

    // Sets position of clicked item in listview
    void setSelectedPosition(int position) {
        mSelectedPosition = position;
    }

    //Gets position of clicked item in listview
    int getSelectedPosition() {
        return mSelectedPosition;
    }

    @Override
    public int getCount() {
        return mAnimalList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAnimalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    static class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
        Button mNextFact;
        Button mDeleteFact;

        ViewHolder(View item) {
            //Add All views for an item in the view holder
            mImageView = item.findViewById(R.id.image);
            mTextView = item.findViewById(R.id.fact);
            mNextFact = item.findViewById(R.id.nextFactBtn);
            mDeleteFact = item.findViewById(R.id.deleteFactBtn);


        }
    }
}
