package top.dyzmj.mindoro;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * 描述:
 *
 * @author dongYu
 * @date 2023/03/22
 */
public class PopupDialogAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // get current project
        Project project = e.getProject();
        // e.getPresentation() get current subassembly
        StringBuilder dialogMsg = new StringBuilder(e.getPresentation().getText() + "selected");
        String dialogTitle = e.getPresentation().getDescription();
        // get current selected obj
        Navigatable nav = e.getData(CommonDataKeys.NAVIGATABLE);
        if (Objects.nonNull(nav)) {
            dialogMsg.append(String.format("\nSelected elements:%s", nav));
        }
        Messages.showMessageDialog(project, dialogMsg.toString(), dialogTitle, Messages.getInformationIcon());


    }

    @Override
    public void update(@NotNull AnActionEvent e) {
    }
}
