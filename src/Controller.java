
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
	
	private Model model;
	private View view;
	private ActionListener searchButtonActionListener;
	private ActionListener resetButtonActionListener;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		// add action listener to the search button
		initSearchButtonActionListener();
		view.getSearchButton().addActionListener(searchButtonActionListener);
		
		// add reset button action listener
		initResetButtonActionListener();
		view.getResetButton().addActionListener(resetButtonActionListener);
	}
	
	// initialize search button action listener
	private void initSearchButtonActionListener() {
		searchButtonActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchButtonActions();
			}
		};
	}
		
	// actions done when search button is clicked
	private void searchButtonActions() {
		// get the input data
		String word = view.getInputField().getText();
		String category = getSelectedCategory();
		int max = view.getSlider().getValue();
		
		// create a new model
		model = new Model(word, category, max);
		
		// get the responses
		Response[] responses = model.getResponses();
		
		// format the response data
		String output = formatResponses(responses);
		
		// set the view result area to the new formatted responses
		view.getTextArea().setText(output);
	}
	
	// return the appropriate string value of the selected dropdown category type
	private String getSelectedCategory() {
		
		String selectedCategory = null;
		
		int selectedIndex = view.getDropdown().getSelectedIndex();
		
		switch(selectedIndex) {
			case 0:
				selectedCategory = "syn";	// synonym
				break;
			case 1:
				selectedCategory = "ant";	// antonym
				break;
			case 2:
				selectedCategory = "rhy";	// rhyme
				break;
			case 3:
				selectedCategory = "nry";	// approximate rhyme
				break;
			default:
				selectedCategory = "syn";	// else: synonym
				break;
		}
		
		return selectedCategory;
	}
	
	private String formatResponses(Response[] responses) 
	{	
		// initialize the formatted string
		String formatted = "";
		
		// add the responses to the string
		for (Response response : responses)
			formatted = formatted + response.word + "\n";
		
		return formatted;
	}
	
	// initialize reset button action listener
	private void initResetButtonActionListener() {
		resetButtonActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonActions();
			}
		};
	}
	
	// actions taken when reset button is clicked
	private void resetButtonActions() {	
		view.getInputField().setText("");		// clear text input
		view.getDropdown().setSelectedIndex(0);	// reset dropdown
		view.getSlider().setValue(10);			// reset slider
		view.getTextArea().setText("");			// clear text area
	}
	
}
