package samoy.graph.implementtrieprefixtree;

/**
 * @link <a href="https://leetcode.cn/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=top-100-liked">实现Trie（前缀树）</a>
 */
class Trie {
    // 创建一个大小为26的数组，用于存储每个字母对应的子节点
    private final Trie[] children;
    // 标记当前节点是否为一个单词的结束
    private boolean isEnd;

    // 构造函数，初始化前缀树
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    // 插入一个单词到前缀树中
    public void insert(String word) {
        Trie node = this; // 从根节点开始
        for (int i = 0; i < word.length(); i++) {
            // 获取单词的当前字符
            char ch = word.charAt(i);
            // 计算字符在children数组中的索引（'a'映射到0，'b'映射到1，以此类推）
            int index = ch - 'a';
            // 如果该字符对应的子节点不存在，创建一个新的子节点
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 标记当前节点为单词的结束
        node.isEnd = true;
    }

    // 搜索完整的单词，返回true表示单词存在于前缀树中，否则返回false
    public boolean search(String word) {
        Trie node = searchPrefix(word); // 找到单词的前缀节点
        // 如果找到了完整的单词（前缀节点且isEnd为true），返回true
        return node != null && node.isEnd;
    }

    // 检查前缀是否存在于前缀树中，返回true表示存在，否则返回false
    public boolean startsWith(String prefix) {
        // 如果前缀的前缀节点存在，返回true
        return searchPrefix(prefix) != null;
    }

    // 私有方法，查找给定前缀对应的前缀节点
    private Trie searchPrefix(String prefix) {
        Trie node = this; // 从根节点开始
        for (int i = 0; i < prefix.length(); i++) {
            // 获取前缀的当前字符
            char ch = prefix.charAt(i);
            // 计算字符在children数组中的索引
            int index = ch - 'a';
            // 如果找不到对应字符的子节点，返回null
            if (node.children[index] == null) {
                return null;
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 返回前缀节点
        return node;
    }
}
