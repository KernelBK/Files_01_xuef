package cn.javass.xgen.genconf;

import java.util.Map;

import cn.javass.xgen.genconf.vo.GenConfModel;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
/**
 * 对外接口
 * @author moveb
 */
public interface GenConfEbi {
	/**
	 * 获取x-gen核心框架运行所需的配置数据 model
	 * @return
	 */
	public GenConfModel getGenConf();
	/**
	 * 获取需要生成的所有模块的配置
	 * @return 包含需要生成的所有模块的配置数据的Map
	 * key: 模块的id
	 * value: 相应模块的配置数据的 model
	 */
	public Map<String, ModuleConfModel> getMapModuleConf();
}
