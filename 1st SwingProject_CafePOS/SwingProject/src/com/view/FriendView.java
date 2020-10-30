package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Friend;
import com.model.FriendDAOImpl;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FriendView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblNewLabel_2;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JButton btnView;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JLabel label_1;
	private JTextField tfNum;
	private JPanel panel_1;
	private JComboBox jcb;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JTable table;
	
	FriendDAOImpl dao = new FriendDAOImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
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
	public FriendView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(250);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLabel());
			panel.add(getLblNewLabel_2());
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getBtnView());
			panel.add(getBtnInsert());
			panel.add(getBtnUpdate());
			panel.add(getBtnDelete());
			panel.add(getLabel_1());
			panel.add(getTfNum());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setBounds(28, 46, 57, 21);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("생일");
			lblNewLabel_1.setBounds(28, 84, 57, 21);
		}
		return lblNewLabel_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("전화번호");
			label.setBounds(28, 133, 57, 21);
		}
		return label;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("주소");
			lblNewLabel_2.setBounds(28, 175, 57, 21);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(92, 46, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(92, 84, 116, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(92, 133, 116, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(92, 175, 116, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}
	
	//전체보기
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("전체보기");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					ArrayList<Friend> arr = dao.friendView();
					for(Friend f : arr) {
						ta.append("번호 : " + f.getNum() +"\n");
						ta.append("이름 : " + f.getName() +"\n");
						ta.append("생일 : " + f.getBirth() +"\n");
						ta.append("전화번호 : " + f.getPhone() +"\n");
						ta.append("주소 : " + f.getAddr() +"\n"); 
						ta.append("\n");
					}
				}
			});
			btnView.setBounds(12, 224, 97, 23);
		}
		return btnView;
	}
	
	//친구등록
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("친구등록");
			
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					dao.friendInsert(f);
					btnView.doClick();

				}
			});
			btnInsert.setBounds(126, 224, 97, 23);
		}
		return btnInsert;
	}
	
	//수정하기
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정하기");
			
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					f.setNum(Integer.parseInt(tfNum.getText()));
					dao.friendUpdate(f);
					
				}
			});
			btnUpdate.setBounds(12, 290, 97, 23);
		}

		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int num = Integer.parseInt(tfNum.getText());
					dao.friendDelete(num);
					btnView.doClick();
					tfName.setText("");;
					
				}
			});
			btnDelete.setBounds(126, 290, 97, 23);
		}
		return btnDelete;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setDividerLocation(250);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}
	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
		}
		return ta;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("번호");
			label_1.setBounds(28, 260, 57, 15);
		}
		return label_1;
	}
	
	// 상세 조회
	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int num = Integer.parseInt(tfNum.getText());
					tfNum.setText(num+"");
					Friend f = dao.friendDetail(num);
					tfNum.setText(num+"");
					tfName.setText(f.getName());
					tfPhone.setText(f.getPhone());
					tfBirth.setText(f.getBirth());
					tfAddr.setText(f.getAddr());
				}
			});
			
			tfNum.setBounds(92, 257, 116, 21);
			tfNum.setColumns(10);
		}
		
		return tfNum;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getJcb());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
			panel_1.add(getTable());
		}
		return panel_1;
	}
	private JComboBox getJcb() {
		if (jcb == null) {
			jcb = new JComboBox();
			jcb.setModel(new DefaultComboBoxModel(new String[] {"선택", "이름", "주소"}));
			jcb.setBounds(12, 35, 62, 21);
		}
		return jcb;
	}
	
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(86, 35, 107, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	
	//검색하기
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					int idx = jcb.getSelectedIndex();
					String key = "";
					
					if(idx==0) {
						JOptionPane.showMessageDialog(null, "분류를 선택하세요");
						return; // 끝
					}else if(idx==1) {
						key = "name";
					}else if(idx==2) {
						key = "addr";
					}
					
					ArrayList<Friend> arr = dao.friendSearch(key, tfSearch.getText());
					for(Friend f : arr) {
						ta.append("번호 : " + f.getNum() + "\n");
						ta.append("이름 : " + f.getName() + "\n");
						ta.append("생일: " + f.getBirth() + "\n");
						ta.append("전화번호 : " + f.getPhone() + "\n");
						ta.append("주소 : " + f.getAddr() + "\n");
					}
					
					
				}
			});
			btnSearch.setBounds(205, 34, 97, 23);
		}
		return btnSearch;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(61, 24, 1, 1);
		}
		return table;
	}
}
