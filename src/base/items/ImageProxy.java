package base.items;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import base.Element;
import base.statistics.Visitor;


public class ImageProxy  implements Icon, Element
{


private int imgSize = 300;


   public ImageProxy(String url) throws IOException
   {
	   
	   this.name = url;
      JTabbedPane tabbedPane = new JTabbedPane();
       JLabel label = new JLabel(new Image(url));
       tabbedPane.add(url, label);

      JFrame frame = new JFrame();
      frame.add(tabbedPane);

      frame.setSize(this.imgSize , this.imgSize);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setVisible(true);
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
	   
      ensureImageLoaded();
      image.paintIcon(c, g, x, y);
      System.out.println(this.name+ " ready");
   }

   public int getIconWidth()
   {
      ensureImageLoaded();
      return image.getIconWidth();
   }

   public int getIconHeight()
   {
      ensureImageLoaded();
      return image.getIconHeight();
   }

   private void ensureImageLoaded()
   {
      if (image == null)
      {
         System.out.println("Loading " + name);
         image = new ImageIcon(name);
      }
   }

   private String name;
   private ImageIcon image;
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
	
	visitor.visitImageProxy(this);
}

@Override
public void print() {


	
}

@Override
public String getTitle() {
	// TODO Auto-generated method stub
	return null;
}
}
