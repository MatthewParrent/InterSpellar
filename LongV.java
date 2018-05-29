// you need this class because you can't access primitives in animation timer
public class LongV
{
    private long value;
    
    public LongV(long i)
    {
        value = i;
    }
    
    public long getValue() // returns the value as a long
    {
    	return value;
    }
    
    public void removeOne()
    {
    	value--;
    }
    
    public void set(long a)
    {
    	value = a;
    }
}