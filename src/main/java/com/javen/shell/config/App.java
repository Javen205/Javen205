package com.javen.shell.config;

import com.javen.shell.controller.ShellController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class App extends JFinalConfig {

	public static void main(String[] args) {
		UndertowServer.start(App.class, 8888, true);
	}

	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	public void configRoute(Routes me) {
		me.add("/", ShellController.class);
	}

	public void configEngine(Engine me) {
	}

	public void configPlugin(Plugins me) {
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}
