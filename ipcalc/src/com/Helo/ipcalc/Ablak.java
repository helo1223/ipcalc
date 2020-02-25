package com.Helo.ipcalc;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;

public class Ablak {

	private JFrame frame;
	private JTextField ip1;
	private JTextField ip2;
	private JTextField ip3;
	private JTextField ip4;
	private JTextField netmask;
	private boolean ipv6 = false;
	private JLabel lblIp_1;
	private JLabel lblAlhlzatiCm;
	private JLabel lblElsKioszthatCm;
	private JLabel lblUtolsKioszthatCm;
	private JLabel lblSzrsiCm;
	private JLabel maszklabel;
	private JLabel alhlabel;
	private JLabel elsolabel;
	private JLabel utolsolabel;
	private JLabel broadcastlabel;
	private JLabel lblHiba;
	private JLabel alhip;
	private JLabel elsoip;
	private JLabel utolsoip;
	private JLabel broadcastip;
	private JCheckBox chckbxDOsztly;
	private JCheckBox chckbxEOsztly;
	private JLabel maszkip;
	private Image icon;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ablak window = new Ablak();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ablak() {
		initialize();
	}

	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		URL iconU = Ablak.class.getResource("/resource/icon.png");
		ImageIcon iconI = new ImageIcon(iconU);
		icon = iconI.getImage();

		frame = new JFrame();
		frame.setTitle("IP hálózat számító");
		frame.setIconImage(icon);
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 650, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		ip1 = new JTextField();
		ip1.setDocument(new JTextFieldLimit(3));
		ip1.setBounds(60, 42, 50, 20);
		frame.getContentPane().add(ip1);
		ip1.setColumns(10);

		JLabel lblip = new JLabel("IP");
		lblip.setBounds(24, 45, 46, 14);
		frame.getContentPane().add(lblip);

		JLabel label = new JLabel("/");
		label.setBounds(300, 45, 46, 14);
		frame.getContentPane().add(label);

		ip2 = new JTextField();
		ip2.setDocument(new JTextFieldLimit(3));
		ip2.setColumns(10);
		ip2.setBounds(120, 42, 50, 20);
		frame.getContentPane().add(ip2);

		ip3 = new JTextField();
		ip3.setDocument(new JTextFieldLimit(3));
		ip3.setColumns(10);
		ip3.setBounds(180, 42, 50, 20);
		frame.getContentPane().add(ip3);

		ip4 = new JTextField();
		ip4.setDocument(new JTextFieldLimit(3));
		ip4.setColumns(10);
		ip4.setBounds(240, 42, 50, 20);
		frame.getContentPane().add(ip4);

