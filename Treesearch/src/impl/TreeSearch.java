package impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class TreeSearch {

	public static void main(String[] args) {

		Path inputFile = Paths.get("files/input/data_parent.txt");
		List<String[]> cleanInput = new LinkedList<>();

		// 1. Read Input
		try {
			Stream<String> inputLines = Files.lines(inputFile.toAbsolutePath(), Charset.defaultCharset());
			inputLines.forEach(readLine -> {
				if (readLine.length() > 0) {
					String[] chunks = readLine.split("\t");
					for (String chunk : chunks) {
						if (chunk.isBlank() || chunk.isBlank()) {
							return;
						}
					}
					cleanInput.add(chunks);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2. Create Forest
		Map<String, Node> forest = new LinkedHashMap<>();
		cleanInput.stream().forEach(array -> {
			List<Node> references = new ArrayList<>();
			for (int k = 0; k < array.length; k++) {
				String id = array[k];
				Node node = null;
				if (forest.containsKey(id)) {
					node = forest.get(id);
				} else {
					node = new Node(id);
					forest.put(id, node);
				}
				references.add(node);
			}
			if (references.size() > 1) {
				Node child = references.get(0);
				Node parrent = references.get(1);
				child.setParrent(parrent);
			}
		});

		//3. Print out nice values
		forest.values().stream().forEach(node -> {
			Node root = node.getRoot();
			System.out.print(node.getId());
			if (node != root) {
				System.out.print("\t" + root.getId());
			}
			System.out.println();
		});

	}

}
