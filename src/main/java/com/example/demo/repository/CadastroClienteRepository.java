package com.example.demo.repository;

import org.apache.hadoop.hbase.client.Connection;

import com.example.demo.model.CadastroCliente;
import com.flipkart.hbaseobjectmapper.AbstractHBDAO;

public class CadastroClienteRepository extends AbstractHBDAO<String, CadastroCliente> {

	public CadastroClienteRepository(Connection connection) {
		super(connection);
	}

}