		netmask = new JTextField();
		netmask.setDocument(new JTextFieldLimit(2));
		netmask.setColumns(10);
		netmask.setBounds(315, 42, 50, 20);
		frame.getContentPane().add(netmask);
		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton rdbtnIpv = new JRadioButton("IPv4");
		rdbtnIpv.setVisible(false);
		rdbtnIpv.setBounds(6, 7, 64, 23);
		frame.getContentPane().add(rdbtnIpv);
		rdbtnIpv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("ipv4");
				ipv6 = false;
				System.out.println(ipv6);
			}
		});
		rdbtnIpv.setSelected(true);
		buttonGroup.add(rdbtnIpv);

		JRadioButton rdbtnIpv_1 = new JRadioButton("IPv6");
		rdbtnIpv_1.setVisible(false);
		rdbtnIpv_1.setBounds(72, 7, 109, 23);
		frame.getContentPane().add(rdbtnIpv_1);
		rdbtnIpv_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("ipv6");
				ipv6 = true;
				System.out.println(ipv6);
			}
		});
		buttonGroup.add(rdbtnIpv_1);

		JLabel lblMaszk = new JLabel("Maszk");
		lblMaszk.setVisible(false);
		lblMaszk.setBounds(25, 125, 46, 14);
		frame.getContentPane().add(lblMaszk);

		lblIp_1 = new JLabel("IP");
		lblIp_1.setVisible(false);
		lblIp_1.setBounds(25, 100, 46, 14);
		frame.getContentPane().add(lblIp_1);

		lblAlhlzatiCm = new JLabel("Alh\u00E1l\u00F3zati c\u00EDm");
		lblAlhlzatiCm.setVisible(false);
		lblAlhlzatiCm.setBounds(25, 150, 85, 14);
		frame.getContentPane().add(lblAlhlzatiCm);

		lblElsKioszthatCm = new JLabel("Els\u0151 kioszthat\u00F3 c\u00EDm");
		lblElsKioszthatCm.setVisible(false);
		lblElsKioszthatCm.setBounds(25, 175, 118, 14);
		frame.getContentPane().add(lblElsKioszthatCm);

		lblUtolsKioszthatCm = new JLabel("Utols\u00F3 kioszthat\u00F3 c\u00EDm");
		lblUtolsKioszthatCm.setVisible(false);
		lblUtolsKioszthatCm.setBounds(25, 200, 140, 14);
		frame.getContentPane().add(lblUtolsKioszthatCm);

		lblSzrsiCm = new JLabel("Sz\u00F3r\u00E1si c\u00EDm");
		lblSzrsiCm.setVisible(false);
		lblSzrsiCm.setBounds(25, 225, 85, 14);
		frame.getContentPane().add(lblSzrsiCm);

		JCheckBox chckbxAOsztly = new JCheckBox("A Oszt\u00E1ly");
		chckbxAOsztly.setEnabled(false);
		chckbxAOsztly.setOpaque(false);
		chckbxAOsztly.setBounds(500, 10, 97, 23);
		frame.getContentPane().add(chckbxAOsztly);

		JCheckBox chckbxBOsztly = new JCheckBox("B Oszt\u00E1ly");
		chckbxBOsztly.setEnabled(false);
		chckbxBOsztly.setBounds(500, 30, 97, 23);
		chckbxBOsztly.setOpaque(false);

		frame.getContentPane().add(chckbxBOsztly);

		JCheckBox chckbxCOsztly = new JCheckBox("C Oszt\u00E1ly");
		chckbxCOsztly.setEnabled(false);
		chckbxCOsztly.setBounds(500, 50, 97, 23);
		frame.getContentPane().add(chckbxCOsztly);

		JButton szamolbutton = new JButton("Sz\u00E1mol");

		szamolbutton.setBounds(375, 40, 80, 25);
		frame.getContentPane().add(szamolbutton);

		JLabel iplabel = new JLabel("00000000.00000000.00000000.00000000");
		iplabel.setVisible(false);
		iplabel.setBounds(200, 100, 250, 14);
		frame.getContentPane().add(iplabel);

		maszklabel = new JLabel("00000000.00000000.00000000.00000000");
		maszklabel.setVisible(false);
		maszklabel.setBounds(200, 125, 250, 14);
		frame.getContentPane().add(maszklabel);

		alhlabel = new JLabel("00000000.00000000.00000000.00000000");
		alhlabel.setVisible(false);
		alhlabel.setBounds(200, 150, 250, 14);
		frame.getContentPane().add(alhlabel);

		elsolabel = new JLabel("00000000.00000000.00000000.00000000");
		elsolabel.setVisible(false);
		elsolabel.setBounds(200, 175, 250, 14);
		frame.getContentPane().add(elsolabel);

		utolsolabel = new JLabel("00000000.00000000.00000000.00000000");
		utolsolabel.setVisible(false);
		utolsolabel.setBounds(200, 200, 250, 14);
		frame.getContentPane().add(utolsolabel);

		broadcastlabel = new JLabel("00000000.00000000.00000000.00000000");
		broadcastlabel.setVisible(false);
		broadcastlabel.setBounds(200, 225, 250, 14);
		frame.getContentPane().add(broadcastlabel);

		lblHiba = new JLabel("HIBA");
		lblHiba.setVisible(false);
		lblHiba.setForeground(Color.RED);
		lblHiba.setBounds(24, 286, 266, 14);
		frame.getContentPane().add(lblHiba);

		alhip = new JLabel("0.0.0.0");
		alhip.setVisible(false);
		alhip.setBounds(460, 150, 118, 14);
		frame.getContentPane().add(alhip);

		elsoip = new JLabel("0.0.0.0");
		elsoip.setVisible(false);
		elsoip.setBounds(460, 175, 118, 14);
		frame.getContentPane().add(elsoip);

		utolsoip = new JLabel("0.0.0.0");
		utolsoip.setVisible(false);
		utolsoip.setBounds(460, 200, 118, 14);
		frame.getContentPane().add(utolsoip);

		broadcastip = new JLabel("0.0.0.0");
		broadcastip.setVisible(false);
		broadcastip.setBounds(460, 225, 118, 14);
		frame.getContentPane().add(broadcastip);

		chckbxDOsztly = new JCheckBox("D Oszt\u00E1ly");
		chckbxDOsztly.setEnabled(false);
		chckbxDOsztly.setBounds(500, 70, 97, 23);
		frame.getContentPane().add(chckbxDOsztly);

		chckbxEOsztly = new JCheckBox("E Oszt\u00E1ly");
		chckbxEOsztly.setEnabled(false);
		chckbxEOsztly.setBounds(500, 90, 97, 23);
		frame.getContentPane().add(chckbxEOsztly);

		maszkip = new JLabel("0.0.0.0");
		maszkip.setVisible(false);
		maszkip.setBounds(460, 125, 118, 14);
		frame.getContentPane().add(maszkip);

		szamolbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (!ip1.getText().isEmpty() && !ip2.getText().isEmpty() && !ip3.getText().isEmpty()
						&& !ip4.getText().isEmpty() && !netmask.getText().isEmpty()) {
					if (Integer.valueOf(ip1.getText()) < 255 && Integer.valueOf(ip1.getText()) > 1) {
						if (Integer.valueOf(netmask.getText()) <= 32 && Integer.valueOf(netmask.getText()) >= 1) {
							int maszk1es = Integer.valueOf(netmask.getText());
							String ip1binary = binaryString(Integer.valueOf(ip1.getText()), 8);
							String ip2binary = binaryString(Integer.valueOf(ip2.getText()), 8);
							String ip3binary = binaryString(Integer.valueOf(ip3.getText()), 8);
							String ip4binary = binaryString(Integer.valueOf(ip4.getText()), 8);
							String ip = ip1binary + "." + ip2binary + "." + ip3binary + "." + ip4binary;
							iplabel.setText(ip);
							String maszk = "";

							for (int i = 1; i <= 32; i++) {
								if (maszk1es > 0) {
									maszk = maszk.concat("1");
								} else {
									maszk = maszk.concat("0");
								}
								if (i % 8 == 0 && i != 32) {
									maszk = maszk.concat(".");
								}
								maszk1es--;
							}
							maszklabel.setText(maszk);
							String halozat = "00000000.00000000.00000000.00000000";
							StringBuilder halozatip = new StringBuilder(halozat);

							for (int j = 1; j <= 35; j++) {
								if (ip.charAt(j - 1) == '1' && maszk.charAt(j - 1) == '1') {
									halozatip.setCharAt(j - 1, '1');
								}
							}
							alhlabel.setText(halozatip.toString());
							String[] maszkpart = maszk.split("\\.");
							int[] maszkdarabok = new int[maszkpart.length];
							for (int i = 0; i < maszkpart.length; i++) {
								maszkdarabok[i] = Integer.parseInt(maszkpart[i], 2);
							}

							maszkip.setText(maszkdarabok[0] + "." + maszkdarabok[1] + "." + maszkdarabok[2] + "."
									+ maszkdarabok[3]);
							String[] alhpart = halozatip.toString().split("\\.");
							System.out.println(alhpart.length);
							int[] alhdarabok = new int[alhpart.length];
							for (int i = 0; i < alhpart.length; i++) {
								alhdarabok[i] = Integer.parseInt(alhpart[i], 2);
							}

							alhip.setText(
									alhdarabok[0] + "." + alhdarabok[1] + "." + alhdarabok[2] + "." + alhdarabok[3]);

							String elsocim = halozatip.toString();
							StringBuilder elsocimbuilder = new StringBuilder(elsocim);
							elsocimbuilder.replace(elsocim.length() - 1, elsocim.length(), "1");
							elsocim = elsocimbuilder.toString();

							elsolabel.setText(elsocim);

							String[] elsopart = elsocim.toString().split("\\.");
							int[] elsodarabok = new int[elsopart.length];
							for (int i = 0; i < elsopart.length; i++) {
								elsodarabok[i] = Integer.parseInt(elsopart[i], 2);
							}

							elsoip.setText(elsodarabok[0] + "." + elsodarabok[1] + "." + elsodarabok[2] + "."
									+ elsodarabok[3]);

							String utolsocim = halozatip.toString();
							int lastindex = maszk.lastIndexOf('1') + 1;
							StringBuilder utolsobuilder = new StringBuilder(utolsocim);
							for (int i = lastindex; i < utolsocim.length() - 1; i++) {
								if (utolsocim.charAt(i) != '.') {
									utolsobuilder.replace(i, i + 1, "1");
								}
							}
							utolsocim = utolsobuilder.toString();
							utolsolabel.setText(utolsocim);

							String[] utolsopart = utolsocim.toString().split("\\.");
							int[] utolsodarabok = new int[utolsopart.length];
							for (int i = 0; i < utolsopart.length; i++) {
								utolsodarabok[i] = Integer.parseInt(utolsopart[i], 2);
							}

							utolsoip.setText(utolsodarabok[0] + "." + utolsodarabok[1] + "." + utolsodarabok[2] + "."
									+ utolsodarabok[3]);

							String broadcastcim = utolsocim;
							StringBuilder broadcastbuilder = new StringBuilder(broadcastcim);
							broadcastbuilder.replace(broadcastcim.length() - 1, broadcastcim.length(), "1");
							broadcastcim = broadcastbuilder.toString();
							broadcastlabel.setText(broadcastcim);

							String[] broadcastpart = broadcastcim.toString().split("\\.");
							int[] broadcastdarabok = new int[broadcastpart.length];
							for (int i = 0; i < broadcastpart.length; i++) {
								broadcastdarabok[i] = Integer.parseInt(broadcastpart[i], 2);
							}

							broadcastip.setText(broadcastdarabok[0] + "." + broadcastdarabok[1] + "."
									+ broadcastdarabok[2] + "." + broadcastdarabok[3]);

							lblHiba.setVisible(false);
							iplabel.setVisible(true);
							maszklabel.setVisible(true);
							alhlabel.setVisible(true);
							elsolabel.setVisible(true);
							utolsolabel.setVisible(true);
							broadcastlabel.setVisible(true);
							lblIp_1.setVisible(true);
							lblMaszk.setVisible(true);
							lblAlhlzatiCm.setVisible(true);
							lblElsKioszthatCm.setVisible(true);
							lblUtolsKioszthatCm.setVisible(true);
							lblSzrsiCm.setVisible(true);
							maszkip.setVisible(true);
							alhip.setVisible(true);
							elsoip.setVisible(true);
							utolsoip.setVisible(true);
							broadcastip.setVisible(true);

						}
					}

				}
				if (ip1.getText().isEmpty() || ip2.getText().isEmpty() || ip3.getText().isEmpty()
						|| ip4.getText().isEmpty()) {
					lblHiba.setText("Hiányos IP címet adtál meg!");
					lblHiba.setVisible(true);
				} else if (netmask.getText().isEmpty()) {
					lblHiba.setText("Nem adtál meg hálózati maszkot!");
					lblHiba.setVisible(true);
				} else if (Integer.valueOf(netmask.getText()) > 32 || Integer.valueOf(netmask.getText()) < 1) {
					lblHiba.setText("Érvénytelen hálózati maszkot adtál meg!");
					lblHiba.setVisible(true);
				} else if (Integer.valueOf(ip1.getText()) >= 255 || Integer.valueOf(ip1.getText()) < 1) {
					lblHiba.setText("Érvénytelen IP címet adtál meg!");
					lblHiba.setVisible(true);
				}
				try {
					if (Integer.valueOf(ip1.getText()) < 127 && Integer.valueOf(ip1.getText()) > 1) {
						chckbxAOsztly.setSelected(true);
						chckbxBOsztly.setSelected(false);
						chckbxCOsztly.setSelected(false);
						chckbxDOsztly.setSelected(false);
						chckbxEOsztly.setSelected(false);
					} else if (Integer.valueOf(ip1.getText()) < 192 && Integer.valueOf(ip1.getText()) > 1) {
						chckbxAOsztly.setSelected(false);
						chckbxBOsztly.setSelected(true);
						chckbxCOsztly.setSelected(false);
						chckbxDOsztly.setSelected(false);
						chckbxEOsztly.setSelected(false);
					} else if (Integer.valueOf(ip1.getText()) < 224 && Integer.valueOf(ip1.getText()) > 1) {
						chckbxAOsztly.setSelected(false);
						chckbxBOsztly.setSelected(false);
						chckbxCOsztly.setSelected(true);
						chckbxDOsztly.setSelected(false);
						chckbxEOsztly.setSelected(false);
					} else if (Integer.valueOf(ip1.getText()) < 240 && Integer.valueOf(ip1.getText()) > 1) {
						chckbxAOsztly.setSelected(false);
						chckbxBOsztly.setSelected(false);
						chckbxCOsztly.setSelected(false);
						chckbxDOsztly.setSelected(true);
						chckbxEOsztly.setSelected(false);
					} else if (Integer.valueOf(ip1.getText()) < 255 && Integer.valueOf(ip1.getText()) > 1) {
						chckbxAOsztly.setSelected(false);
						chckbxBOsztly.setSelected(false);
						chckbxCOsztly.setSelected(false);
						chckbxDOsztly.setSelected(false);
						chckbxEOsztly.setSelected(true);
					}
				} catch (Exception ee) {
					System.err.println("Nem adtál meg IP-t. Konzol hiba, nem láttál semmit");
				}
			}
		});

	}

	@SuppressWarnings("serial")
	class JTextFieldLimit extends PlainDocument { // karakter limitálás
		private int limit;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null)
				return;

			if ((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, attr);
			}
		}
	}

	public static String binaryString(final int number, final int binaryDigits) {
		final String pattern = String.format("%%0%dd", binaryDigits);
		final String padding = String.format(pattern, 0);
		final String response = String.format("%s%s", padding, Integer.toBinaryString(number));

		return response.substring(response.length() - binaryDigits);
	}
}
