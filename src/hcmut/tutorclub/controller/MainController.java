package hcmut.tutorclub.controller;

import hcmut.tutorclub.view.IMainView;

public class MainController implements IMainController{
	
	private IMainView mainView;
	
	private IPrinterController printerController;
	
	private IClassManagerController classManagerController;
	
	public MainController(IMainView mainView) {
		
		this.mainView = mainView;
		
		printerController = new PrinterController();
		classManagerController = new ClassManagerController();
		
	}

	@Override
	public void startUp() {
		
		mainView.setPrinterController(printerController);
		mainView.show();
	}
	

}
