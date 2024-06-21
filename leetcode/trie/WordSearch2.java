package leetcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearch2 {
    class Node{
        HashMap<Character,Node> nodes;
        boolean isEnd;
        public Node(){
            isEnd = false;
            nodes = new HashMap<>();
        }
    }
    Node head = new Node();
    
    public void addWord(String word){
        Node temp = head;
        for(Character c : word.toCharArray()){
            if(!temp.nodes.containsKey(c))
                temp.nodes.put(c,new Node());
            temp = temp.nodes.get(c);
        }
        temp.isEnd = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        List<String> res = new ArrayList<String>();
        for(String word : words){
            addWord(word);
        }
        for(int i = 0;i<rows;i++)
            for(int j = 0;j<cols;j++)
               { 
                Node temp = head;
                boolean[][] visited = new boolean[rows][cols];
                findWords(i,j,"",temp,visited,board,res);
                }
        
        return res;
    }
     public void findWords(int row, int col, String ans,Node head, boolean[][] visited, char[][] board, List<String> res){
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || head.nodes.get(board[row][col]) == null)
            return;
        Node node = head.nodes.get(board[row][col]);
        ans += board[row][col];
        if(node.isEnd) {
            res.add(ans);
            node.isEnd = false;
        }

        visited[row][col] = true;
        findWords(row + 1, col, ans, node, visited, board, res);
        findWords(row - 1, col, ans, node, visited, board, res);
        findWords(row, col + 1, ans, node, visited, board, res);
        findWords(row, col - 1, ans, node, visited, board, res);
        visited[row][col] = false;
        
     }
}