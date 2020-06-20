package org.loudsi.common.tree;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NodeHelper {


    public static <T> T findMax(Node<T> node, Comparator<T> comparator) {
        if (node.isRoot() || !node.isLeaf()) {
            final Optional<T> bestResultNode = node.getChildren()
                    .stream()
                    .map(childNode -> NodeHelper.findMax(childNode, comparator))
                    .max(comparator);
            return bestResultNode.orElse(node.getData());
        } else {
            return node.getData();
        }
    }

    public static <T> List<Node<T>> getAllLeafs(Node<T> node) {
        if (node.isLeaf()) {
            return List.of(node);
        } else {
            return node.getChildren()
                    .stream()
                    .map(NodeHelper::getAllLeafs)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }
    }
}
