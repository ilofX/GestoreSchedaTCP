package View.Controls;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MaxCharactersTextField extends PlainDocument {

    private final Integer length;

    public MaxCharactersTextField(Integer length) {
        super();
        this.length = length;
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException{
        try {
            if(string == null)
                throw new Exception("Stringa Vuota");
            else{
                if(getLength() + string.length() <= this.length){
                    super.insertString(i, string, as);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MaxCharactersTextField.class.getName()).log(Level.WARNING, null, ex);
        }
    }
    
    
    
}
