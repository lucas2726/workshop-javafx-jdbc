module app.workshop.javafx.jdbc {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires mysql.connector.java;
	requires javafx.base;
	requires javafx.web;
	
	opens application;
	opens gui;
	opens gui.util;
	opens model.services;
	opens model.entities;
	opens model.dao.impl;
	opens model.dao;
	opens db;
	
}
