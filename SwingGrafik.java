/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.grafik;
import java.awt.EventQueue;
import javax.swing.JFrame;//importere JFrame
import javax.swing.JLabel;//Importer label
import java.awt.Font;
import javax.swing.JButton;//importer classen til knapper JButton
import java.awt.*;
import javax.swing.JTextField;//importere class filen til tekstfeltet
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
/**
 * @author Ahmad
 */
public abstract class SwingGrafik extends JFrame implements ActionListener
{
private final JPanel panel = new JPanel();//opretter et panel til programmets forside
private final JPanel cPanel = new JPanel();//opretter panel til cirkler
private final JPanel F = new JPanel();//tilføjer panel inde i JFrame firkanter
private final JButton cirkel_omkreds = new JButton("Beregn omkreds");//laver et tekstfelt med 20 pladser til omkreds af cirkel
private final JButton cirkel_areal = new JButton("Beregn areal");//laver et tekstfelt med 20 pladser til areal af cirkel
private final JButton cirkel_rumfang = new JButton("Beregn rumfang af kugle");//laver et tekstfelt med 20 pladser til rumfang af cirkel
private final JPanel tPanel = new JPanel();//opretter panel til trekanter
private final JLabel h = new JLabel("Højde");//opretter tekst til forklaring af tekstfelt trekant_højde i JFrame trekanter
private final JLabel g = new JLabel("Grundlinje");//opretter et nyt JLabel h til tekstfelt trekant_grundlinje i JFrame trekanter
private final JButton areal = new JButton("Beregn areal");//laver en knap til udregning af areal i JFrame trekanter
private final JLabel lenght = new JLabel("Længde");//opretter Label tekst til tekstfeltet til f_area i JFrame firkanter
private final JLabel bredde = new JLabel("Bredde");//Opretter Label tekst til tekstfeltet bred i JFrame firkanter
private final JLabel r = new JLabel("Radius");//opretter label til forklaring af tekstfelt i JFrame cirkler
private final JTextField rad = new JTextField(20);//opretter tekstfelt til radius til JFrame cirkler
private final JTextField trekant_højde = new JTextField(20);//opretter tekstfelt med 20 pladser til højde af trekant
private final JTextField trekant_grundlinje = new JTextField(20);//opretter tekstfelt med 20 pladser til grundlinjen af trekanter
private final JTextField f_area = new JTextField(40);//Her tilføjes tekstfelt til længden i JFrame firkanter 
private final JTextField bred = new JTextField(40);//Her filføjes tekstfelt til bredden i JFrame firkanter
private final JButton om = new JButton("Beregn omkreds");//Tilføjer knap til panel F i JFrame firkanter
private final JButton ar = new JButton("Beregn areal");//tilføjer knap til panel F i Jframe firkanter
private final JLabel resultat = new JLabel("Resultat");//Her til føjes teksten resultat for tekstfeltet res for alle emnerne
private final JTextField res = new JTextField(20);//her oprettes tekstfeltet resultat, hvor resultatet bliver skrevet ud
//implementere knapperne for de forskellige emner nedenunder
private final JButton Trekanter = new JButton("Trekanter");
private final JButton Firkanter = new JButton("Firkanter");
private final JButton Cirkler = new JButton("Cirkler");
private final JButton tilbage = new JButton("Tilbage");
int screenHeight;// variable størrelserne for højden af knapperne
int screenWidth;//variable størrelserne for bredden af knapperne
int height;
int width;
private static final long serialVersionUID = 1L;
public SwingGrafik()
 {
     initUI();
 }
private void initUI()
{
    JFrame vindue = new JFrame ("Geometri udregner ");//opretter JFrame box/container
    vindue.getContentPane().setLayout(new GridLayout(3, 3));
    vindue.add(panel);//tilføjer panel til JFrame vindue
    panel.setSize(300, 200);//sætter størrelsen for panelet
    //tilføjer knapper til panelet nedenunder
    panel.add(Trekanter);
    Trekanter.addActionListener(new ActionListener() 
     {//reagere når der bliver trykket
    @Override 
    public void actionPerformed(ActionEvent e){//her bliver udført funktioner, når der trykkes på knappen
    vindue.setVisible(false);//gør JFramet vindue usynligt
    vindue.dispose();//fjerner JFrame vindue
    JFrame trekanter = new JFrame();//opretter et JFrame til trekanter
    trekanter.setSize(300, 200);//størrelsen af JFrame trekanter
    trekanter.setResizable(false);//størrelsen af JFrame kan ikke ændres
    trekanter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    trekanter.setVisible(true);//gør JFrame trelanter synligt
    trekanter.add(tPanel);//tilføjer tPanel til JFrame trekanter
    trekanter.setTitle("Trekanter");
    tPanel.setSize(300, 200);//Her defineres størrelsen af panelet
    tPanel.setVisible(true);//gør panelet tPanel synligt
    tPanel.add(h);//tilføjer JLabel til panelet
    tPanel.add(trekant_højde);//tilføjer tekstfelt til trekantens højde i JFrame trekanter
    tPanel.add(g);//tilføjer label til panelet
    tPanel.add(trekant_grundlinje);//tilføjer tekstfelt til panelet 
    tPanel.add(areal);//tilføjer knappen til beregning af arealet  panelet
    areal.addActionListener(new ActionListener()
    {//reaktion, når der bliver trykket på knappen
    @Override
    public void actionPerformed(ActionEvent e) {
    String b = trekant_højde.getText();//henter teksten i tekstfeltet trekant_højde
    double b1 = Double.parseDouble(b);//omskriver string b til double b1
    String l = trekant_grundlinje.getText();//henter teksten i tekstfeltet trekant_grundlinje
    double l1 = Double.parseDouble(l);//omskriver string l til double l1
    double a1 = 0.5*b1*l1;//her udregnes arealet af de indtastede værdier til trekanten
    String a2 = String.valueOf(a1);//tallet bliver skrevet om til String
    res.setText(a2);//værdien bliver sat ind i tekstfeltet res
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    });
    tPanel.add(resultat);//tilføjer tekst label til panelet i Jframe trekanter
    tPanel.add(res);//opretter tekstfelt til resultat, når der bliver trykket på en af beregningsknapperne
    System.out.println("Du har trykket på emnet Trekanter");//skriver teksten, når der bliver trykket 
    tPanel.add(tilbage);// her bliver tilbage knappen implementeret 
    tilbage.setSize(100, 50);
    tilbage.addActionListener(new ActionListener() 
    {//reagere når der bliver trykket
    @Override 
    public void actionPerformed(ActionEvent e){//her bliver udført funktioner, når der trykkes på knappen
    trekanter.setVisible(false);//gør JFramet trekanter usynligt 
    trekanter.dispose();//lukker JFrame trekanter
    vindue.setVisible(true);//gør JFramet vindue synligt igen 
    }    
    });
     }});
    panel.add(Firkanter);
    Firkanter.addActionListener(new ActionListener() 
     {
    @Override 
    public void actionPerformed(ActionEvent e)
        {//her bliver der udført funktioner, når der trykkes på knappen
    vindue.setVisible(false);//gør JFrame vindue usynligt
    vindue.dispose();//fjerner JFrame vindue
    System.out.println("Du har trykket på emnet Firkanter");//printer teksten ud   
    JFrame firkanter = new JFrame();//der oprettes et nyt JFrame 
    firkanter.setSize(500, 400);//størrelsen af området
    firkanter.setVisible(true);//gør JFramet synligt
    firkanter.setTitle("Firkanter");
    firkanter.setResizable(false);//størrelsen kan ikke blive ændret
    F.setVisible(true);//gør panelet synligt
    F.setSize(300, 200);//her defineres størrelsen af panelet i pixels
    firkanter.add(F);//Panelet blivet tilføjet til JFrame 
    F.add(lenght);//tilføjer label tekst til tekstfeltet f_area
    F.add(f_area);//tilføjer tekstfeltet f_area til panelet F
    F.add(bredde);//tilføjer label til panelet F
    F.add(bred);//tilføjer tekstfeltet bred til panelet F
    F.add(om);//tilføjer JButton for beregning af omkreds til panelet F
    om.addActionListener(new ActionListener()
    {
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String b2 = bred.getText();//henter værdien fra tekstfeltet bredde
        double b3 = Double.parseDouble(b2);//omskriver værdien til double b3
        String l2 = f_area.getText();//henter værdien fra tekstfeltet f_area
        double l3 = Double.parseDouble(l2);//omskriver værdien til double l3
        double o=(l3*2)+(b3*2);//udregner omkredsen af værdierne l3 og b3
        String o1 = String.valueOf(o);//omskriver o til String
        res.setText(o1);//tilføjer værdien til tekstfeltet res
    }
    }
    );
    F.add(ar);//tilføjer JButton for beregning af areal til panelet F
    ar.addActionListener(new ActionListener()
    {
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String b4 = bred.getText();//henter værdien fra tekstfeltet bredde
        double b5 = Double.parseDouble(b4);//omskriver værdien til double b5
        String l4 = f_area.getText();//henter værdien fra tekstfeltet f_area
        double l5 = Double.parseDouble(l4);//omskriver værdien til double l5
        double are=l5*b5;//udregner arealet af værdierne
        String are1 = String.valueOf(are);//omskriver værdien til String
        res.setText(are1);//indsætter værdien i tekstfeltet res
    }
    }
    );
    F.add(resultat);//tilføjer label resultat til panel F
    F.add(res);//tilføjer tekstfelt til panel F
    F.setVisible(true);//gør panelet synligt
    F.add(tilbage);// her bliver tilbage knappen implementeret 
    firkanter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tilbage.setSize(100, 75);//Her defineres størrelsen af tilbageknappen
    tilbage.addActionListener(new ActionListener() 
    {//reagere når der bliver trykket
    @Override 
    public void actionPerformed(ActionEvent e)
      {//her bliver udført funktioner, når der trykkes på knappen
    firkanter.setVisible(false);
    firkanter.dispose();
    vindue.setVisible(true);
      }    
    });
        }    
     });
    panel.add(Cirkler);
    Cirkler.addActionListener(new ActionListener()
{
    @Override
    @SuppressWarnings("Convert2Lambda")
    public void actionPerformed(ActionEvent e)
        {//her bliver udført funktioner, når der trykkes på knappen
    vindue.setVisible(false);//gør JFrame vindue usynligt
    vindue.dispose();//fjerner JFrame vindue
    System.out.println("Du har trykket på emnet Kugle");
    JFrame cirkler = new JFrame();//laver et nyt JFrame 
    cirkler.setSize(500, 400);//sætter størrelsen for højden og bredden
    cirkler.setResizable(false);//størrelsen af JFramet cirkler kan ikke ændres
    cirkler.getContentPane().setLayout(new GridLayout(3, 3));//laver et layout til JFrame cirkler
    cirkler.setVisible(true);//gør JFramet cirkler synligt
    cirkler.add(cPanel);//tilføjer panelet cPanel til JFrame cirkler
    cPanel.setSize(500, 400);//beskriver størrelsen af panelet i pixels
    //her nedenunder bliver tekstfelterne tilføjet til JFramet cirkler
    cPanel.add(r);//tilføjer label til JFrame cirkler
    cPanel.add(rad);//tilføjer tekstfeltet rad, som er radius til JFrame cirkler
    cPanel.add(cirkel_omkreds);//knappen til udregning af cirklens omkreds
    cirkel_omkreds.addActionListener(new ActionListener()
    {
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String radius = rad.getText();//henter værdien fra tekstfeltet f_area
        double r = Double.parseDouble(radius);//omskriver værdien til double r
        double r1=r*2*3.141592653589793238;//udregner omkredsen af cirklen
        String r2 = String.valueOf(r1);//omskriver værdien til String
        res.setText(r2);//indsætter værdien i tekstfeltet res
    }
    }
    );
    cPanel.add(cirkel_areal);//knappen til udregning af cirklens areal
    cirkel_areal.addActionListener(new ActionListener()
    {
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String radius = rad.getText();//henter værdien fra tekstfeltet f_area
        double r = Double.parseDouble(radius);//omskriver værdien til double r
        double r1=r*r*3.141592653589793238;//udregner arealet af cirklen
        String r2 = String.valueOf(r1);//omskriver værdien til String
        res.setText(r2);//indsætter værdien i tekstfeltet res
    }
    }
    );
    cPanel.add(cirkel_rumfang);//knappen til udregning af en kugles rumfang
    cirkel_rumfang.addActionListener(new ActionListener()
    {
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String radius = rad.getText();//henter værdien fra tekstfeltet f_area
        double r = Double.parseDouble(radius);//omskriver værdien til double r
        double r1=(4/3)*(r*r*r)*3.141592653589793238;//udregner rumfanget af kuglen
        String r2 = String.valueOf(r1);//omskriver værdien til String
        res.setText(r2);//indsætter værdien i tekstfeltet res
    }
    }
    );
    cPanel.add(tilbage);// her bliver tilbage knappen implementeret
    cPanel.add(resultat);//tilføjer label resultat til panelet cPanel
    cPanel.add(res);//tilføjer tekstfeltet til resultat i cPanel
    cirkler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cPanel.setVisible(true);//JFramet bliver synligt for brugeren 
    tilbage.setSize(100, 75);//her defineres tilbageknappens størrelse
    tilbage.addActionListener(new ActionListener() 
    {//reagere når der bliver trykket
    @Override 
    public void actionPerformed(ActionEvent e)
     {//her bliver udført funktioner, når der trykkes på knappen
    cirkler.setVisible(false);//gør JFramet cirkler usynligt
    cirkler.dispose();//afslutter JFrame cirkler
    vindue.setVisible(true);
     }    
    });
        }
});
    JLabel label = new JLabel();//opretter JLabel 
    label.setFont(new Font("Serif",Font.PLAIN,30));
    vindue.setSize(500, 400);//angiver antal pixels i lodret og vandret
    vindue.setResizable(false);//låser vinduets størrelse
    vindue.pack();
    vindue.setVisible(true);//gør vinduet synligt   
    vindue.setLocationRelativeTo(null);
    vindue.setTitle("Matematisk geometri udregner");
    vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    EventQueue.invokeLater(() -> 
    {   
        SwingGrafik ex = new SwingGrafik() 
        {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }  
        };
        ex.setVisible(true);
    });
    }
    }

