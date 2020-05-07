package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import ui.TestForm;

public class MyForm extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent e) {

    TestForm testForm = new TestForm();

    testForm.onShowing();

  }
}
