package algstudents.s7.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.UUID;

/**
 * To save and sort the nodes that are going to be used
 */
public class Heap {
	protected PriorityQueue<Node> nodes; //Nodes on the Heap
	private HashMap<UUID, Node> usedNodes; //To compose the solution and to know what nodes have been treated
	
	public Heap() {
		nodes = new PriorityQueue<Node>();
        usedNodes = new HashMap<UUID, Node>();
	}

	public void createEmpty() {
		nodes.clear();
	}
	
	public void insert(Node node) {
        if (!nodeRepeated(node)) { //Not repeat used nodes and avoid infinite loops (e.g., in the puzzle problem)
            nodes.add(node);
        }
	}

    private boolean nodeRepeated(Node node) {
        for (Node n : usedNodes.values()) {
        	if (node.equals(n))
        		return true;
        }
        return false;
    }
	
	public boolean empty() {
		return nodes.isEmpty();
	}
	
	/**
	 * Gets the heuristic of the best node in the priority queue
	 * @return Value of the heuristic of the best node in the queue
	 */
	public int estimateBest() {
		return nodes.peek().getHeuristicValue();
	}
	
	/**
	 * Retrieves and removes the first element of the priority queue
	 * @return Best node of the priority queue
	 */
	public Node extractBestNode() {
		Node node = nodes.poll();
        usedNodes.put(node.getID(), node); //We save it because it can be part of the solution
        //In addition, we can check if we have explored a node previously
		return node;
	}
	
	/**
	 * Extracts the nodes from a specific node (e.g., the solution) to the root node
	 * @param node Node from which we want to extract the path to the root node
	 * @return List with the path from the specific node to the root node
	 */
	public ArrayList<Node> extractUsedNodesFrom(Node node) {
		ArrayList<Node> result = new ArrayList<Node>();
		
        result.add(node); //Add the last node
        UUID parentID = node.getParentID(); //Find its parent node

        while (parentID != null) { //While there is a parent node
        	node = usedNodes.get(parentID);
            result.add(node);
            parentID = node.getParentID();
        }
              
		return result;
	}
}
