package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import model.Contact;
import model.dao.PersonDAO;
import view.*;

/**
 *
 * @author cassiano
 */
public class InsertControll {

    private JTextField fieldName, fieldDate, fieldNacionality;
    private JRadioButton radioF;
    private InsertView insertView;
    private JButton buttonOkay, buttonCancel;
    private PersonDAO personDAO;

    public InsertControll(Connection connection){
        this.insertView       = new InsertView();
        this.fieldName        = this.insertView.getFieldName();
        this.fieldDate        = this.insertView.getFieldDate();
        this.fieldNacionality = this.insertView.getFieldNacionality();
        this.radioF           = this.insertView.getRadioFemale();
        this.buttonOkay       = this.insertView.getButtonOkay();
        this.buttonCancel     = this.insertView.getButtonCancel();
        
        this.personDAO = new PersonDAO(connection);

        addButtonListeners();
    }
    
    private void addButtonListeners(){
        this.buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertView.dispose();
            }
        });
        
        this.buttonOkay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ( ! fieldName.getText().isEmpty() && ! fieldDate.getText().isEmpty()) {
                    try {
                        String name        = fieldName.getText();
                        String nacionality = fieldNacionality.getText();
                        char sex           = (radioF.isSelected()) ? 'F' : 'M';
                        Date date          = new SimpleDateFormat("dd/MM/yyyy").parse(fieldDate.getText());
                        personDAO.create(new Contact(0, name, sex, date, nacionality));
                        JOptionPane.showMessageDialog(insertView, "Cadastro realizado.");
                        
                    } catch (SQLException | ParseException e) {
                        JOptionPane.showMessageDialog(insertView, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    insertView.dispose();
                }else 
                    JOptionPane.showMessageDialog(insertView, "Preencha todos os campos.", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
