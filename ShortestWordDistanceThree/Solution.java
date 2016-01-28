public static int shortestWordDistance(String[] words, String word1, String word2) {
        int ret = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1 && index1 != index2) {
                    ret = Math.min(ret, index1 - index2);
                    index2=-1;
                }
            }
            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1 && index1 != index2) {
                    ret = Math.min(ret, index2 - index1);
                    index1=-1;
                }
            }
        }
        return ret;
    }
