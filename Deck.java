import java.util.Random;
public class Deck
{
    private Card[] cards=new Card[52];
    private int top=-1;
    public Deck()
    {
        cards[0]=new Card(0,1);
        cards[1]=new Card(0,2);
        cards[2]=new Card(0,3);
        cards[3]=new Card(0,4);
        cards[4]=new Card(0,5);
        cards[5]=new Card(0,6);
        cards[6]=new Card(0,7);
        cards[7]=new Card(0,8);
        cards[8]=new Card(0,9);
        cards[9]=new Card(0,10);
        cards[10]=new Card(0,11);
        cards[11]=new Card(0,12);
        cards[12]=new Card(0,13);
        
        cards[13]=new Card(1,1);
        cards[14]=new Card(1,2);
        cards[15]=new Card(1,3);
        cards[16]=new Card(1,4);
        cards[17]=new Card(1,5);
        cards[18]=new Card(1,6);
        cards[19]=new Card(1,7);
        cards[20]=new Card(1,8);
        cards[21]=new Card(1,9);
        cards[22]=new Card(1,10);
        cards[23]=new Card(1,11);
        cards[24]=new Card(1,12);
        cards[25]=new Card(1,13);
        
        cards[26]=new Card(2,1);
        cards[27]=new Card(2,2);
        cards[28]=new Card(2,3);
        cards[29]=new Card(2,4);
        cards[30]=new Card(2,5);
        cards[31]=new Card(2,6);
        cards[32]=new Card(2,7);
        cards[33]=new Card(2,8);
        cards[34]=new Card(2,9);
        cards[35]=new Card(2,10);
        cards[36]=new Card(2,11);
        cards[37]=new Card(2,12);
        cards[38]=new Card(2,13);
        
        cards[39]=new Card(3,1);
        cards[40]=new Card(3,2);
        cards[41]=new Card(3,3);
        cards[42]=new Card(3,4);
        cards[43]=new Card(3,5);
        cards[44]=new Card(3,6);
        cards[45]=new Card(3,7);
        cards[46]=new Card(3,8);
        cards[47]=new Card(3,9);
        cards[48]=new Card(3,10);
        cards[49]=new Card(3,11);
        cards[50]=new Card(3,12);
        cards[51]=new Card(3,13);
    }
    public Card deal()
    {
        top++;
        return cards[top];
    }
    public void Shuffle()
    {
        Random rand=new Random();
        for(int p=0;p<52;p++)
        {
            int spot=rand.nextInt(52);
            Card temp=cards[spot];
            cards[spot]=cards[p];
            cards[p]=temp;
        }
        top=-1;
    }
    public int isLeft()
    {
        return 51-top;
    }
}