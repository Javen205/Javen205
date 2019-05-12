package com.javen.shell.controller;

import java.util.List;

import com.javen.shell.kit.ShellKit;
import com.jfinal.core.Controller;
import com.jfinal.log.Log;

public class ShellController extends Controller {
	private final Log logger =  Log.getLog(ShellController.class);

	public void index() {
		logger.info("\n\nTNW 微信公众号开发脚手架：https://gitee.com/javen205/TNW\n" + 
				"IJPay 让支付触手可及：https://gitee.com/javen205/IJPay\n" + 
				"SpringBoot 微服务高效开发 mica 工具集：https://gitee.com/596392912/mica\n" + 
				"Avue 一款基于 vue 可配置化的神奇框架：https://gitee.com/smallweigit/avue\n" + 
				"pig 宇宙最强微服务（架构师必备）：https://gitee.com/log4j/pig\n" + 
				"SpringBlade 完整的线上解决方案（企业开发必备）：https://gitee.com/smallc/SpringBlade");

		renderHtml("通过 Java 程序执行 Shell 脚本文件 \n"+
				"<h3>开源推荐</h3>\n" + 
				"<ul>\n" + 
				"<li><code>TNW</code> 微信公众号开发脚手架：<a href=\"https://gitee.com/javen205/TNW\">https://gitee.com/javen205/TNW</a></li>\n" + 
				"<li><code>IJPay</code> 让支付触手可及：<a href=\"https://gitee.com/javen205/IJPay\">https://gitee.com/javen205/IJPay</a></li>\n" + 
				"<li>SpringBoot 微服务高效开发 <code>mica</code> 工具集：<a href=\"https://gitee.com/596392912/mica\">https://gitee.com/596392912/mica</a></li>\n" + 
				"<li><code>Avue</code> 一款基于 vue 可配置化的神奇框架：<a href=\"https://gitee.com/smallweigit/avue\">https://gitee.com/smallweigit/avue</a></li>\n" + 
				"<li><code>pig</code> 宇宙最强微服务（架构师必备）：<a href=\"https://gitee.com/log4j/pig\">https://gitee.com/log4j/pig</a></li>\n" + 
				"<li><code>SpringBlade</code> 完整的线上解决方案（企业开发必备）：<a href=\"https://gitee.com/smallc/SpringBlade\">https://gitee.com/smallc/SpringBlade</a></li>\n" + 
				"</ul>");
	}

	public void execShell() {
//		这里可以做权限验证
//		String result = getRawData();
//		System.out.println(result);
		ShellKit.execShell("/mnt/www/javen.dev/gitpull.sh");
		System.out.println("gitpull.sh 执行完成...");
		
		renderText("执行完成...");
	}

	public void runShell() {
		String shStr = getPara("shell");
		try {
			List<String> list = ShellKit.runShell(shStr);
			renderJson(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
