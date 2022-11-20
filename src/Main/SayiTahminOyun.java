package Main;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SayiTahminOyun {
	private JFrame frmSayTahminOyunu;
	private JTextField txtSayi;
	private JTextField txtTahmin;
	private JTextField txtSayac;
	private JTextField txtMesaj;
	public int sayac = 0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SayiTahminOyun window = new SayiTahminOyun();
				window.frmSayTahminOyunu.setVisible(true);
			}
		});
	}
	public SayiTahminOyun() {
		initialize();
	}
	private void initialize() {
		frmSayTahminOyunu = new JFrame();
		frmSayTahminOyunu.setTitle("Sayi Tahmin Oyunu");
		frmSayTahminOyunu.setBounds(100, 100, 555, 228);
		frmSayTahminOyunu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSayTahminOyunu.getContentPane().setLayout(null);
		JLabel lblTahminEdilecekSayiyi = new JLabel("Tahmin edilecek Sayi: ");
		lblTahminEdilecekSayiyi.setBounds(10, 29, 136, 14);
		frmSayTahminOyunu.getContentPane().add(lblTahminEdilecekSayiyi);

		txtSayi = new JTextField();
		txtSayi.setForeground(Color.WHITE);
		txtSayi.setBounds(156, 29, 48, 20);
		frmSayTahminOyunu.getContentPane().add(txtSayi);
		txtSayi.setColumns(10);

		JLabel lblTahmin = new JLabel("Tahmin: ");
		lblTahmin.setBounds(10, 71, 109, 14);
		frmSayTahminOyunu.getContentPane().add(lblTahmin);

		txtTahmin = new JTextField();
		txtTahmin.setBounds(156, 68, 48, 20);
		frmSayTahminOyunu.getContentPane().add(txtTahmin);
		txtTahmin.setColumns(10);

		JLabel lblSaya = new JLabel("Sayi:");
		lblSaya.setBounds(10, 112, 109, 14);
		frmSayTahminOyunu.getContentPane().add(lblSaya);

		txtSayac = new JTextField();
		txtSayac.setBounds(156, 112, 48, 20);
		frmSayTahminOyunu.getContentPane().add(txtSayac);
		txtSayac.setColumns(10);

JButton btnGonder = new JButton("Gönder");
btnGonder.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0)
{
int sayi=0;
int tahmin=0;

try
{
sayi= Integer.parseInt(txtSayi.getText());
tahmin = Integer.parseInt(txtTahmin.getText());

sayac= sayac+1;
txtSayac.setText(String.valueOf(sayac));

if (sayac<7)
{
if (tahmin==sayi)
{

txtSayi.setForeground(Color.black);
txtMesaj.setText("Kazandýnýz!!!");
return;
}
else if (tahmin<sayi)
txtMesaj.setText("Yukarý");
else
txtMesaj.setText("Aþaðý");
}
else
{
txtMesaj.setText("Oyun Bitti");
txtTahmin.setEnabled(false);

}

txtTahmin.setText(null);

}

catch(NumberFormatException e)
{
txtSayi.setText(null);
txtTahmin.setText(null);
txtMesaj.setText("Lütfen integer deðer giriniz!!");
}
}

});
btnGonder.setBounds(212, 67, 93, 23);
frmSayTahminOyunu.getContentPane().add(btnGonder);

txtMesaj = new JTextField();
txtMesaj.setEditable(false);
txtMesaj.setBounds(315, 68, 214, 20);
frmSayTahminOyunu.getContentPane().add(txtMesaj);
txtMesaj.setColumns(10);

JButton btnYeniOyun = new JButton("Yeni Oyun");
btnYeniOyun.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
sayac=0;
txtTahmin.setEnabled(true);
txtTahmin.setText(null);
txtSayi.setText(null);
txtSayac.setText(null);
txtMesaj.setText(null);

}
});
btnYeniOyun.setBounds(135, 155, 109, 23);
frmSayTahminOyunu.getContentPane().add(btnYeniOyun);
}
}


