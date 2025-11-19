package org.example.leetcode.wordle.entity;

import java.util.ArrayList;
import java.util.List;

public class LetterData {

    private final List<Integer> indexList = new ArrayList<>();

    public void addIndex(int i) {
        indexList.add(i);
    }

    public boolean contains(int i) {
        return indexList.contains(i);
    }

    public void removeAnyOneLetter() {
        indexList.remove(0);
    }

    public int getListSize() {
        return indexList.size();
    }
}
