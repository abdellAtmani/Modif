/**
 * comment
 *  
 * Copyvalid (C) 2018 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  @date 5 mai 2018
 */
package uiModif;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

import ecoremodif.utils.ModifIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import utils.UtilEMF;

/**
 * @author Abdellatif ATMANI
 *
 */
public class ihmController implements Initializable {
	@FXML private Label labelProjectFolder;
	@FXML private Button buttonSelectProjectFolder;
	@FXML private Button buttonSelectMetaModel;
	@FXML private Button buttonSelectModifSpecif;
	@FXML private Button buttonSelectTargetMetaModel;
	@FXML private Button buttonGenerateModif;
	@FXML private Button buttonRefactor;
	@FXML private Button buttonCompare;
	@FXML private ToggleButton buttonMinimize;
	@FXML private RadioButton radioNoModif;
	@FXML private RadioButton radioEraseAll;
	@FXML private RadioButton radioatomic;
	@FXML private RadioButton radiospecific;
	@FXML private MenuItem menuCloseItem;
	@FXML private TextField textfieldProjectFolderPath;
	@FXML private TextField textfieldMetaModelPath;
	@FXML private TextField textfieldModifSpecifPath;
	@FXML private TextField textfieldTargetMetaModelPath;
	@FXML ToggleGroup radioGroup = new ToggleGroup();
	private Button buttonOK = new Button("OK");
    private Button buttonClear = new Button("Clear");
    private Button buttonClose = new Button("Exit");

	protected modifService theModifService;
	protected File projectFolder;
	protected String modifFileName;
	protected String ProjectFolderPath;
	public static String MetaModelFilePath;
	protected String specificFileName;
	protected String ModifSpecifFilePath;
	public static  List <String> selectedEclasses =new ArrayList<String>();
	public static  List <String> notSelectedEclasses =new ArrayList<String>();
	public static List <EClassifier> subClassifier=new ArrayList<EClassifier>();
	
    ModifIO aModifIO =new ModifIO();
    public  EPackage theRootEcore;
    public static   EPackage epackage;
    public static   EPackage theRootepackage;
    private CheckBox []checkEClass;
	  
   
	public void SelectProjectFolder(ActionEvent event) throws IOException {
		 
		if(!textfieldProjectFolderPath.getText().equals(""))
		{  
			DirectoryChooser chooser = new DirectoryChooser();
			chooser.setInitialDirectory(new File(textfieldProjectFolderPath.getText()));
			chooser.setTitle("choose a new directory");		
			File selectedDirectory = chooser.showDialog(null);
			if (selectedDirectory != null) {	    
				File A =new File(selectedDirectory.getPath()+"\\metamodel");
				boolean exist=A.exists();
				if(exist) {
					textfieldProjectFolderPath.setText(selectedDirectory.getPath());
				}	
				else {
					 Alert alert = new Alert(AlertType.ERROR);
					 alert.setTitle("Error");
					 alert.setHeaderText(null);
					 String s ="Select a valid project source folder ";
					 alert.setContentText(s);
					 alert.show();
				}
			}
			else {
				 System.out.println("dossier n'est pas valide");
			 	}

		 }else {
		 DirectoryChooser chooser = new DirectoryChooser();
		 chooser.setTitle("choose directory");		
		 	File selectedDirectory = chooser.showDialog(null);		 	 
			{
				if (selectedDirectory != null) {	    
					File A =new File(selectedDirectory.getPath()+"\\metamodel");
					boolean exist=A.exists();
					if(exist) {
						textfieldProjectFolderPath.setText(selectedDirectory.getPath());
					}
					else {
						Alert alert = new Alert(AlertType.ERROR);
						 alert.setTitle("Error");
						 alert.setHeaderText(null);
						 String s ="Select a valid project source folder ";
						 alert.setContentText(s);
						 alert.show();
					}
				       }
				else {
					System.out.println("dossier n'est pas valide");
				}
			}	
	 }
	 }
	
