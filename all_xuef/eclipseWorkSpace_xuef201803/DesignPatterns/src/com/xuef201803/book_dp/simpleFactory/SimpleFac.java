package com.xuef201803.book_dp.simpleFactory;

public class SimpleFac {
	public static Api getInstance(int flag){
		/**
		 * 工厂并不自己制造对象，它只是根据条件做出选择。
		 * 当然是根据条件或者参数来选择；
		 * 参数来源于：
		 * 1. 客户端
		 * 2. 配置文件
		 * 3. 程序运行期的某个值，比如从缓存中获取某个值。
		 */
		if(1==flag){ // 这个参数还是暴露了工厂的部分内部细节
			return new ApiImplA();
		}else if(2==flag){
			return new ApiImplB();
		}
		// 缺点：如果新增一个实现类，这儿的代码需要改动。
		else{
			return null;
		}
	}
}
