package huffman;

import java.util.PriorityQueue;

/**
 * Created by andro on 18/04/17.
 */

abstract class HuffmanTree implements Comparable<HuffmanTree> {

    int frequency;

    HuffmanTree(int freq) {
        frequency = freq;
    }

    @Override
    public int compareTo(HuffmanTree o) {
        return frequency - o.frequency;
    }
}

class HuffmanLeaf extends HuffmanTree {

    final char value;

    HuffmanLeaf(int frequency, char v) {
        super(frequency);
        value = v;
    }
}

class HuffmanNode extends HuffmanTree {

    final HuffmanTree left, right;

    HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

public class Huffman {

    private static HuffmanTree buildTree(int[] charFreqs, char[] arr) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();

        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0) {
                trees.offer(new HuffmanLeaf(charFreqs[i], arr[i]));
            }
        }

        while (trees.size() > 1) {
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    private static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {

        String str = "abcdef";
        //converting to array
        char[] arr = str.toCharArray();
        int[] charFreqs = {5, 9, 12, 13, 16, 45};

        // build tree
        HuffmanTree tree = buildTree(charFreqs, arr);

        System.out.println("SYMBOL\tFREQ\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }
}