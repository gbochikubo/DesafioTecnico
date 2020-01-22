package com.desafio.desafio.model;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** Classe que representa um Detalhe **/

@Entity
public class Detalhe implements Serializable{
	
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    
	private static final int tipoRegistro = 1;
	
	private int estabelecimento;	
	@Temporal(TemporalType.DATE)
	private Date dataInicial;
	@Temporal(TemporalType.DATE)
	private Date dataEvento;
	@Temporal(TemporalType.TIME)
	private Date horaEvento;	
	private int tipoEvento;
	private int tipoTransacao;
	private String numSerieLeitor;
	private String codigoTransacao;
	private String codigoPedido;
	private double valorTotal;
	private double valorParcela;
	private String pagamento;
	private String plano;
	private String parcela;
	private int quantidadeParcelas;
	@Temporal(TemporalType.DATE)
	private Date dataPrevista;
	private double taxaParcelamentoComprador;
	private double tarifaComprador;
	private double valorOriginal;
	private double taxaParcelamentoVendedor;
	private double taxaIntermediacao;
	private double tarifaIntermediacao;
	private double tarifaVendedor;
	private double repasseAplicacao;
	private double valorLiquidoTransacao;
	private int statusPagamento;
	private String filler;
	private int meioPagamento;
	private String instituicaoFinanceira;
	private String canalEntrada;
	private int leitor;
	private int meioCaptura;
	private String numLogico;
	private String nsu;
	private String outroFiller;
	private String cartaoBin;
	private String cartaoHolder;
	private String codigoAutorizacao;
	private String codigoCv;
	private String reservadoFuturos;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public int getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(int estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Date getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(Date horaEvento) {
		this.horaEvento = horaEvento;
	}
	public int getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(int tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public int getTipoTransacao() {
		return tipoTransacao;
	}
	public Date getDataPrevista() {
		return dataPrevista;
	}
	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}
	public void setTipoTransacao(int tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public String getNumSerieLeitor() {
		return numSerieLeitor;
	}
	public void setNumSerieLeitor(String numSerieLeitor) {
		this.numSerieLeitor = numSerieLeitor;
	}
	public String getCodigoTransacao() {
		return codigoTransacao;
	}
	public void setCodigoTransacao(String codigoTransacao) {
		this.codigoTransacao = codigoTransacao;
	}
	public String getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public double getTarifaComprador() {
		return tarifaComprador;
	}
	public void setTarifaComprador(double tarifaComprador) {
		this.tarifaComprador = tarifaComprador;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(int valorParcela) {
		this.valorParcela = valorParcela;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	public double getTaxaParcelamentoComprador() {
		return taxaParcelamentoComprador;
	}
	public void setTaxaParcelamentoComprador(double taxaParcelamentoComprador) {
		this.taxaParcelamentoComprador = taxaParcelamentoComprador;
	}
	public double getValorOriginal() {
		return valorOriginal;
	}
	public void setValorOriginal(double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}
	public double getTaxaParcelamentoVendedor() {
		return taxaParcelamentoVendedor;
	}
	public void setTaxaParcelamentoVendedor(double taxaParcelamentoVendedor) {
		this.taxaParcelamentoVendedor = taxaParcelamentoVendedor;
	}
	public double getTaxaIntermediacao() {
		return taxaIntermediacao;
	}
	public void setTaxaIntermediacao(double taxaIntermediacao) {
		this.taxaIntermediacao = taxaIntermediacao;
	}
	public double getTarifaIntermediacao() {
		return tarifaIntermediacao;
	}
	public void setTarifaIntermediacao(int tarifaIntermediacao) {
		this.tarifaIntermediacao = tarifaIntermediacao;
	}
	public double getTarifaVendedor() {
		return tarifaVendedor;
	}
	public void setTarifaVendedor(int tarifaVendedor) {
		this.tarifaVendedor = tarifaVendedor;
	}
	public double getRepasseAplicacao() {
		return repasseAplicacao;
	}
	public void setRepasseAplicacao(int repasseAplicacao) {
		this.repasseAplicacao = repasseAplicacao;
	}
	public double getValorLiquidoTransacao() {
		return valorLiquidoTransacao;
	}
	public void setValorLiquidoTransacao(int valorLiquidoTransacao) {
		this.valorLiquidoTransacao = valorLiquidoTransacao;
	}
	public int getStatusPagamento() {
		return statusPagamento;
	}
	public void setStatusPagamento(int statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public int getMeioPagamento() {
		return meioPagamento;
	}
	public void setMeioPagamento(int meioPagamento) {
		this.meioPagamento = meioPagamento;
	}
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	public String getCanalEntrada() {
		return canalEntrada;
	}
	public void setCanalEntrada(String canalEntrada) {
		this.canalEntrada = canalEntrada;
	}
	public int getLeitor() {
		return leitor;
	}
	public void setLeitor(int leitor) {
		this.leitor = leitor;
	}
	public int getMeioCaptura() {
		return meioCaptura;
	}
	public void setMeioCaptura(int meioCaptura) {
		this.meioCaptura = meioCaptura;
	}
	public String getNumLogico() {
		return numLogico;
	}
	public void setNumLogico(String numLogico) {
		this.numLogico = numLogico;
	}
	public String getNsu() {
		return nsu;
	}
	public void setNsu(String nsu) {
		this.nsu = nsu;
	}
	public String getOutroFiller() {
		return outroFiller;
	}
	public void setOutroFiller(String outroFiller) {
		this.outroFiller = outroFiller;
	}
	public String getCartaoBin() {
		return cartaoBin;
	}
	public void setCartaoBin(String cartaoBin) {
		this.cartaoBin = cartaoBin;
	}
	public String getCartaoHolder() {
		return cartaoHolder;
	}
	public void setCartaoHolder(String cartaoHolder) {
		this.cartaoHolder = cartaoHolder;
	}
	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}
	public void setCodigoAutorizacao(String codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}
	public String getCodigoCv() {
		return codigoCv;
	}
	public void setCodigoCv(String codigoCv) {
		this.codigoCv = codigoCv;
	}
	public String getReservadoFuturos() {
		return reservadoFuturos;
	}
	public void setReservadoFuturos(String reservadoFuturos) {
		this.reservadoFuturos = reservadoFuturos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static int getTiporegistro() {
		return tipoRegistro;
	}

}
