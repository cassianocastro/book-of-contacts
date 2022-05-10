package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import model.ConfigDataBase;
import model.dao.ConfigDataBaseDAO;
import view.ConfigView;

/**
 *
 */
public class ConfigControll
{

    private final JTextField fieldServer, fieldUser, fieldDB, fieldDoor;
    private final JPasswordField fieldPass;
    private final JButton buttonSave, buttonCancel;
    private final ConfigView configView;

    public ConfigControll()
    {
        this.configView   = new ConfigView();

        this.buttonSave   = this.configView.getButtonSave();
        this.buttonCancel = this.configView.getButtonCancel();
        this.fieldServer  = this.configView.getFieldServer();
        this.fieldUser    = this.configView.getFieldUser();
        this.fieldPass    = this.configView.getFieldPassword();
        this.fieldDB      = this.configView.getFieldBankName();
        this.fieldDoor    = this.configView.getFieldDoor();

        this.addButtonsListeners();
        this.foo();
    }

    private void addButtonsListeners()
    {
        this.buttonCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                configView.dispose();
            }
        });

//        this.buttonSave.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent evt)
//            {
//                ConfigDataBase config = new ConfigDataBase(
//                    fieldServer.getText(),
//                    fieldDoor  .getText(),
//                    fieldDB    .getText(),
//                    fieldUser  .getText(),
//                    String.valueOf(fieldPass.getPassword())
//                );
//                try {
//                    new FileManager().write(config);
//                    JOptionPane.showMessageDialog(configView, "Alterações gravadas.");
//                } catch (IOException e) {
//                    JOptionPane.showMessageDialog(configView, e.getMessage());
//                }
//                configView.dispose();
//            }
//        });
    }

    private void foo()
    {
//        try
//        {
//            ConfigDataBase config = (ConfigDataBase) new FileManager().read();
//
//            fieldServer.setText(config.getHost());
//            fieldDoor  .setText(config.getPort());
//            fieldDB    .setText(config.getDataBase());
//            fieldUser  .setText(config.getUser());
//            fieldPass  .setText(config.getPassword());
//        } catch(IOException e)
//        {
//
//        }
    }

}
