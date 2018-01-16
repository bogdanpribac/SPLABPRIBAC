package base.statistics;

import base.items.Image;
import base.items.ImageProxy;
import base.items.Paragraph;
import base.items.Table;
import wrappers.Section;

public interface Visitor {

    public void visitImageProxy(ImageProxy image);

    public void visitImage(Image image);

    public void visitParagraf(Paragraph paragraf);

    public void visitTabel(Table tabel);

	public void visitSection(Section section);

}
