
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
        
        
        BinaryTreeNode testCopy = copyTree( root2 );
        System.out.println( "----------No Null---------" );
        printTreeNoNull( root2 );
        System.out.print( "SUM: " );
        System.out.println( treeSum( root2 ) );
        incrementTree( root2 );
        System.out.println( "------------Updated-----------" );
        printTreeNoNull( root2 );
        System.out.println( "------------Copy Tree-----------" );
        printTreeNoNull( copyTree( root2 ) );
        System.out.println( "------------Original Tree-----------" );
        printTreeNoNull( testCopy );
        System.out.println( "-------------Count Nodes-------------" );
        System.out.println( countNodes( root2 ) );
        System.out.println( "---------------Height-----------------" );
        System.out.println( height( root2 ) );
        System.out.println( "----------------Max Value----------------" );
        System.out.println( maxValue( testCopy ) );
        System.out.println( "-----------------Set Depth-----------------" );
        setDepth( testCopy );
        printTreeNoNull( testCopy );
         */
        System.out.println( "-------------------Rotated Tree------------------" );
        printLeftRotatedTree( root2 );
        System.out.println( "--------------------Num Leaves--------------------" );
        System.out.println( numLeaves( root2 ) );
        System.out.println( "--------------------Search------------------" );
        System.out.println( isFound( root2, 10 ) );
    }
    
    public static void setDepth( BinaryTreeNode ref )
    {
        setDepth( ref, 1 );
    }
    
    private static void setDepth( BinaryTreeNode ref, int depth )
    {
        if ( ref != null )
        {
            ref.setValue( depth );
            setDepth( ref.left(), depth + 1 );
            setDepth( ref.right(), depth + 1 );
        }
    }
    
    public static void printLeftRotatedTree( BinaryTreeNode ref )
    {
        printLeftRotatedTree( ref, 0 );
    }
    
    private static void printLeftRotatedTree( BinaryTreeNode ref, int depth )
    {
        if ( ref == null )
        {
            for ( int i = 0; i < depth; i++ )
            {
                System.out.print( "    " );
            }
            System.out.println( "NULL" );
        }
        else
        {
            printLeftRotatedTree( ref.right(), depth + 1 );
            for ( int i = 0; i < depth; i++ )
            {
                System.out.print( "    " );
            }
            System.out.println( ref.value() );
            printLeftRotatedTree( ref.left(), depth + 1 );
        }
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
    
    public static BinaryTreeNode copyTree( BinaryTreeNode ref )
    {
        if ( ref != null )
        {
            return new BinaryTreeNode( copyTree( ref.left() ), ref.value(), copyTree( ref.right() ) );
        }
        return null;
    }
    
    
    public static int countNodes( BinaryTreeNode ref )
    {
        int count = 0;
        if ( ref != null )
        {
            count = 1 + countNodes( ref.right() ) + countNodes( ref.left() );
            
        }
        return count;
    }
    
    public static int maxValue( BinaryTreeNode ref )
    {
        int max;
        if ( ref.isLeaf() )
        {
            max = ref.value();
        }
        else if ( ref.left() == null )
        {
            int rightMax = maxValue( ref.right() );
            max = Math.max( rightMax, ref.value() );
        }
        else if ( ref.right() == null )
        {
            int leftMax = maxValue( ref.left() );
            max = Math.max( leftMax, ref.value() );
        }
        else
        {
            int leftMax = maxValue( ref.left() );
            int rightMax = maxValue( ref.right() );
            max = maxOf3( ref.value(), leftMax, rightMax );
        }
        return max;
    }
    
    private static int maxOf3( int a, int b, int c )
    {
        int[] arr = { a, b, c };
        int bigger = 0;
        for ( int i = 0; i < arr.length - 1; i++ )
        {
            if ( arr[ i ] <= arr[ i + 1 ] )
            {
                bigger = arr[ i + 1 ];
            }
            
        }
        return bigger;
    }
    
    public static int height( BinaryTreeNode ref )
    {
        int height = 0;
        if ( ref != null )
        {
            int leftHeight = height( ref.left() );
            int rightHeight = height( ref.right() );
            
            if ( leftHeight >= rightHeight )
            {
                height = leftHeight + 1;
            }
            else
            {
                height = rightHeight + 1;
            }
            
            //Terinary Version of the if/else statement
            // height = (leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1)
            //                evaluates first         true case       false case
        }
        return height;
        
    }
    
    public static int numLeaves( BinaryTreeNode ref )
    {
        int leafCount = 0;
        if ( ref != null )
        {
            if ( ref.isLeaf() )
            {
                leafCount = 1 + numLeaves( ref.left() ) + numLeaves( ref.right() );
            }
            else
            {
                leafCount = numLeaves( ref.left() ) + numLeaves( ref.right() );
            }
        }
        return leafCount;
    }
    
    public static boolean isFound( BinaryTreeNode ref, int key )
    {
        if ( ref != null )
        {
            return ref.value() == key || isFound( ref.left(), key ) || isFound( ref.right(), key );
        }
        return false;
    }
}
