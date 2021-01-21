package com.example.demo.model;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;

@SuppressWarnings("serial")
@HBTable(name = "acpt107.CadastroCliente", families = { @Family(name = "cfDadosGerais"), @Family(name = "cfCliente"),
		@Family(name = "cfEndereco"), @Family(name = "cfTelefone"), @Family(name = "cfEmail"),

})
public class CadastroCliente implements HBRecord<String> {

	@HBColumn(family = "cfDadosGerais", column = "CnpjOgm")
	private Integer CnpjOgm;

	@HBColumn(family = "cfDadosGerais", column = "NrRms")
	private Integer NrRms;

	@HBColumn(family = "cfDadosGerais", column = "DtRms")
	private String DtRms;

	@HBColumn(family = "cfDadosGerais", column = "TipCli")
	private Integer TipCli;

	@HBColumn(family = "cfDadosGerais", column = "IdfcCli")
	private Integer IdfcCli;

	@HBColumn(family = "cfDadosGerais", column = "NmCli")
	private String NmCli;

	@Override
	public String composeRowKey() {
		return String.format("#%d#%d#%d", TipCli, IdfcCli, CnpjOgm);
	}

	@Override
	public void parseRowKey(String rowKey) {
		String[] pieces = rowKey.split("#");
		this.TipCli = Integer.valueOf(pieces[0]);
		this.IdfcCli = Integer.valueOf(pieces[1]);
		this.CnpjOgm = Integer.valueOf(pieces[2]);
	}
}
