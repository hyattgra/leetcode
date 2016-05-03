public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> ret = new HashSet<List<Integer>>();
        if (words == null || words.length < 2) return new ArrayList<List<Integer>>(ret);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0;i<words.length;i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);

                if (isPanlidrome(str1)) {
                    String str2Reverse = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2Reverse) && map.get(str2Reverse) != i) {
                        List<Integer> list = new ArrayList<Integer>();

                        list.add(map.get(str2Reverse));
                        list.add(i);
                        ret.add(list);
                    }
                }

                if (isPanlidrome(str2)) {
                    String str1Reverse = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1Reverse) && map.get(str1Reverse) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1Reverse));
                        ret.add(list);
                    }
                }
            }
        }

        return new ArrayList<List<Integer>>(ret);
    }

    private boolean isPanlidrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
