package top.dyzmj.mindoro.tab;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 描述:
 *
 * @author dongYu
 * @date 2023/03/22
 */
public class JBTabAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new JBTabDialogWrapper(e.getProject()).showAndGet();
    }
}
