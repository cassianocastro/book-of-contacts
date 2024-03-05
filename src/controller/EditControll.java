package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.dao.PersonDAO;

/**
 *
 */
public class EditController
{

    private void OKMouseClicked(java.awt.event.MouseEvent evt)
    {

        if ( ! T1.getText().isEmpty() && ! T3.getText().isEmpty() )
        {
            String name = T1.getText();
            char sex = ( RBF.isSelected() ) ? 'F' : 'M';

            try
            {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(T3.getText());

                new PersonDAO().update(new Person(0, name, sex, date, null));

				JOptionPane.showMessageDialog(rootPane, "Atualização realizada.");

				dispose();
            }
			catch ( SQLException | ParseException e )
            {
                System.out.println("problema na inserção do contato");
            }
        }
		else
        {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos.");
        }
    }

    private void CancelaMouseClicked(java.awt.event.MouseEvent evt)
    {
        dispose();
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt)
    {
        try
        {
            P = new PersonDAO().findByID(codigo);
            T1.setText(P.getNome());
            T4.setText(P.getNacionalidade());

            if ( P.getSexo() == 'F' )
                RBF.setSelected(true);
            else
                RBM.setSelected(true);

            Date date = P.getDataNasc();

            T3.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));
        }
		catch ( SQLException e )
        {
            System.out.println("Contato não encontrado.");
        }
    }
}