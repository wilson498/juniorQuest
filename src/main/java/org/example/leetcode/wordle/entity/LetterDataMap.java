package org.example.leetcode.wordle.entity;

import org.example.leetcode.wordle.enumdata.LetterStatus;

import java.util.HashMap;
import java.util.Map;

public class LetterDataMap {

    private final Map<Character, LetterData> letterMap = new HashMap<>();

    public void addIndexToList(Character ch, int index) {
        LetterData letter = letterMap.getOrDefault(ch, new LetterData());
        letter.addIndex(index);
        letterMap.put(ch, letter);
    }

    public void removeLetterData(char c) {
        LetterData letter = letterMap.get(c);
        if (letter == null) {
            return;
        }
        if (letter.getListSize() > 0) {
            letter.removeAnyOneLetter();
        }
        if (letter.getListSize() == 0) {
            letterMap.remove(c);
        }
    }

    public void clear() {
        letterMap.clear();
    }

    public LetterStatus checkLetterStatus(char c, int index) {
        LetterData letter = letterMap.get(c);
        if (letter == null) {
            return LetterStatus.NOT_EXIST;
        }
        if (letter.contains(index)) {
            return LetterStatus.CORRECT;
        }
        return LetterStatus.EXIST;
    }
}
