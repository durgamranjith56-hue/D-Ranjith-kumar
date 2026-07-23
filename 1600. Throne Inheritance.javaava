import java.util.*;

class ThroneInheritance {

    // Store children of each person in birth order
    private Map<String, List<String>> children;

    // Store dead people
    private Set<String> dead;

    // Name of the king
    private String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();

        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {

        // Add child to parent's children list
        children
            .computeIfAbsent(parentName, k -> new ArrayList<>())
            .add(childName);

        // Create an empty children list for the new child
        children.put(childName, new ArrayList<>());
    }

    public void death(String name) {

        // Mark person as dead
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {

        List<String> result = new ArrayList<>();

        // DFS starting from king
        dfs(king, result);

        return result;
    }

    private void dfs(String person, List<String> result) {

        // Add person if they are alive
        if (!dead.contains(person)) {
            result.add(person);
        }

        // Visit children in birth order
        for (String child : children.get(person)) {
            dfs(child, result);
        }
    }
}
