import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Track which rooms have been visited
        boolean[] visited = new boolean[rooms.size()];
        
        // Start graph traversal from room 0
        dfs(0, rooms, visited);
        
        // Check if any room was left unvisited
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited) {
        // Mark the current room as visited
        visited[currentRoom] = true;
        
        // Iterate through all the keys available in the current room
        for (int key : rooms.get(currentRoom)) {
            // If we haven't visited the room that this key unlocks, go visit it
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
