
import java.util.*;

class ThroneInheritance {

    // Stores children of each person in birth order
    private Map<String, List<String>> children;

    // Stores people who are dead
    private Set<String> dead;

    // Name of the king
    private String king;

    public ThroneInheritance(String kingName) {
        king = kingName;

        children = new HashMap<>();
        dead = new HashSet<>();

        // Initialize the king's children list
        children.put(kingName, new ArrayList<>());
    }

    // Add a child to the parent's list
    public void birth(String parentName, String childName) {
        children.putIfAbsent(childName, new ArrayList<>());

        children.get(parentName).add(childName);
    }

    // Mark a person as dead
    public void death(String name) {
        dead.add(name);
    }

    // Return the current inheritance order
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();

        dfs(king, order);

        return order;
    }

    // DFS traversal
    private void dfs(String person, List<String> order) {

        // Add person if alive
        if (!dead.contains(person)) {
            order.add(person);
        }

        // Visit all children in birth order
        for (String child : children.get(person)) {
            dfs(child, order);
        }
    }
}




        

    

        

    

        

    

        









