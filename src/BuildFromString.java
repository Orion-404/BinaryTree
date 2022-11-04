public class BuildFromString extends Main
{
    
    public static void main( String[] args )
    {
        String toBuild = "3L5R7RR10";
        BinaryTreeNode root =
                new BinaryTreeNode( null, 3, null);
        printLeftRotatedTree( root );
        root = new BinaryTreeNode( new BinaryTreeNode( null, 5, null ), 3, null );
        printLeftRotatedTree( root );
    }
    
    /*
    public static BinaryTreeNode buildTree(String toBuild)
    {
        if(toBuild.length() != 0)
        {
            
        }
    }
    
     */
    
    
    
    
}
