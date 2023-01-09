package com.dilidili.filter.service.entity.trie;

import java.util.Collection;

public class AbstractTrieNode<V> implements TrieNode<V> {

    /**
     * 当前节点的字符
     */
    private final char character;

    /**
     * 当前节点是否包含词
     */
    private String word;

    /**
     * 当前节点是否组成词
     */
    private boolean isEnd;

    /**
     * 自定义的一些属性
     */
    private V data;

    public AbstractTrieNode(char character) {
        this.character = character;
        isEnd = false;
        data = null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public void setValue(V data) {

    }

    @Override
    public char getChar() {
        return 0;
    }

    @Override
    public TrieNode<V> getChildByChar(char c) {
        return null;
    }

    @Override
    public TrieNode<V> addChild(char c) {
        return null;
    }

    @Override
    public void removeChild(char c) {

    }

    @Override
    public Collection<TrieNode<V>> getChildren() {
        return null;
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public void setIsEnd(boolean isEnd) {

    }

    @Override
    public String getWord() {
        return this.word;
    }

    @Override
    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean containsChild(char c) {
        return false;
    }

    @Override
    public boolean containsWord() {
        return word != null || word.isBlank();
    }

    @Override
    public void clear() {

    }
}
