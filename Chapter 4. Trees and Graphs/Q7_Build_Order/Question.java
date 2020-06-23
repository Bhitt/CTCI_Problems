package Q7_Build_Order;

import java.util.ArrayList;

public class Question {
	/*
		Chapter 4 Problem 7
		You are given a list of projects and a list of dependencies (which is a list of pairs
		of projects, where the second project is dependent on the first project). All of a
		project's dependencies must be built before the project is. Find a build order that
		will allow the projects to be built. If there is no valid build order, return an
		error.

		Input: 
			projects: a, b, c, d, e, f
			dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
		Output:
			f, e, a, b, d, c


		Time Complexity:  O(P + D), where P is the number of projects and
			D is the number of dependency pairs.

		NOTE: The solution is a topological sort algorithm, most may not know
			the algorithm but an interviewer could expect you to derive it.
	*/

	public static void main(String[] args) {
		//create test data
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		String[][] dependencies = {
				{"a", "b"},
				{"b", "c"},
				{"a", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
				{"i", "j"},
				{"g", "j"}};
		String[] buildOrder = buildOrderWrapper(projects, dependencies);
		//output solution
		if (buildOrder == null) {
			System.out.println("Circular Dependency.");
		} else {
			for (String s : buildOrder) {
				System.out.println(s);
			}
		}

	}

	//SOLUTION Starts here
	public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}

	/* Build the graph, adding the edge (a, b) if b is dependent on a. 
  	Assumes a pair is listed in 'build order'. The pair (a, b) in 
  	dependencies indicates that b depends on a and a must be built
  	before b. */
	public static Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}
		
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		
		return graph;
	}

	public static Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order = new Project[projects.size()];
		
		/* Add roots to the build order first.*/
		int endOfList = addNonDependent(order, projects, 0);
		
		int toBeProcessed = 0;
		while (toBeProcessed < order.length) {
			Project current = order[toBeProcessed];
			
			/* We have a circular dependency since there are no remaining
			 * projects with zero dependencies. */ 
			if (current == null) {
				return null;
			}
			
			/* Remove myself as a dependency. */
			ArrayList<Project> children = current.getChildren();
			for (Project child : children) {
				child.decrementDependencies();
			}			
			
			/* Add children that have no one depending on them. */
			endOfList = addNonDependent(order, children, endOfList);
			
			toBeProcessed++;
		}
		
		return order;
	}

	/* A helper function to insert projects with zero dependencies 
	 * into the order array, starting at index offset. */
	public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getNumberDependencies() == 0) {
				order[offset] = project;
				offset++;
			}
		}
		return offset;
	}


	//OUTPUT STUFF
	public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
		Project[] buildOrder = findBuildOrder(projects, dependencies);
		if (buildOrder == null) return null;
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}

	public static String[] convertToStringList(Project[] projects) {
		String[] buildOrder = new String[projects.length];
		for (int i = 0; i < projects.length; i++) {
			buildOrder[i] = projects[i].getName();
		}
		return buildOrder;
	}




}