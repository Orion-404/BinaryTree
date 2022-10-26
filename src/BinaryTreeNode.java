public class BinaryTreeNode
{
    private BinaryTreeNode left;
    private int value;
    private BinaryTreeNode right;
    
    public BinaryTreeNode( BinaryTreeNode left, int value, BinaryTreeNode right )
    {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    
    
    public int value()
    {
        return value;
    }
    
    public void setValue( int v )
    {
        value = v;
    }
    
    public BinaryTreeNode left()
    {
        return left;
    }
    
    public BinaryTreeNode right()
    {
        return right;
    }
    
    public boolean isLeaf()
    {
        return right == null && left == null;
    }
    
    
}
