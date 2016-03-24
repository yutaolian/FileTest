import java.io.File;


public class AppFolder {

	//"Controller" 控制器
	//"View" 视图
	//"Modle" 模型
	//"Expand" 扩展
	//"Vender" 第三方
	//"Resource" 资源
	//"Other" 其他   
	
	public static void main(String[] args) {

		
		
		//生成code结构
		String path = "D:/test/Code";
		//String[] modelName = {"模块1","模块2","模块3","模块4","Other"}; 
		String[] modelName = {"模块1","模块2","模块3","模块4"}; 
		//代码结构模式1
		AppFolder.makeModel1(path,modelName,true);
		
	}
	
	/**
	 * 
	 * @param path 生成路径
	 * @param modeArray 模块的名称（尽量用英文）
	 * @param hasNote 是否加中文注释
	 */
	public  static void makeModel1(String path,String[] modelArray , boolean hasNote){
		try {
			
			File file = new File(path);
			
			
			//String[] modeArray = {"模块1","模块2","模块3","模块4","Other"}; 
			String[] MVCArray = {"Controller","View","Modle","Other"};
			
			String[] MVCOtherSubArray = {"Common","LoginAndRegister","NewFeature","Setting","Other"};
			
			String[] MVCOtherSubArrayHasNote = {"Common(通用)","LoginAndRegister(登录注册)","NewFeature(新特性)","Setting(设置)","Other"};
			
			String[] otherArray = {"Expand","Vender","Resource"};
			String[] otherArrayHasNote = {"Expand(扩展)","Vender(第三方库)","Resource(资源)"};
			
			String[] ExpandSubArray = {"DataBase","Category","NetWork","Tools","Macros","Const"};
			String[] ExpandSubArrayHasNote = {"DataBase(数据库)","Category(分类)","NetWork(网络)","Tools(工具)","Macros(宏)","Const(常量)"};
			
			if (!file.exists()) {
					file.mkdir();
					System.out.println("done");
			}
			
			//生成模块的结构
			for (int i = 0; i < modelArray.length; i++) {
			
				File modeFile = new File(path+"/"+modelArray[i]);
				modeFile.mkdir();
				
				if (!modelArray[i].equals("Other")) {
					for (int j = 0; j < MVCArray.length; j++) {
						File mvcFile = new File(path+"/"+modelArray[i]+"/"+MVCArray[j]);
						mvcFile.mkdir();
					}
				}
				if (modelArray[i].equals("Other")) {
		
					String[] hasNoteMVCOtherSubArray = MVCOtherSubArray;
					if (hasNote) {
						hasNoteMVCOtherSubArray = MVCOtherSubArrayHasNote;
					}
					
					for (int k = 0; k < hasNoteMVCOtherSubArray.length; k++) {
						File hasNoteMVCOtherSubArrayFile = new File(path+"/"+modelArray[i]+"/"+hasNoteMVCOtherSubArray[k]);
						hasNoteMVCOtherSubArrayFile.mkdir();
					}
					
				}
			}
			
			String[] hasNoteOtherArray= otherArray;
			
			if (hasNote) {
				hasNoteOtherArray = otherArrayHasNote;
			}
			
			//生成扩展内的结构
			for (int i = 0; i < hasNoteOtherArray.length; i++) {
				File otherFile = new File(path+"/"+hasNoteOtherArray[i]);
				otherFile.mkdir();
				String[] hasNoteOtherSubArray= ExpandSubArray;
				if (hasNote) {
					hasNoteOtherSubArray = ExpandSubArrayHasNote;
				}
				if (i==0) {
					for (int j = 0; j < hasNoteOtherSubArray.length; j++) {
						File otherSubFile = new File(path+"/"+hasNoteOtherArray[i]+"/"+hasNoteOtherSubArray[j]);
						otherSubFile.mkdir();
					}
				}
			}
			System.out.println("exit");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
