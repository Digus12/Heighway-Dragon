import java.awt.*;
import java.awt.event.*;

public class Dragon extends Frame implements ActionListener 
{
	public Dragon()
	{
		addWindowListener(new WindowAdapter()
	{ public void windowClosing(WindowEvent event) {System.exit(0);}});
		drawButton.addActionListener(this);
		setTitle("Dragon");
		Panel parameterPanel = new Panel(); 
		parameterPanel.setLayout(new GridLayout(2,1));
	       	Panel nStepsPanel = new Panel();
		nStepsPanel.add(new Label("no of steps = "));
		nStepsPanel.add(nStepsField);
		Panel buttonPanel = new Panel();
	 	buttonPanel.add(drawButton);
	parameterPanel.add(nStepsPanel); parameterPanel.add(buttonPanel);		
	add("North",parameterPanel);  add("Center",dragonAttractor);
	setSize(400,400); setVisible(true);
}
public static void main(String[] args) {new Dragon();}
public void actionPerformed(ActionEvent action) 
{
	if(action.getSource()==drawButton) 
	dragonAttractor.setSteps(Integer.parseInt(nStepsField.getText()));
	System.out.println(Integer.parseInt(nStepsField.getText()));
}
TextField nStepsField = new TextField("6",6);
Button drawButton= new Button("Draw");
DragonAttractor dragonAttractor = new DragonAttractor();
}

class DragonAttractor extends Canvas
{
	private int n, scaling;
	public DragonAttractor() {n=6;}
	public void dragonr(int x1,int y1,int x2,int y2,int x3, int y3,int n) 
	{
		if(n==1)
		{
			Graphics g = getGraphics();
			g.drawLine(x1+scaling,y1+scaling,x2+scaling,y2+scaling);
			g.drawLine(x2+scaling,y2+scaling,x3+scaling,y3+scaling);
		}
		else
		{
			int x4=(x1+x3)/2;int y4 =(y1+y3)/2;
			int x5 =x3+x2-x4; int y5= y3+y2-y4;			
			dragonr(x2,y2,x4,y4,x1,y1,n-1); dragonr(x2,y2,x5,y5,x3,y3,n-1);
		}
	}
	public void paint(Graphics g)
	{
		Dimension size =getSize(); 
		scaling= Math.min(size.width,size.height)/4;
		int xorig= scaling;int yorig =scaling; 
		int x1 = xorig+scaling; int y1 =yorig;
		int x2 = xorig; int y2= yorig-scaling; 
		int x3 = yorig-scaling; int y3= yorig;
		dragonr(x1,y1,x2,y2,x3,y3,n);
	}
	public void setSteps(int nSteps) {n= nSteps; repaint();}
}
