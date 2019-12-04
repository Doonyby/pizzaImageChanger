package changingImages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class ChangingImages extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbxPizza;
	private JCheckBox chckbxMeat;
	private JCheckBox chckbxVeggies;
	private JLabel lblPizzaLabel;
	private JLabel lblMeatLabel;
	private JLabel lblVeggieLabel;
    String[] pizzaArr = {"/pizzaImgs/pizzaPlain.png", "/pizzaImgs/pizzaParmesean.png", "/pizzaImgs/pizzaSpinach.png"};
    String[] meatArr = {"/pizzaImgs/bacon.png", "/pizzaImgs/pepperoni.png", "/pizzaImgs/sausage.png"};
    String[] veggiesArr = {"/pizzaImgs/olives.png", "/pizzaImgs/peppers.png", "/pizzaImgs/mushrooms.png"};
    Color[] pizzaBoxArr = {new Color(0, 0, 0), new Color(240, 248, 255), new Color(128, 128, 128)};
    int pizzaIdx = 0;
    int meatIdx = 0;
    int veggiesIdx = 0;
    int pizzaBoxIdx = 0;
	private JPanel pizzaPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangingImages frame = new ChangingImages();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChangingImages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(160, 0, 160, 0));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		chckbxPizza = new JCheckBox("Pizza");
		panel.add(chckbxPizza);
		
		chckbxMeat = new JCheckBox("Meat");
		panel.add(chckbxMeat);
		
		chckbxVeggies = new JCheckBox("Veggies");
		panel.add(chckbxVeggies);
		
		JButton btnSubmit = newBtnSubmit(chckbxPizza);
		panel.add(btnSubmit);
		
		JLabel lblPizzaBuilder = newLblPizzaBuilder();
		contentPane.add(lblPizzaBuilder, BorderLayout.NORTH);
		
		JPanel pizzaPanel = newPizzaPanel();
		contentPane.add(pizzaPanel, BorderLayout.CENTER);

		JLabel lblPizzaLabel = newLblPizzaLabel();
		pizzaPanel.add(lblPizzaLabel);

	}
	
	private JPanel newPizzaPanel() {
		pizzaPanel = new JPanel();
		pizzaPanel.setBackground(pizzaBoxArr[0]);
		pizzaPanel.setLayout(new OverlayLayout(pizzaPanel));
		pizzaPanel.add(newLblVeggieLabel());
		pizzaPanel.add(newLblMeatLabel());
		return pizzaPanel;
	}

	private JLabel newLblPizzaLabel() {
		lblPizzaLabel = new JLabel("");
		lblPizzaLabel.setIcon(new ImageIcon(ChangingImages.class.getResource(pizzaArr[0])));
		lblPizzaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return lblPizzaLabel;
	}
	
	private String getPizzaImg() {
		if(pizzaIdx == 2) {
			pizzaIdx = 0;
		} else {
			pizzaIdx++;
		}
		return pizzaArr[pizzaIdx];
	}
	
	private JLabel newLblMeatLabel() {
		lblMeatLabel = new JLabel("");
		lblMeatLabel.setIcon(new ImageIcon(ChangingImages.class.getResource(meatArr[0])));
		return lblMeatLabel;
	}
	
	private String getMeatImg() {
		if(meatIdx == 2) {
			meatIdx = 0;
		} else {
			meatIdx++;
		}
		return meatArr[meatIdx];
	}
	
	private JLabel newLblVeggieLabel() {
		lblVeggieLabel = new JLabel("");
		lblVeggieLabel.setIcon(new ImageIcon(ChangingImages.class.getResource(veggiesArr[0])));
		return lblVeggieLabel;
	}
	
	private String getVeggiesImg() {
		if(veggiesIdx == 2) {
			veggiesIdx = 0;
		} else {
			veggiesIdx++;
		}
		return veggiesArr[veggiesIdx];
	}
	
	private Color getPizzaBox() {
		if(pizzaBoxIdx == 2) {
			pizzaBoxIdx = 0;
		} else {
			pizzaBoxIdx++;
		}
		return pizzaBoxArr[pizzaBoxIdx];
	}

	private JButton newBtnSubmit(JCheckBox chckbxPizza) {
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxPizza.isSelected() && !chckbxMeat.isSelected() && !chckbxVeggies.isSelected()) {
					pizzaPanel.setBackground(getPizzaBox());
				} else {
					if(chckbxPizza.isSelected()) {
						lblPizzaLabel.setIcon(new ImageIcon(ChangingImages.class.getResource(getPizzaImg())));
					}
					if(chckbxMeat.isSelected()){
						lblMeatLabel.setIcon(new ImageIcon(ChangingImages.class.getResource(getMeatImg())));
					}
					if(chckbxVeggies.isSelected()) {
						lblVeggieLabel.setIcon(new ImageIcon(ChangingImages.class.getResource(getVeggiesImg())));
					} 
				}
			}
		});
		return btnSubmit;
	}
	
	private JLabel newLblPizzaBuilder() {
		JLabel lblPizzaBuilder = new JLabel("Pizza Builder");
		lblPizzaBuilder.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPizzaBuilder.setBorder(new EmptyBorder(8, 0, 8, 0));
		lblPizzaBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		return lblPizzaBuilder;
	}
}
