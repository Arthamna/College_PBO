
/**
 * Write a description of class NumberDisplay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NumberDisplay
{
    // instance variables - replace the example below with your own
    private int limit;
    private int value;

    /**
     * Constructor for objects of class NumberDisplay
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
    }

    public int getValue()
    {
        return value;
    }

    public String getDisplayValue()
    {
        if(value < 10){
            return "0" + value;
        }
        else{
            return "" + value;
        }
    }

    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    public void increment()
    {
        value = (value+1) % limit;
    }
}