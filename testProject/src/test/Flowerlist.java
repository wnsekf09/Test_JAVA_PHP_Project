package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Flowerlist extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfco;
	private JTextField tfca;
	private JTextField tfpr;
	private JTextField tfop;
	private JTextField tfun;
	private JTextField tfwe;
	private JTextField tfsh;
	private JTextField tfwc;
	private JTextField tfsc;
	private JTextField tfsear;
	private JButton btsear;
	private JButton btin;
	private JButton btde;
	private JButton btup;
	
	private FlowerDTO dto;
	private Vector<String> col;
	private DefaultTableModel model;
	private FlowerDAO dao;
	private JTextField tfdel;
	private int stock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flowerlist frame = new Flowerlist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Flowerlist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 197, 775, 358);
		contentPane.add(scrollPane);
		
		dao = new FlowerDAO();
		col = new Vector<String>();
		col.add("제품코드");
		col.add("카테고리");
		col.add("제품명");
		col.add("옵션");
		col.add("단위");
		col.add("입고단가");
		col.add("출고단가");
		col.add("입고계");
		col.add("출고계");
		col.add("재고");
		col.add("삭제코드");
		list();
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                FlowerDTO dto= new FlowerDTO();
				int idx = table.getSelectedRow();
				tfco.setEditable(false);
				tfco.setText(table.getValueAt(idx, 0)+"");
				tfca.setText(table.getValueAt(idx, 1)+"");
				tfpr.setText(table.getValueAt(idx, 2)+"");
				tfop.setText(table.getValueAt(idx, 3)+"");
				tfun.setText(table.getValueAt(idx, 4)+"");
				tfwe.setText(table.getValueAt(idx, 5)+"");
				tfsh.setText(table.getValueAt(idx, 6)+"");
				tfwc.setText(table.getValueAt(idx, 7)+"");
				tfsc.setText(table.getValueAt(idx, 8)+"");
				tfdel.setText(table.getValueAt(idx, 10)+"");
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblE = new JLabel("제품코드");
		lblE.setBounds(51, 62, 57, 15);
		contentPane.add(lblE);
		
		JLabel label = new JLabel("카테고리");
		label.setBounds(120, 62, 57, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("제품명");
		lblNewLabel.setBounds(198, 61, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("옵션");
		label_1.setBounds(276, 62, 57, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("단위");
		label_2.setBounds(345, 62, 57, 15);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("입고단가");
		lblNewLabel_1.setBounds(403, 62, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("출고단가");
		lblNewLabel_2.setBounds(472, 62, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("입고계");
		lblNewLabel_3.setBounds(541, 62, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("출고계");
		lblNewLabel_4.setBounds(610, 61, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		tfco = new JTextField();
		tfco.setBounds(51, 87, 57, 21);
		contentPane.add(tfco);
		tfco.setColumns(10);
		
		tfca = new JTextField();
		tfca.setColumns(10);
		tfca.setBounds(120, 87, 57, 21);
		contentPane.add(tfca);
		
		tfpr = new JTextField();
		tfpr.setColumns(10);
		tfpr.setBounds(189, 87, 57, 21);
		contentPane.add(tfpr);
		
		tfop = new JTextField();
		tfop.setColumns(10);
		tfop.setBounds(258, 87, 57, 21);
		contentPane.add(tfop);
		
		tfun = new JTextField();
		tfun.setColumns(10);
		tfun.setBounds(327, 87, 57, 21);
		contentPane.add(tfun);
		
		tfwe = new JTextField();
		tfwe.setColumns(10);
		tfwe.setBounds(396, 87, 57, 21);
		contentPane.add(tfwe);
		
		tfsh = new JTextField();
		tfsh.setColumns(10);
		tfsh.setBounds(465, 87, 57, 21);
		contentPane.add(tfsh);
		
		tfwc = new JTextField();
		tfwc.setColumns(10);
		tfwc.setBounds(534, 87, 57, 21);
		contentPane.add(tfwc);
		
		tfsc = new JTextField();
		tfsc.setColumns(10);
		tfsc.setBounds(603, 87, 57, 21);
		contentPane.add(tfsc);
		
		btsear = new JButton("찾기");
		btsear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btsear.setBounds(247, 141, 97, 23);
		contentPane.add(btsear);
		
		tfsear = new JTextField();
		tfsear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				search();
			}
		});
		tfsear.setBounds(103, 142, 116, 21);
		contentPane.add(tfsear);
		tfsear.setColumns(10);
		
		btin = new JButton("추가");
		btin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.insertFlower(dto);
				if(result==1) {
					JOptionPane.showMessageDialog(Flowerlist.this, "저장되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btin.setBounds(382, 141, 71, 23);
		contentPane.add(btin);
		
		btde = new JButton("삭제");
		btde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String del = tfdel.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(Flowerlist.this, "삭제되었습니다.");
				if(response==JOptionPane.YES_NO_OPTION) {
					result= dao.deletFlower(del);
				}
				if(result==1) {
					JOptionPane.showMessageDialog(Flowerlist.this, "삭제되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
					
				
			}
		});
		btde.setBounds(489, 141, 71, 23);
		contentPane.add(btde);
		
		btup = new JButton("수정");
		btup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.updateFlower(dto);
				if(result==1) {
					JOptionPane.showMessageDialog(Flowerlist.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btup.setBounds(603, 141, 71, 23);
		contentPane.add(btup);
		
		JLabel lblNewLabel_6 = new JLabel("Folwer_Shop");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("HY견고딕", Font.BOLD, 25));
		lblNewLabel_6.setBounds(287, 10, 213, 42);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("삭제코드");
		lblNewLabel_5.setBounds(689, 62, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		tfdel = new JTextField();
		tfdel.setColumns(10);
		tfdel.setBounds(685, 86, 57, 21);
		contentPane.add(tfdel);
	}
	public void search() {
		String category = tfsear.getText();
		model = new DefaultTableModel(dao.searchFlower(category),col) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}
	
	public void input() {
		int cod = Integer.parseInt(tfco.getText());
		String category = tfca.getText();
		String product = tfpr.getText();
		String ops = tfop.getText();
		String unit = tfun.getText();
		int wearing = Integer.parseInt(tfwe.getText());
		int shipping = Integer.parseInt(tfsh.getText());
		int wcount = Integer.parseInt(tfwc.getText());
		int scount = Integer.parseInt(tfsc.getText());
		int stock = 0;
		String del = tfdel.getText();
		dto = new FlowerDTO(cod, category, product, ops, unit, wearing, shipping, wcount, scount, stock, del);
				
	}
	
	public void clear() {
		tfco.setText("");
		tfca.setText("");
		tfpr.setText("");
		tfop.setText("");
		tfun.setText("");
		tfwe.setText("");
		tfsh.setText("");
		tfwc.setText("");
		tfsc.setText("");
		tfdel.setText("");
		tfco.requestFocus();
		tfco.setEditable(true);
		
	}
	
	public void list() {
		model = new DefaultTableModel(dao.listFlower(),col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}
}
