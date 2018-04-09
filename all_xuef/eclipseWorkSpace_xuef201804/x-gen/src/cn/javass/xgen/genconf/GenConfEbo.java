package cn.javass.xgen.genconf;

import java.util.Map;

import cn.javass.xgen.genconf.confmgr.ConfManager;
import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;

// ���� ���ù���ģ���ҵ����
public class GenConfEbo implements GenConfEbi {
	// ������
	private static GenConfEbo genConEbo = new GenConfEbo();
	private GenConfEbo(){}
	public static GenConfEbo getInstance(){
		return genConEbo;
	}
	
	@Override
	public GenConfModel getGenConf() {
		// ʵ�ʵĻ�ȡ�������� ConfManager
		return ConfManager.getInstance().getGenConfModel();
	}

	@Override
	public Map<String, ModuleConfModel> getMapModuleConf() {
		return ConfManager.getInstance().getMapModuleConf();
	}

}
