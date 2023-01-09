package com.dilidili.filter.service.entity.trie.node;

import com.dilidili.filter.service.entity.trie.AbstractTrieNode;
import com.dilidili.filter.service.entity.trie.TrieNode;

import java.util.Collection;
import java.util.Map;

public abstract class AbstractMapNode<V> extends AbstractTrieNode<V> {

    private final Map<Character, TrieNode<V>> children;

    AbstractMapNode(char character) {
        super(character);
        children = createMap();
    }

    private Map<Character, TrieNode<V>> createMap() {
        return onCreateMap();
    }

    protected abstract Map<Character, TrieNode<V>> onCreateMap();

    private AbstractMapNode<V> createNode(char character) {
        return onCreateNode(character);
    }

    protected abstract AbstractMapNode<V> onCreateNode(char character);

    @Override
    public TrieNode<V> getChildByChar(char c) {
        if (children.containsKey(c)) {
            return children.get(c);
        }
        return null;
    }

    @Override
    public TrieNode<V> addChild(char c) {
        AbstractTrieNode<V> subNode = createNode(c);
        children.put(c, subNode);
        return subNode;
    }

    @Override
    public void removeChild(char c) {
        TrieNode<V> removeNode = children.remove(c);
    }

    @Override
    public Collection<TrieNode<V>> getChildren() {
        return children.values();
    }

    @Override
    public boolean isEnd() {
        return super.isEnd();
    }

    @Override
    public boolean containsChild(char c) {
        return children.containsKey(c);
    }

    @Override
    public void clear() {
        super.clear();
    }
}
