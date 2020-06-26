package org.loudsi.common.tree;

import java.util.*;
import java.util.stream.Collectors;

public class NodeHelper {


    public static <T> T findMax(Node<T> node, Comparator<T> comparator) {
        if (node.isRoot() || !node.isLeaf()) {
            final Optional<T> bestResultNode = node.getChildren()
                    .stream()
                    .map(childNode -> NodeHelper.findMax(childNode, comparator))
                    .max(comparator);
            final T bestOfChildren = bestResultNode.orElse(node.getData());
            if(!node.isRoot() && comparator.compare(node.getData(),bestOfChildren) > 0){
                return node.getData();
            }else {
                return bestOfChildren;
            }
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

    public <T> List<Node<T>> getAllNodes(Node<T> node) {
        if (node.isLeaf()) {
            return List.of(node);
        } else {
            final List<Node<T>> collected = node.getChildren().stream().map(this::getAllNodes).flatMap(Collection::stream).collect(Collectors.toList());
            collected.add(node);
            return collected;
        }
    }
    //TODO REDO with lambda
    public <T> Map<Integer, Integer> getChildrenByDepth(Node<T> node) {
        HashMap<Integer, Integer> childrenByDepth = new HashMap<>();
        fillChildrenByDepth(node, childrenByDepth, 0);
        return childrenByDepth;
    }

    private <T> void fillChildrenByDepth(Node<T> node, HashMap<Integer, Integer> childrenByDepth, int currentDepth) {
        if (currentDepth == 0) {
            childrenByDepth.put(0, 1);
        }
        childrenByDepth.merge(currentDepth + 1, node.getChildren().size(), Integer::sum);
        node.getChildren().forEach(child -> fillChildrenByDepth(child, childrenByDepth, currentDepth + 1));
    }
}
