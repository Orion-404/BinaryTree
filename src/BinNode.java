public interface BinNode<E>
{
    public E value();
    
    public void setValue(E v);
    
    public BinNode<E> left();
    
    public BinNode<E> right();
    
    public boolean isLeaf();
}
