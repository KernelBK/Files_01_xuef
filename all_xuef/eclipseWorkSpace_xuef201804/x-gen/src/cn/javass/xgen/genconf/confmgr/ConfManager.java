package cn.javass.xgen.genconf.confmgr;

import java.util.HashMap;
import java.util.Map;

import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;

/**
 * 真正负责获取配置数据，并缓存配置数据
 * @author moveb
 */
public class ConfManager {
	// 实现为单例
	private static ConfManager confmgr = new ConfManager();
	private ConfManager(){
		readConf();
	}
	
	public static ConfManager getInstance(){
		return confmgr;
	}
	
	// 缓存配置数据
	private GenConfModel genConfModel = new GenConfModel();
	public Map<String, ModuleConfModel> mapModuleConf = 
			new HashMap<String, ModuleConfModel>(); 
	
	public GenConfModel getGenConfModel() {
		return genConfModel;
	}

	private void setGenConfModel(GenConfModel genConfModel) {
		this.genConfModel = genConfModel;
	}

	public Map<String, ModuleConfModel> getMapModuleConf() {
		return mapModuleConf;
	}

	private void setMapModuleConf(Map<String, ModuleConfModel> mapModuleConf) {
		this.mapModuleConf = mapModuleConf;
	}

	private void readConf() {
		// 读取配置文件，并缓存对应的model
		
	}
}
