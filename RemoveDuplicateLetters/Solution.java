public static void main(String[] args) {
        String s = "ASD";

        Stack<Character> stack = new Stack<Character>();
        int[] count = new int[256];
        boolean[] added = new boolean[256];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (added[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                added[stack.pop() - 'a'] = false;
            }

            stack.add(c);
            added[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }
