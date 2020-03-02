package guiintro;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MyFirstWindow {

	protected Shell shell;
	private Text wert;
	private Text ergebnis;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyFirstWindow window = new MyFirstWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button addButton = new Button(shell, SWT.NONE);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int ergebnis = Integer.parseInt(getErgebnis().getText());
				int wert = Integer.parseInt(getWert().getText());
				//
				ergebnis = ergebnis + wert;
				//
				getErgebnis().setText(Integer.toString(ergebnis));
				getWert().setText("");
				
			}
		});
		addButton.setBounds(130, 88, 75, 25);
		addButton.setText("+");
		
		wert = new Text(shell, SWT.BORDER);
		wert.setBounds(130, 51, 76, 21);
		
		ergebnis = new Text(shell, SWT.BORDER);
		ergebnis.setText("0");
		ergebnis.setEditable(false);
		ergebnis.setBounds(130, 10, 76, 21);

	}
	public Text getWert() {
		return wert;
	}
	public Text getErgebnis() {
		return ergebnis;
	}
}
