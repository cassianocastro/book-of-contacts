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
 */
public class InsertControll
{

    private final JTextField fieldName, fieldDate, fieldNacionality;
    private final JRadioButton radioF;
    private final InsertView insertView;
    private final JButton buttonOkay, buttonCancel;
    private final PersonDAO personDAO;

    public InsertControll(Connection connection)
    {
        this.insertView       = new InsertView();

        this.fieldName        = this.insertView.getFieldName();
        this.fieldDate        = this.insertView.getFieldDate();
        this.fieldNacionality = this.insertView.getFieldNacionality();
        this.radioF           = this.insertView.getRadioFemale();
        this.buttonOkay       = this.insertView.getButtonOkay();
        this.buttonCancel     = this.insertView.getButtonCancel();

        this.personDAO = new PersonDAO(connection);

        this.addButtonListeners();
    }

    private void addButtonListeners()
    {
        this.buttonCancel.addActionListener((ActionEvent e) ->
        {
            insertView.dispose();
        });

        this.buttonOkay.addActionListener((ActionEvent evt) ->
        {
            if ( ! fieldName.getText().isEmpty() && ! fieldDate.getText().isEmpty())
            {
                try
                {
                    String name        = fieldName.getText();
                    String nacionality = fieldNacionality.getText();
                    char sex           = (radioF.isSelected()) ? 'F' : 'M';
                    Date date          = new SimpleDateFormat("dd/MM/yyyy").parse(fieldDate.getText());

					personDAO.create(new Contact(0, name, sex, date, nacionality));

					JOptionPane.showMessageDialog(insertView, "Cadastro realizado.");
                }
				catch ( SQLException | ParseException e )
                {
                    JOptionPane.showMessageDialog(insertView, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                insertView.dispose();
            }
			else
			{
                JOptionPane.showMessageDialog(insertView, "Preencha todos os campos.", "Alert", JOptionPane.INFORMATION_MESSAGE);
			}
        });
    }
}