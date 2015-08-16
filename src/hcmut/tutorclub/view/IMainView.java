package hcmut.tutorclub.view;

import hcmut.tutorclub.controller.IClassManagerController;
import hcmut.tutorclub.controller.IPrinterController;

public interface IMainView {

	void show();
	void setPrinterController(IPrinterController printerController);
	void setClassManagerController(IClassManagerController classManagerController);
	
}
