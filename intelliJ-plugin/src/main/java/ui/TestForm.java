package ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestForm {

  private JDialog dialog = new JDialog();

  private JButton search;
  private JTextField textField;
  private JPanel panel;
  private JLabel label;

  public void onShowing(){

    dialog.add(panel, BorderLayout.CENTER);
    dialog.pack();
    dialog.setLocation(200, 200);
    dialog.setVisible(true);

    search.addActionListener(event -> onClick());
  }

  private void onClick() {
    label.setText(textField.getText());
  }


}
