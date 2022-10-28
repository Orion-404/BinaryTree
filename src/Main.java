import java.sql.SQLOutput;

public class Main
{
    
    public static void main( String[] args )
    {
        BinaryTreeNode five =
                new BinaryTreeNode( null, 5, null );
        
        BinaryTreeNode seven =
                new BinaryTreeNode( null, 7, null );
        
        BinaryTreeNode root =
                new BinaryTreeNode( five, 3, seven );
        
        BinaryTreeNode root2 =
                new BinaryTreeNode(
                        new BinaryTreeNode( null, 5, null ),
                        3,
                        new BinaryTreeNode(
                                null,
                                7,
                                new BinaryTreeNode( null, 10, null )
                        )
                );
        /*
        System.out.println( "----------Post-----------" );
        printTreePostTransversal( root2 );
        System.out.println( "----------Pre-----------" );
        printTreePreTransversal( root2 );
        System.out.println( "----------In----------" );
        printTreeInTransversal( root2 );
        
         */
        System.out.println( "----------No Null---------" );
        printTreeNoNull( root2 );
        System.out.print( "SUM: " );
        System.out.println( treeSum( root2 ) );
        incrementTree( root2 );
        System.out.println( "------------Updated-----------" );
        printTreeNoNull( root2 );
        
    }
    
    public static void printTreePostTransversal( BinaryTreeNode ref )
    {
        if ( ref == null )
        {
            System.out.println( "NULL" );
        }
        else
        {
            // 1. print the left subtree
            // 2. print the right subtree
            // 3. print ref's value
            printTreePostTransversal( ref.left() );
            printTreePostTransversal( ref.right() );
            System.out.println( ref.value() );
        }
    }
    
    public static void printTreeInTransversal( BinaryTreeNode ref )
    {
        if ( ref == null )
        {
            System.out.println( "NULL" );
        }
        else
        {
            // 1. print the left subtree
            // 2. print the right subtree
            // 3. print ref's value
            
            printTreeInTransversal( ref.left() );
            System.out.println( ref.value() );
            printTreeInTransversal( ref.right() );
            
        }
    }
    
    public static void printTreePreTransversal( BinaryTreeNode ref )
    {
        if ( ref == null )
        {
            System.out.println( "NULL" );
        }
        else
        {
            // 1. print the left subtree
            // 2. print the right subtree
            // 3. print ref's value
            System.out.println( ref.value() );
            printTreePreTransversal( ref.left() );
            printTreePreTransversal( ref.right() );
        }
    }
    
    public static void printTreeNoNull( BinaryTreeNode ref )
    {
        if ( ref != null )
        {
            printTreeNoNull( ref.left() );
            System.out.println( ref.value() );
            printTreeNoNull( ref.right() );
        }
    }
    
    public static int treeSum( BinaryTreeNode ref )
    {
        if ( ref != null )
        {
            return ref.value() + treeSum( ref.left() ) + treeSum( ref.right() );
        }
        return 0;
    }
    
    public static void incrementTree( BinaryTreeNode ref )
    {
        //Base case: if null, do nothing
        if ( ref != null )
        {
            ref.setValue( ref.value() + 1 );
            incrementTree( ref.left() );
            incrementTree( ref.right() );
        }
    }
    
    
    
}
