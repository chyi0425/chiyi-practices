package com.chiyi.leetcode;

import java.util.*;

/**
 * @author chiyi
 * @date 2019/5/21.
 */
public class FindDuplicateFileInSystem {
    // ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
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
                    map.put(content,allPaths);
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

    public static void main(String[] args) {
        FindDuplicateFileInSystem findDuplicateFileInSystem = new FindDuplicateFileInSystem();
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> duplicate = findDuplicateFileInSystem.findDuplicate(paths);

        String test = "1.txt(abcd)";
        System.out.println(duplicate);
        System.out.println(test.indexOf('('));
        System.out.println(test.lastIndexOf(')'));
        System.out.println(test.substring(0, test.indexOf('(')));
        System.out.println(test.substring(test.indexOf('(') + 1, test.lastIndexOf(')')));
    }
}
