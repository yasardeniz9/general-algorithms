package com.algorithms.hashcode;

import java.util.List;

public class FileInput {
    private int maxSlice;
    private int differentTypeCount;
    private List<Integer> sliceOfTypeList;

    public int getMaxSlice() {
        return maxSlice;
    }

    public void setMaxSlice(int maxSlice) {
        this.maxSlice = maxSlice;
    }

    public int getDifferentTypeCount() {
        return differentTypeCount;
    }

    public void setDifferentTypeCount(int differentTypeCount) {
        this.differentTypeCount = differentTypeCount;
    }

    public List<Integer> getSliceOfTypeList() {
        return sliceOfTypeList;
    }

    public void setSliceOfTypeList(List<Integer> sliceOfTypeList) {
        this.sliceOfTypeList = sliceOfTypeList;
    }
}
