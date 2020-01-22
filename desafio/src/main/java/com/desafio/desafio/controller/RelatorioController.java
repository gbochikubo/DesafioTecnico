 package com.desafio.desafio.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.desafio.desafio.Persistence.DetalheDAO;
import com.desafio.desafio.Persistence.HeaderDAO;
import com.desafio.desafio.Persistence.TrailerDAO;
import com.desafio.desafio.model.Detalhe;
import com.desafio.desafio.model.Header;
import com.desafio.desafio.model.Trailer;

/** Classe responsável pelo controle da página de exibição do relatório assim como a leitura do arquivo texto e filtragem de dados**/

@Controller
@RequestMapping(value = "/")
public class RelatorioController {
	
	@Autowired
	private HeaderDAO headerDAO;
	@Autowired
	private DetalheDAO detalheDAO;
	@Autowired
	private TrailerDAO trailerDAO;

	private List<Header> headers;
	private List<Detalhe> detalhes;
	private List<Trailer> trailers;
	
	//Endereço do Arquivo Texto
	private String endereco = "/src/main/resources/static/ArquivosTexto/CasetcnicodesenvolvedorFullStack.txt";
	
	
	/**Método responsavel por receber a requisição da página index, assim como processar as informações do arquivo texto
	 * e retornar a tabela com os respectivos dados
	 */
	@RequestMapping(method = RequestMethod.POST, value="/tabelaRelatorio")
	public ModelAndView gerarRelatorio(String dataInicio,String dataFim,String estabelecimento) throws ParseException {
		
		
		ModelAndView tabela = new ModelAndView("tabelaRelatorio");

		this.headers = (List<Header>) headerDAO.findAll();

		if(this.headers.isEmpty()) {
			this.lerArquivo();
		}
        
		this.headers = (List<Header>) headerDAO.findAll();
		this.filtrar(dataInicio,dataFim,estabelecimento);
        this.trailers = (List<Trailer>) trailerDAO.findAll();
        
		
	    tabela.addObject("headers", headers);
        tabela.addObject("detalhes", detalhes);
        tabela.addObject("trailers", trailers);
        
        return tabela;
	}
	
	/**Método responsável por filtrar os dados da tabela, sendo possivel filtrar por data e estabelecimento,
	 * somente data ou somente estabelecimento, caso nenhum dado seja preenchido no campo de filtragem da página index
	 * o método busca todos o detalhes presentes no banco de dados
	 */
	public void filtrar(String dataInicio, String dataFim, String estabelecimento) throws ParseException {
		DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
		
		//Sem filtragem
		if((dataInicio.equals("") || dataFim.equals("")) && estabelecimento.equals("")) {
			this.detalhes =  (List<Detalhe>) detalheDAO.findAll();
		}
		//Filtragem a partir do Estabelecimento
		else if(dataInicio.equals("") || dataFim.equals("")){
			int umEstabelecimento = Integer.parseInt(estabelecimento);
			this.detalhes =  (List<Detalhe>) detalheDAO.findByEstabelecimento(umEstabelecimento);
		}
		//Filtragem a partir da Data
		else if(estabelecimento.equals("")) {
			Date dataInicial = data.parse(dataInicio);
			Date dataFinal = data.parse(dataFim);
			this.detalhes = (List<Detalhe>) detalheDAO.findByDate(dataInicial,dataFinal);	
		}
		//Filtragem a partir da Data e do Estabelecimento
		else {
			int umEstabelecimento = Integer.parseInt(estabelecimento);
			Date dataInicial = data.parse(dataInicio);
			Date dataFinal = data.parse(dataFim);
			this.detalhes = (List<Detalhe>) detalheDAO.findByDateAndEstabelecimento(dataInicial,dataFinal,umEstabelecimento);
		}
	}
	
