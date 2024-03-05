package view;

import javax.swing.*;

/**
 *
 */
public class InsertView extends JFrame
{

    public InsertView()
    {
        this.initComponents();
        this.radioFemale.setSelected(true);

        super.setLocationRelativeTo(rootPane);
        super.setVisible(true);
    }

    public JButton getButtonCancel()
    {
        return this.buttonCancel;
    }

    public JButton getButtonOkay()
    {
        return this.buttonOkay;
    }

    public JTextField getFieldDate()
    {
        return this.fieldDate;
    }

    public JTextField getFieldNacionality()
    {
        return this.fieldNacionality;
    }

    public JTextField getFieldName()
    {
        return this.fieldName;
    }

    public JRadioButton getRadioFemale()
    {
        return this.radioFemale;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        GB = new ButtonGroup();
        fieldName = new JTextField();
        fieldDate = new JTextField();
        fieldNacionality = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        buttonOkay = new JButton();
        buttonCancel = new JButton();
        radioMale = new JRadioButton();
        radioFemale = new JRadioButton();

        GB.add(radioMale); GB.add(radioFemale);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserir Pessoa");

        jLabel1.setText("Nome");

        jLabel2.setText("Sexo");

        jLabel3.setText("Nascimento");

        jLabel4.setText("Nacionalidade");

        buttonOkay.setText("Ok");

        buttonCancel.setText("Cancelar");

        radioMale.setText("Masculino");

        radioFemale.setText("Feminino");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(radioMale)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldName)
                                .addComponent(fieldDate)
                                .addComponent(fieldNacionality, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
                            .addComponent(radioFemale)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(buttonOkay, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNacionality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(radioFemale)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioMale)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOkay)
                    .addComponent(buttonCancel))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonGroup GB;
    private JButton buttonCancel;
    private JButton buttonOkay;
    private JTextField fieldDate;
    private JTextField fieldNacionality;
    private JTextField fieldName;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JRadioButton radioFemale;
    private JRadioButton radioMale;
    // End of variables declaration//GEN-END:variables
}