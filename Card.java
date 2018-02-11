import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
//Images taken from www.oxymoron.com
public class Card
{
    private int suit, value;//1-14(ace-king), 0-3 for suit 
    //(club,diamond,heart,spade)
    private String ValueName[]={"Two","Three","Four","Five","Six","Seven"
        ,"Eight","Nine","Ten","Jack","Queen","King","Ace"};
    public Card()
    {
    }

    public Card(int inSuit, int inValue)
    {
        setValue(inValue);
        setSuit(inSuit);
    }
    
    public void setSuit(int inSuit)
    {
        if (inSuit>=0 && inSuit<=3)
            suit=inSuit;
        else
            suit=3;
    }

    public void setValue(int inValue)
    {
        if (inValue>0 && inValue<14)
            value=inValue;
        else
            value=0;
    }

    public String getSuit()
    {
        if(suit==0)
            return "Clubs";
        else if (suit==1)
            return "Diamonds";
        else if (suit==2)
            return "Hearts";
        else return "Spades";
    }

    public int getSuitNum()
    {
        if(suit==0)
            return 0;
        else if (suit==1)
            return 1;
        else if (suit==2)
            return 2;
        else return 3;
    }

    public String getValueName()
    {
        return ValueName[value-1];
    }


    public int getValue()
    {
        return value+1;
    }

    public String toString()
    {
        return "The "+getValueName()+" of "+getSuit();
    }

    public Image getCard( Applet app)
    {
        return app.getImage(app.getCodeBase(), "c"+(suit*13+(value+1))+".gif"); //oxymoron.com
    }
}
