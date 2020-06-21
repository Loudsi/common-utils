package org.loudsi.common.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node<T> {

    private final List<Node<T>> children = new ArrayList<>();

    private Node<T> parent = null;
    private T data = null;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Collection<Node<T>> children) {
        this.data = data;
        children.forEach(this::addChild);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        child.parent = this;
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        child.parent = this;
        this.children.add(child);
    }

    public void addChildren(Collection<Node<T>> children) {
        children.forEach(this::addChild);
    }

    public void addChildrenData(Collection<T> childrenData) {
        childrenData.forEach(this::addChild);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }

}
