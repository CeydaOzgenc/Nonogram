package Main;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main extends JFrame{
	private JPanel contentPane;
	private JLabel lblSayi;
	private JLabel lblSecim;
	private JButton btnSiyah;
	private JButton btnBeyaz;
	private int col_say,row_say,col_adet,row_adet,height,width,yazi_height,yazi_width,secim=2,hak_say=3,oyun_say;
	private String string_say;
	public  Main() {
		GUI();
	}
	public void GUI() {
		int resim[][]=new int[5][5];
		int kalp[][] = {{0,1,0,1,0},{1,0,1,0,1},{1,0,0,0,1},{0,1,0,1,0},{0,0,1,0,0}};
		int aslan[][] = {{0,1,1,1,0},{1,1,1,1,0},{1,1,1,1,0},{0,1,1,1,1},{1,1,1,1,1}};
		int agac[][] = {{0,1,1,1,0},{1,1,1,1,1},{0,1,1,1,0},{0,0,1,0,0},{0,0,1,0,0}};
		int semsiye[][] = {{0,0,1,0,0},{0,1,1,1,0},{1,1,1,1,1},{0,0,1,0,0},{0,0,1,1,0}};
		String resim_sec[] = {"Kalp","Aslan","Agac","Þemsiye"};
		int say_col[][]=new int[5][5];
		int say_row[][]=new int[5][5];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblSecim = new JLabel(String.valueOf("Seçim Yapýnýz: "));
		lblSecim.setBounds(600, 10, 121, 30);
		contentPane.add(lblSecim);
		btnSiyah = new JButton();
		btnSiyah.setBackground(Color.BLACK);
		btnSiyah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secim=1;
			}
		});
		btnSiyah.setBounds(600, 50, 80, 30);
		contentPane.add(btnSiyah);
		btnBeyaz = new JButton();
		btnBeyaz.setBackground(Color.WHITE);
		btnBeyaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secim=0;
			}
		});
		btnBeyaz.setBounds(700, 50, 80, 30);
		contentPane.add(btnBeyaz);
		int al = (int)(Math.random() * 4);
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				switch (al) {
				  case 0:
					resim[row][col]=kalp[row][col];
				    break;
				  case 1:
					resim[row][col]=aslan[row][col];
				    break;
				  case 2:
					resim[row][col]=agac[row][col];
				    break;
				  case 3:
					resim[row][col]=semsiye[row][col];
				    break;
				}
			}
		}
		height=10;
		for (int row = 0; row < 5; row++) {
			width=10;
			for (int col = 0; col < 5; col++) {
				if(resim[col][row]!=0) {
					JButton ButtonS = new JButton();
					ButtonS.setBackground(Color.gray);
					ButtonS.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(hak_say>0) {
								if(secim==0) {
									JOptionPane.showMessageDialog(contentPane,"Hatalý seçim hakkýnýz:"+hak_say);
									ButtonS.setBackground(new Color(0,0,0));
									hak_say-=1;
									oyun_say+=1;
								}else if(secim==1) {
									oyun_say+=1;
									ButtonS.setBackground(new Color(0,0,0));
								}
							}else {
								JOptionPane.showMessageDialog(contentPane,"Oyunu Kaybettiniz!!");
								System.exit(0);
							}
							if(oyun_say==25) {
								JOptionPane.showMessageDialog(contentPane,"Kazandýnýz!!");
								JOptionPane.showMessageDialog(contentPane,resim_sec[al]);
								System.exit(0);
							}
						}
					});
					ButtonS.setBounds(height, width, 80, 80);
					contentPane.add(ButtonS);
				}else {
					JButton ButtonB = new JButton();
					ButtonB.setBackground(Color.gray);
					ButtonB.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(hak_say>0) {
								if(secim==1 ) {
									JOptionPane.showMessageDialog(contentPane,"Hatalý seçim hakkýnýz:"+hak_say);
									ButtonB.setBackground(new Color(255,255,255));
									hak_say-=1;
									oyun_say+=1;
								}else if(secim==0) {
									oyun_say+=1;
									ButtonB.setBackground(new Color(255,255,255));
								}
							}
							else {
								JOptionPane.showMessageDialog(contentPane,"Oyunu Kaybettiniz!!");
								System.exit(0);
							}
							if(oyun_say==25) {
								JOptionPane.showMessageDialog(contentPane,"Kazandýnýz!!");
								JOptionPane.showMessageDialog(contentPane,resim_sec[al]);
								System.exit(0);
							}
						}
					});
					ButtonB.setBounds(height, width, 80, 80);
					contentPane.add(ButtonB);
				}
				width+=100;
			}
			height+=100;
		}
		for (int row = 0; row < 5; row++) {
			col_adet=0;
			row_adet=0;
			for (int col = 0; col < 5; col++) {
				if(resim[row][col]==1) {
					if(col<4) {
						col_say+=1;
						if(resim[row][col+1]==0) {
							say_col[row][col_adet]=col_say;
							col_say=0;						
							//System.out.println(say_col[row][col_adet]);
							//System.out.println(col_adet+"--");
							col_adet+=1;
						}
					}
					else {
						col_say+=1;	
						say_col[row][col_adet]=col_say;
						col_say=0;
						//System.out.println(say_col[row][col_adet]);
						//System.out.println(col_adet+"--");
						col_adet+=1;
					}
					
				}
				if(resim[col][row]==1) {
					if(col<4) {
						row_say+=1;
						if(resim[col+1][row]==0) {
							say_row[row][row_adet]=row_say;
							row_say=0;
							row_adet+=1;
						}
						
					}
					else {
						row_say+=1;
						say_row[row][row_adet]=row_say;
						row_say=0;
						row_adet+=1;
					}
				}
			}
		}
		yazi_width=10;
		yazi_height=10;
		for (int row = 0; row <say_row.length; row++) {
			string_say="-";
			for (int col = 0; col<say_row[row].length; col++) {
				if(say_row[row][col]!=0) {
					string_say+=say_row[row][col]+"-";
				}
			}
			lblSayi = new JLabel(String.valueOf(string_say));
			lblSayi.setBounds(yazi_height, 500, 121, 23);
			contentPane.add(lblSayi);
			yazi_height+=100;
			string_say="-";
			for (int col = 0; col<say_col[row].length; col++) {
				if(say_col[row][col]!=0) {
					string_say+=say_col[row][col]+"-";
				}
			}
			lblSayi = new JLabel(String.valueOf(string_say));
			lblSayi.setBounds(500, yazi_width, 121, 23);
			contentPane.add(lblSayi);
			yazi_width+=100;
		}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main frame = new Main();
				frame.setVisible(true);
				}
		});
	}

}
