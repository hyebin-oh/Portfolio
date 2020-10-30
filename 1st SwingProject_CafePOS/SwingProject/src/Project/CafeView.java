package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Friend;
import com.model.FriendDAOImpl;

import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class CafeView extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelPos;
	private JPanel panelToday;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JButton btnDrink1;
	private JButton btnFood1;
	private JButton btnDrink2;
	private JButton btnDrink3;
	private JButton btnDrink4;
	private JButton btnDrink5;
	private JButton btnDrink6;
	private JButton btnDrink7;
	private JButton btnDrink8;
	private JButton btnDrink9;
	private JButton btnDrink10;
	private JButton btnDrink11;
	private JButton btnDrink12;
	private JButton btnDrink13;
	private JButton btnDrink14;
	private JButton btnDrink15;
	private JButton btnFood2;
	private JButton btnFood3;
	private JRadioButton rdbtnHot;
	private JRadioButton rdbtnIce;
	private JButton btnCancel;
	private JButton btnCancelAll;
	private JButton btnCard_1;
	private JButton btnCash_1;
	private JTextField tfPrice;
	private JTable table;
	private JTable tableOrderList;
	private JTable table_1;
	
	
	ButtonGroup group = new ButtonGroup();
	String str="";

	ArrayList<Cafe> ca = new ArrayList<Cafe>();
	CafeDAOImpl dao = new CafeDAOImpl();
	
	DefaultTableModel dt = new DefaultTableModel();
	
	JButton[] arr  = new JButton[15];
	String[] drink = {"에스프레소","아메리카노", "카푸치노", "카페라떼", "바닐라라떼", "그린티라떼", "카페모카", 
			 "프라푸치노", "요거트스무디", "딸기스무디","망고스무디","청포도에이드", "레몬에이드", "자몽에이드","계절빙수"};
	int[] drinkPrice= {1500,1500,2000,2000,2500,3000,2500,4000,3500,3500,3500,3500,3500,3500,7000};
	
	JButton[] arr2  = new JButton[3];
	String[] food = {"케이크","쿠키","스콘"};
	int[] foodPrice = {5000,1500,2000};
	
	int sum;  //총가격
	private JLabel label_1;
	private JLabel label_2;
	private JScrollPane scrollPane;
	private JTable table_2;
	private JButton btnNewButton;
	private JScrollPane scrollPane_1;
	private JTable table_3;
	private JLabel label_2_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeView frame = new CafeView();
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
	public CafeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTabbedPane());
		
		int i=0;
		for( i=0; i<arr.length;i++) {
			String d = drink[i];
			int dp =  drinkPrice[i];
			
			arr[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					if(rdbtnHot.isSelected()) {
						str = rdbtnHot.getText();
					}else if(rdbtnIce.isSelected()) {
						str = rdbtnIce.getText();
					}
					
					dt.addRow(new Object[] {str, d, dp});
							
					sum += dp ;	
    				tfPrice.setText("총 결제 금액 :  " + sum );
				}	
			});
		}
		
		int j=0;
		for( j=0; j<arr2.length;j++) {
			String f = food[j];
			int fp =  foodPrice[j];
			
			arr2[j].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					
					dt.addRow(new Object[] {"", f, fp});
							
					sum += fp ;	
    				tfPrice.setText("총 결제 금액 :  " + sum );
				}	
			});
		}
		
	}
	
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(30, 10, 689, 579);
			tabbedPane.addTab("POS", null, getPanelPos(), null);
			tabbedPane.addTab("당일 매출", null, getPanelToday(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanelPos() {
		if (panelPos == null) {
			panelPos = new JPanel();
			panelPos.setLayout(null);
			panelPos.add(getLblNewLabel());
			panelPos.add(getBtnDrink6());
			panelPos.add(getBtnDrink14());
			panelPos.add(getBtnDrink9());
			panelPos.add(getBtnDrink10());
			panelPos.add(getBtnDrink13());
			panelPos.add(getBtnDrink12());
			panelPos.add(getLblNewLabel_2());
			
			panelPos.add(getRdbtnHot());
			panelPos.add(getRdbtnIce());
			
			panelPos.add(getBtnDrink15());
			panelPos.add(getBtnDrink11());
			panelPos.add(getBtnDrink1());
			panelPos.add(getBtnDrink2());
			panelPos.add(getBtnDrink3());
			panelPos.add(getBtnDrink5());
			panelPos.add(getBtnCancel());
			panelPos.add(getBtnCancelAll());
			panelPos.add(getBtnCard_1());
			panelPos.add(getBtnCash_1());
			panelPos.add(getBtnDrink7());
			panelPos.add(getBtnDrink4());
			panelPos.add(getBtnDrink8());
			panelPos.add(getBtnNewButton_1_1_16());
			panelPos.add(getBtnNewButton_1_2_1());
			panelPos.add(getLblNewLabel_1());
			panelPos.add(getBtnNewButton_1_2());
			
			
			tfPrice = new JTextField();
			tfPrice.setBounds(386, 369, 266, 69);
			panelPos.add(tfPrice);
			tfPrice.setColumns(10);
			panelPos.add(getLabel());

			panelPos.add(getTable_1());
			panelPos.add(getLabel_1());
			
		}
		return panelPos;
	}
	private JPanel getPanelToday() {
		if (panelToday == null) {
			panelToday = new JPanel();
			panelToday.setLayout(null);
			panelToday.add(getLabel_2_2());
			panelToday.add(getScrollPane());
			panelToday.add(getBtnNewButton());
			panelToday.add(getScrollPane_1());
			panelToday.add(getLabel_2_1());
			panelToday.add(getBtnNewButton_1());
			panelToday.add(getBtnNewButton_1_1());
		}
		return panelToday;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("음료");
			lblNewLabel.setBounds(12, 10, 24, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("디저트");
			lblNewLabel_1.setBounds(12, 359, 64, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Hot/Ice");
			lblNewLabel_2.setBounds(23, 319, 41, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("주문내역");
			label.setBounds(386, 10, 48, 15);
		}
		return label;
	}
	private JButton getBtnDrink1() {
		if (btnDrink1 == null) {
			btnDrink1 = new JButton("에스프레소");
			btnDrink1.setBounds(12, 40, 88, 45);
			btnDrink1.setFont(btnDrink1.getFont().deriveFont(btnDrink1.getFont().getSize() - 1f));
			arr[0]= btnDrink1;
		}
		return btnDrink1;
	}
	private JButton getBtnNewButton_1_2() {
		if (btnFood1 == null) {
			btnFood1 = new JButton("쿠키");
			arr2[1]= btnFood1;
			btnFood1.setBounds(216, 388, 88, 50);
		}
		return btnFood1;
	}
	private JButton getBtnDrink2() {
		if (btnDrink2 == null) {
			btnDrink2 = new JButton("아메리카노");
			arr[1] = btnDrink2;
			btnDrink2.setBounds(118, 40, 88, 45);
			btnDrink2.setFont(btnDrink2.getFont().deriveFont(btnDrink2.getFont().getSize() - 1f));
		}
		return btnDrink2;
	}
	private JButton getBtnDrink3() {
		if (btnDrink3 == null) {
			btnDrink3 = new JButton("카페라떼");
			arr[3] = btnDrink3;
			btnDrink3.setBounds(12, 95, 88, 45);
			btnDrink3.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink3;
	}
	private JButton getBtnDrink4() {
		if (btnDrink4 == null) {
			btnDrink4 = new JButton("카푸치노");
			arr[2] = btnDrink4;
			btnDrink4.setBounds(216, 42, 88, 45);
			btnDrink4.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink4;
	}
	private JButton getBtnDrink5() {
		if (btnDrink5 == null) {
			btnDrink5 = new JButton("바닐라라떼");
			arr[4] = btnDrink5;
			btnDrink5.setBounds(118, 96, 88, 45);
			btnDrink5.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink5;
	}
	private JButton getBtnDrink6() {
		if (btnDrink6 == null) {
			btnDrink6 = new JButton("카페모카");
			arr[6] = btnDrink6;
			btnDrink6.setBounds(12, 152, 88, 45);
			btnDrink6.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink6;
	}
	private JButton getBtnDrink7() {
		if (btnDrink7 == null) {
			btnDrink7 = new JButton("그린티라떼");
			arr[5] = btnDrink7;
			btnDrink7.setBounds(216, 97, 88, 45);
			btnDrink7.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink7;
	}
	private JButton getBtnDrink8() {
		if (btnDrink8 == null) {
			btnDrink8 = new JButton("딸기스무디");
			arr[9] = btnDrink8;
			btnDrink8.setBounds(12, 209, 88, 45);
			btnDrink8.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink8;
	}
	private JButton getBtnDrink9() {
		if (btnDrink9 == null) {
			btnDrink9 = new JButton("망고스무디");
			arr[10] = btnDrink9;
			btnDrink9.setBounds(118, 209, 88, 45);
			btnDrink9.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink9;
	}
	private JButton getBtnDrink10() {
		if (btnDrink10 == null) {
			btnDrink10 = new JButton("요거트스무디");
			arr[8] = btnDrink10;
			btnDrink10.setBounds(216, 152, 88, 45);
			btnDrink10.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink10;
	}
	private JButton getBtnDrink11() {
		if (btnDrink11 == null) {
			btnDrink11 = new JButton("레몬에이드");
			arr[12] = btnDrink11;
			btnDrink11.setBounds(12, 265, 88, 45);
			btnDrink11.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink11;
	}
	private JButton getBtnDrink12() {
		if (btnDrink12 == null) {
			btnDrink12 = new JButton("청포도에이드");
			arr[11] = btnDrink12;
			btnDrink12.setBounds(216, 209, 88, 45);
			btnDrink12.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink12;
	}
	private JButton getBtnDrink13() {
		if (btnDrink13 == null) {
			btnDrink13 = new JButton("자몽에이드");
			arr[13] = btnDrink13;
			btnDrink13.setBounds(118, 264, 88, 45);
			btnDrink13.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink13;
	}
	private JButton getBtnDrink14() {
		if (btnDrink14 == null) {
			btnDrink14 = new JButton("프라푸치노");
			arr[7] = btnDrink14;
			btnDrink14.setBounds(118, 152, 88, 45);
			btnDrink14.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink14;
	}
	private JButton getBtnDrink15() {
		if (btnDrink15 == null) {
			btnDrink15 = new JButton("계절빙수");
			arr[14] = btnDrink15;
			btnDrink15.setBounds(216, 264, 88, 45);
			btnDrink15.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnDrink15;
	}
	private JButton getBtnNewButton_1_1_16() {
		if (btnFood2 == null) {
			btnFood2 = new JButton("스콘");
			arr2[2] = btnFood2;
			btnFood2.setBounds(112, 388, 88, 50);
		}
		return btnFood2;
	}
	private JButton getBtnNewButton_1_2_1() {
		if (btnFood3 == null) {
			btnFood3 = new JButton("딸기케이크");
			arr2[0] = btnFood3;
			btnFood3.setBounds(12, 389, 88, 50);
			btnFood3.setFont(new Font("굴림", Font.PLAIN, 11));
		}
		return btnFood3;
	}
	private JRadioButton getRdbtnHot() {
		if (rdbtnHot == null) {
			rdbtnHot = new JRadioButton("Hot");
//			
			group.add(rdbtnHot);
			rdbtnHot.setBounds(70, 315, 43, 23);
		}
		return rdbtnHot;
	}
	private JRadioButton getRdbtnIce() {
		if (rdbtnIce == null) {
			rdbtnIce = new JRadioButton("Ice");
			rdbtnIce.setSelected(true);
			group.add(rdbtnIce);
			rdbtnIce.setBounds(120, 315, 43, 23);
		}
		return rdbtnIce;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("선택취소");
			btnCancel.setActionCommand("\uC120\uD0DD\uCDE8\uC18C");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table_1.getSelectedRow();
					if(row == -1) return;
					dt = (DefaultTableModel) table_1.getModel();					
					dt.removeRow(row);	
					int p =  (int) table_1.getValueAt(row-1, 2);
					sum = sum -p;
					tfPrice.setText("결제하실 금액은 " + sum +"입니다.");
				}	
				
					
				
			});
			btnCancel.setBounds(276, 463, 90, 84);
		}
		return btnCancel;
	}
	private JButton getBtnCancelAll() {
		if (btnCancelAll == null) {
			btnCancelAll = new JButton("전체취소");
			btnCancelAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dt = (DefaultTableModel) table_1.getModel();
					
					dt.setRowCount(1);
					
					tfPrice.setText(String.valueOf(""));
					
				}
			});
			btnCancelAll.setActionCommand("\uC804\uCCB4\uCDE8\uC18C");
			btnCancelAll.setBounds(378, 463, 90, 84);
		}
		return btnCancelAll;
	}
	private JButton getBtnCard_1() {
		if (btnCard_1 == null) {
			btnCard_1 = new JButton("\uCE74\uB4DC\uACB0\uC81C");
						
			
			btnCard_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cafe f = new Cafe();			
					int rows = table_1.getRowCount();
						for(int j=1 ; j<rows ; j++) {
							
							Date date = new Date();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
							
							String temList = table_1.getValueAt(j, 0).toString();
							String menuList = table_1.getValueAt(j, 1).toString();
							int priceList = (int) table_1.getValueAt(j, 2);
							
							f.setTime(df.format(date));
							f.setMenu(menuList);
							f.setTemperture(temList);
							f.setPrice(priceList);
							f.setPay("카드");	
							dao.OrderCard(f);
						}
						dt = (DefaultTableModel) table_1.getModel();
						dt.setRowCount(1);
						tfPrice.setText(String.valueOf(""));	

				}
			});
			
			btnCard_1.setBounds(480, 463, 90, 84);
		}
		return btnCard_1;
	}
	private JButton getBtnCash_1() {
		if (btnCash_1 == null) {
			btnCash_1 = new JButton("\uD604\uAE08\uACB0\uC81C");
			btnCash_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Cafe f = new Cafe();			
					int rows = table_1.getRowCount();
						for(int j=1 ; j<rows ; j++) {
							
							
							Date date = Calendar.getInstance().getTime();
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
							
							String temList = table_1.getValueAt(j, 0).toString();
							String menuList = table_1.getValueAt(j, 1).toString();
							int priceList = (int) table_1.getValueAt(j, 2);
							
							f.setTime(df.format(date));
							f.setMenu(menuList);
							f.setTemperture(temList);
							f.setPrice(priceList);
							f.setPay("현금");	
							dao.OrderCard(f);
						}
						dt = (DefaultTableModel) table_1.getModel();
						dt.setRowCount(1);
						tfPrice.setText(String.valueOf(""));											
				}
			});
			
			
			btnCash_1.setBounds(582, 463, 90, 84);
			
			
		}
		return btnCash_1;
	}

	
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.setBounds(386, 35, 266, 290);
			
			String[] cols = { "Hot/Ice", "메뉴", "가격"};
			dt = new DefaultTableModel(cols, 1);
		
			dt.setValueAt(cols[0], 0,0);
			dt.setValueAt(cols[1], 0,1);
			dt.setValueAt(cols[2], 0,2);	
					
			table_1.setModel(dt);

		}
		return table_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("가격");
			label_1.setBounds(386, 344, 48, 15);
		}
		return label_1;
	}
	private JLabel getLabel_2_2() {
		if (label_2 == null) {
			label_2 = new JLabel("오늘 판매리스트");
			label_2.setBounds(12, 10, 137, 15);
		}
		return label_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 35, 637, 240);
			scrollPane.setViewportView(getTable_2());
		}
		return scrollPane;
	}
	private JTable getTable_2() {
		if (table_2 == null) {
			table_2 = new JTable();
//			ArrayList<Cafe> ca = new ArrayList<Cafe>();
//			String[] cols = { "No", "주문시간", "메뉴", "Hot/Ice", "가격", "결제수단"};
//			
//			dt = new DefaultTableModel(cols, 1);		
//			table_2.setModel(dt);
//
		}
		return table_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("오늘 판매량 조회");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ca = dao.SellList();
					String[] cols = { "No", "주문시간", "메뉴", "Hot/Ice", "가격", "결제수단"};
					DefaultTableModel dt = new DefaultTableModel(cols, ca.size());
					
					for(int i = 0 ; i <ca.size() ; i++) {	
						
						dt.setValueAt(i+1, i,0);
						dt.setValueAt(ca.get(i).getTime(), i,1);
						dt.setValueAt(ca.get(i).getMenu(), i,2);
						dt.setValueAt(ca.get(i).getTemperture(), i,3);
						dt.setValueAt(ca.get(i).getPrice(), i,4);
						dt.setValueAt(ca.get(i).getPay(), i,5);	
						
					table_2.setModel(dt);
						
					}
				}
			});
			btnNewButton.setBounds(36, 478, 148, 62);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(12, 304, 637, 164);
			scrollPane_1.setViewportView(getTable_3());
		}
		return scrollPane_1;
	}
	private JTable getTable_3() {
		if (table_3 == null) {
			table_3 = new JTable();
		}
		return table_3;
	}
	private JLabel getLabel_2_1() {
		if (label_2_1 == null) {
			label_2_1 = new JLabel("제품별 판매량");
			label_2_1.setBounds(12, 285, 137, 15);
		}
		return label_2_1;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("제품별 판매량 조회");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ca = dao.SellMenu();
					String[] cols = { "메뉴", "주문수", "Hot/Ice", "합계", "결제수단"};
					DefaultTableModel dt = new DefaultTableModel(cols, ca.size());
				
					
					for(int i = 0 ; i <ca.size() ; i++) {						
						dt.setValueAt(ca.get(i).getMenu(), i,0);
						dt.setValueAt(ca.get(i).getCountMenu(), i,1);
						dt.setValueAt(ca.get(i).getTemperture(), i,2);
						dt.setValueAt(ca.get(i).getSumPrice(), i,3);
						dt.setValueAt(ca.get(i).getPay(), i,4);	
						
					table_3.setModel(dt);
					}
				}
			});
			btnNewButton_1.setBounds(257, 478, 169, 62);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("마감");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				int end = JOptionPane.showConfirmDialog(null, "마감하시겠습니까?","POS 종료", JOptionPane.YES_NO_OPTION);
				if(end == JOptionPane.YES_OPTION ) {
					System.exit(0);
				}else {
					return ;
				}
						
				}
			});
			btnNewButton_1_1.setBounds(495, 478, 154, 59);
		}
		return btnNewButton_1_1;
	}
}
