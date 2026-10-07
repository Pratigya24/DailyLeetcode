class Solution {
    Set<String> set = new HashSet<>();
    int maxLen = 0;

    public List<String> removeInvalidParentheses(String s) {
        backtrack(s, 0, 0, new StringBuilder());
        return new ArrayList<>(set);
    }

    private void backtrack(String s, int index, int count, StringBuilder current) {
        if (count < 0) {
            return;
        }

        if (index == s.length()) {
            if (count == 0) {
                int len = current.length();

                if (len > maxLen) {
                    set.clear();
                    maxLen = len;
                    set.add(current.toString());
                } else if (len == maxLen) {
                    set.add(current.toString());
                }
            }
            return;
        }

        char ch = s.charAt(index);
        int len = current.length();

        if (ch == '(') {
            current.append(ch);
            backtrack(s, index + 1, count + 1, current);
            current.setLength(len);

            backtrack(s, index + 1, count, current);
        } else if (ch == ')') {
            current.append(ch);
            backtrack(s, index + 1, count - 1, current);
            current.setLength(len);

            backtrack(s, index + 1, count, current);
        } else {
            current.append(ch);
            backtrack(s, index + 1, count, current);
            current.setLength(len);
        }
    }
}