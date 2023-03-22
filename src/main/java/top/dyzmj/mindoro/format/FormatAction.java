package top.dyzmj.mindoro.format;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * 描述:
 *
 * @author dongYu
 * @date 2023/03/22
 */
public class FormatAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        if (Objects.isNull(editor)) {
            return;
        }
        SelectionModel selectionModel = editor.getSelectionModel();
        String selectedText = selectionModel.getSelectedText();
        if (StringUtils.isBlank(selectedText)) {
            return;
        }
        String replaceStr = TransitionUtils.spacingText(RegexExpressionUtils.replace(selectedText, "\\f|\\r|\\t", ""));
        WriteCommandAction.runWriteCommandAction(e.getData(PlatformDataKeys.PROJECT), () -> editor.getDocument().replaceString(selectionModel.getSelectionStart(), selectionModel.getSelectionEnd(), replaceStr));

    }
}
