package com.xuef.architect.customermgr.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 包装返回数据和信息
 * @author moveb
 */
public class Msg {
	// 状态码 0:失败 1:成功
		private int status;
		// 提示消息
		private String msg;
		private Map<String, Object> data = new HashMap();
		
		public static Msg success(){
			Msg msg = new Msg();
			msg.setStatus(1);
			msg.setMsg("success");
			return msg;
		}

		public static Msg fail(){
			Msg msg = new Msg();
			msg.setStatus(0);
			msg.setMsg("fail");
			return msg;
		}
		public Msg add(String key, Object data){
			this.data.put(key, data);
			return this;
		}
		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public Map<String, Object> getRes() {
			return data;
		}

		public void setRes(Map<String, Object> data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Msg [status=" + status + ", msg=" + msg + ", data=" + data
					+ "]";
		}
}
