package %%%JAVAPACKAGE;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

/**
 * Class providing UI services for model migration.<p>
 * An instance of %%%CLASS is used :
 * <li>
 * <ul> to define the model to load conforming to a concrete class of %%%SOURCEMM from an existing file</ul>
 * <ul> to define the model to save conforming to a concrete class of %%%TARGETMM into a (possibly) new file</ul>
 * </li>
 * Typically, the instance to be saved comes from the migration of the loaded instance.
 */
public class %%%CLASS {

	/* *************************************************************** */
	/* ****   STRUCTURAL FEATURES                                 **** */
	/* *************************************************************** */

	/**
	 * Input file name.
	 * The corresponding file contains an instance of a concrete class of %%%SOURCEMM
	 */
	private String inputFile;
	
	/**
	 * Output file name.
	 * The corresponding file is supposed to be created to contain an instance of a concrete class of %%%TARGETMM
	 */
	private String outputFile;
	
	/* *************************************************************** */
	/* ****   getters                                        **** */
	/* *************************************************************** */
	
	public String getInputFileName() {
		return inputFile;
	}

	public String getOutputFileName() {
		return outputFile;
	}
	
	/* *************************************************************** */
	/* ****   CONSTRUCTORS                                        **** */
	/* *************************************************************** */

	/**
	 * Constructor with explicit file names
	 * @param inputFile input file name
	 * @param outputFile output file name
	 */
	public %%%CLASS(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}

	/**
	 * Constructor using a GUI to fetch the required file names
	 */
	public %%%CLASS() {
		this.inputFile = null;
		this.outputFile = null;

		final Display display = new Display();
	    final Shell shell = new Shell(display);
	    shell.setText("%%%SOURCEMM model migration");
	    shell.setLayout(new GridLayout(3, false));

	    new Label(shell, SWT.NONE).setText("Input model:");

	    final Text inputFileName = new Text(shell, SWT.BORDER);
	    inputFileName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    Button openE = new Button(shell, SWT.PUSH);
	    openE.setText("Open...");
	    openE.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	    	  final String[] FILTER_NAMES = {"%%%SOURCEMM file (*.%%%SOURCEEPACKAGE)", "All Files (*.*)"};
	    	  final String[] FILTER_EXTS =  { "*.%%%SOURCEEPACKAGE", "*.*"};
	    	  FileDialog dlg = new FileDialog(shell, SWT.OPEN);
	    	  dlg.setFilterNames(FILTER_NAMES);
	    	  dlg.setFilterExtensions(FILTER_EXTS);
	    	  String fn = dlg.open();
	    	  if (fn != null) {
	    		  inputFileName.setText(fn);
	    	  }
	      }
	    });

	    new Label(shell, SWT.NONE).setText("Output model:");

	    final Text outputFileName = new Text(shell, SWT.BORDER);
	    outputFileName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    Button openT = new Button(shell, SWT.PUSH);
	    openT.setText("Open...");
	    openT.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	    	  final String[] FILTER_NAMES = {"%%%TARGETMM file (*.%%%TARGETEPACKAGE)", "All Files (*.*)"};
	    	  final String[] FILTER_EXTS =  { "*.%%%TARGETEPACKAGE", "*.*"};
	    	  FileDialog dlg = new FileDialog(shell, SWT.SAVE);
	    	  dlg.setFilterNames(FILTER_NAMES);
	    	  dlg.setFilterExtensions(FILTER_EXTS);
	    	  String fn = dlg.open();
	    	  if (fn != null) {
	    		  outputFileName.setText(fn);
	    	  }
	      }
	    });

	    new Label(shell, SWT.NONE);
	    new Label(shell, SWT.NONE).setLayoutData(new GridData(300, SWT.DEFAULT));
	    new Label(shell, SWT.NONE);

	    Composite composite = new Composite(shell, SWT.NONE);
	    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
	    composite.setLayout(new GridLayout(2, true));

	    Button process = new Button(composite, SWT.PUSH);
	    process.setText("Run");
	    process.setLayoutData(new GridData (SWT.FILL, SWT.FILL, true, true));
	    process.addSelectionListener(new SelectionAdapter() {
		  public void widgetSelected(SelectionEvent event) {
			  if (inputFileName.getText().equals("")) {
				  MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
				  messageBox.setMessage("Missing input model");
				  messageBox.open();				  
			  }
			  else if (outputFileName.getText().equals("")) {
				  MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
				  messageBox.setMessage("Missing generated file name");
				  messageBox.open();				  
			  }
			  else {
				  inputFile = inputFileName.getText();
				  outputFile = outputFileName.getText();
				  display.dispose();
			  }
		  }
		});
	    
	    Button cancel = new Button(composite, SWT.PUSH);
	    cancel.setLayoutData(new GridData (SWT.FILL, SWT.FILL, true, true));
	    cancel.setText("Cancel");
	    cancel.addSelectionListener(new SelectionAdapter() {
		  public void widgetSelected(SelectionEvent event) {
			  display.dispose();
		  }
		});
	    
	    shell.pack();
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	}

}
