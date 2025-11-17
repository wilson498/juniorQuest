package org.example.leetcode.wordle.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LetterData {
    private List<Integer> indexList = new ArrayList<>();

    public void addIndex(int i) {
        indexList.add(i);
    }

    public boolean contains(int i) {
        if (indexList.contains(i)) {
            return true;
        } else {
            return false;
        }
    }

    public void removeOne() {
        indexList.remove(0);
    }

    public int getListSize() {
        return indexList.size();
    }
}
