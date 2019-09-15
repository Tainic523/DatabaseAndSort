package Tree;

public class Serialize {
    public String Serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        SerializeHelper(root, sb);
        return sb.toString();
    }

    private void SerializeHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        SerializeHelper(root.left, sb);
        SerializeHelper(root.right, sb);
    }

    private int index = -1;

   public TreeNode Deserialize(String str) {
        if(str.length() == 0)
            return null;
        String[] strs = str.split(",");
        return DeserializeHelper(strs);
    }

    private TreeNode DeserializeHelper(String[] strs) {
        index++;
        if(!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = DeserializeHelper(strs);
            root.right = DeserializeHelper(strs);
            return root;
        }
        return null;
    }
}
