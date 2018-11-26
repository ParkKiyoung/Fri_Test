package friendPac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FriendView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JLayeredPane layeredPane;
	private JTextField tfName;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JButton btnView;
	private JButton btnInsert;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JPanel panel;
	private JComboBox comSet;
	private JTextField tfSearch;
	private JButton btnSearch;

	FriendDBAimp dba = new FriendDBAimp();
	private JTextField tfNum;
	private JButton btnSelect;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblnum;

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
		setBounds(100, 100, 542, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(1);
			splitPane.setLeftComponent(getLayeredPane_1());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(250);
		}
		return splitPane;
	}

	private JLayeredPane getLayeredPane_1() {
		if (layeredPane == null) {
			layeredPane = new JLayeredPane();
			layeredPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
					"\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			layeredPane.setLayout(null);
			layeredPane.add(getTfName());
			layeredPane.add(getLabel());
			layeredPane.add(getLblNewLabel());
			layeredPane.add(getLblNewLabel_1());
			layeredPane.add(getLblNewLabel_2());
			layeredPane.add(getTfBirth());
			layeredPane.add(getTfPhone());
			layeredPane.add(getTfAddr());
			layeredPane.add(getBtnView());
			layeredPane.add(getBtnInsert());
			layeredPane.add(getTfNum());
			layeredPane.add(getBtnSelect());
			layeredPane.add(getBtnUpdate());
			layeredPane.add(getBtnDelete());
			layeredPane.add(getLblnum());
		}
		return layeredPane;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(99, 39, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("이름");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(30, 42, 57, 15);
		}
		return label;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("생일");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(30, 86, 57, 15);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("전화번호");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(30, 125, 57, 15);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("주소");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(30, 172, 57, 15);
		}
		return lblNewLabel_2;
	}

	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(99, 83, 116, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(99, 122, 116, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}

	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(99, 169, 116, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}

	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("전체보기");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					ArrayList<Friend> arr = dba.friendView();
					for (int i = 0; i < arr.size(); i++) {
						ta.append("고유번호 : "+arr.get(i).getNum()+"\n");
						ta.append("이름 : " + arr.get(i).getName() + "\n");
						ta.append("생년월일 : " + arr.get(i).getBirth() + "\n");
						ta.append("번호 : " + arr.get(i).getPhone() + "\n");
						ta.append("주소 : " + arr.get(i).getAddr() + "\n\n");
					}
				}
			});
			btnView.setBounds(12, 200, 97, 23);
		}
		return btnView;
	}

	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("추가");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					dba.friendInsert(f);
					ta.setText(tfName.getText() + " 추가완료");
					tfName.setText("");
					tfBirth.setText("");
					tfPhone.setText("");
					tfAddr.setText("");

				}
			});
			btnInsert.setBounds(129, 200, 97, 23);
		}
		return btnInsert;
	}

	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setDividerSize(1);
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel());
			splitPane_1.setDividerLocation(220);
		}
		return splitPane_1;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uC804\uCCB4\uBCF4\uAE30",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getComboBox_1());
			panel.add(getTfSearch());
			panel.add(getBtnSearch());
		}
		return panel;
	}

	private JComboBox getComboBox_1() {
		if (comSet == null) {
			comSet = new JComboBox();
			comSet.setModel(new DefaultComboBoxModel(new String[] {"선택", "이름", "주소"}));
			comSet.setBounds(0, 24, 65, 21);
		}
		return comSet;
	}

	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(69, 24, 116, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("찾기");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					String str = tfSearch.getText();
					int idx = comSet.getSelectedIndex();
					if (idx == 0) {
						tfSearch.setText("항목선택");
					}
					ArrayList<Friend> arr = dba.friendSearch(str, idx);
					for (int i = 0; i < arr.size(); i++) {
						ta.append("고유번호 : " + arr.get(i).getNum() + "\n");
						ta.append("이름 : " + arr.get(i).getName() + "\n");
						ta.append("생년월일 : " + arr.get(i).getBirth() + "\n");
						ta.append("번호 : " + arr.get(i).getPhone() + "\n");
						ta.append("주소 : " + arr.get(i).getAddr() + "\n\n");

					}

				}
			});
			btnSearch.setBounds(189, 23, 69, 23);
		}
		return btnSearch;
	}

	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setBounds(12, 252, 116, 21);
			tfNum.setColumns(10);
		}
		return tfNum;
	}

	private JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("상세보기");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int num = Integer.parseInt(tfNum.getText());
						Friend f = dba.friendSelect(num);
						tfName.setText(String.valueOf(f.getName()));
						tfBirth.setText(f.getBirth());
						tfPhone.setText(f.getPhone());
						tfAddr.setText(f.getAddr());
						btnUpdate.setEnabled(true);
						btnDelete.setEnabled(true);
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(null, "번호 입력요망");
					} catch (NullPointerException a) {
						JOptionPane.showMessageDialog(null, "친구번호 입력 요망.");
					}
				}
			});
			btnSelect.setBounds(145, 251, 81, 23);
		}
		return btnSelect;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int num = Integer.parseInt(tfNum.getText());
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					dba.friendUpdate(f, num);
					ta.append(tfName.getText() + "수정되었음.");

				}
			});
			btnUpdate.setBounds(12, 293, 97, 23);
			btnUpdate.setEnabled(false);
		}
		return btnUpdate;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog
					(null, tfName.getText()+" 삭제하시겠습니까?","삭제확인",JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				int num = Integer.parseInt(tfNum.getText());
				dba.friendDelete(num);
				ta.setText(tfNum.getText()+"삭제 되었음.");
					}
				}
			});
			btnDelete.setEnabled(false);
			btnDelete.setBounds(129, 293, 97, 23);
		}
		return btnDelete;
	}

	private JLabel getLblnum() {
		if (lblnum == null) {
			lblnum = new JLabel("고유번호입력");
			lblnum.setBounds(12, 233, 134, 15);
		}
		return lblnum;
	}
}
