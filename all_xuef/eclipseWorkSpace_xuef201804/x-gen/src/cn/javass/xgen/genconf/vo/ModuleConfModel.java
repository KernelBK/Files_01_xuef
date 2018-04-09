package cn.javass.xgen.genconf.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleConfModel {
	// ģ���ʶ
	private String moduleId = "";
	// ��ģ��ʹ�õ��ⲿ����ı�ʶ
	private String useTheme = "";
	// �û���Ҫ���ɵľ��幦�ܣ�key: ���ܱ�ʶ value: �������ɺ�Ķ���������͵ı�ʶ�ļ���
	private Map<String, List<String>> needGenTypes = 
			new HashMap<String, List<String>>();
	// ģ����������Ҫ����չ���ݣ� key: ���ݵ�id  value: ��Ӧ����չ���ݵ�model
	private Map<String, ExtendConfModel> extds = 
			new HashMap<String, ExtendConfModel>();
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getUseTheme() {
		return useTheme;
	}
	public void setUseTheme(String useTheme) {
		this.useTheme = useTheme;
	}
	public Map<String, List<String>> getNeedGenTypes() {
		return needGenTypes;
	}
	public void setNeedGenTypes(Map<String, List<String>> needGenTypes) {
		this.needGenTypes = needGenTypes;
	}
	public Map<String, ExtendConfModel> getExtds() {
		return extds;
	}
	public void setExtds(Map<String, ExtendConfModel> extds) {
		this.extds = extds;
	}
}
