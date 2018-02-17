package com.pace.cs639spring.hw2;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 2/15/2018.
 */

public class Animal {

     private String mName;
     private List<String> mFactList;
     private int mImageId;
     private int mColorFilter;
     private int index;

     Animal(String name, int mImageId, String initialFact){
        mName = name;
        this.mFactList = new ArrayList<>();
        mFactList.add(initialFact);
        this.mImageId = mImageId;
        this.mColorFilter= Color.BLACK;
        this.index = 0;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public int getmColorFilter() {
        return mColorFilter;
    }

    public void setmColorFilter(int mColorFilter) {
        this.mColorFilter = mColorFilter;
    }

    public List<String> getmFactList() {
        return mFactList;
    }

    public void setmFactList(List<String> mFactList) {
        this.mFactList = mFactList;
    }

    //check if you can delete the fact. If you can, remove current fact.
    public boolean deleteFact(){
        if(index == 0){
            return false;
        } else{
            mFactList.remove(index);
            return true;

        }
    }

    public int getNextFactIndex(){
        // checks to see if index is greater than the fact list size. If it is reset to 0, if not, increment.
        index = index >= mFactList.size()-1 ? 0 : index+1;
        return index;

    }

    public int getPrevFactIndex(){
        //if index is greater than 0, move to the previous index, else keep it assigned to 0.
        index = index > 0 ? index-1 : 0;
        return index;
    }

    public int getCurrentFactIndex(){
        return index;
    }

    public void addFact(String newFact){
        mFactList.add(newFact);
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
