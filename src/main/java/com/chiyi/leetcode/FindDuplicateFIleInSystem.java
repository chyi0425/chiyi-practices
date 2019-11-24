package com.chiyi.leetcode;

import java.util.*;

public class FindDuplicateFIleInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : paths) {
            String[] strings = str.split(" ");
            String parentPath = strings[0];
            for (int i = 1; i < strings.length; i++) {
                String string = strings[i];
                int left = string.indexOf('(');
                int right = string.lastIndexOf(')');
                String path = string.substring(0, left);
                String content = string.substring(left + 1, right);
                List<String> allPaths = map.get(content);
                if (allPaths == null) {
                    allPaths = new ArrayList<>();
                    map.put(content, allPaths);
                }
                allPaths.add(parentPath + "/" + path);
            }
        }
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> next = iterator.next();
            List<String> value = next.getValue();
            if (value.size() > 1) {
                result.add(value);
            }
        }
        return result;
    }
}