	 public void SelectMetaModel(ActionEvent event) throws IOException {
	  ProjectFolderPath=textfieldProjectFolderPath.getText();
		 if(ProjectFolderPath.equals("")) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Error");
			 alert.setHeaderText(null);
			 String s ="Select the project source folder ";
			 alert.setContentText(s);
			 alert.show();
			 }
		 else {
			 File A =new File(ProjectFolderPath+"\\metamodel");
			 boolean exist=A.exists();
			 if(exist) {
			 FileChooser fileChooser = new FileChooser();
			 fileChooser.setTitle("Open Resource File");
			 fileChooser.setInitialDirectory(A);
			 fileChooser.getExtensionFilters().addAll( new ExtensionFilter("Ecore Files", "*.ecore"));
			 File selectedFile = fileChooser.showOpenDialog(null);
		 	 	if (selectedFile != null) { 
		 	 		 textfieldMetaModelPath.setText(selectedFile.getName());
		 	 		 MetaModelFilePath=selectedFile.getPath();
		 	 		 theRootEcore= UtilEMF.loadMetamodel(MetaModelFilePath);
		 	 		 epackage= UtilEMF.loadMetamodel(MetaModelFilePath);
		 	 		 theRootepackage=UtilEMF.loadMetamodel(MetaModelFilePath);
		 	 	}
		 	 	else {
		 	 		System.out.println("fichier n'est pas valide");
		 		}
		  }	
			 else {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("can't open file ");
			 alert.setHeaderText(null);
			 String s ="choose a valid directory ";
			 alert.setContentText(s);
			 alert.show();
		 }
      } 
	 }
	 
	 public void GenerateModif(ActionEvent event) throws IOException {
		 if(textfieldProjectFolderPath.getText().equals("")) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Error");
			 alert.setHeaderText(null);
			 String s ="Select the project source folder ";
			 alert.setContentText(s);
			 alert.show();
			 }
		 else if(textfieldMetaModelPath.getText().equals("")) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Error");
			 alert.setHeaderText(null);
			 String s ="Select a domain metamodel ";
			 alert.setContentText(s);
			 alert.show();
		 }else{
			 String metaModelPath =MetaModelFilePath;// textfieldMetaModelPath.getText(); 
			 File metaModelFile = new File(metaModelPath);
			 int metaModelName = metaModelFile.getName().lastIndexOf('.');	
				
			 theModifService.setFiles(null, metaModelPath, null, null, null, null, null, null, false);

				String noModifFileName;
				noModifFileName = metaModelFile.getParent()+"/../modif/NoModif"+metaModelFile.getName().substring(0,metaModelName)+".modif"; /*metaModelName*/
				String modifEraseAll;
				modifEraseAll = metaModelFile.getParent()+"/../modif/EraseAll"+metaModelFile.getName().substring(0,metaModelName)+".modif"; /*metaModelName*/
				String atomicFileName;
				atomicFileName = metaModelFile.getParent()+"/../modif/Atomic"+metaModelFile.getName().substring(0,metaModelName)+".modif"; /*metaModelName*/
				specificFileName = metaModelFile.getParent()+"/../modif/Specific"+metaModelFile.getName().substring(0,metaModelName)+".modif"; /*metaModelName*/
				File modifFolder = new File(metaModelFile.getParent().replace("metamodel", "modif"));
				// modif folder does not exist
				if(!modifFolder.exists()){
					//modif folder creation
					File dir = new File(metaModelFile.getParent()+"/../modif");
					dir.mkdir();
				}
				
				// NoModif is selected
				if(radioNoModif.isSelected()){
					File noModif = new File(noModifFileName);
					// There is a NoModif file
					if(noModif.exists()){	
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirmation ");
						alert.setHeaderText(null);
						alert.setContentText("Do you want to rewrite "+ "NoModif"+metaModelFile.getName().substring(0,metaModelName)+".modif ?");
						ButtonType buttonTypeYes = new ButtonType("Yes");
						ButtonType buttonTypeNo = new ButtonType("No");	
						ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
						alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);
						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == buttonTypeYes){
							try { theModifService.generateModifFile(metaModelPath, 1, noModifFileName, false); } 
							catch (IOException e1) { e1.printStackTrace(); }
						}
					 else  {
					    alert.close();
					 }   
					}
				else{
						try { theModifService.generateModifFile(metaModelPath, 1, noModifFileName, false); } 
						catch (IOException e1) { e1.printStackTrace(); }
					}
						// EraseAll is selected
				}else if(radioEraseAll.isSelected()){
						File eraseAll = new File(modifEraseAll);
						if(eraseAll.exists()){
							Alert alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Confirmation ");
							alert.setHeaderText(null);
							alert.setContentText("Do you want to rewrite "+ "EraseAll"+metaModelFile.getName().substring(0,metaModelName)+".modif ?");
							ButtonType buttonTypeYes = new ButtonType("Yes");
							ButtonType buttonTypeNo = new ButtonType("No");	
							ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
							alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);
							Optional<ButtonType> result = alert.showAndWait();
							if (result.get() == buttonTypeYes){
								try { theModifService.generateModifFile(metaModelPath, 2, modifEraseAll, false); } 
								catch (IOException e1) { e1.printStackTrace(); }
							
							} else if (result.get() == buttonTypeNo) {
							    alert.close();
							}  else {
							    alert.close();
							}	
							}
						else try {theModifService.generateModifFile(metaModelPath, 2, modifEraseAll, false); } 
						catch (IOException e1) { e1.printStackTrace();}	
						}
				// radioAtomic is selected
				else if(radioatomic.isSelected()) {
					
					File Atomic = new File(atomicFileName);
					// There is an Atomic file
					if(Atomic.exists()){	
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirmation ");
						alert.setHeaderText(null);
						alert.setContentText("Do you want to rewrite "+ "Atomic"+metaModelFile.getName().substring(0,metaModelName)+".modif ?");
						ButtonType buttonTypeYes = new ButtonType("Yes");
						ButtonType buttonTypeNo = new ButtonType("No");	
						ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
						alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);

						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == buttonTypeYes){
							try { theModifService.generateModifFile(metaModelPath, 3, atomicFileName, false); } 
							catch (IOException e1) { e1.printStackTrace(); }
						}
					 else  {
					    alert.close();
					 }   
					}
				else{
						try { theModifService.generateModifFile(metaModelPath, 3, atomicFileName, false); } 
						catch (IOException e1) { e1.printStackTrace(); }
					}
				}
				// radioSpecific is selected
				else if (radiospecific.isSelected()) {	
					showChoiceBoxDialaog();	
					epackage.getEClassifiers().clear();
				}
					}
				}
	    private void generateSpecificModifFactory() throws IOException{
	      theModifService.generateModifFile(MetaModelFilePath, 4, specificFileName, false);       
	    }
	    public  int getNumberEClass() {
	    	int allClass =getNameAllEclass(theRootEcore).size();
			return allClass;  	
	    }
	    public  List<String> getNameAllEclass() {
			List <String> classNames = new ArrayList<String>()  ;
			for (EClassifier subClassifier : theRootEcore.getEClassifiers()) {
				if (subClassifier instanceof EClass) {
					classNames.add(subClassifier.getName());
				}
			}
			return classNames;
		}
	    public  List<String> getNameAllEclass(EPackage epack) {
			List <String> classNames = new ArrayList<String>()  ;
			for (EClassifier subClassifier : epack.getEClassifiers()) {
				if (subClassifier instanceof EClass) {
					classNames.add(subClassifier.getName());
				}
			}
			return classNames;
		}
	    public static EPackage getEpackage() {
	    	for (int i=0; i<selectedEclasses.size();i++) {
	    			try {
						epackage.getEClassifiers().add((EClass)theRootepackage.getEClassifier(selectedEclasses.get(i)));
						subClassifier.add((EClass)theRootepackage.getEClassifier(selectedEclasses.get(i)));
						}
						catch(Exception ee) {
						ee.printStackTrace();
						}
	    }
			return epackage;
	    }
	    public Object ChoiceEClass (ActionEvent e) throws IOException {
	    	int numberEClass=getNumberEClass();
	    	selectedEclasses.clear();
	    	notSelectedEclasses.clear();
			for(int i=0; i< numberEClass  ; i++ ) {
				if(checkEClass[i].isSelected()) {
					selectedEclasses.add(checkEClass[i].getText());	}
				else  {
					notSelectedEclasses.add(checkEClass[i].getText());
				}	
			}	
			return null;
		}
	 public void SelectModifSpecif(ActionEvent event) throws IOException {
		 ProjectFolderPath=textfieldProjectFolderPath.getText();
		 if(ProjectFolderPath.equals("")) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Error");
			 alert.setHeaderText(null);
			 String s ="Select the project source folder ";
			 alert.setContentText(s);
			 alert.show();
			 }
		 else {
			 FileChooser fileChooser = new FileChooser();
			 fileChooser.setTitle("Open Resource File");
			 fileChooser.setInitialDirectory(new File(ProjectFolderPath+"//modif"));
			 fileChooser.getExtensionFilters().addAll( new ExtensionFilter("Modif Files", "*.modif"));
			 File selectedFile = fileChooser.showOpenDialog(null);
		 	 if (selectedFile != null) {
			 textfieldModifSpecifPath.setText(selectedFile.getName());
			 ModifSpecifFilePath = selectedFile.getPath();
		 	}
		 	else {
			 System.out.println("fichier n'est pas valide");
		 	}
		 }
	 }
	 public void Refactor(ActionEvent event) throws IOException {
		 if(textfieldProjectFolderPath.getText().equals("")) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Error");
			 alert.setHeaderText(null);
			 String s ="Select the project source folder ";
			 alert.setContentText(s);
			 alert.show();
			 }
		 else if(textfieldModifSpecifPath.getText().equals("")) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Error");
			 alert.setHeaderText(null);
			 String s ="Select a modifspecifpath ";
			 alert.setContentText(s);
			 alert.show();
		 }
		 else { projectFolder = new File(ProjectFolderPath);		    
			    theModifService.setFiles(projectFolder.getAbsolutePath(), MetaModelFilePath, ModifSpecifFilePath, null, null, null, null, null, false);
				long start = System.nanoTime();
				theModifService.CreateModif(true, null);
				theModifService.Refactor();			
				System.out.print("Refactoring   Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");			
		 }
	 }
	 public void SelectTargetMetaModel(ActionEvent event) throws IOException {
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Open Resource File");
		 fileChooser.setInitialDirectory(new File("C:\\Users\\Abdou\\Desktop\\Projet\\workspaceMR\\ModifRoundtrip\\model\\Modif"));
		 fileChooser.getExtensionFilters().addAll( new ExtensionFilter("Ecore Files", "*.ecore"));
		 File selectedFile = fileChooser.showOpenDialog(null);
		 if (selectedFile != null) {
			 textfieldTargetMetaModelPath.setText(selectedFile.getName());
		 }
		 else {
			 System.out.println("fichier n'est pas valide");
		 }
	 }
	 public void Compare(ActionEvent event) throws IOException {
	
	 }
	 public void Minimize(ActionEvent event) throws IOException{
		 if(textfieldProjectFolderPath.getText().equals("")) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Error");
			 alert.setHeaderText(null);
			 String s ="Select the project source folder ";
			 alert.setContentText(s);
			 alert.show();
			 }
		 else if(textfieldModifSpecifPath.getText().equals("")) {
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Error");
			 alert.setHeaderText(null);
			 String s ="Select a modifspecifpath ";
			 alert.setContentText(s);
			 alert.show();
		 }
		 else {
			 theModifService.Minimize(ModifSpecifFilePath);
		 }
	 }
	 private void checkvide() {
    	 for(int i=0;i<getNumberEClass();i++) {
    		 checkEClass[i].setSelected(false);
	        }
    }
	 private void showChoiceBoxDialaog() {
		 	Stage stage = new Stage();
	        stage.initModality(Modality.APPLICATION_MODAL);
	        Scene scene = new Scene(getview(), 300, 470);
	        buttonClose.setOnAction(e -> { closeChoicewindow(); });    
	        stage.setScene(scene);
	        stage.show();
	    }
	    private ScrollPane scrollShow() {        
	        ScrollPane scroll = new ScrollPane();
	        BorderPane border = new BorderPane();
	        border.setPadding(new Insets(20, 0, 20, 20));
	        border.setLeft(alignmentSample());  
	        scroll.setContent(border);
	        return scroll;
	    }
	    public Pane getview(){
	    	buttonClose.setStyle("-fx-font-size: 15pt;");
	    	buttonClear.setStyle("-fx-font-size: 15pt;");
	    	buttonOK.setStyle("-fx-font-size: 15pt;");
	        MenuBar menuBar = new MenuBar();
	        BorderPane pane=new BorderPane();
	        pane.setCenter(scrollShow());
	        Menu fileMenu = new Menu("File");
	        buttonOK.setOnAction(actionEvent -> {
					try {
						generateSpecificModifFactory();
					} catch (IOException e) {
						e.printStackTrace();
					}});  
	        buttonClear.setOnAction(actionEvent -> checkvide());
	        MenuItem newMenuItem = new MenuItem("New");
	        MenuItem exitMenuItem = new MenuItem("Exit");
	        exitMenuItem.setOnAction(actionEvent -> closeChoicewindow());
	        newMenuItem.setOnAction(actionEvent -> checkvide());
	        fileMenu.getItems().addAll(newMenuItem,
	            new SeparatorMenuItem(), exitMenuItem);
	        pane.setTop(menuBar);
	        menuBar.getMenus().addAll(fileMenu);
	        pane.setCenter(scrollShow());
	        pane.setBottom(buttonRow());
	        return pane;
	    }
	    private TilePane buttonRow() {
	        buttonOK.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        buttonClear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        buttonClose.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);       
	        TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);
	        tileButtons.setPadding(new Insets(25, 15, 20, 0));
	        tileButtons.setHgap(10.0);
	        tileButtons.setVgap(12.0); 
	        tileButtons.getChildren().addAll(buttonOK, buttonClear, buttonClose);
	        return tileButtons;
	    }
	 private VBox alignmentSample() {
	    	checkEClass =new CheckBox[getNameAllEclass().size()];
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);  
	        grid.setHgap(10);
	        grid.setVgap(12);
	        int numberEClass=getNumberEClass();
	        for(int i=0 ; i<numberEClass;i++) {
	         checkEClass[i]=new CheckBox(getNameAllEclass().get(i)); } 
	        for(int i=0 ; i<numberEClass;i++) {
	        	checkEClass[i].setOnAction((e) -> {
					try {
						ChoiceEClass(e);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				});
	        }
	        VBox vbcheckbox = new VBox();
	        vbcheckbox.setSpacing(10);
	        vbcheckbox.setPadding(new Insets(0, 20, 10, 20));   
	        for(int i=0;i<numberEClass;i++) {       
	           vbcheckbox.getChildren().add(checkEClass[i]);
	            }   
	        return vbcheckbox;   
	    }
	 public void closeMainWindow(){
	        Stage stage = (Stage) buttonSelectProjectFolder.getScene().getWindow();
	        stage.close();
	    }
	public void closeChoicewindow(){
	        Stage stage = (Stage) buttonClose.getScene().getWindow();
	        stage.close();
	    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		radioNoModif.setToggleGroup(radioGroup);
		radioEraseAll.setSelected(true);
		radioEraseAll.setToggleGroup(radioGroup);
	    radioatomic.setToggleGroup(radioGroup);
	    radiospecific.setToggleGroup(radioGroup);
	    
	    theModifService = new modifService();
		
	}

}
