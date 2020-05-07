package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class TopMenu extends AnAction {

  @Override
  public void actionPerformed(AnActionEvent anActionEvent) {
    Project project = anActionEvent.getProject();

    Messages.showMessageDialog(project, "안녕하세요! 좋은 하루 되세요", "아침인사", Messages.getInformationIcon());
  }

}
