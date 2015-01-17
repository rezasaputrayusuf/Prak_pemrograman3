package belajar.complex.component;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.util.List;
import java.util.List;
import java.util.ArrayList;

public class DemoCombo{
	private static JComboBox cmbMahasiswa = new JComboBox();
	private static final List<String> daftarMahasiswa = new ArrayList<String>();


	public static void isiCombo(){
		//data dimasukkan ke dalam class model
		DefaultComboBoxModel model = new DefaultComboBoxModel(daftarMahasiswa.toArray());

		//pasang model di combo
		cmbMahasiswa.setModel(model);
	}

	public static void tambahIsiCombo(String data){
		//data untuk ditampilkan dalam combo
		daftarMahasiswa.add(data);
		isiCombo();
	}

	public static void main(String[] xx) {
		tambahIsiCombo("Rita");;

		JLabel lbl = new JLabel("Nama Mahasiswa : ");
		final JTextField tfMahasiswa = new JTextField(20);
		JButton btnTambah = new JButton("Tambah");

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(lbl);
		panel.add(tfMahasiswa);
		panel.add(btnTambah);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		panel2.add(cmbMahasiswa);

		JPanel panel4 = new JPanel(new FlowLayout());
		panel4.add(new JLabel("Pilihan : "));
		final JTextField tfPilihan = new JTextField(20);
		tfPilihan.setEditable(false);
		panel4.add(tfPilihan);

		JPanel1 panel3 = new JPanel1();
		panel3.setLayout(new GridLayout(3,1));

		panel3.add(panel);
		panel3.add(pane2);
		panel3.add(pane4);

		//mengistankan frame
		JFrame fr = new JFrame("Belajar combo");

		fr.getContentPane().add(panel3);
		//ukuran frame
		fr.getSize(800,200);

		//posisi ditengah
		fr.setLocationRelativeTo(null);

		//tampilkan
		fr.setVisible(true);

		//event handler untuk button
		class TambahMahasiswaListener implements ActionListener{
			public void actitionPerfomed(ActionEvent e){
				String data = tfMahasiswa.getText();
				System.out.println("Isi textField :"+data);

				//tambahKAN ISINYA KEDALAM COMBO
				tambahIsiCombo(data);

				//kosongkan textfield
				tfMahasiswa.setText();
				tfMahasiswa.requestFocus();
			}
		}


		//pasang event handler di button dan textfield
		TambahMahasiswaListener l = new TambahMahasiswaListener();
		btnTambah.addActionListener(l);
		tfMahasiswa.addActionListener(l);

		//event handler untuk combo
		class PilihanComboListener implements ActionListener{
			public void actitionPerfomed(ActionEvent e){
				JComboBox cd = new (JComboBox) e.getSource();
				String Pilihan = (String) cb.getSelectedtem();
				tfPilihan.setText(Pilihan);
			}
		}

		//pasang listener di combo
		cmbMahasiswa.addActionListener(new PilihanComboListener());
	}
}

