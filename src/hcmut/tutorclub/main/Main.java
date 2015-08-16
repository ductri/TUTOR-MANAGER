package hcmut.tutorclub.main;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;

import hcmut.tutorclub.controller.IMainController;
import hcmut.tutorclub.controller.MainController;
import hcmut.tutorclub.view.IMainView;
import hcmut.tutorclub.view.MainView;

public class Main {
	
	public static void main(String[] args) throws Exception
	{
		
		/****************************************
		 *                                       *
		 *        --- INTERFACE SETTING --- 
		 *                                       *
		 ****************************************/
		BeautyEyeLNFHelper . frameBorderStyle = FrameBorderStyle.generalNoTranslucencyShadow;   
		org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		
		/****************************************
		 *                                       *
		 *        --- START PROGRAM --- 
		 *                                       *
		 ****************************************/
		
		//Init view
		IMainView mainView = new MainView();
		
		//Init model: Authorization module
		//TODO
		
		//Init controller
		IMainController mainController = new MainController(mainView);
		
		mainController.startUp();
	}
}
