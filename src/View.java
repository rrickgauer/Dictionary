
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class View extends JFrame{
	
	private JTextField textInput;
	private JComboBox<String> dropdown;
	private JButton searchButton;
	private JButton resetButton;
	private JLabel titleLabel;
	private JPanel panel;
	private GridBagConstraints constraints;
	private String categories[] = {"Synonyms", "Antonyms", "Rhymes", "Approximate Rhymes"};
	private JSlider slider;
	private JLabel textLabel;
	private JLabel dropdownLabel;
	private JLabel sliderLabel;
	private Font titleFont = new Font("Geneva", Font.BOLD, 18);
	private Font labelFont = new Font("Arial", Font.BOLD, 12);
	private Dimension textInputDimension = new Dimension(250, 25);	// width, height
	private Dimension sliderDimension = new Dimension(250, 50);	// width, height
	private JTextArea resultArea;
	private Dimension resultAreaDimension = new Dimension(300, 300);
	
	
	public View() {
		super("Dictionary");
		setSize(800, 800);
		
		// initialize the panel
		panel = new JPanel(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		
		
		// initialize and add title label
		titleLabel = new JLabel("Dictionary Application");
		titleLabel.setFont(titleFont);
		constraints.gridwidth = 3;
		add(0, 0, titleLabel);
		
		
		// add text input label
		textLabel = new JLabel("Enter word:");
		textLabel.setFont(labelFont);
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.WEST;
		add(0, 1, textLabel);
		
		// add textbox input
		textInput = new JTextField();
		textInput.setPreferredSize(textInputDimension);
		constraints.gridwidth = 2;
		add(1, 1, textInput);
	
		
		// add dropdown menu label
		constraints.gridwidth = 1;
		dropdownLabel = new JLabel("Select category:");
		dropdownLabel.setFont(labelFont);
		add(0, 2, dropdownLabel);

		// add dropdown menu
		dropdown = new JComboBox<String>(categories);
		dropdown.setPreferredSize(textInputDimension);
		constraints.gridwidth = 2;
		add(1, 2, dropdown);
		
		// add slider label
		sliderLabel = new JLabel("Select max return:");
		sliderLabel.setFont(labelFont);
		constraints.gridwidth = 1;
		add(0, 3, sliderLabel);
		
		// add slider
		constraints.gridwidth = 2;
		slider = new JSlider(JSlider.HORIZONTAL, 0, 20, 10);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTrack(true);
		slider.setPreferredSize(sliderDimension);
		add(1, 3, slider);
		
		constraints.gridwidth = 1;
		
		// add search button
		searchButton = new JButton("Search");
		add(1, 4, searchButton);
		
		// add reset button
		resetButton = new JButton("Reset");
		add(2, 4, resetButton);
		
		// result text area
		resultArea = new JTextArea();
		resultArea.setPreferredSize(resultAreaDimension);
		constraints.gridwidth = 3;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		resultArea.setLineWrap(true);
		resultArea.setRows(20);
		add(0, 5, resultArea);
		
		// show view
		add(panel);
		pack();
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void add(int gridx, int gridy, Component comp) {
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		panel.add(comp, constraints);
	}
	
	public JButton getSearchButton() {
		return searchButton;
	}
	
	public JTextField getInputField() {
		return this.textInput;
	}
	
	public JComboBox getDropdown() {
		return this.dropdown;
	}
	
	public JSlider getSlider() {
		return slider;
	}
	
	public JTextArea getTextArea() {
		return this.resultArea;
	}
	
	public JButton getResetButton() {
		return resetButton;
	}
}
