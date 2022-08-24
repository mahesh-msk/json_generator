package org.ancit.json.ui.dialog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

public class FileExportDialog {
	public static void export(String generate) {

		FileDialog dialog = new FileDialog(Display.getDefault()
				.getActiveShell(), SWT.SAVE);
		String open = dialog.open();
		File file = new File(open);
		try {
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(generate);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}