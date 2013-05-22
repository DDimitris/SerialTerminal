import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;


public class ReadingLine {
	public GUI GUI;
	
public void Read() {
	Document document = GUI.txtLog.getDocument();
	Element rootElem = document.getDefaultRootElement();
	int numLines = rootElem.getElementCount();
	Element lineElem = rootElem.getElement(numLines - 1);
	int lineStart = lineElem.getStartOffset();
	int lineEnd = lineElem.getEndOffset();
	String lineText;
	try {
		lineText = document.getText(lineStart, lineEnd - lineStart);
		System.out.println(lineText);
	} catch (BadLocationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}

}
