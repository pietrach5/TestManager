package services;

public class Counter
{
    private int count=0;

    public Counter()
    {
        count = 0;
    }

    public int get()
    {
        return count;
    }

    public int incrementAndGet()
    {
        return ++count;
    }

    public String toString()
    {
        return ""+count;
    }
}
