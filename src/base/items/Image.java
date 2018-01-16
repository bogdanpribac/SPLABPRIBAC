package base.items;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import base.Element;
import base.statistics.Visitor;

public class Image implements Element, Icon {

	private String path = null;
	private File imageFile = null;
	private BufferedImage imageBuff = null;
	private int imgSize = 200;
	
	public Image(String location) throws IOException {
		
		this.path = location;
		
		this.imageFile = new File(this.path);
		this.imageBuff = ImageIO.read(this.imageFile);
	}
	
	public void print() throws IOException{

		this.ProxyTester(this.path);
	}

	@Override
	public void add(Element element) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Element element) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element getChild(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
		visitor.visitImage(this);
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.path;
	}
	   public void ProxyTester(String url) throws IOException
	   {
	      JTabbedPane tabbedPane = new JTabbedPane();
	       JLabel label = new JLabel(new ImageProxy(url));
	       tabbedPane.add(this.path, label);

	      JFrame frame = new JFrame();
	      frame.add(tabbedPane);

	      frame.setSize(this.imgSize, this.imgSize);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	   }

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {

		
		new ImageIcon(this.path).paintIcon(c, g, x, y);
	}
}
