import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
public class Ay2y extends Applet implements ActionListener

{
    Button surrenderBtn=new Button("Surrender");
    Button doubleBtn=new Button("Double Down");
    Button dealBtn=new Button("Deal");
    Button betBtn=new Button("Place Bet");
    Button nextBtn=new Button ("Next");
    Button highBtn=new Button("High?");
    Button lowBtn=new Button("Low?");
    TextField betTf=new TextField("");
    Deck d=new Deck();
    Card c1;
    Card c2;
    Card c3;
    Card highC,lowC,tempC;
    int low,high,mid;
    String win="";
    String input,output;
    int bet;
    int money=1000;
    boolean betPlaced=false;
    boolean showCard=false;
    boolean highPicked=false;
    Font f20b=new Font("Arial",1,20);
    Font f15=new Font("Arial",0,20);
    String over="";
    //high ace or low?
    public void init()
    {
        this.setLayout(null);
        this.resize(1300,756);
        this.setBackground(Color.yellow);
        d.Shuffle();
        c1=d.deal();
        c2=d.deal();

        dealBtn.setBounds(100,500,100,30);
        this.add(dealBtn);
        dealBtn.addActionListener(this);
        dealBtn.setVisible(false);

        surrenderBtn.setBounds(200,500,100,30);
        this.add(surrenderBtn);
        surrenderBtn.addActionListener(this);
        surrenderBtn.setVisible(false);

        doubleBtn.setBounds(300,500,100,30);
        this.add(doubleBtn);
        doubleBtn.addActionListener(this);
        doubleBtn.setVisible(false);

        betTf.setBounds(100,50,100,30);
        this.add(betTf);
        betTf.addActionListener(this);

        betBtn.setBounds(100,500,100,30);
        this.add(betBtn);
        betBtn.addActionListener(this);

        nextBtn.setBounds(100,500,100,30);
        this.add(nextBtn);
        nextBtn.addActionListener(this);
        nextBtn.setVisible(false);

        lowBtn.setBounds(700,100,100,30);
        this.add(lowBtn);
        lowBtn.addActionListener(this);
        lowBtn.setVisible(false);

        highBtn.setBounds(700,150,100,30);
        this.add(highBtn);
        highBtn.addActionListener(this);
        highBtn.setVisible(false);

        high=c1.getValue();
        highC=c1;
        low=c2.getValue();
        lowC=c2;
        if (high<low)
        {
            high=c2.getValue();
            highC=c2;
            lowC=c1;
            low=c1.getValue();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==betBtn)
        {
            input=betTf.getText();
            bet=Integer.parseInt(input);
            if (bet>0 & bet<=money)
            {
                betPlaced=true;
                betBtn.setVisible(false);
                betTf.setVisible(false);
                dealBtn.setVisible(true);
                surrenderBtn.setVisible(true);
                doubleBtn.setVisible(true);
                input=betTf.getText();
                output="Nice bet";
            }
            else output="That is not a valid bet";
            if (highPicked==false)
            {
                if (betPlaced)
                {
                    if(high==14)
                    {
                        lowBtn.setVisible(true);
                        highBtn.setVisible(true);

                        if (e.getSource()==highBtn)
                        {
                            lowBtn.setVisible(false);
                            highBtn.setVisible(false);
                            highPicked=true;
                        }
                        if (e.getSource()==lowBtn)
                        {
                            highPicked=true;
                            lowBtn.setVisible(false);
                            highBtn.setVisible(false);
                            tempC=lowC;
                            lowC=highC;
                            highC=tempC;
                            high=low;
                            low=1;
                        }
                    }
                }
            }
        }
        if(e.getSource()==dealBtn)
        {
            c3=d.deal();
            showCard=true;
            lowBtn.setVisible(false);
            highBtn.setVisible(false);
            if (c3.getValue()==high || c3.getValue()==low)
            {
                money=money-(bet*2);
                win="Wow! You lose DOUBLE your bet!";
            }
            else
            {
                if(c3.getValue()<high && c3.getValue()>low)
                {
                    win="Congrats! The card is inbetween!";
                    money=money+bet;
                }
                else
                {
                    win="Sorry, that card is not inbetween.";
                    money=money-bet;
                }
            }
            nextBtn.setVisible(true);
            dealBtn.setVisible(false);
            doubleBtn.setVisible(false);
            surrenderBtn.setVisible(false);
            output="";
        }
        if (e.getSource()==doubleBtn)
        {
            surrenderBtn.setVisible(false);
            doubleBtn.setVisible(false);
            bet=bet*2;
            output="";
        }
        if (e.getSource()==surrenderBtn)
        {
            bet=bet/2;
            money=money-bet;
            surrenderBtn.setVisible(false);
            doubleBtn.setVisible(false);
            dealBtn.setVisible(false);
            c3=d.deal();
            nextBtn.setVisible(true);
            showCard=true;
            if(c3.getValue()<high && c3.getValue()>low)
            {
                win="Whoops! Bad move.";
            }
            else
            {
                win="You made a good call!";
            }
            output="";
        }
        if (e.getSource()==nextBtn)
        {
            betPlaced=false;
            surrenderBtn.setVisible(false);
            doubleBtn.setVisible(false);
            betBtn.setVisible(true);
            betTf.setVisible(true);
            win="";
            d.Shuffle();
            c1=d.deal();
            c2=d.deal();
            showCard=false;
            high=c1.getValue();
            highC=c1;
            low=c2.getValue();
            lowC=c2;
            if (high<low)
            {
                high=c2.getValue();
                highC=c2;
                lowC=c1;
                low=c1.getValue();
            }

        }
        repaint();
    }

    public void paint(Graphics g)
    {
        g.setFont(f20b);
        g.drawString(win,50,400);
        g.setFont(f15);
        g.drawString("Money: $"+money,50,300);
        g.drawString(output,50,275);
        if (betPlaced)
        {
            g.drawString("Current bet: "+bet,50,350);
            g.drawImage(lowC.getCard(this),50,50,this);
            g.drawImage(highC.getCard(this),350,50,this);

        }
        if (showCard)
            g.drawImage(c3.getCard(this),200,50,this);
        g.setColor(Color.green);
        g.setFont(f20b);
        g.drawString(over,500,500);
    }
}