	/** Método responsável por realizar a leitura do arquivo texto e salvar as informações lidas no banco de dados **/
	public void lerArquivo() throws ParseException {
		try {
			
	        String absolutePath = new File("").getAbsolutePath();
	        
			BufferedReader arquivo = new BufferedReader(new FileReader(absolutePath+endereco));
			
			String linha = arquivo.readLine();
				
			while(linha != null) {
				int tipoRegistro = Integer.parseInt(linha.substring(0,1));
				
				if(tipoRegistro == 1) {
			
					detalheDAO.save(this.leitorDetalhe(linha));
				}
				else if(tipoRegistro == 0) {
									
					headerDAO.save(this.leitorHeader(linha));
				}
				else if(tipoRegistro == 9) {
					
					trailerDAO.save(this.leitorTrailer(linha));
				}else {
					
				throw new RuntimeException("Numero de Registro Invalido");
				}	
				linha = arquivo.readLine();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Nao foi possivel abrir o aquivo " + endereco);	
		}
		catch(IOException e) {
			System.out.println("Problema na leitura do aquivo " + endereco);
		}
	}
	
	
	/** Método responsável por ler um Header **/
	public Header leitorHeader(String linha) throws ParseException  {
		
		Header umHeader = new Header();
		
        DateFormat data = new SimpleDateFormat("yyyyMMdd");
		
		int estabelecimento = Integer.parseInt(linha.substring(1,11));
		umHeader.setEstabelecimento(estabelecimento);

	
		String dataProcessamento = (linha.substring(11,19));
		umHeader.setDataProcessamento(data.parse(dataProcessamento));
			
		
		Date periodoInicial =  data.parse(linha.substring(19,27));
		umHeader.setPeriodoInicial(periodoInicial);
		
		Date periodoFinal =  data.parse(linha.substring(27,35));
		umHeader.setPeriodoFinal(periodoFinal);
		
		int sequencia = Integer.parseInt(linha.substring(35,42));
		umHeader.setSequencia(sequencia);
		
		String empresaAdquirente = linha.substring(42,47);
		umHeader.setEmpresaAdquirente(empresaAdquirente);
		
		int tipoExtrato = Integer.parseInt(linha.substring(47,49));
		umHeader.setTipoExtrato(tipoExtrato);
		
		String filler = linha.substring(49,70);
		umHeader.setFiller(filler);
		
		String versaoLayout = linha.substring(70,73);
		umHeader.setVersaoLayout(versaoLayout);
		
		String reservadoFuturo = linha.substring(78,530);
		umHeader.setReservadoFuturo(reservadoFuturo);
		
		return umHeader;
	}
	
	/**Método responsável pela leitura de um Detalhe**/
	public Detalhe leitorDetalhe(String linha) throws ParseException {
		
		Detalhe umDetalhe = new Detalhe();
		DateFormat data = new SimpleDateFormat("yyyyMMdd");
	    DateFormat hora = new SimpleDateFormat("HHmmss");
	    
        int estabelecimento = Integer.parseInt(linha.substring(1,11));
        umDetalhe.setEstabelecimento(estabelecimento);
    	
        Date dataInicial = data.parse(linha.substring(11,19));
        umDetalhe.setDataInicial(dataInicial);
        
        Date dataEvento =  data.parse(linha.substring(19,27));
        umDetalhe.setDataEvento(dataEvento);
        
        Date horaEvento = hora.parse(linha.substring(27,33));
        umDetalhe.setHoraEvento(horaEvento);
        
        int tipoEvento = Integer.parseInt(linha.substring(33,35));
        umDetalhe.setTipoEvento(tipoEvento);
        
        int tipoTransacao = Integer.parseInt(linha.substring(35,37));
        umDetalhe.setTipoTransacao(tipoTransacao);
        
        String numSerieLeitor = linha.substring(37,45);
        umDetalhe.setNumSerieLeitor(numSerieLeitor);
        
        String codigoTransacao = linha.substring(45,77);
        umDetalhe.setCodigoTransacao(codigoTransacao);
        
        String codigoPedido = linha.substring(77,97);
        umDetalhe.setCodigoPedido(codigoPedido);
        
        int valorTotal = Integer.parseInt(linha.substring(97,110));
        umDetalhe.setValorTotal(valorTotal);
        
        int valorParcela = Integer.parseInt(linha.substring(110,123));
        umDetalhe.setValorParcela(valorParcela);
        
        String pagamento = linha.substring(123,124);
        umDetalhe.setPagamento(pagamento);
        
        String plano = linha.substring(124,126);
        umDetalhe.setPlano(plano);
        
        String parcela = linha.substring(126,128);
        umDetalhe.setParcela(parcela);
        
        int quantidadeParcelas = Integer.parseInt(linha.substring(128,130));
        umDetalhe.setQuantidadeParcelas(quantidadeParcelas);
        
        Date dataPrevista = data.parse(linha.substring(130,138));
        umDetalhe.setDataPrevista(dataPrevista);
        
        int taxaParcelamentoComprador = Integer.parseInt(linha.substring(138,151));
        umDetalhe.setTaxaParcelamentoComprador(taxaParcelamentoComprador);
        
        int tarifaComprador = Integer.parseInt(linha.substring(138,151));
        umDetalhe.setTarifaComprador(tarifaComprador);
        
        int valorOriginal = Integer.parseInt(linha.substring(164,177));
        umDetalhe.setValorOriginal(valorOriginal);
        
        int taxaParcelamentoVendedor = Integer.parseInt(linha.substring(177,190));
        umDetalhe.setTaxaParcelamentoVendedor(taxaParcelamentoVendedor);
        
        int taxaIntermediacao = Integer.parseInt(linha.substring(190,203));
        umDetalhe.setTaxaIntermediacao(taxaIntermediacao);
        
        int tarifaIntermediacao = Integer.parseInt(linha.substring(203,216));
        umDetalhe.setTarifaIntermediacao(tarifaIntermediacao);
        
        int tarifaVendedor = Integer.parseInt(linha.substring(216,229));
        umDetalhe.setTarifaVendedor(tarifaVendedor);
        
        int repasseAplicacao = Integer.parseInt(linha.substring(229,242));
        umDetalhe.setRepasseAplicacao(repasseAplicacao);
        
        int valorLiquidoTransacao = Integer.parseInt(linha.substring(242,255));
        umDetalhe.setValorLiquidoTransacao(valorLiquidoTransacao);
        
        int statusPagamento = Integer.parseInt(linha.substring(255,257));
        umDetalhe.setStatusPagamento(statusPagamento);
        
        String filler = linha.substring(257,259);
        umDetalhe.setFiller(filler);
        
        int meioPagamento = Integer.parseInt(linha.substring(259,261));
        umDetalhe.setMeioPagamento(meioPagamento);
        
        String instituicaoFinanceira = linha.substring(261,291);
        umDetalhe.setInstituicaoFinanceira(instituicaoFinanceira);
        
        String canalEntrada = linha.substring(291,293);
        umDetalhe.setCanalEntrada(canalEntrada);
        
        int leitor = Integer.parseInt(linha.substring(293,295));
        umDetalhe.setLeitor(leitor);
        
        int meioCaptura = Integer.parseInt(linha.substring(295,297));
        umDetalhe.setMeioCaptura(meioCaptura);
        
        String numLogico = linha.substring(297,329);
        umDetalhe.setNumLogico(numLogico);
        
        String nsu = linha.substring(329,340);
        umDetalhe.setNsu(nsu);
        
        String outroFiller = linha.substring(340,343);
        umDetalhe.setOutroFiller(outroFiller);
        
        String cartaoBin = linha.substring(343,349);
        umDetalhe.setCartaoBin(cartaoBin);
        
        String cartaoHolder = linha.substring(349,353);
        umDetalhe.setCartaoHolder(cartaoHolder);
        
        String codigoAutorizacao = linha.substring(353,359);
        umDetalhe.setCodigoAutorizacao(codigoAutorizacao);
        
        String codigoCv = linha.substring(359,391);
        umDetalhe.setCodigoCv(codigoCv);

        String reservadoFuturos = linha.substring(391,530);
        umDetalhe.setReservadoFuturos(reservadoFuturos);     
        
		return umDetalhe;
	}
	
	/**Método responsável pela leitura de um Trailer**/
	public Trailer leitorTrailer(String linha) {
		
		Trailer umTrailer = new Trailer();
		
		int totalRegistro = Integer.parseInt(linha.substring(1,12));
		umTrailer.setTotalRegistro(totalRegistro);
		
		String reservadoFuturo = linha.substring(12,530);
		umTrailer.setReservadoFuturo(reservadoFuturo);
		
		return umTrailer;
	}
	

}
