import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class CricketQuiz extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    CricketQuiz(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Who has played most consecutive international matches?");  
            jb[0].setText("Sachin tendulkar");jb[1].setText("Inzamam ul haq");jb[2].setText("Virat kohli");jb[3].setText("Ricky ponting");   
        }  
        if(current==1)  
        {  
            l.setText("Que2:Who has played most consecutive world cup matches?");  
            jb[0].setText("Ricky ponting");jb[1].setText("Kumar sangakarra");jb[2].setText("Sachin tendulkar");jb[3].setText("MS dhoni");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Who has taken the highest number of wickets in test cricket?");  
            jb[0].setText("Malcoin marshal");jb[1].setText("Waqar yunus");jb[2].setText("M.murlidharan");jb[3].setText("Shane warne");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Cricket World Cup 1996 was won by?");  
            jb[0].setText("India");jb[1].setText("Sri lanka");jb[2].setText("S.africa");jb[3].setText("Austraila");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which country will host the 2023 cricket world cup??");  
            jb[0].setText("India");jb[1].setText("England");jb[2].setText("New zealand");jb[3].setText("Sri lanka");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which country owns the Indian Premier League??");  
            jb[0].setText("England");jb[1].setText("India");jb[2].setText("Sri lanka");jb[3].setText("Bangladesh");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Who won the mom award in 2011 world cup final? ");  
            jb[0].setText("Yuvraj singh");jb[1].setText("Gautam gambhir");jb[2].setText("L.malinga");  
                        jb[3].setText("MS dhoni");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Who won player of the series award of T-20 & ODI world cups?");  
            jb[0].setText("Yuvraj singh");jb[1].setText("Sachin tendulkar");jb[2].setText("Virat kohli");  
                        jb[3].setText("Imran khan");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: Which team has won IPL most times?");  
            jb[0].setText("CSK");jb[1].setText("MI");jb[2].setText("KKR");jb[3].setText("RR");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which bowler holds the record of consistently being the No.1 test bowler?");  
            jb[0].setText("Shane warne");jb[1].setText("M.mrulidharan");jb[2].setText("Dale Steyn");  
                        jb[3].setText("James anderson");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[1].isSelected());  
        if(current==6)  
            return(jb[3].isSelected());  
        if(current==7)  
            return(jb[0].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new CricketQuiz("Cricket Quiz");  
    }  
} 