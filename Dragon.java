import java.awt.*;
import java.awt.event.*;

public class Dragon extends Frame implements ActionListener 
{
	public Dragon()
	{
		addWindowListener(New WindowAdapter()
	{ public void windowClosing(WindowEvent event) {System.exit(0);}})
		drawButton.addActionListener(this);
		setTitle("Dragon");
		Panel parameterPanel = New Panel(); 
		parameterPanel.setLayout(new GridLayout(2,1));
	       	Panel NstepsPanel = new Panel();
		nStepsPanel.add(new Label("no of steps = "));
		nStepsPanel.add(nStepsField);
		Panel buttonPanel = new Panel();
	 	buttonPanel.add(drawButton);
	parameterPanel.add(nStepsPanel); parameterPanel.add(buttonPanel);		
	add("North",parameterPanel);  add("Center",dragonAttractor);
	setSize(400,400); setVisible(true);

// incomplete! need to add other lines!

