package com.dilidili.filter.service.entity.trie;

import java.util.Collection;
import java.util.Collections;

public interface TrieNode<V> {

    /**
     * 获取当前节点的额外字段(比如完整词信息)
     *
     * @return
     */
    V getValue();

    void setValue(V data);



    /**
     * 当前节点的字符
     *
     * @return
     */
    char getChar();

    /**
     * 获取子节点的字符为c的TrieNode
     *
     * @param c
     * @return
     */
    TrieNode<V> getChildByChar(char c);

    TrieNode<V> addChild(char c);

    void removeChild(char c);

    /**
     * 获取当前节点的所有子节点
     *
     * @return
     */
    Collection<TrieNode<V>> getChildren();

    boolean isEnd();

    /**
     * 当前节点是否能组成一个词
     *
     * @param isEnd
     */
    void setIsEnd(boolean isEnd);

    /**
     * 获取当前的词
     *
     * @return
     */
    String getWord();

    void setWord(String word);

    boolean containsChild(char c);

    boolean containsWord();

    void clear();
}
