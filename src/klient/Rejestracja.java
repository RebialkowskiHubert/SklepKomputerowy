package klient;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logowanie.Baza;
import logowanie.Login;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Rejestracja extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNumerDomu;
	private JTextField textField_7;
	private JLabel lblNumerLokalu;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel label;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel lblNieObowizkowe;

	JButton btnZarejestruj = new JButton("Zarejestruj");
	JButton btnWstecz = new JButton("Anuluj");

	public Rejestracja() {
		setBounds(100, 100, 580, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Rejestracja");
		this.setVisible(true);

		JLabel lblImi = new JLabel("Imię:");
		lblImi.setBounds(10, 11, 46, 14);
		contentPane.add(lblImi);

		textField = new JTextField();
		textField.setBounds(146, 8, 149, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(10, 39, 80, 14);
		contentPane.add(lblNazwisko);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 36, 149, 20);
		contentPane.add(textField_1);

		JLabel lblHaso = new JLabel("Hasło:");
		lblHaso.setBounds(10, 121, 106, 14);
		contentPane.add(lblHaso);

		JLabel lblPowtrzHaso = new JLabel("Powtórz hasło:");
		lblPowtrzHaso.setBounds(10, 149, 114, 14);
		contentPane.add(lblPowtrzHaso);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(146, 146, 86, 20);
		contentPane.add(passwordField_1);

		JLabel lblAdresEmail = new JLabel("Adres e-mail:");
		lblAdresEmail.setBounds(10, 67, 106, 14);
		contentPane.add(lblAdresEmail);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 64, 149, 20);
		contentPane.add(textField_2);

		JLabel lblNumerTelefonu = new JLabel("*Numer telefonu:");
		lblNumerTelefonu.setBounds(10, 299, 126, 14);
		contentPane.add(lblNumerTelefonu);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(146, 296, 86, 20);
		contentPane.add(textField_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(146, 118, 86, 20);
		contentPane.add(passwordField);

		JLabel lblMiejscosc = new JLabel("Miejscowość:");
		lblMiejscosc.setBounds(10, 206, 106, 14);
		contentPane.add(lblMiejscosc);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(146, 203, 86, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(388, 203, 26, 20);
		contentPane.add(textField_5);

		JLabel lblKodPocztowy = new JLabel("Kod pocztowy:");
		lblKodPocztowy.setBounds(272, 206, 106, 14);
		contentPane.add(lblKodPocztowy);

		JLabel lblUlica = new JLabel("Ulica:");
		lblUlica.setBounds(10, 237, 106, 14);
		contentPane.add(lblUlica);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(146, 234, 86, 20);
		contentPane.add(textField_6);

		lblNumerDomu = new JLabel("Numer domu:");
		lblNumerDomu.setBounds(272, 237, 106, 14);
		contentPane.add(lblNumerDomu);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(388, 234, 26, 20);
		contentPane.add(textField_7);

		lblNumerLokalu = new JLabel("*Numer lokalu:");
		lblNumerLokalu.setBounds(424, 237, 106, 14);
		contentPane.add(lblNumerLokalu);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(535, 234, 26, 20);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(426, 203, 40, 20);
		contentPane.add(textField_9);

		label = new JLabel("-");
		label.setBounds(416, 203, 4, 14);
		contentPane.add(label);

		btnZarejestruj.setBounds(10, 387, 122, 23);
		contentPane.add(btnZarejestruj);
		btnZarejestruj.addActionListener(this);

		btnWstecz.setBounds(459, 387, 91, 23);
		contentPane.add(btnWstecz);
		btnWstecz.addActionListener(this);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 100, 585, 7);
		contentPane.add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(0, 185, 585, 7);
		contentPane.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setBounds(0, 276, 585, 7);
		contentPane.add(separator_2);

		lblNieObowizkowe = new JLabel("*Pola nie obowiązkowe");
		lblNieObowizkowe.setBounds(10, 352, 170, 14);
		contentPane.add(lblNieObowizkowe);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnWstecz) {
			Login log = new Login();
			log.setVisible(true);
			this.setVisible(false);
		}

		if (e.getSource() == btnZarejestruj) {
			String imie = textField.getText();
			String nazwisko = textField_1.getText();
			char[] hasloz = passwordField.getPassword();
			String haslo = String.valueOf(hasloz);
			char[] haslo2z = passwordField_1.getPassword();
			String haslo2 = String.valueOf(haslo2z);
			String miejscowosc = textField_4.getText();
			String kod = textField_5.getText() + "-" + textField_9.getText();
			String ulica = textField_6.getText();
			String nrdomu = textField_7.getText();
			String nrlokalu = textField_8.getText();
			String nrtelefonu = textField_3.getText();
			String email = textField_2.getText();

			String query = "Select * FROM uzytkownicy WHERE Adres_email='" + email + "'";
			Baza b = new Baza();
			b.sprlogin(query, 11, 4);

			if (email.equals(b.pierwszy))
				JOptionPane.showMessageDialog(null, "Konto już istnieje");

			else {
				if (imie.length() != 0 && nazwisko.length() != 0 && haslo.length() != 0 && haslo2.length() != 0
						&& miejscowosc.length() != 0 && kod.length() != 0 && ulica.length() != 0 && nrdomu.length() != 0
						&& nrtelefonu.length() != 0 && email.length() != 0) {
					if (haslo.equals(haslo2)) {
						if (textField_5.getText().length() == 2 && textField_5.getText().matches("^[0-9]+$")
								&& textField_9.getText().length() == 3 && textField_9.getText().matches("^[0-9]+$")) {
							if (nrtelefonu.matches("^[0-9]+$")) {
								String query2 = "SELECT * FROM uzytkownicy WHERE ID_Uzytkownika IN(SELECT MAX(ID_Uzytkownika) FROM uzytkownicy)";
								b.sprid(query2, 1);
								b.rejestracja(b.trzeci + 1, imie, nazwisko, haslo, miejscowosc, kod, ulica, nrdomu,
										nrlokalu, nrtelefonu, email);
								JOptionPane.showMessageDialog(null, "Zarejestrowano pomyślnie");
								Login log = new Login();
								log.setVisible(true);
								this.setVisible(false);
							} else
								JOptionPane.showMessageDialog(null, "Numer telefonu składa się tylko z cyfr");
						} else
							JOptionPane.showMessageDialog(null, "Proszę poprawić format kodu pocztowego");
					} else
						JOptionPane.showMessageDialog(null, "Hasła nie są identyczne");
				} else
					JOptionPane.showMessageDialog(null, "Proszę wprowadzić wszystkie pola obowiązkowe");
			}
		}
	}
}
