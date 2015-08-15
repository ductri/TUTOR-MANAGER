package face;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;

public class Main {
	
	public static void main(String[] args)
	{
		try 
		{
			BeautyEyeLNFHelper . frameBorderStyle = FrameBorderStyle.generalNoTranslucencyShadow;   
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			new MainFrame();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
