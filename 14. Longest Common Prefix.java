class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start with the first string as the prefix
        String prefix = strs[0];

        // Compare the prefix with every other string
        for (int i = 1; i < strs.length; i++) {

            // Keep reducing the prefix until it matches
            // the beginning of the current string
            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                // If no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
