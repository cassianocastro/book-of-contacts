package controller;

import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import model.*;
import model.dao.*;
import view.HomeView;


/**
 *
 */
public class HomeController
{

    private final JComboBox comboBox;
    private final JButton buttonNewNumber;
    private final JList numberList;
    private final DefaultListModel listModel;
    private final JTextField fieldDate, fieldNacionality;
    private final JRadioButton radioF, radioM;
    private final HomeView home;

    private final PersonDAO personDAO;
    private final PhoneDAO phoneDAO;

    public HomeController(Connection connection)
    {
        this.home             = new HomeView();

        this.comboBox         = this.home.getComboBox();
        this.fieldDate        = this.home.getFieldDate();
        this.fieldNacionality = this.home.getFieldNacionality();
        this.listModel        = this.home.getModel();
        this.numberList       = this.home.getNumberList();
        this.buttonNewNumber  = this.home.getButtonNewNumber();
        this.radioF           = this.home.getRadioFemale();
        this.radioM           = this.home.getRadioMale();

        this.personDAO = new PersonDAO(connection);
        this.phoneDAO  = new PhoneDAO(connection);

        this.onCreate();
    }

    private void onCreate()
    {
        this.loadCombo();
        this.loadNumberList();
        this.addComboListeners();
        this.addNumberListListener();
        this.addButtonListeners();
    }

    private void loadCombo()
    {
        this.comboBox.removeAllItems();
        try
        {
            List<Contact> people = personDAO.read();

			for ( Contact person : people )
            {
                this.comboBox.addItem(person.getName());
            }
        }
		catch ( SQLException e )
        {

        }
    }

    private void loadNumberList()
    {
        this.numberList.removeAll();

		int index = this.comboBox.getSelectedIndex();

        if ( index != -1 )
        {
            try
            {
                List<Contact> people = personDAO.read();
                Contact person = people.get(index);
                List<Phone> phones = phoneDAO.findByID(person.getID());

		        this.listModel.clear();

                for ( Phone phone : phones )
                {
                    this.listModel.addElement(phone.getPhone());
                }

                this.numberList.setModel(this.listModel);
            }
			catch ( SQLException e )
            {

            }
        }
    }

    private void addButtonListeners()
    {
        this.buttonNewNumber.addActionListener((ActionEvent evt) ->
        {
            int index = comboBox.getSelectedIndex();
            String phone = JOptionPane.showInputDialog(null, "Novo Número", "Novo");

            try
            {
                List<Contact> people = personDAO.read();
                Contact person = people.get(index);

                phoneDAO.create(new Phone(0, phone, person.getID()));
            }
			catch ( SQLException e )
            {

            }

            loadNumberList();
        });
    }

    private void addComboListeners()
    {
        this.comboBox.addItemListener((ItemEvent evt) ->
        {
            int index = comboBox.getSelectedIndex();

			if ( index != -1 )
            {
                try
                {
                    List<Contact> people = personDAO.read();
                    Contact person = people.get(index);

                    if ( person.getSex() == 'F' )
                    {
                        radioF.setSelected(true);
                    }
					else
                    {
                        radioM.setSelected(true);
                    }

                    fieldDate.setText(
                        new SimpleDateFormat("dd/MM/yyyy").format(person.getDateNasc())
                    );

					fieldNacionality.setText(person.getNacionality());

					loadNumberList();
                }
				catch ( SQLException e )
                {

                }
            }
        });
    }

    private void addNumberListListener()
    {
        this.numberList.addMouseListener(
			new MouseListener()
			{
				@Override
				public void mouseClicked(MouseEvent evt)
				{
					int personID = comboBox.getSelectedIndex();
					int index = numberList.getSelectedIndex();

					if ( index != -1 )
					{
						try
						{
							List<Contact> people = personDAO.read();
							Contact person = people.get(personID);
							List<Phone> phones = phoneDAO.findByID(person.getID());

							if ( evt.getButton() == MouseEvent.BUTTON3 )
							{
								int confirm = JOptionPane.showConfirmDialog(null, "Excluir o Telefone?", "Confirmação", 0);

								if ( confirm == JOptionPane.YES_OPTION )
								{
									phoneDAO.delete(phones.get(index).getId());
									loadNumberList();
								}
							}
							else if ( evt.getClickCount() == 2 )
							{
								String newPhone = JOptionPane.showInputDialog(null, "Novo telefone:");

								phoneDAO.update(new Phone(phones.get(index).getId(), newPhone, 0));

								loadNumberList();
							}
						}
						catch ( SQLException e )
						{

						}
					}
				}

				@Override
				public void mousePressed(MouseEvent e)
				{

				}

				@Override
				public void mouseReleased(MouseEvent e)
				{

				}

				@Override
				public void mouseEntered(MouseEvent e)
				{

				}

				@Override
				public void mouseExited(MouseEvent e)
				{

				}
			}
		);
    }

//    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt)
//    {
//        JFrame Ins = new InsertView();
//    }
//
//    private void jMenuItemEditActionPerformed(java.awt.event.ActionEvent evt)
//    {
//        JFrame Alterar = new EditView();
//    }
//
//    private void jMenuItemDelActionPerformed(java.awt.event.ActionEvent evt)
//    {
//        int vlr = JOptionPane.showConfirmDialog(rootPane, "Confirmar a exclusão", "Confirmaçao", 2);
//        if ( vlr == 0 )
//        {
//            try
//            {
//                PersonDAO PDAO = new PersonDAO();
//                PDAO.delete(codigo);
//            } catch (SQLException e)
//            {
//
//            }
//        }
//    }
//
//    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt)
//    {
//        System.exit(0);
//    }
//
//    private void jMenuItemConfigActionPerformed(java.awt.event.ActionEvent evt)
//    {
//        JFrame JanelaConfigura = new ConfigView();
//    }
}